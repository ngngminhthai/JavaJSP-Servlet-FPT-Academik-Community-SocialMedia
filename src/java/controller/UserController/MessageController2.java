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
import java.util.LinkedList;
import java.util.List;
import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/message3"}, asyncSupported = true)
public class MessageController2 extends HttpServlet {

    private List<AsyncContext> contexts = new LinkedList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final AsyncContext asyncContext = request.startAsync(request, response);
        asyncContext.setTimeout(10 * 60 * 1000);
        contexts.add(asyncContext);
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
        List<AsyncContext> asyncContexts = new ArrayList<>(this.contexts);
        this.contexts.clear();

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String content = request.getParameter("content");
        int replyid = (Integer) request.getSession().getAttribute("userID");
        int cid = Integer.parseInt(request.getParameter("cid"));
        int usertwo = Integer.parseInt(request.getParameter("usernameReplied"));

        String htmlMessage = cid + "-" + content + "-" + replyid + "-" + 1;

        ServletContext sc = request.getServletContext();
//        if (sc.getAttribute("messages") == null) {
//            sc.setAttribute("messages", htmlMessage);
//        } else {
//            String currentMessages = (String) sc.getAttribute("messages");
//            sc.setAttribute("messages", htmlMessage + currentMessages);
//        }
        ConversationDBContext conDb = new ConversationDBContext();
        conDb.createMessage(usertwo, replyid, cid, content);

        for (AsyncContext asyncContext : asyncContexts) {
            try (PrintWriter writer = asyncContext.getResponse().getWriter()) {

                request.setCharacterEncoding("UTF-8");
                writer.println(htmlMessage);
                writer.flush();
                asyncContext.complete();
            } catch (Exception ex) {
            }
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
