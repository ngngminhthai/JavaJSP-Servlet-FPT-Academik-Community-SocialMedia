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
import model.User;
import model.View;

/**
 *
 * @author Admin
 */
public class UserDBContext extends DBContext {

    public void updateStatus(int status, int userid) {

        try {
            String sql = "UPDATE dbo.[User] SET onlineStatus = ? WHERE UserID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, status);
            stm.setInt(2, userid);
            stm.executeUpdate();

            String sql_lastActive = "UPDATE dbo.[User] SET lastLogin = GETDATE() WHERE UserID = ?";
            PreparedStatement stm2 = connection.prepareStatement(sql_lastActive);
            stm2.setInt(1, userid);
            stm2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateImg(int userid, String img) {

        try {
            String sql = "update [user] set img = ? where userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(2, userid);
            stm.setString(1, img);
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String findImg(int userid) {

        try {
            String sql = "select img from [user] where userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                if (rs.getString("img") == null) {
                    return "";
                } else {
                    return rs.getString("img");
                }
            }
            return "";
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

//    public static void main(String[] args) {
//        UserDBContext u = new UserDBContext();
//        u.updateview("sa");
//    }

    public void updateview(String today) {
        try {
            String sql = "update views set " + today + " = " + today + " + 1";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public View getview() {
        try {
            String sql = "select mo,tu,we,th,fr,sa,su from views";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                View v = new View();
                v.setMo(rs.getInt("mo"));
                v.setTu(rs.getInt("tu"));
                v.setWe(rs.getInt("we"));
                v.setTh(rs.getInt("th"));
                v.setFr(rs.getInt("fr"));
                v.setSa(rs.getInt("sa"));
                v.setSu(rs.getInt("su"));
                return v;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//    public static void main(String[] args) {
//        UserDBContext u = new UserDBContext();
//        System.out.println(u.getview().getSu());
//    }

    public String getimg(String userid) {

        try {
            String sql = "select img from [user] where username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userid);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                if (rs.getString("img") == null) {
                    return "";
                } else {
                    return rs.getString("img");
                }
            }
            return "";
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public User getUserInfo(int userid) {

        try {
            String sql = "SELECT UserID,firstName,middleName,lastName,email,img,username FROM dbo.[User] where userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                u.setMiddleName(rs.getString("middleName"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setImg(rs.getString("img"));
                return u;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
