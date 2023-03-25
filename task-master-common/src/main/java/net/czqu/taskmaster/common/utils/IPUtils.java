package net.czqu.taskmaster.common.utils;


import javax.servlet.http.HttpServletRequest;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-23 23:33
 **/
public class IPUtils {
    public static String getUserIP(HttpServletRequest request) {
        if (request == null) {
            return "";
        }
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (!(ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress))) {

            return ipAddress;
        }
        return request.getRemoteAddr();


    }


}
