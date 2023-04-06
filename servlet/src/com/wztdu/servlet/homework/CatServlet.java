package com.wztdu.servlet.homework;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CatServlet implements Servlet {

    // 定义一个记录访问次数的变量
    private int count = 0;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        count++;
        // 访问的方式
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println("访问的方式= " + httpServletRequest.getMethod());

        System.out.println("访问CatServlet的次数= " + count);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
