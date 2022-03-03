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
    public void insertLikeToQues(int quesid, int userid) {
        String sql2 = "INSERT INTO dbo.Question_Like(UserID, QuestionID)\n"
                + "VALUES(?,\n"
                + "?   \n"
                + "    )";
        try {
            PreparedStatement stm = connection.prepareStatement(sql2);
            stm.setInt(1, userid);
            stm.setInt(2, quesid);

            stm.executeUpdate();

        } catch (SQLException ex) {
            deleteLikeOfQues(quesid, userid);
            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteLikeOfQues(int quesid, int userID) {
        sql = "DELETE FROM dbo.Question_Like WHERE QuestionID = ? AND UserID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, quesid);
            stm.setInt(2, userID);

            stm.executeUpdate();

        } catch (SQLException ex) {
            
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Question> getQuestions(int pageindex, int pagesize, int userid) {

        try {
            TagDBContext tagDB = new TagDBContext();
            MainTagDBContext mainDB = new MainTagDBContext();
            ArrayList<Question_Tag> tags = null;
            Main_Tag main = null;
            String sql = "SELECT QuestionID,UserID,title,summary,createdAt,content,totalLike from  (SELECT *,ROW_NUMBER() OVER (ORDER BY createdAt ASC) as row_index  FROM dbo.Question) tbl\n"
                    + "            WHERE row_index >= (? -1)*? + 1 \n"
                    + "                    AND row_index <= ? * ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                tags = tagDB.getTagsByQuesID(rs.getInt("QuestionID"));
                main = mainDB.getMainTagByQuesID(rs.getInt("QuestionID"), userid);
                Question s = new Question(rs.getInt("QuestionID"), rs.getInt("UserID"), rs.getString("title"), rs.getString("summary"), rs.getString("createdAt"), rs.getString("content"), tags, main, rs.getInt("totalLike"));
                questions.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    public int count() {
        try {
            String sql = "SELECT COUNT(*) as Total FROM Question";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public Question getQuestions2(int quesid, int currentUser) {

        try {
            TagDBContext tagDB = new TagDBContext();
            MainTagDBContext mainDB = new MainTagDBContext();
            ArrayList<Question_Tag> tags = null;
            Main_Tag main = null;
            String sql = "SELECT QuestionID,UserID,title,summary,createdAt,content,totalLike from Question where questionid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quesid);
            ResultSet rs = stm.executeQuery();

            if (currentUser == -1) {
                if (rs.next()) {
                    tags = tagDB.getTagsByQuesID(rs.getInt("QuestionID"));
                    main = mainDB.getMainTagByQuesID(rs.getInt("QuestionID"), currentUser);
                    Question s = new Question(rs.getInt("QuestionID"), rs.getInt("UserID"), rs.getString("title"), rs.getString("summary"), rs.getString("createdAt"), rs.getString("content"), tags, main, rs.getInt("totalLike"));
                    return s;
                }
            } else {
                if (rs.next()) {
                    tags = tagDB.getTagsByQuesID(rs.getInt("QuestionID"));
                    main = mainDB.getMainTagByQuesID(rs.getInt("QuestionID"), currentUser);
                    boolean isLike = checkIsLike(currentUser, quesid);
                    Question s = new Question(rs.getInt("QuestionID"), rs.getInt("UserID"), rs.getString("title"), rs.getString("summary"), rs.getString("createdAt"), rs.getString("content"), tags, main, isLike, rs.getInt("totalLike"));
                    return s;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkIsLike(int userid, int quesid) {
        String newsql = "	select count(*) as total from dbo.Question_Like where userid = ? and QuestionID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(newsql);
            stm.setInt(1, userid);
            stm.setInt(2, quesid);

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

    public int createQuestion(int userid, String title, String summary, String createdAt, String content, String maintag) {

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
            ResultSet rs = stm.executeQuery("select questionid from question");
            int quesid = -1;
            if (rs.last()) {
                quesid = rs.getInt("questionid");
            }

            mainDB.LinkTagToQuestion(quesid, maintag);

            return quesid;

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
