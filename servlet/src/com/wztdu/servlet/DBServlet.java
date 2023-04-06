package com.wztdu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DBServlet extends HttpServlet {

    /**
     * 1. 当DBServlet 对象初始化时，Tomcat会同时创建一个 ServletConfig 对象
     * 2. 这是如果 DBServlet init() 方法中你调用了 super.init(config);
     * 3. 调用 父类 GenericServlet
     * public void init(ServletConfig config) throws ServletException {
     *      this.config = config;
     *      this.init();
     * }
     *这时就会把 Tomcat 创建的 ServletConfig 对象赋给 GenericServlet的属性 config
     * 4. 因此如果你重写init() 方法，记住如果你想在其他方法通过 getServletConfig() 方法获取ServletConfig,
     * 则一定要记住 调用 super.init(config);
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init= " + config);
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 在DBServlet 执行 doGet/doPost时，可以获得到web.xml配置的用户名和密码
        // 你是一个oop程序员 -> 现有的方法或对象来搞定有getServletConfig()
        // DBServlet 的父类GenericServlet
        /**
         * 1. getServletConfig() 是 GenericServlet
         * 2. 返回的 servletConfig 对象是 private transient ServletConfig config;
         * 3. 当一个属性被 transient 修饰，表示属性不会被串行化（有些重要信息，不希望保存到文件）
         */
        ServletConfig servletConfig = getServletConfig();
        System.out.println("servletConfig " + servletConfig);
        String username = servletConfig.getInitParameter("username");
        String pwd = servletConfig.getInitParameter("pwd");
        System.out.println("初始化参数username= " + username);
        System.out.println("初始化参数pwd= " + pwd);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
