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
import model.Major;
import model.Question;

/**
 *
 * @author Admin
 */
public class MajorDBContext extends DBContext{
     String sql = null;
      ArrayList<Major> majors = new ArrayList<>();
      
     public ArrayList<Major> getMajor() {

        try {
            sql = "select MajorID, name, summary from major";

            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Major s = new Major(rs.getInt("MajorID"), rs.getString("name"), rs.getString("summary"));
                majors.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MajorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return majors;
    }
}
