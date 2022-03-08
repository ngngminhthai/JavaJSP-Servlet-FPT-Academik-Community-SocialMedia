/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;
import model.Comment_Like;
import model.Major;
import model.User;

/**
 *
 * @author Admin
 */
public class CommentDBContext extends DBContext {
    
    String sql = null;
    ArrayList<Comment> comments = new ArrayList<>();
    
    public ArrayList<Comment> getCommentByQuestionID(int questionId, int userid) {
        
        try {
            sql = "SELECT q1.CommentID,q1.QuestionID,q1.content,q1.createdAt,u.UserID,u.username,q2.CommentID AS commentid2,q2.QuestionID AS questionid2,q2.content AS content2,q2.createdAt AS createdat2, u2.UserID AS userid2, u2.username AS username2 FROM dbo.Question_comment AS q1 FULL OUTER JOIN dbo.[User] AS u ON u.UserID = q1.UserID FULL OUTER JOIN dbo.Question_comment AS q2 ON q2.CommentID = q1.replyTo FULL OUTER JOIN dbo.[User] AS u2 ON u2.UserID = q2.UserID WHERE q1.QuestionID = ?";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionId);
            ResultSet rs = stm.executeQuery();
            
            User user2 = null;
            Comment comment2 = null;
            User user1 = null;
            int totalLike = -1;
            Comment comment1 = null;
            
            if (userid == -1) {
                while (rs.next()) {
                    user2 = new User(rs.getInt(11), rs.getString(12));
                    
                    comment2 = new Comment(rs.getInt(7), rs.getInt(8), user2, rs.getString(9), rs.getString(10));
                    
                    user1 = new User(rs.getInt("userid"), rs.getString("username"));
                    
                    totalLike = getLikeByCommentID2(rs.getInt("CommentID"));
                    
                    comment1 = new Comment(rs.getInt("CommentID"), rs.getInt("QuestionID"), user1, rs.getString("content"), rs.getString("createdAt"), comment2, totalLike);
                    
                    comments.add(comment1);
                }
            } else {
                while (rs.next()) {
                    user2 = new User(rs.getInt(11), rs.getString(12));
                    
                    comment2 = new Comment(rs.getInt(7), rs.getInt(8), user2, rs.getString(9), rs.getString(10));
                    
                    user1 = new User(rs.getInt("userid"), rs.getString("username"));
                    
                    boolean islike = checkIsLike(userid, rs.getInt("CommentID"));
                    
                    totalLike = getLikeByCommentID2(rs.getInt("CommentID"));
                    
                    comment1 = new Comment(rs.getInt("CommentID"), rs.getInt("QuestionID"), user1, rs.getString("content"), rs.getString("createdAt"), comment2, islike, totalLike);
                    
                    comments.add(comment1);
                }
            }
            return comments;
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }
    
    public int getLikeByCommentIDLogin(int userid, int commentid) {
        //select * from comment_like where userid not like 1 and CommentID = 33
        String newsql = "SELECT count(*)\n"
                + "FROM comment_like\n"
                + "where userid not like ? and CommentID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(newsql);
            stm.setInt(1, userid);
            stm.setInt(2, commentid);
            
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int getLikeByCommentID2(int commentid) {
        //select * from comment_like where userid not like 1 and CommentID = 33
        String newsql = "SELECT count(*)\n"
                + "FROM comment_like\n"
                + "where CommentID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(newsql);
            stm.setInt(1, commentid);
            
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean checkIsLike(int userid, int commentid) {
        String newsql = "select count(*) as total from Comment_like where userid = ? and commentid = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(newsql);
            stm.setInt(1, userid);
            stm.setInt(2, commentid);
            
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
//    public ArrayList<Comment> getCommentByQuestionID(int questionId) {
//
//        try {
//            sql = "SELECT CommentID,QuestionID,u.UserID,u.username,content,createdAt,replyTo  FROM dbo.Question_comment AS qm JOIN dbo.[User] u ON u.UserID = qm.UserID"
//                    + " WHERE qm.QuestionID = ?";
//
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, questionId);
//            ResultSet rs = stm.executeQuery();
//
//            while (rs.next()) {
//                User user = new User(rs.getInt("UserID"), rs.getString("username"));
//                Comment comment = new Comment(rs.getInt("CommentID"), rs.getInt("QuestionID"), user, rs.getString("content"), rs.getString("createdAt"), rs.getInt("replyTo"));
//                comments.add(comment);
//            }
//            return comments;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return comments;
//    }

//     public Comment createComment(int questionID, int userID, String content, String createdAt){
//         
//     }
    public void createComment(int questionID, int userID, String content) {
        QuestionDBContext quesdb = new QuestionDBContext();
        sql = "INSERT INTO dbo.Question_comment(QuestionID, UserID, content, createdAt) VALUES(?,?,?,GETDATE() )";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            
            stm.setInt(1, questionID);
            stm.setInt(2, userID);
            stm.setString(3, content);
            
            stm.executeUpdate();
            quesdb.updateLastActive(questionID);
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateForReplies(int old_commentID, int new_commentID) {
        String newsql = "	UPDATE dbo.Question_comment SET replyTo = ? WHERE CommentID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(newsql);
            
            stm.setInt(1, old_commentID);
            stm.setInt(2, new_commentID);
            
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getLastCommentAdded() {
        String newsql = "WITH x AS (SELECT *, r = RANK() OVER (ORDER BY createdAt DESC) FROM dbo.Question_comment) SELECT x.CommentID FROM x WHERE r = 1";
        int commentIDAdded = -1;
        try {
            
            PreparedStatement stm = connection.prepareStatement(newsql);
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                commentIDAdded = rs.getInt("CommentID");
            }
            return commentIDAdded;
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public void insertLikeToComment(int commentID, int userID) {
        sql = "insert into Comment_like (UserID,CommentID) values(?,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            
            stm.setInt(1, userID);
            stm.setInt(2, commentID);
            
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            deleteLikeOfComment(commentID, userID);
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void deleteLikeOfComment(int commentID, int userID) {
        sql = "delete comment_like where userid = ? and CommentID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            
            stm.setInt(1, userID);
            stm.setInt(2, commentID);
            
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            deleteLikeOfComment(commentID, userID);
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
