package com.wztdu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HiServlet doGet()被调用");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HiServlet doPost()被调用");
    }
}
