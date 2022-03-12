/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.MajorDBContext;
import db.QuestionDBContext;
import db.TagDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Major;
import model.Question;
import model.Question_Tag;
import model.Tag;

/**
 *
 * @author Admin
 */
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
//        MajorDBContext majordb = new MajorDBContext();
//        ArrayList<Major> majorList = majordb.getMajor();
//
//        request.setAttribute("majorList", majorList);
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
        if(field == null && sort == null){
            field = "q.lastActive";
            sort = "desc";
            
        }
        ////int pageindex, int pagesize, int userid, String field, String type
        if (userid != -1) {
            questions = quesDB.getQuestionsWithUserLogin(pageindex, pagesize, userid, field, sort);
        } else {
            questions = quesDB.getQuestions(pageindex, pagesize, userid, field, sort);
        }

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

        request.getRequestDispatcher("pages/home2.jsp").forward(request, response);

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
