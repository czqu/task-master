package net.czqu.taskmasterjwt.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 22:49
 **/
@Getter
@Setter
public class AuthDTO {
    private String uid;
    private String password;
}
