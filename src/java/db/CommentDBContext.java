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

    public ArrayList<Comment> getCommentByQuestionID2(int questionId, int userid, String type) {

        try {
            String sql = "(SELECT q1.CommentID,q1.QuestionID,q1.content,q1.createdAt,u.UserID,u.username,q2.CommentID AS commentid2,q2.QuestionID AS questionid2,q2.content AS content2,q2.createdAt AS createdat2, u2.UserID AS userid2, u2.username AS username2, 1 AS rs,q1.isBest,q1.totalReplies,q1.TotalLike,u.img,u2.img AS img2 FROM dbo.Question_comment AS q1 FULL OUTER JOIN dbo.[User] AS u ON u.UserID = q1.UserID FULL OUTER JOIN dbo.Question_comment AS q2 ON q2.CommentID = q1.replyTo FULL OUTER JOIN dbo.[User] AS u2 ON u2.UserID = q2.UserID WHERE q1.QuestionID = ? and q1.isBest is NULL)\n"
                    + "UNION all\n"
                    + "(SELECT q1.CommentID,q1.QuestionID,q1.content,q1.createdAt,u.UserID,u.username,q2.CommentID AS commentid2,q2.QuestionID AS questionid2,q2.content AS content2,q2.createdAt AS createdat2, u2.UserID AS userid2, u2.username AS username2,2 AS rs ,q1.isBest,q1.totalReplies,q1.TotalLike,u.img,u2.img AS img2 FROM dbo.Question_comment AS q1 FULL OUTER JOIN dbo.[User] AS u ON u.UserID = q1.UserID FULL OUTER JOIN dbo.Question_comment AS q2 ON q2.CommentID = q1.replyTo FULL OUTER JOIN dbo.[User] AS u2 ON u2.UserID = q2.UserID WHERE q1.QuestionID = ? and q1.isBest = 1)\n"
                    + "UNION all\n"
                    + "(SELECT q1.CommentID,q1.QuestionID,q1.content,q1.createdAt,u.UserID,u.username,q2.CommentID AS commentid2,q2.QuestionID AS questionid2,q2.content AS content2,q2.createdAt AS createdat2, u2.UserID AS userid2, u2.username AS username2,0 AS rs,q1.isBest,q1.totalReplies,q1.TotalLike,u.img,u2.img AS img2 FROM dbo.Question_comment AS q1 FULL OUTER JOIN dbo.[User] AS u ON u.UserID = q1.UserID FULL OUTER JOIN dbo.Question_comment AS q2 ON q2.CommentID = q1.replyTo FULL OUTER JOIN dbo.[User] AS u2 ON u2.UserID = q2.UserID WHERE q1.QuestionID = ? and q1.isBest = 0)\n"
                    + "ORDER BY rs DESC," + type + " DESC";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionId);
            stm.setInt(2, questionId);
            stm.setInt(3, questionId);
            ResultSet rs = stm.executeQuery();

            User user2 = null;
            Comment comment2 = null;
            User user1 = null;
            int totalLike = -1;
            Comment comment1 = null;

            if (userid == -1) {
                while (rs.next()) {

                    user2 = new User(rs.getInt(11), rs.getString(12));
                    user2.setImg(rs.getString("img2"));

                    comment2 = new Comment(rs.getInt(7), rs.getInt(8), user2, rs.getString(9), rs.getString(10));

                    user1 = new User(rs.getInt("userid"), rs.getString("username"));
                    user1.setImg(rs.getString("img"));

                    totalLike = getLikeByCommentID2(rs.getInt("CommentID"));

                    comment1 = new Comment(rs.getInt("CommentID"), rs.getInt("QuestionID"), user1, rs.getString("content"), rs.getString("createdAt"), comment2, totalLike);

                    if (rs.getString("isBest") == null) {
                        comment1.setStatus("NULL");
                    } else if (rs.getString("isBest").equals("1")) {
                        comment1.setStatus("Được bình chọn");
                    } else if (rs.getString("isBest").equals("0")) {
                        comment1.setStatus("Bị gắn cờ");
                    }
//                    comment1.setTotalReplies(rs.getInt("CommentID"));
                    comments.add(comment1);
                }
            } else {
                while (rs.next()) {
                    user2 = new User(rs.getInt(11), rs.getString(12));
                    user2.setImg(rs.getString("img2"));

                    comment2 = new Comment(rs.getInt(7), rs.getInt(8), user2, rs.getString(9), rs.getString(10));

                    user1 = new User(rs.getInt("userid"), rs.getString("username"));
                    user1.setImg(rs.getString("img"));

                    boolean islike = checkIsLike(userid, rs.getInt("CommentID"));

                    totalLike = getLikeByCommentID2(rs.getInt("CommentID"));

                    comment1 = new Comment(rs.getInt("CommentID"), rs.getInt("QuestionID"), user1, rs.getString("content"), rs.getString("createdAt"), comment2, islike, totalLike);

                    if (rs.getString("isBest") == null) {
                        comment1.setStatus("NULL");
                    } else if (rs.getString("isBest").equals("1")) {
                        comment1.setStatus("Được bình chọn");
                    } else if (rs.getString("isBest").equals("0")) {
                        comment1.setStatus("Bị gắn cờ");
                    }
//                    comment1.setTotalReplies(rs.getInt("CommentID"));
                    comments.add(comment1);
                }
            }
            return comments;

        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

    //SELECT COUNT(q2.CommentID),q1.CommentID FROM dbo.Question_comment AS q1 LEFT JOIN dbo.Question_comment AS q2 ON q1.CommentID = q2.replyTo GROUP BY q1.CommentID
    public int getTotalReplies(int commentid) {
        //select * from comment_like where userid not like 1 and CommentID = 33
        String newsql = "SELECT COUNT(q2.CommentID) as total,q1.CommentID FROM dbo.Question_comment AS q1 LEFT JOIN dbo.Question_comment AS q2 ON q1.CommentID = q2.replyTo where q1.CommentID = ? GROUP BY q1.CommentID"
                + "";
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

//    public static void main(String[] args) {
//        CommentDBContext c = new CommentDBContext();
//        System.out.println(c.checkIsLike(1, 59));
//
//    }
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

    public ArrayList<Comment> getComment() {
        ArrayList<Comment> cl = new ArrayList<>();
        try {
            String sql = "SELECT isBest,QuestionID,CommentID,u.UserID,u.username,content,createdAt FROM dbo.Question_comment AS q JOIN dbo.[User] AS u ON u.UserID = q.UserID";
            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("UserID"));
                u.setUsername(rs.getString("username"));

                Comment c = new Comment(rs.getInt("CommentID"), rs.getInt("QuestionID"), u, rs.getString("content"), rs.getString("createdAt"));
                if (rs.getString("isBest") == null) {
                    c.setStatus("NULL");
                } else if (rs.getString("isBest").equals("1")) {
                    c.setStatus("Được bình chọn");
                } else if (rs.getString("isBest").equals("0")) {
                    c.setStatus("Bị gắn cờ");
                }
                c.setUser(u);
                cl.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }

//    public static void main(String[] args) {
//        CommentDBContext c = new CommentDBContext();
//        c.flag(60, "NULL", 17);
//    }
    public void vote(int comid, String status, int quesid) {
        String sql = "UPDATE dbo.Question_comment SET isBest = 1 WHERE CommentID = ?";
        try {
            if (status.equals("Được bình chọn")) {
                setStatus(quesid);
                return;
            }
            setStatus(quesid);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, comid);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStatus(int quesid) {
        String sql = "UPDATE dbo.Question_comment SET isBest = NULL WHERE isBest = 1 AND QuestionID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quesid);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStatus2(int quesid) {
        String sql = "UPDATE dbo.Question_comment SET isBest = NULL WHERE isBest = 0 AND QuestionID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quesid);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void flag(int comid, String status, int quesid) {
        String sql = "UPDATE dbo.Question_comment SET isBest = 0 WHERE CommentID = ?";
        try {
            if (status.equals("Bị gắn cờ")) {
                setStatus2(quesid);
                return;
            }
            setStatus2(quesid);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, comid);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Comment> getCommentBySubid(String subid) {
        ArrayList<Comment> cl = new ArrayList<>();
        try {
            String sql = "SELECT u.img,u.UserID,u.username,qm.CommentID,qm.content,qm.createdAt,qm.TotalLike,qm.QuestionID FROM dbo.Question_comment AS qm JOIN dbo.Question AS q ON q.QuestionID = qm.QuestionID JOIN dbo.[User] AS u ON u.UserID = q.UserID JOIN dbo.MainTag_Question AS mq ON mq.questionid = q.QuestionID WHERE mq.mtid LIKE ? ORDER BY qm.createdAt";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, subid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("UserID"));
                u.setUsername(rs.getString("username"));
                u.setImg(rs.getString("img"));

                Comment c = new Comment(rs.getInt("CommentID"), rs.getInt("QuestionID"), u, rs.getString("content"), rs.getString("createdAt"));
                c.setUser(u);
                cl.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }
//    public static void main(String[] args) {
//        CommentDBContext c = new CommentDBContext();
//        ArrayList<Comment> cl = c.getCommentBySubid("prj301");
//        for (Comment comment : cl) {
//            System.out.println(comment.getContent());
//        }
//    }

//    public void updateTotalRepied(int Type) {
//        String sql = "UPDATE dbo.Question_comment SET totalReplies = totalReplies + 1 WHERE CommentID = ?";
//        try {
//            if (status.equals("Bị gắn cờ")) {
//                setStatus2(quesid);
//                return;
//            }
//            setStatus2(quesid);
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, comid);
//
//            stm.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
