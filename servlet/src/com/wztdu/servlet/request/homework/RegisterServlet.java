package com.wztdu.servlet.request.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RegisterServlet 被调用...");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");

        // 获取喜欢的运动
        String[] sports = request.getParameterValues("sport");
        // 对 sports 处理
        String sportsString = "";
        for (String sport : sports) {
            sportsString += sport + " ";
        }
        // 获取性别 radio
        String gender = request.getParameter("gender");
        // 获取select 城市
        String city = request.getParameter("city");

        // 获取 textarea
        String info = request.getParameter("info");

        // 返回给浏览器，回显
        response.setContentType("text/html;charset=utf-8");

        // 解决乱码的方式
//        // 1. 设置服务器使用 utf-8
//        response.setCharacterEncoding("utf-8");
//        // 2. 设置浏览器端是 utf-8，而且类型是 text/html
//        response.setHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("username= " + username + "<br/>");
        writer.print("pwd= " + pwd + "<br/>");
        writer.print("pwd2= " + pwd2 + "<br/>");
        writer.print("喜欢的运动= " + sportsString + "<br/>");
        writer.print("gender= " + gender + "<br/>");
        writer.print("city= " + city + "<br/>");
        writer.print("info= " + info + "<br/>");

        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
