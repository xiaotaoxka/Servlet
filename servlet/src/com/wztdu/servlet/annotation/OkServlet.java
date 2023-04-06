package com.wztdu.servlet.annotation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注解方式来配置
 */

/**
 * 1. WebServlet 是一个注解
 * 2. WebServlet 源码
 *
 * @Target({ElementType.TYPE})
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented => 在Javadoc工具生成文档有记录
 * public @interface WebServlet {
 * String name() default "";
 * <p>
 * String[] value() default {};
 * <p>
 * String[] urlPatterns() default {};
 * <p>
 * int loadOnStartup() default -1;
 * <p>
 * WebInitParam[] initParams() default {};
 * <p>
 * boolean asyncSupported() default false;
 * <p>
 * String smallIcon() default "";
 * <p>
 * String largeIcon() default "";
 * <p>
 * String description() default "";
 * <p>
 * String displayName() default "";
 * 3. urlPatterns 对应 web.xml 的 <url-pattern></url-pattern>
 * 4. {"/ok1", "/ok2"} 可以给OkServlet配置多个url-pattern
 * 5. 相当于@WebServlet(urlPatterns = {"/ok1", "/ok2"})代替了web.xml的配置
 * 6. 浏览器可以这样访问OkServlet时，可以 http://localhost:8080/servlet/ok1 或者 http://localhost:8080/servlet/ok2
 * 7. 我还有很多的疑惑
 * 8. 我们可以根据 @interface WebServlet 源码知道可以配置哪些信息
 * web.xml init-param 在注解中，如何指定呢？
 * <init-param>
 * <param-name></param-name>
 * <param-value></param-value>
 * </init-param>
 * 9. 注解方式开发Servlet 和 web.xml配置servlet 流程机制是一样的
 */
@WebServlet(urlPatterns = {"/ok1", "/ok2"}, loadOnStartup = 1, initParams = @WebInitParam(name = "xx", value = "yy"))
public class OkServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("注解方式 OkServlet init()被调用");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注解方式 OkServlet doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注解方式 OkServlet doPost()");
    }
}
