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
import model.Message;

/**
 *
 * @author Admin
 */
public class OpenMessage extends HttpServlet {

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
            out.println("<title>Servlet OpenMessage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OpenMessage at " + request.getContextPath() + "</h1>");
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
        int userID = (Integer) request.getSession().getAttribute("userID");
//        who get the message 
        String raw_user = request.getParameter("user");
        int user = -1;
        if (raw_user != null) {
            user = Integer.parseInt(raw_user);
            
        }
        ConversationDBContext conDB = new ConversationDBContext();
        ArrayList<Conversation> cons = conDB.getConversation(userID);
        request.setAttribute("userfocus", user);
        request.setAttribute("conversations", cons);
        request.getRequestDispatcher("pages/Conversation_1.jsp").forward(request, response);
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
        ConversationDBContext conDB = new ConversationDBContext();
        int numberItems = Integer.parseInt(request.getParameter("total"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Message> mesages = conDB.getMessages(cid, numberItems);
        PrintWriter out = response.getWriter();

        for (Message mesage : mesages) {
            out.print(mesage.getContent() + "/" + mesage.getUserID() + "/" + cid + "/"+mesage.getCreatedAt()+"//");
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
