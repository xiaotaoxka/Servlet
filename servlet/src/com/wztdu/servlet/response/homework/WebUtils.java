package com.wztdu.servlet.response.homework;

/**
 * 编写一个 String -> int 的方法，还要处理异常
 */
public class WebUtils {

    public static int parseString(String str) {
        int num = 0;

        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("输入的str格式不正确...");
        }

        return num;
    }

}
