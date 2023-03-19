package net.czqu.taskmasterjwt.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 22:53
 **/
@Getter
@Setter
public class SignUpDTO {
    private String username;
    private String password;
}
