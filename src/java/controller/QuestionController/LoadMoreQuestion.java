/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.QuestionController;

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
public class LoadMoreQuestion extends HttpServlet {

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
            out.println("<title>Servlet LoadMoreQuestion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadMoreQuestion at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        
        int currentNum = Integer.parseInt(request.getParameter("num"));
        String subid = request.getParameter("subid");
        
        QuestionDBContext quedb = new QuestionDBContext();
        
        ArrayList<Question> q = quedb.loadMore(subid, currentNum);
        PrintWriter out = response.getWriter();
        for (Question question : q) {

            out.print("<div class=\"tt-item\">\n"
                    + "                            <div class=\"tt-col-avatar\">\n"
                    + "                                <img style=\"    width: 50px;\n"
                    + "                                     height: 50px;\n"
                    + "                                     border-radius: 100%;\" src=\"/FPTCommunity/img/"+question.getUser().getImg()+"\">\n"
                    + "                            </div>\n"
                    + "                            <div class=\"tt-col-description\">\n"
                    + "                                <h6 class=\"tt-title\"><a href=\"#\">\n"
                    + "                                       "+question.getTitle()+"\n"
                    + "                                    </a></h6>\n"
                    + "                                <div class=\"row align-items-center no-gutters hide-desktope\">\n"
                    + "                                    \n"
                    + "                                    <div class=\"col-1 ml-auto show-mobile\">\n"
                    + "                                        <div class=\"tt-value\">1d</div>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </div>\n"
                    + "                            <div class=\"tt-col-value hide-mobile\">"+question.getViews()+"</div>\n"
                    + "                            <div class=\"tt-col-value tt-color-select hide-mobile\">"+question.getTotalComment()+"</div>\n"
                    + "      \n"
                    + "                        </div>");
        }
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
