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
import model.Notification;
import model.Question;
import model.User;

/**
 *
 * @author Admin
 */
public class NotificationDBContext extends DBContext {

    public void addNotification(int toUser, int fromUser, int questionID) {
        String sql = "INSERT INTO dbo.Notification(toUser, fromUser, sourceID) VALUES(?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, toUser);
            stm.setInt(2, fromUser);
            stm.setInt(3, questionID);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Notification> getNotifications(int userid) {
        ArrayList<Notification> notifitcations = new ArrayList<>();
        try {
            String sql = "SELECT u.username,u.UserID,q.QuestionID, q.title, q.summary FROM dbo.Notification AS n JOIN dbo.[User] AS u ON u.UserID = n.fromUser JOIN dbo.Question AS q ON q.QuestionID = n.sourceID WHERE n.toUser = ?";
            
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User fromUser = new User(rs.getInt("UserID"), rs.getString("username"));
                Question source = new Question(rs.getInt("QuestionID"), rs.getString("title"), rs.getString("summary"));
                Notification notification = new Notification(fromUser, source);
                notifitcations.add(notification);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return notifitcations;
    }
}
