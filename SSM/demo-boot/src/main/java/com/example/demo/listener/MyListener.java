package com.example.demo.listener;


import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web开始");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web 结束");
    }
}
