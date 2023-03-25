package net.czqu.taskmaster.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-26 00:03
 **/
@Getter
@Setter
@ToString
public class UserTokenInfo {
    private String uid;
    private String userName;

    public UserTokenInfo() {
    }




}
