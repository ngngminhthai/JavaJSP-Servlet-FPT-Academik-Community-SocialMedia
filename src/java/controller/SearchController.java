/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.QuestionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;

/**
 *
 * @author Admin
 */
public class SearchController extends HttpServlet {

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
            out.println("<title>Servlet a</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet a at " + request.getContextPath() + "</h1>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchContent = request.getParameter("q");
        String field = request.getParameter("order");
        String sort = request.getParameter("sort");
        QuestionDBContext quesDB = new QuestionDBContext();

        int pagesize = 10;
        String page = request.getParameter("page");
        if (page == null || page.trim().length() == 0) {
            page = "1";
        }

        int pageindex = Integer.parseInt(page);
        int userid = - 1;
        if (request.getSession().getAttribute("userID") != null) {
            userid = (Integer) request.getSession().getAttribute("userID");
        }
        ArrayList<Question> questions = new ArrayList<>();
        if (field == null && sort == null) {
            field = "q.createdAt";
            sort = "desc";
        }

        questions = quesDB.SearchQuestion(userid, pageindex, pagesize, field, sort, searchContent);

        if (field != null && sort != null) {
            if (sort.equals("asc")) {
                sort = "desc";
            } else {
                sort = "asc";
            }
        }
        request.setAttribute("order", field);
        request.setAttribute("sort", sort);
        request.setAttribute("ques", questions);
        int count = quesDB.count();
        int totalpage = (count % pagesize == 0) ? (count / pagesize) : (count / pagesize) + 1;
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("content", searchContent);

        request.getRequestDispatcher("pages/SearchList.jsp").forward(request, response);
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

        String searchContent = request.getParameter("q");
        String field = request.getParameter("order");
        String sort = request.getParameter("sort");
        QuestionDBContext quesDB = new QuestionDBContext();

        int pagesize = 10;
        String page = request.getParameter("page");
        if (page == null || page.trim().length() == 0) {
            page = "1";
        }

        int pageindex = Integer.parseInt(page);
        int userid = - 1;
        if (request.getSession().getAttribute("userID") != null) {
            userid = (Integer) request.getSession().getAttribute("userID");
        }
        ArrayList<Question> questions = new ArrayList<>();
        if (field == null && sort == null) {
            field = "q.createdAt";
            sort = "desc";

        }

        questions = quesDB.SearchQuestion(pageindex, pagesize, userid, field, sort, searchContent);

//        if (field != null && sort != null) {
//            if (sort.equals("asc")) {
//                sort = "desc";
//            } else {
//                sort = "asc";
//            }
//        }
//        request.setAttribute("order", field);
//        request.setAttribute("sort", sort);
        request.setAttribute("ques", questions);
        int count = quesDB.count();
        int totalpage = (count % pagesize == 0) ? (count / pagesize) : (count / pagesize) + 1;
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);

        request.getRequestDispatcher("SearchList.jsp").forward(request, response);
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
