package net.czqu.taskmaster.core;


import net.czqu.taskmaster.security.config.SecurityConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "net.czqu.taskmaster.dao.mapper")
@Import(SecurityConfiguration.class)

public class TaskMasterApplication {


    public static void main(String[] args) {
        SpringApplication.run(TaskMasterApplication.class, args);
    }


}
