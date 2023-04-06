package com.wztdu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 1.开发一个Servlet 需要实现 Servlet接口
 * 2.实现Servlet接口的方法 5个
 */
public class HelloServlet implements Servlet {
    private static int count = 0;

    /**
     * 1.初始化 servlet
     * 2.当创建HelloServlet 实例时，会调用init方法
     * 3.该方法只会调用一次
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet init() 被调用");
    }

    /**
     * 返回ServletConfig 也就是返回Servlet的配置
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 1.service方法处理浏览器的请求（包括Get/Post）
     * 2.当浏览器每次请求Servlet时就会调用service方法
     * 3.当tomcat调用该方法时，会把http请求的数据封装成实现了ServletRequest接口的对象
     * 4.通过servletRequest 对象，可以得到用户请求的数据
     * 5.servletResponse 对象可以用于返回数据给tomcat->浏览器
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse) throws ServletException, IOException {
        count++;
        System.out.println("hi HelloServlet-count= " + count);
        System.out.println("当前线程id= " + Thread.currentThread().getId());

        // 思考->从servletRequest对象来获取请求方式->
        // 1.ServletRequest 没有得到提交方式的方法
        // 2.ServletRequest 看看ServletRequest子接口有没有相关方法
        // 3.老师小技巧：ctrl+alt+b -> 可以看到接口的子接口和实现子类
        // 4.把servletRequest转换成HttpServletRequest引用
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet();  // 用doGet处理GET请求
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    /**
     * 用于响应get请求
     */
    public void doGet() {
        System.out.println("doGet() 被调用");
    }

    /**
     * 用于响应post请求
     */
    public void doPost() {
        System.out.println("doPost() 被调用");
    }

    /**
     * 返回servlet的信息，使用较少
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 1.该方法是在servlet销毁时被调用，只会被调用一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy()被调用");
    }
}
