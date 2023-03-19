package net.czqu.taskmasterjwt.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 22:51
 **/
@Setter
@Getter
public class JwtAuthenticationDTO {
    private String token;

    public JwtAuthenticationDTO(String token) {
        this.token = token;
    }
}
