package com.wztdu.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContext_ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取web.xml的context-parameter

        // 1. 获取到ServletContext
        ServletContext servletContext = getServletContext();
        // 2. 获取website
        String website = servletContext.getInitParameter("website");
        String company = servletContext.getInitParameter("company");
        System.out.println("website= " + website);
        System.out.println("company= " + company);
        // 3. 获取项目的工程目录
        String contextPath = servletContext.getContextPath();
        System.out.println("项目路径= " + contextPath);
        // 4. 获取项目发布会，正在的工作路径
        // / 表示我们的项目（发布后）的 根路径
        String realPath = servletContext.getRealPath("/");
        System.out.println("项目发布后绝对路径= " + realPath);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
