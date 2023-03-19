package net.czqu.taskmaster;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "net.czqu.taskmasterdao.mapper")
public class TaskMasterApplication {


    public static void main(String[] args) {
        SpringApplication.run(TaskMasterApplication.class, args);
    }


}
