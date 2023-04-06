package com.wztdu.servlet.annotation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;

/**
 * 模拟一把Tomcat是如何通过@WebServlet(urlPatterns = {"/ok1", "/ok2"})
 * 来装载一个Servlet的
 */
public class TestAnnotationServlet {

    private static final HashMap<String, Object> hm = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 1.首先要得到扫描的包 路径 io
        String classAllPath = "com.wztdu.servlet.annotation.OkServlet";
        // 2.得到 OkServlet 的 Class 对象
        Class<?> aClass = Class.forName(classAllPath);
        // 3.通过class对象得到Annotation
        WebServlet annotation = aClass.getAnnotation(WebServlet.class);
        System.out.println(annotation);
        String[] strings = annotation.urlPatterns();
        for (String url : strings) {
            System.out.println("url= " + url);
        }

        // 如果匹配了 url，如果是第一次，Tomcat就会创建一个OkServlet实例，放入hashmap
        Object instance = aClass.newInstance();
        System.out.println("instance= " + instance);  // OkServlet

        // 简单的模拟，没有深入
        hm.put("OkServlet", instance);

        System.out.println(hm);
    }
}
