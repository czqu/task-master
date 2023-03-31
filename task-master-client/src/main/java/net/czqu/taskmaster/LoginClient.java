package net.czqu.taskmaster;

import net.czqu.taskmaster.common.dto.UserInfoDTO;
import net.czqu.taskmaster.service.LoginService;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-31 23:09
 **/
public class LoginClient {
    public static void main(String[] args) throws IOException, URISyntaxException {
        LoginService loginService = new LoginService();
        String uid="12345";
        String password="test";
        loginService.login(uid,password);
        UserInfoDTO userInfoDTO=loginService.getUserInfo(uid);
        System.out.println(userInfoDTO.toString());
    }
}
