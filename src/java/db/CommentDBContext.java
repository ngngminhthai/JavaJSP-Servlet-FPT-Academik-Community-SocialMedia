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
import model.Comment;
import model.Major;
import model.User;

/**
 *
 * @author Admin
 */
public class CommentDBContext extends DBContext {

    String sql = null;
    ArrayList<Comment> comments = new ArrayList<>();

    public ArrayList<Comment> getCommentByQuestionID(int questionId) {

        try {
            sql = "SELECT QuestionID,u.UserID,u.username,content,createdAt  FROM dbo.Question_comment AS qm JOIN dbo.[User] u ON u.UserID = qm.UserID"
                    + " WHERE qm.QuestionID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionId);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getInt("UserID"), rs.getString("username"));
                Comment comment = new Comment(rs.getInt("QuestionID"), user, rs.getString("content"), rs.getString("createdAt"));
                comments.add(comment);
            }
            return comments;

        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

//     public Comment createComment(int questionID, int userID, String content, String createdAt){
//         
//     }
}
