/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Main_Tag;
import model.Question;
import model.Question_Tag;
import model.User;

/**
 *
 * @author Admin
 */
public class QuestionDBContext extends DBContext {

    String sql = null;
    ArrayList<Question> questions = new ArrayList<>();

//    public ArrayList<Question> getQuestions() {
//
//        try {
//            String sql = "select QuestionID,UserID,title,summary,createdAt,content,majorid from Question";
//
//            PreparedStatement stm = connection.prepareStatement(sql);
//
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                Question s = new Question(rs.getInt("QuestionID"), rs.getInt("UserID"), rs.getString("title"), rs.getString("summary"), rs.getString("createdAt"), rs.getString("content"), rs.getInt("majorid"));
//                questions.add(s);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return questions;
//    }
    public ArrayList<Question> getQuestions() {

        try {
            TagDBContext tagDB = new TagDBContext();
            MainTagDBContext mainDB = new MainTagDBContext();
            ArrayList<Question_Tag> tags = null;
            Main_Tag main = null;
            String sql = "select QuestionID,UserID,title,summary,createdAt,content from Question";

            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                tags = tagDB.getTagsByQuesID(rs.getInt("QuestionID"));
                main = mainDB.getMainTagByQuesID(rs.getInt("QuestionID"));
                Question s = new Question(rs.getInt("QuestionID"), rs.getInt("UserID"), rs.getString("title"), rs.getString("summary"), rs.getString("createdAt"), rs.getString("content"), tags, main);
                questions.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    public User getUserByQuestionID(int questionID) {
        try {
            String sql = "SELECT u.UserID, u.username FROM dbo.[User] AS u JOIN dbo.Question AS q ON q.UserID = u.UserID WHERE q.QuestionID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionID);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getInt("UserID"), rs.getString("username"));
                return user;
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Question> getQuestionsByForum(int majorID) {
        ArrayList<Question> questionsByForum = new ArrayList<>();

        try {
            String sql = "select QuestionID,UserID,title,summary,createdAt,content,majorid from Question where majorid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, majorID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                User user = getUserByQuestionID(rs.getInt("QuestionID"));
                Question s = new Question(rs.getInt("QuestionID"), user, rs.getString("title"), rs.getString("summary"), rs.getString("createdAt"), rs.getString("content"), rs.getInt("majorid"));
                questionsByForum.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questionsByForum;
    }

    public int sizeOfQuesList() {
        return questions.size();
    }

    public Question createQuestion(int userid, String title, String summary, String createdAt, String content, String maintag) {

        String sql = "insert into question(UserID,title,summary,createdAt,content) VALUES(?,?,?,?,?)";
        try {
            MainTagDBContext mainDB = new MainTagDBContext();
            
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, userid);
            stm.setString(2, title);
            stm.setString(3, summary);
            stm.setString(4, createdAt);
            stm.setString(5, content);
            
            
            stm.executeUpdate();
            
            Question q = getQuestions().get(questions.size() - 1);
            mainDB.LinkTagToQuestion(q.getQuestionID(), maintag);
            
            return q;

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
