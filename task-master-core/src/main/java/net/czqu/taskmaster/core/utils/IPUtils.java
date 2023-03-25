package net.czqu.taskmaster.core.utils;


import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
