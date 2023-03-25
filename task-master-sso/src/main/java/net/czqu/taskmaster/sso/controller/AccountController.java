package net.czqu.taskmaster.sso.controller;

import io.swagger.v3.oas.annotations.Operation;
import net.czqu.taskmaster.common.constant.exception.UserAccountException;
import net.czqu.taskmaster.common.dto.UserInfoDTO;
import net.czqu.taskmaster.common.response.ResponseResult;
import net.czqu.taskmaster.sso.service.TMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-26 00:18
 **/
@RestController
@RequestMapping("/account")
public class AccountController {
    private TMUserService userService;

    @Autowired
    public AccountController(TMUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")

    @PreAuthorize("#userId == authentication.principal.uid ")
    @Operation(summary = "获取用户信息")
    public ResponseResult<UserInfoDTO> getUserInfo(
            @RequestParam(value = "uid", required = true)
            String userId) throws UserAccountException {

        int uid = Integer.parseInt(userId);
        return ResponseResult.success(userService.getUserInfo(uid));
    }
}
