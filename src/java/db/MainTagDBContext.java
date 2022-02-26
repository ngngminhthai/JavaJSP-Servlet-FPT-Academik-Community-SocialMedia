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

    public Main_Tag getMainTagByQuesID(int quesid) {

        try {
            String sql = "SELECT mt.mtid FROM dbo.Question AS q JOIN MainTag_Question AS mt ON mt.questionid = q.QuestionID where q.questionid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, quesid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Main_Tag tag = new Main_Tag(rs.getString(1));
                return tag;
            }

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
