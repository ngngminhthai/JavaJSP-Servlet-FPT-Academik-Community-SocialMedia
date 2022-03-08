/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import controller.UserController.CreateConversation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conversation;
import model.Message;

/**
 *
 * @author Admin
 */
public class ConversationDBContext extends DBContext {

    public ArrayList<Conversation> getConversation(int userID) {
        ArrayList<Conversation> conversations = new ArrayList<>();
        try {
            String sql = "EXEC dbo.userIDCheck @userid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userID);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ArrayList<Message> messages = getMessages(rs.getInt("c_id"), 0);
                String name = rs.getString(2);
                int userid = rs.getInt(3);
                int cid = rs.getInt("c_id");
                Conversation conversation = new Conversation(name, userid, messages, cid);
                conversations.add(conversation);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConversationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conversations;
    }


    public ArrayList<Message> getMessages(int cid, int currentNumberItems) {
        ArrayList<Message> messages = new ArrayList<>();
        try {
            String sql = "SELECT message_content, userID FROM dbo.Message WHERE c_id = ? ORDER BY createdAt DESC OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.setInt(2, currentNumberItems);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                messages.add(new Message(rs.getString("message_content"), rs.getInt("userID")));
            }

            return messages;
        } catch (SQLException ex) {
            Logger.getLogger(ConversationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messages;
    }

    public int createConversation(int usersend, int userreceive) {
        int cid = -1;
        try {
            String sql = "INSERT INTO dbo.Conversation(user_send, user_receive, lastModify)\n"
                    + "VALUES(?,?,GETDATE())";
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, usersend);
            stm.setInt(2, userreceive);
            stm.executeUpdate();

            String sql_get_id = "select @@IDENTITY as c_id";
            PreparedStatement stm_get_id = connection.prepareStatement(sql_get_id);

            ResultSet rs = stm_get_id.executeQuery();
            if (rs.next()) {
                cid = rs.getInt("c_id");
            }
            connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(ConversationDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ConversationDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                return cid;
            } catch (SQLException ex) {
                Logger.getLogger(ConversationDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            //close connection
        }
        return 0;

    }

    public boolean findConversation(int usersend, int userreceive) {
        try {
            String sql = "SELECT COUNT(*) as total FROM dbo.Conversation WHERE (user_send = ? and user_receive = ?) OR (user_receive = ? AND user_send = ?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, usersend); //1
            stm.setInt(2, userreceive); //2

            stm.setInt(3, usersend); //1
            stm.setInt(4, userreceive); //2

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return (rs.getInt("total") > 0);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConversationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void createMessage(int userone, int replyid, int cid, String content) {
        try {
            String sql = "INSERT INTO dbo.Message(message_content, createdAt, userID, c_id)\n"
                    + "VALUES(?,GETDATE(),?,?)";

            if (findConversation(userone, replyid)) {
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setString(1, content);
                stm.setInt(2, replyid);
                stm.setInt(3, cid);
                stm.executeUpdate();
            } else {
                PreparedStatement stm = connection.prepareStatement(sql);
                int cid2 = createConversation(userone, replyid);
                stm.setString(1, content);
                stm.setInt(2, replyid);
                stm.setInt(3, cid2);
                stm.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConversationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ConversationDBContext c = new ConversationDBContext();
        ArrayList<Conversation> cc = c.getConversation(2);
        for (Conversation conversation : cc) {
            System.out.println(conversation);
        }
    }
}
