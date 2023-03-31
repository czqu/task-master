package net.czqu.taskmaster.common.filter;


import net.czqu.taskmaster.common.dto.ApiLogDTO;
import net.czqu.taskmaster.common.utils.IPUtils;
import net.czqu.taskmaster.common.utils.JacksonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static net.czqu.taskmaster.common.utils.DateTimeUtil.getCurrentDateTimeString;


/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-23 23:14
 **/


public class ApiLogFilter extends OncePerRequestFilter {
    private static final Logger API_LOGGER = LogManager.getLogger("ApiLog");
    private  final int appId;
    private final ApiLogCallback callback;


    public ApiLogFilter(int appId, ApiLogCallback callback) {
        this.appId = appId;
        this.callback = callback;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ApiLogDTO logDTO = new ApiLogDTO();
        long startTime = System.currentTimeMillis();

        logDTO.setIp(IPUtils.getUserIP(request));
        logDTO.setAppId(appId);
        logDTO.setHostName(request.getServerName());
        logDTO.setRequestUri(request.getServletPath());
        logDTO.setParams(request.getQueryString());
        logDTO.setUserAgent(request.getHeader("User-Agent"));
        logDTO.setMethod(request.getMethod());
        logDTO.setTime(new Date());
        logDTO.setProtocol(request.getProtocol());
        try {
            filterChain.doFilter(request, response);
        } finally {
            logDTO.setStatusCode(response.getStatus());
            logDTO.setCostTime(System.currentTimeMillis() - startTime);
            callback.onFinished(logDTO);
            API_LOGGER.info(JacksonUtils.serialize(logDTO));
        }


    }
}
