package net.czqu.taskmaster;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.TimeZone;


@SpringBootApplication
@MapperScan("net.czqu.taskmaster.dao.mapper")
@EnableScheduling
public class TaskMasterApplication {


    public static void main(String[] args) {
        SpringApplication.run(TaskMasterApplication.class, args);
    }


}
