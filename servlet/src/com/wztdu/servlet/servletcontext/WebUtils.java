package com.wztdu.servlet.servletcontext;

import javax.servlet.ServletContext;
import java.io.PrintWriter;

public class WebUtils {
    // 这个方法就是对访问次数的累积，同时并返回次数
    public static Integer visitCount(ServletContext servletContext) {
        // 从 servletContext 获取 visit_count 属性 k-v
        Object visit_count = servletContext.getAttribute("visit_count");
        // 判断 visit_count 是否为 null
        if (visit_count == null) {  // 说明是第一次访问网站
            servletContext.setAttribute("visit_count", 1);
            visit_count = 1;
        } else {  // 是第二次或以后
            // 取出 visit_count 属性值 + 1
            visit_count = Integer.parseInt(visit_count + "") + 1;
            // 放回到servletContext
            servletContext.setAttribute("visit_count", visit_count);
        }

        return Integer.parseInt(visit_count + "");
    }
}
