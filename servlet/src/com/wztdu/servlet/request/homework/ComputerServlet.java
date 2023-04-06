package com.wztdu.servlet.request.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComputerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ComputerServlet 被调用...");

        // 可以获得到浏览器所在电脑的操作系统版本和位数（32还是64），显示在页面
        // User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/111.0
        // 我们要 Windows NT 10.0 和 Win64
        String userAgent = request.getHeader("User-Agent");

        String regStr = "\\((.*)\\)";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(userAgent);
        matcher.find();  // 因为我们的 userAgent 只有一组 （）
        String group = matcher.group(0);  // (Windows NT 10.0; Win64; x64; rv:109.0)
        String group1 = matcher.group(1); // Windows NT 10.0; Win64; x64; rv:109.0
        String[] operInfos = group1.split(";");
        System.out.println("group= " + group);
        System.out.println("操作系统= " + operInfos[0]);  // Windows NT 10.0
        System.out.println("操作系统位数= " + operInfos[1].trim());  // Win64
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
