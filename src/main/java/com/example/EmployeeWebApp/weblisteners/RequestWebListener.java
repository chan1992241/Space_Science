package com.example.EmployeeWebApp.weblisteners;

import javax.servlet.*;
import javax.servlet.annotation.*;

@WebListener
public class RequestWebListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request cycle ends here");
        ServletRequestListener.super.requestDestroyed(sre);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request cycle start here");
        ServletRequestListener.super.requestInitialized(sre);
    }

    public RequestWebListener() {
    }

}
