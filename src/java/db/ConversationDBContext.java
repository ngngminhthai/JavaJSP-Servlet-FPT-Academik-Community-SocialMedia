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

}
