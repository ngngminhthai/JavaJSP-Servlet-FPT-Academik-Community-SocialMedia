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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
    String strDate = sdf.format(cal.getTime());

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
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
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

            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateLastActive(int quesid) {
        String sql = "UPDATE dbo.Question SET lastActive = GETDATE() WHERE QuestionID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quesid);
            stm.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Question> getQuestionsWithUserLogin(int pageindex, int pagesize, int userid, String field, String type) {
        NotificationDBContext notidb = new NotificationDBContext();
        try {
            TagDBContext tagDB = new TagDBContext();
            MainTagDBContext mainDB = new MainTagDBContext();
            ArrayList<Question_Tag> tags = null;
            Main_Tag main = null;
            String sql = "SELECT tbl.totalViews, tbl.totalComment, tbl.lastActive, tbl.mtid,QuestionID,UserID,title,summary,createdAt,content,totalLike from  (SELECT *,ROW_NUMBER() OVER (ORDER BY " + field + " " + type + ",q.rs ASC) as row_index  FROM ( SELECT q.totalViews,q.totalComment,q.lastActive,q.QuestionID,q.UserID,q.createdAt,q.totalLike,mq.mtid,q.summary,q.content,q.title,2 AS rs  FROM dbo.Question AS q LEFT JOIN dbo.MainTag_Question AS mq ON mq.questionid = q.QuestionID LEFT JOIN dbo.MainTag_User AS u ON u.mtid = mq.mtid WHERE  u.userid IS NULL OR u.userid != ?\n"
                    + " UNION\n"
                    + " SELECT q.totalViews,q.totalComment,q.lastActive,q.QuestionID,q.UserID,q.createdAt,q.totalLike,mq.mtid,q.summary,q.content,q.title,1 AS rs FROM dbo.Question AS q LEFT JOIN dbo.MainTag_Question AS mq ON mq.questionid = q.QuestionID JOIN dbo.MainTag_User AS u ON u.mtid = mq.mtid WHERE u.userid = ?\n"
                    + ") AS q) tbl\n"
                    + "WHERE row_index >= (? -1)*? + 1\n"
                    + "AND row_index <= ? * ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);
            stm.setInt(2, userid);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            stm.setInt(5, pageindex);
            stm.setInt(6, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                tags = tagDB.getTagsByQuesID(rs.getInt("QuestionID"));
                main = mainDB.getMainTagByQuesID(rs.getInt("QuestionID"), userid);
                Question s = new Question(rs.getInt("QuestionID"), rs.getInt("UserID"), rs.getString("title"), rs.getString("summary"), rs.getString("createdAt"), rs.getString("content"), tags, main, rs.getInt("totalLike"));
                s.setUser(findUser(rs.getInt("UserID")));
                s.setLastActive(notidb.findDifference(rs.getString("lastActive"), strDate));
                s.setTotalComment(rs.getInt("totalComment"));
                s.setViews(rs.getInt("totalViews"));
                questions.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    public ArrayList<Question> SearchQuestion(int userid, int pageindex, int pagesize, String field, String type, String searchContent) {
        NotificationDBContext notidb = new NotificationDBContext();
        try {
            TagDBContext tagDB = new TagDBContext();
            MainTagDBContext mainDB = new MainTagDBContext();
            ArrayList<Question_Tag> tags = null;
            Main_Tag main = null;
            String sql = "SELECT totalViews,totalComment, lastActive,QuestionID,UserID,title,summary,createdAt,content,totalLike from  (SELECT *,ROW_NUMBER() OVER (ORDER BY "+field+" "+type+") as row_index  FROM dbo.Question as q) tbl\n"
                    + "            WHERE row_index >= (? -1)*? + 1 \n"
                    + "                    AND row_index <= ? * ? AND (content LIKE ? OR title LIKE ?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            searchContent = "%" + searchContent + "%";
            stm.setString(5, searchContent);
            stm.setString(6, searchContent);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                tags = tagDB.getTagsByQuesID(rs.getInt("QuestionID"));
                main = mainDB.getMainTagByQuesID(rs.getInt("QuestionID"), userid);
                Question s = new Question(rs.getInt("QuestionID"), rs.getInt("UserID"), rs.getString("title"), rs.getString("summary"), rs.getString("createdAt"), rs.getString("content"), tags, main, rs.getInt("totalLike"));
                s.setUser(findUser(rs.getInt("UserID")));
                s.setLastActive(notidb.findDifference(rs.getString("lastActive"), strDate));
                s.setTotalComment(rs.getInt("totalComment"));
                s.setViews(rs.getInt("totalViews"));
                questions.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }
//    public static void main(String[] args) {
//        QuestionDBContext ques = new QuestionDBContext();
//        ArrayList<Question> quess = ques.SearchQuestion(-1, 1, 10, "q.createdAt", "desc", "t");
//        for (Question ques1 : quess) {
//            System.out.println(ques1.getQuestionID());
//        }
//    }

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

    public ArrayList<Question> getQuestions(int pageindex, int pagesize, int userid, String field, String type) {
        NotificationDBContext notidb = new NotificationDBContext();
        try {
            TagDBContext tagDB = new TagDBContext();
            MainTagDBContext mainDB = new MainTagDBContext();
            ArrayList<Question_Tag> tags = null;
            Main_Tag main = null;
            String sql = "SELECT totalViews,totalComment, lastActive,QuestionID,UserID,title,summary,createdAt,content,totalLike from  (SELECT *,ROW_NUMBER() OVER (ORDER BY " + field + " " + type + ") as row_index  FROM dbo.Question as q) tbl\n"
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
                s.setUser(findUser(rs.getInt("UserID")));
                s.setLastActive(notidb.findDifference(rs.getString("lastActive"), strDate));
                s.setTotalComment(rs.getInt("totalComment"));
                s.setViews(rs.getInt("totalViews"));
                questions.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    public User findUser(int userid) {
        try {
            String sql = "SELECT userid, username from [User] where userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("userid"), rs.getString("username"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Question> getQuestionsSort(int pageindex, int pagesize, int userid, String field, String type) {
        NotificationDBContext notidb = new NotificationDBContext();
        try {
            TagDBContext tagDB = new TagDBContext();
            MainTagDBContext mainDB = new MainTagDBContext();
            ArrayList<Question_Tag> tags = null;
            Main_Tag main = null;
            String sql = "SELECT totalComment, lastActive,QuestionID,UserID,title,summary,createdAt,content,totalLike from  (SELECT *,ROW_NUMBER() OVER (ORDER BY ? ?) as row_index  FROM dbo.Question) tbl\n"
                    + "            WHERE row_index >= (? -1)*? + 1 \n"
                    + "                    AND row_index <= ? * ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, field);
            stm.setString(2, type);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            stm.setInt(5, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                tags = tagDB.getTagsByQuesID(rs.getInt("QuestionID"));
                main = mainDB.getMainTagByQuesID(rs.getInt("QuestionID"), userid);
                Question s = new Question(rs.getInt("QuestionID"), rs.getInt("UserID"), rs.getString("title"), rs.getString("summary"), rs.getString("createdAt"), rs.getString("content"), tags, main, rs.getInt("totalLike"));
                s.setUser(findUser(rs.getInt("UserID")));
                s.setLastActive(notidb.findDifference(rs.getString("lastActive"), strDate));
                s.setTotalComment(rs.getInt("totalComment"));
                questions.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
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
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
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
        int quesid = -1;
        try {
            String sql_insert_ques = "insert into question(UserID,title,summary,createdAt,content,lastActive) VALUES(?,?,?,?,?,GETDATE())";
            connection.setAutoCommit(false);
            PreparedStatement stm_insert_ques = connection.prepareStatement(sql_insert_ques);

            stm_insert_ques.setInt(1, userid);
            stm_insert_ques.setString(2, title);
            stm_insert_ques.setString(3, summary);
            stm_insert_ques.setString(4, createdAt);
            stm_insert_ques.setString(5, content);

            stm_insert_ques.executeUpdate();

            String sql_get_id = "select @@IDENTITY as QuestionID";
            PreparedStatement stm_get_id = connection.prepareStatement(sql_get_id);

            ResultSet rs = stm_get_id.executeQuery();
            if (rs.next()) {
                quesid = rs.getInt("QuestionID");
            }

            String sql = "INSERT INTO dbo.MainTag_Question(mtid, questionid)\n"
                    + "VALUES(?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(2, quesid);
            stm.setString(1, maintag);

            stm.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                return quesid;
            } catch (SQLException ex) {
                Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            //close connection
        }
        return 0;
    }

}
