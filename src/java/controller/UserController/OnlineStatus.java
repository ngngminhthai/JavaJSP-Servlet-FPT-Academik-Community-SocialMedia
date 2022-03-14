/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.UserController;

import db.UserDBContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Admin
 */
public class OnlineStatus implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int userid = (Integer) se.getSession().getAttribute("userID");
        UserDBContext userdb = new UserDBContext();
        userdb.updateStatus(1, userid);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        if (se.getSession().getAttribute("userID") != null) {
            int userid = (Integer) se.getSession().getAttribute("userID");
            UserDBContext userdb = new UserDBContext();
            userdb.updateStatus(0, userid);
        }
    }
}
