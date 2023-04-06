package com.wztdu.servlet.response.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyPayServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyPayServlet 被调用");

        String money = request.getParameter("money");
        System.out.println("money=" + money.getClass());
        // 转成int
        int iMoney = WebUtils.parseString(money);
        String contextPath = getServletContext().getContextPath();

        if (iMoney > 100) {
            // 重定向到 payok.html
            // contextPath -> /servlet
            response.sendRedirect(contextPath + "/payok.html");
        } else {
            response.sendRedirect(contextPath + "/pay.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
