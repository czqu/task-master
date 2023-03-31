package net.czqu.taskmaster.core.filter;


import net.czqu.taskmaster.common.constant.enums.AppIdEnums;
import net.czqu.taskmaster.common.filter.ApiLogFilter;
import net.czqu.taskmaster.core.service.AccessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-23 23:14
 **/

@Configuration
public class ApiLogFilterConfig {

    @Autowired
    AccessLogService accessLogService;
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ApiLogFilter(AppIdEnums.CORE.getId(),(dto)->{
            accessLogService.setToAccessLog(dto);
        }));
        registration.addUrlPatterns("*");
        registration.setName("ApiLogFilter");
        //设置优先级别
        registration.setOrder(Integer.MIN_VALUE);
        return registration;
    }


}
