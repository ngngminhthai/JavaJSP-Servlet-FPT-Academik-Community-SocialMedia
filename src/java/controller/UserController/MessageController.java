/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.UserController;

import db.ConversationDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Conversation;

/**
 *
 * @author Admin
 */
public class MessageController extends HttpServlet {

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
        String content = request.getParameter("content");
        int replyid = (Integer) request.getSession().getAttribute("userID");
        int cid = Integer.parseInt(request.getParameter("cid"));

        try (PrintWriter out = response.getWriter()) {

            out.println(" <li class=\"clearfix\">\n" +
"                            <div class=\"message-data text-right\">\n" +
"                                <span class=\"message-data-time\">10:10 AM, Today</span>\n" +
"                                <img src=\"pages/thai.jpg\" alt=\"avatar\">\n" +
"                            </div>\n" +
"                            <div class=\"message other-message float-right\">"+ content + "</div>\n" +
"                        </li>");

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
        int userID = (Integer) request.getSession().getAttribute("userID");
        ConversationDBContext conDB = new ConversationDBContext();
        ArrayList<Conversation> cons = conDB.getConversation(userID);
        request.setAttribute("conversations", cons);
        request.getRequestDispatcher("pages/Conversation.jsp").forward(request, response);
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
