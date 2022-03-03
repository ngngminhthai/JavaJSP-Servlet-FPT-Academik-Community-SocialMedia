/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CommentDBContext;
import db.MainTagDBContext;
import db.QuestionDBContext;
import db.TagDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comment;
import model.Main_Tag;
import model.Question;
import model.Question_Tag;
import model.Tag;
import model.User;

/**
 *
 * @author Admin
 */
public class ThreadController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int questionID = Integer.parseInt(request.getParameter("questionid"));

        QuestionDBContext quesDB = new QuestionDBContext();
        TagDBContext tagDB = new TagDBContext();
        CommentDBContext comDB = new CommentDBContext();
        MainTagDBContext mainDB = new MainTagDBContext();

        Object raw_userID = request.getSession().getAttribute("userID");
        int userID = -1;
        if (raw_userID != null) {
            userID = (Integer) request.getSession().getAttribute("userID");
        }

        Question clickedQuestion = quesDB.getQuestions2(questionID, userID);
        User user = quesDB.getUserByQuestionID(clickedQuestion.getQuestionID());
        ArrayList<Question_Tag> tagList = tagDB.getTagsByQuesID(clickedQuestion.getQuestionID());
        ArrayList<Comment> comLists = comDB.getCommentByQuestionID(questionID, userID);
        Main_Tag main = mainDB.getMainTagByQuesID(clickedQuestion.getQuestionID(), userID);

        request.setAttribute("comlist", comLists);
        request.setAttribute("userid", user);
        request.setAttribute("clickedQues", clickedQuestion);
        request.setAttribute("taglist", tagList);
        request.setAttribute("main", main);
        request.getRequestDispatcher("pages/thread3.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
