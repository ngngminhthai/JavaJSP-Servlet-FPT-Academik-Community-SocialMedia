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
public class AccountDBContext extends DBContext {

    String sql = null;

    public User getUser(String username, String password) {
        try {
            sql = "select userid, username, [password] from [user] where username = ? and password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("userid"), rs.getString("username"), rs.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getNumberOfRoles(int userid, String url) {
        try {
            String sql = "SELECT COUNT(*) as Total FROM \n"
                    + "                    [User] a INNER JOIN [User_Group] ag ON a.UserID = ag.userID\n"
                    + "                     INNER JOIN [Group] g ON g.groupID = ag.groupID\n"
                    + "                      INNER JOIN [Group_Feature] gf ON gf.groupID = g.groupID\n"
                    + "                      INNER JOIN [Feature] f ON gf.featureID = f.featureID\n"
                    + "                  WHERE a.UserID = ? AND f.url = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);
            stm.setString(2, url);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
