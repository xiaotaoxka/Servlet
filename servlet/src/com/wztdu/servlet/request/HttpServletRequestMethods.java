package com.wztdu.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpServletRequestMethods extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 这里我们使用request对象，获取表单提交的各种数据
        System.out.println("HttpServletRequestMethods doPost() 被调用..");

        // 获得和 http 请求头相关信息
        System.out.println("请求的资源路径URI= " + request.getRequestURI());

        // http://主机/uri
        System.out.println("请求的统一资源定位符（绝对路径）URL= " + request.getRequestURL());

        System.out.println("请求的客户端ip 地址= " + request.getRemoteAddr());  // 本地就是 127.0.0.1

        // 获取 http 请求头的信息，可以指定其他，比如 User-Agent, Host等
        System.out.println("http 请求 Host= " + request.getHeader("Host"));

        // 如果我们希望得到请求的头的相关信息，可以使用 request.getHeader("请求头字段")
        System.out.println("该请求的发起地址是= " + request.getHeader("Referer"));

        // 请获得访问网站的浏览器是什么
        String userAgent = request.getHeader("User-Agent");
        System.out.println("User-Agent= " + userAgent);
        String[] s = userAgent.split(" ");
        System.out.println("浏览器种类= " + s[s.length - 1].split("\\/")[0]);

        // 获得 Cookie
        // Cookie: JSESSIONID=95F4A34B618EBF727F7FBBE8EAA1BEA0
        String cookie = request.getHeader("Cookie");
        String JSESSIONID = cookie.split("=")[1];
        System.out.println("取出JSESSIONID= " + JSESSIONID);

        // 主要是 Get 还是 Post
        System.out.println("http请求方式~= " + request.getMethod());

        // 解决接收参数的中文乱码问题
        request.setCharacterEncoding("utf-8");

        // 1.获取表单数据【单个数据】
        // username=xiaotaotao&pwd=123456&hobby=spls
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        // 2.获取表单一组数据
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("username= " + username);
        System.out.println("pwd= " + pwd);
        for (String hobby : hobbies) {
            System.out.println("hobby= " + hobby);
        }

        // 返回接收到的信息，给浏览器回显
        // text/html 表示返回的数据类型，浏览器会根据这个类型来解析数据
        // text/plain 表示返回的数据，请浏览器使用文本的方式解析
        // application/x-tar 表示返回的是文件，浏览器就会以下载文件的方式处理
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>提交的用户名= " + username + "</h1>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
