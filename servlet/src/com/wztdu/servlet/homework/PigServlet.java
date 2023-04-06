package com.wztdu.servlet.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/pig1", "/pig2"}, loadOnStartup = 2)
public class PigServlet extends HttpServlet {

    private int getCount = 0;
    private int postCount = 0;

    @Override
    public void init() throws ServletException {
        System.out.println("init() 方法被调用");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getCount++;
        System.out.println("访问的浏览器ip= " + req.getRemoteAddr());
        System.out.println("PigServlet 的 doGet方法被访问了 " + getCount);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postCount++;
        System.out.println("访问的浏览器ip= " + req.getRemoteAddr());
        System.out.println("PigServlet 的 doPost方法被访问了 " + postCount);
    }
}
