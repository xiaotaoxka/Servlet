package com.wztdu.servlet.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DogServlet extends HttpServlet {
    // 定义两个变量
    private int getCount = 0;
    private int postCount = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getCount++;
        System.out.println("DogServlet doGet 访问次数= " + getCount);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        postCount++;
        System.out.println("DogServlet doPost 访问次数= " + postCount);
    }
}
