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

    public static void main(String[] args) {
        UserDBContext u = new UserDBContext();
//        ArrayList<User> ul = u.getUser();
//        for (User user : ul) {
//            System.out.println(user.getUsername());
//        }
        u.updateview("mo");
      
    }
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

    public ArrayList<User> getUser() {
        ArrayList<User> ul = new ArrayList<>();
        try {
            String sql = "SELECT u.password,u.UserID,u.username,u.email,u.img,g.groupName FROM dbo.[User] AS u JOIN dbo.User_Group AS ug ON  ug.userID = u.UserID JOIN dbo.[Group] AS g ON g.groupID = ug.groupID";
            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("UserID"));
                u.setPassword(rs.getString("password"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setImg(rs.getString("img"));
                u.setFeature(rs.getString("groupName"));
                ul.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ul;
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

    public int getRole(int userid) {
        try {
            //SELECT u.UserID,u.username,g.groupName,g.groupID,u.password FROM dbo.[User] AS u JOIN dbo.User_Group AS ug ON  ug.userID = u.UserID JOIN dbo.[Group] AS g ON g.groupID = ug.groupID WHERE u.username = 'thulinh' and u.password = 'thulinh'

            String sql = "SELECT u.UserID,u.username,g.groupName,g.groupID FROM dbo.[User] AS u JOIN dbo.User_Group AS ug ON  ug.userID = u.UserID JOIN dbo.[Group] AS g ON g.groupID = ug.groupID where u.userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String groupname = rs.getString("groupName");
                if (groupname.equals("Admin")) {
                    return 4;
                } else if (groupname.equals("Super Moderator")) {
                    return 3;
                } else if (groupname.equals("Moderator")) {
                    return 2;
                } else if (groupname.equals("User")) {
                    return 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void detele(int userid) {
        try {
            String sql = "delete from [user] where userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void register(String username, String password) {
        try {
            int userid = -1;
            connection.setAutoCommit(false);
            String sql_insert_user = "INSERT INTO dbo.[User](password, registeredAt, username)\n"
                    + "VALUES(?,GETDATE(),?)";

            PreparedStatement stm_insert_user = connection.prepareStatement(sql_insert_user);
            stm_insert_user.setString(1, password);
            stm_insert_user.setString(2, username);

            stm_insert_user.executeUpdate();

            String sql_get_id = "select @@IDENTITY as userID";
            PreparedStatement stm_get_id = connection.prepareStatement(sql_get_id);

            ResultSet rs = stm_get_id.executeQuery();
            if (rs.next()) {
                userid = rs.getInt("userID");
            }

            String sql = "INSERT INTO dbo.User_Group(groupID, userID)\n"
                    + "VALUES(3, \n"
                    + "?   \n"
                    + "    )";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);

            stm.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isExits(String username) {
        try {
            String sql = "select count(*) as total from [user] where username like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                if (rs.getInt("total") == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void update(int memid, String username, String password, String email) {
        try {
            String sql = "update [user] set username = ?, password = ?, email = ? where userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(4, memid);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, email);
                    
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
