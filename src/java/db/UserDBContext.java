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
    
    

    public static void main(String[] args) {
        UserDBContext u = new UserDBContext();
        
        User uu = u.getUserInfo(1);
        System.out.println(uu.getImg());
    }

}
