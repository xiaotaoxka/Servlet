package com.wztedu.http.servlet.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/t2"})
public class T2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = resp.getWriter();
//        writer.print("<h1>成功访问 T2Servlet</h1>");
//        writer.flush();
//        writer.close();

        // 演示 302 重定向
//        resp.sendRedirect("/http/imgs/2.png");

        // 演示 500
        int[] arr = {1, 2};
        for (int i = 0; i < 4; i++) {
            System.out.println("i= " + arr[i]);
        }
    }
}
