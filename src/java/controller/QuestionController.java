/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.QuestionDBContext;
import db.TagDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Question;

/**
 *
 * @author Admin
 */
public class QuestionController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet askformcontroller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet askformcontroller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    String forumID = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        forumID = request.getParameter("forum");
        request.setAttribute("forumID", forumID);
        request.getRequestDispatcher("pages/askform.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        int userID = (int) session.getAttribute("userID");

        int majorID = Integer.parseInt(request.getParameter("forumID"));
        String content = request.getParameter("question-content");
        String title = request.getParameter("question-title");
        String tags = request.getParameter("tag-content");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String createdAt = dtf.format(now);
        String summary = content.substring(0, Math.min(content.length(), 20));

        QuestionDBContext quesDB = new QuestionDBContext();

        Question newQuestion = quesDB.createQuestion(userID, title, summary, createdAt, content, majorID);

        
        TagDBContext tagDB = new TagDBContext();
        String[] arrOfTags = tags.trim().split(" ");

        for (int i = 0; i < arrOfTags.length; i++) {
            tagDB.createTag(arrOfTags[i].trim(), newQuestion.getQuestionID());
        }

//        session.setAttribute("questionid", newQuestion.getQuestionID());
//        request.getRequestDispatcher("thread").forward(request, response);
        response.sendRedirect("thread?questionid=" + newQuestion.getQuestionID());
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
