/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Admin
 */
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Question;
import model.Question_Tag;
import model.Tag;

public class TagDBContext extends DBContext {

    String sql = null;

//    public ArrayList<Tag> getTags() {
//        ArrayList<Tag> tags = new ArrayList<>();
//        try {
//            sql = "select tagname, tagid from tag";
//
//            PreparedStatement stm = connection.prepareStatement(sql);
//
//            ResultSet rs = stm.executeQuery();
//
//            while (rs.next()) {
//                Tag s = new Tag(rs.getInt("tagid"), rs.getString("tagname"));
//                tags.add(s);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return tags;
//    }
    public ArrayList<Question_Tag> getTagsByQuesID(int questionID) {
        ArrayList<Question_Tag> tags = new ArrayList<>();
        try {
            sql = "SELECT TagID, QuestionID FROM dbo.Question_Tag WHERE QuestionID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Question_Tag q = new Question_Tag(rs.getInt("QuestionID"), rs.getString("TagID"));
                tags.add(q);
            }
            return tags;

        } catch (SQLException ex) {
            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tags;
    }

    public void createTag(String tagID, int questionID) {
        String sql = "insert into tag values (?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, tagID);
            stm.executeUpdate();
            createQuestion_Tag(questionID, tagID);
            
        } catch (SQLException ex) {
            createQuestion_Tag(questionID, tagID);
            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createQuestion_Tag(int questionid, String tagid) {
        String sql2 = "INSERT INTO dbo.Question_Tag VALUES(?,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql2);
            stm.setString(1, tagid);
            stm.setInt(2, questionid);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getSizeOfTagList() {
        int count = 0;
        sql = "select count(*) as numberOfTags from tag";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            count = rs.getInt(1);
            return count;

        } catch (SQLException ex) {
            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

//    public void createQuestion_Tag(int tagID, int questionID) {
//
//        sql = "insert into tag values (?)";
//        try {
//            PreparedStatement stm = connection.prepareStatement(sql);
//
//            stm.setString(1, tagName);
//
//            stm.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
