/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    public String findDifference(String start_date, String end_date) {

        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");

        // Try Block
        try {

            // parse method is used to parse
            // the text from a string to
            // produce the date
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);

            // Calucalte time difference
            // in milliseconds
            long difference_In_Time
                    = d2.getTime() - d1.getTime();

            // Calucalte time difference in
            // seconds, minutes, hours, years,
            // and days
            long difference_In_Seconds
                    = (difference_In_Time
                    / 1000)
                    % 60;

            long difference_In_Minutes
                    = (difference_In_Time
                    / (1000 * 60))
                    % 60;

            long difference_In_Hours
                    = (difference_In_Time
                    / (1000 * 60 * 60))
                    % 24;

            long difference_In_Years
                    = (difference_In_Time
                    / (1000l * 60 * 60 * 24 * 365));

            long difference_In_Days
                    = (difference_In_Time
                    / (1000 * 60 * 60 * 24))
                    % 365;

            // Print the date difference in
            // years, in days, in hours, in
            // minutes, and in seconds
//            System.out.print(
//                    "Difference "
//                    + "between two dates is: ");
//
//            System.out.println(
//                    difference_In_Years
//                    + " years, "
//                    + difference_In_Days
//                    + " days, "
//                    + difference_In_Hours
//                    + " hours, "
//                    + difference_In_Minutes
//                    + " minutes, "
//                    + difference_In_Seconds
//                    + " seconds");
            String finalTime = "";
            if (difference_In_Days >= 1) {
                return difference_In_Days + " ngày trước";
            } else {
                if (difference_In_Hours >= 1) {
                    return difference_In_Hours + " giờ trước";
                } else {
                    return difference_In_Minutes + " phút trước";
                }

            }

        } // Catch the Exception
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNotification(int toUser, int fromUser, int questionID, String typeOfComment, String createdAt) {
        String sql = "INSERT INTO dbo.Notification(toUser, fromUser, sourceID, [type], createdAt, isRead) VALUES(?, ?, ?, ?, ?, 0)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, toUser);
            stm.setInt(2, fromUser);
            stm.setInt(3, questionID);
            stm.setString(4, typeOfComment);
            stm.setString(5, createdAt);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateisRead(int notificationID) {
        String sql = "UPDATE [dbo].[Notification]\n"
                + "   SET\n"
                + "     [isRead] = 1\n"
                + " WHERE [notificationID] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, notificationID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<Notification> getNotifications(int userid) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        String strDate = sdf.format(cal.getTime());
        ArrayList<Notification> notifitcations = new ArrayList<>();
        try {
            String sql = "SELECT u.username,u.UserID,q.QuestionID, q.title, q.summary, n.type, n.createdAt, n.isRead, n.notificationID FROM dbo.Notification AS n JOIN dbo.[User] AS u ON u.UserID = n.fromUser JOIN dbo.Question AS q ON q.QuestionID = n.sourceID WHERE n.toUser = ? ORDER BY n.createdAt";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User fromUser = new User(rs.getInt("UserID"), rs.getString("username"));
                Question source = new Question(rs.getInt("QuestionID"), rs.getString("title"), rs.getString("summary"));
                String timeAgo = findDifference(rs.getString("createdAt"), strDate);
                Notification notification = new Notification(fromUser, source, rs.getString("type"), timeAgo, rs.getBoolean("isRead"), rs.getInt("notificationID"));
                notifitcations.add(notification);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NotificationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return notifitcations;
    }
}
