/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.CommentController;

import controller.BaseAuthController;
import db.CommentDBContext;
import db.NotificationDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CommentController extends BaseAuthController {

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
            out.println("<title>Servlet CommentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CommentController at " + request.getContextPath() + "</h1>");
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String raw_Type = request.getParameter("sourceType");

        //if raw_type = null, it means we post comment on the post, if raw_type is not null, we reply to another comment
        //raw_type = the id of comment that user replied
        HttpSession session = request.getSession();
        String comment_content = request.getParameter("comment-content");
        int userID = (Integer) session.getAttribute("userID");
        int sourceType = Integer.parseInt(request.getParameter("questionid"));
        int questionOwnerID = Integer.parseInt(request.getParameter("questionOwner"));
        
        
        String replyType = "reply";
        String commentType = "comment";
       

        CommentDBContext comDb = new CommentDBContext();
        NotificationDBContext notiDb = new NotificationDBContext();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String createdAt = dtf.format(now);

        if (raw_Type == null || raw_Type.isEmpty()) {
            comDb.createComment(sourceType, userID, comment_content);
            //add notification
            if (userID == questionOwnerID) {
            } else {
                notiDb.addNotification(questionOwnerID, userID, sourceType, commentType, createdAt);
            }
            response.sendRedirect("thread?questionid=" + sourceType);
        } else {
            //get the id of user that was repied by another user
            int commentOwnerID = Integer.parseInt(request.getParameter("commentOwner"));

            int Type = Integer.parseInt(raw_Type);
            //type = the id of comment that user replied
            //create new comment
            comDb.createComment(sourceType, userID, comment_content);

            //get new commentid just added
            int new_CommentID = comDb.getLastCommentAdded();

            //update reply_id of old comment with new comment
            //type = the comment that user replied for, new_comment is the comment that just have created
            comDb.updateForReplies(Type, new_CommentID);

            if (userID == questionOwnerID) {

            } else {
                //add notification for question owner
                notiDb.addNotification(questionOwnerID, userID, sourceType, commentType, createdAt);
            }
            if (userID == commentOwnerID) {
            } //add notification for comment owner
            else {
                notiDb.addNotification(commentOwnerID, userID, sourceType, replyType, createdAt);
            }

            response.sendRedirect("thread?questionid=" + sourceType);
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
