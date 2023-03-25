package net.czqu.taskmaster.sso;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Paul Chen
 */
@SpringBootApplication
@MapperScan(basePackages = "net.czqu.taskmaster.dao.mapper")

public class TaskMasterSSOApplication {

    public static void main(String[] args) {

        SpringApplication.run(TaskMasterSSOApplication.class, args);
    }

}
