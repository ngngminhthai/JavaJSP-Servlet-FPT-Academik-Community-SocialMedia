/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

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
                ArrayList<Message> messages = getMessages(rs.getInt("c_id"));
                String name = rs.getString(2);
                int userid = rs.getInt(3);
                int cid = rs.getInt("c_id");
                Conversation conversation = new Conversation(name, userid, messages, cid);
                conversations.add(conversation);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conversations;
    }

    public ArrayList<Message> getMessages(int userID) {
        ArrayList<Message> messages = new ArrayList<>();
        try {
            String sql = "SELECT message_content, userID FROM dbo.Message WHERE c_id = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userID);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                messages.add(new Message(rs.getString("message_content"), rs.getInt("userID")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messages;
    }

    public int createConversation(int usersend, int userreceive) {
        try {
            String sql = "INSERT INTO dbo.Conversation(user_send, user_receive)\n"
                    + "VALUES(?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, usersend);
            stm.setInt(2, userreceive);
            stm.executeUpdate();
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean findConversation(int usersend, int userreceive) {
        try {
            String sql = "SELECT COUNT(*) FROM dbo.Conversation WHERE (user_send = ? and user_receive = ?) OR (user_receive = ? AND user_send = ?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, usersend); //1
            stm.setInt(2, userreceive); //2

            stm.setInt(3, usersend); //1
            stm.setInt(4, userreceive); //2

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void createMessage(int userone, int replyid, int cid, String content) {
        try {
            String sql = "INSERT INTO dbo.Message(message_content, createdAt, userID, c_id)\n"
                    + "VALUES(?,GETDATE(),?,?)";

            if (findConversation(userone, userone)) {
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
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
