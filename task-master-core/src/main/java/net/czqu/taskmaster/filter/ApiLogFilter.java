package net.czqu.taskmaster.filter;

import net.czqu.taskmaster.dto.ApiLogDTO;
import net.czqu.taskmaster.utils.IPUtils;
import net.czqu.taskmaster.utils.JacksonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static net.czqu.taskmaster.utils.DateTimeUtil.getCurrentDateTimeString;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-23 23:14
 **/

@Configuration
public class ApiLogFilter extends OncePerRequestFilter {
    private static final Logger API_LOGGER = LogManager.getLogger("ApiLog");

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(this);
        registration.addUrlPatterns("/*");
        registration.setName("ApiLogFilter");
        //设置优先级别
        registration.setOrder(Integer.MIN_VALUE);
        return registration;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ApiLogDTO logDTO = new ApiLogDTO();
        long startTime = System.currentTimeMillis();

        logDTO.setIp(IPUtils.getUserIP(request));

        logDTO.setUrl(request.getServletPath());
        logDTO.setParams(request.getQueryString());
        logDTO.setUserAgent(request.getHeader("User-Agent"));
        logDTO.setMethod(request.getMethod());
        logDTO.setTime(getCurrentDateTimeString());
        logDTO.setProtocol(request.getProtocol());
        try {
            filterChain.doFilter(request, response);
        } finally {
            logDTO.setStatusCode(response.getStatus());
            logDTO.setCostTime(System.currentTimeMillis() - startTime);
            API_LOGGER.info(JacksonUtils.serialize(logDTO));
        }


    }
}
