package net.czqu.taskmaster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-16 00:47
 **/
@Component
public class AsyncScheduledTaskConfig {
    @Bean
    public Executor scheduledTask() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //最大线程数
        executor.setMaxPoolSize(10);
        //核心线程数
        executor.setCorePoolSize(1);
        //任务队列的大小
        executor.setQueueCapacity(0);
        //线程前缀名
        executor.setThreadNamePrefix("scheduled-task");
        //线程存活时间
        executor.setKeepAliveSeconds(30);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        //线程初始化
        executor.initialize();
        return executor;
    }
}
