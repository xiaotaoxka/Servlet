package com.wztdu.servlet.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CheckServlet 被调用..");

        // 根据用户名来确定该用户是什么身份
        String username = request.getParameter("username");
        if ("tom".equals(username)) {
            // 分配
            request.setAttribute("role", "管理员");
        } else {
            request.setAttribute("role", "普通用户");
        }

        // 获取分发器
        // 1. /manageServlet 写的是 要转发的 servlet 的url
        // 2. / 会被解析成 /servlet/
        // 3. forward(request, response)  表示把当前servlet的request 和 response对象，传递给下一个servlet使用
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/manageServlet");

        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
