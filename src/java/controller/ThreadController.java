/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CommentDBContext;
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

        Question clickedQuestion = quesDB.getQuestions().get(questionID - 1);
        User user = quesDB.getUserByQuestionID(clickedQuestion.getQuestionID());
        ArrayList<Question_Tag> tagList = tagDB.getTagsByQuesID(clickedQuestion.getQuestionID());
        ArrayList<Comment> comLists = comDB.getCommentByQuestionID(questionID);

        request.setAttribute("comlist", comLists);
        request.setAttribute("userid", user);
        request.setAttribute("clickedQues", clickedQuestion);
        request.setAttribute("taglist", tagList);
        request.getRequestDispatcher("pages/thread.jsp").forward(request, response);
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
