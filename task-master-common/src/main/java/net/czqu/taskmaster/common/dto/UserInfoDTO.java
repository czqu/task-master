package net.czqu.taskmaster.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-26 00:13
 **/
@Getter
@Setter
@ToString
public class UserInfoDTO {

    private Integer uid;

    private String username;

    private String email;

    private String phone;

    public UserInfoDTO() {
    }

    public UserInfoDTO(Integer uid, String username, String email, String phone) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }
}
