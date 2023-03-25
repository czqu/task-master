package net.czqu.taskmaster.sso.utils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.appender.RollingFileAppender;


import java.util.Map;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-20 21:14
 **/
public class LogUtil {
    public static String getLogPath(Logger logger) {
        Map<String, Appender> appenderMap = ((org.apache.logging.log4j.core.Logger) logger).getAppenders();
        if (appenderMap == null) {
            return "";
        }
        // LogName 是日志名字
        Appender fileAppender = appenderMap.get("LogName");
        if (fileAppender instanceof RollingFileAppender) {
            return ((RollingFileAppender) fileAppender).getFileName();
        }
        return "";
    }
}
