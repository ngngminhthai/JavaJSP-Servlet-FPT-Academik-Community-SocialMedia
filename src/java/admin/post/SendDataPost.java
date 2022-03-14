/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.post;

import db.MainTagDBContext;
import db.TagDBContext;
import db.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Main_Tag;

/**
 *
 * @author Admin
 */
public class SendDataPost extends HttpServlet {

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
            out.println("<title>Servlet SendDataPost</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendDataPost at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        int memid = Integer.parseInt(request.getParameter("id"));

        int userid = (Integer) request.getSession().getAttribute("userID");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int quesid = Integer.parseInt(request.getParameter("quesid"));
        String maintag = request.getParameter("main");
        
        MainTagDBContext maindb = new MainTagDBContext();
        ArrayList<Main_Tag> mainlist = maindb.getMainTags();
        

//        String img = request.getParameter("img");
        UserDBContext udb = new UserDBContext();
        if ((udb.getRole(userid) > udb.getRole(memid)) || (userid == memid)) {
            request.setAttribute("title", title);
            request.setAttribute("quesid", quesid);
            request.setAttribute("content", content);
            request.setAttribute("main", maintag);
            request.setAttribute("mainlist", mainlist);
            request.getRequestDispatcher("../admin/question/update.jsp").forward(request, response);
        } else {
            response.sendRedirect("question");
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
