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
import model.Main_Tag;
import model.Question;

/**
 *
 * @author Admin
 */
public class MainTagDBContext extends DBContext {

    String sql = null;

    public void follow(int userid, String tagid) {
        String sql2 = "INSERT INTO maintag_user (mtid, userid) VALUES (?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql2);
            stm.setString(1, tagid);
            stm.setInt(2, userid);

            stm.executeUpdate();

        } catch (SQLException ex) {
            unfollow(userid, tagid);
            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void unfollow(int userid, String tagid) {
        String sql2 = "DELETE maintag_user WHERE mtid = ? AND userid = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql2);
            stm.setString(1, tagid);
            stm.setInt(2, userid);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Main_Tag getMainTagByQuesID(int quesid, int userid) {

        try {
            String sql = "SELECT mt.mtid FROM dbo.Question AS q JOIN MainTag_Question AS mt ON mt.questionid = q.QuestionID where q.questionid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, quesid);
            ResultSet rs = stm.executeQuery();

            if (userid != -1) {
                if (rs.next()) {
                    boolean isFollwedByCurrentUser = checkIsFollowed(userid, rs.getString("mtid"));
                    Main_Tag tag = new Main_Tag(rs.getString(1), isFollwedByCurrentUser);
                    return tag;
                }
            } else {
                if (rs.next()) {
                  
                    Main_Tag tag = new Main_Tag(rs.getString(1));
                    return tag;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MainTagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkIsFollowed(int userid, String tagid) {
        String newsql = "select count(*) as total from maintag_user where userid = ? and mtid = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(newsql);
            stm.setInt(1, userid);
            stm.setString(2, tagid);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                if (rs.getInt("total") > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Main_Tag> getMainTags2() {

        try {

            ArrayList<Main_Tag> tags = new ArrayList<>();
            String sql = "SELECT mtid from Main_Tag";

            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Main_Tag tag = new Main_Tag(rs.getString(1));
                tags.add(tag);
            }

            return tags;

        } catch (SQLException ex) {
            Logger.getLogger(MainTagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Main_Tag> getMainTags() {

        try {

            ArrayList<Main_Tag> tags = new ArrayList<>();
            String sql = "SELECT mtid from Main_Tag";

            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Main_Tag tag = new Main_Tag(rs.getString(1));
                tags.add(tag);
            }

            return tags;

        } catch (SQLException ex) {
            Logger.getLogger(MainTagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Main_Tag> LinkTagToQuestion(int quesid, String maintag) {

        try {
            ArrayList<Main_Tag> tags = new ArrayList<>();
            String sql = "INSERT INTO dbo.MainTag_Question(mtid, questionid)\n"
                    + "VALUES(?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(2, quesid);
            stm.setString(1, maintag);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MainTagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
