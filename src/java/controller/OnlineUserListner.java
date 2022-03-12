/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.UserDBContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.application.Application;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.jboss.weld.context.ApplicationContext;

/**
 * Web application lifecycle listener.
 *
 * @author Admin
 */
public class OnlineUserListner implements HttpSessionListener {
//
//    ServletContext application;
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        application = sce.getServletContext();
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("Context Destroyed");
//    }

    private static int songuoionline = 0;

    //ham de lay bien so nguoi online
    public static int getSonguoionline() {
        return songuoionline;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession(); //lay session từ HttpSessionEvent
        Date now = new Date();
        System.out.println("Da tao session co ID " + session.getId() + " vao thoi diem " + now);
        System.out.println("Dang có " + songuoionline + " online");

        DayOfWeek day = LocalDate.now(ZoneId.of("America/Montreal")).getDayOfWeek();
        UserDBContext udb = new UserDBContext();

        String today = "";
        if (day.equals(DayOfWeek.MONDAY)) {
            today = "mo";
        } else if (day.equals(DayOfWeek.TUESDAY)) {
            today = "tu";
        } else if (day.equals(DayOfWeek.WEDNESDAY)) {
            today = "we";
        } else if (day.equals(DayOfWeek.THURSDAY)) {
            today = "th";
        } else if (day.equals(DayOfWeek.FRIDAY)) {
            today = "fr";
        } else if (day.equals(DayOfWeek.SATURDAY)) {
            today = "sa";
        } else if (day.equals(DayOfWeek.SUNDAY)) {
            today = "su";
        }

        udb.updateview(today);

        songuoionline++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession(); //lay session từ HttpSessionEvent
        Date now = new Date();
        System.out.println("Da huy session co ID " + session.getId() + " vao thoi diem " + now);
        songuoionline--;
    }
}
