package com.example.EmployeeWebApp.weblisteners;

import com.example.EmployeeWebApp.utilities.LoggingGeneral;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class LoggingTrack implements ServletContextListener /* ,HttpSessionListener, HttpSessionAttributeListener*/ {

    public LoggingTrack() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application cycle start here");
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        sce.getServletContext().setAttribute("log", new LoggingGeneral());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application cycle end here");
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        sce.getServletContext().removeAttribute("log");
    }
//
//    @Override
//    public void sessionCreated(HttpSessionEvent se) {
//        /* Session is created. */
//    }
//
//    @Override
//    public void sessionDestroyed(HttpSessionEvent se) {
//        /* Session is destroyed. */
//    }
//
//    @Override
//    public void attributeAdded(HttpSessionBindingEvent sbe) {
//        /* This method is called when an attribute is added to a session. */
//    }
//
//    @Override
//    public void attributeRemoved(HttpSessionBindingEvent sbe) {
//        /* This method is called when an attribute is removed from a session. */
//    }
//
//    @Override
//    public void attributeReplaced(HttpSessionBindingEvent sbe) {
//        /* This method is called when an attribute is replaced in a session. */
//    }
}
