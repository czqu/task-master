package net.czqu.taskmaster.sso.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import net.czqu.taskmaster.common.dto.JwtAuthenticationDTO;
import net.czqu.taskmaster.sso.service.JwtService;
import net.czqu.taskmaster.sso.service.TMUserService;
import net.czqu.taskmaster.common.constant.exception.UserAccountException;
import net.czqu.taskmaster.common.response.ResponseResult;
import net.czqu.taskmaster.dao.pojo.TmUser;
import net.czqu.taskmaster.common.dto.AuthDTO;
import net.czqu.taskmaster.common.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 22:47
 **/
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;

    private TMUserService userService;

    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, TMUserService userService,
                          JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    @Operation(summary = "login")
    @Parameter(
            name = "Authorization",
            description = "Authorization header",
            in = ParameterIn.HEADER,
            hidden = true
    )
    public ResponseResult<JwtAuthenticationDTO> authenticateUser(@RequestBody AuthDTO loginRequest) throws JsonProcessingException, NoSuchAlgorithmException, InvalidKeySpecException {

        // 进行身份验证
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUid(),
                        loginRequest.getPassword())

        );

        // 将用户认证信息存储到 SecurityContext 中
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 生成 JWT
        String jwt = jwtService.generateToken(authentication);
        return ResponseResult.success(new JwtAuthenticationDTO(jwt));
    }

    @PostMapping("/register")
    @Operation(summary = "register")
    @Parameter(
            name = "Authorization",
            description = "Authorization header",
            in = ParameterIn.HEADER,
            hidden = true
    )
    public ResponseResult<String> registerUser(@RequestBody SignUpDTO signUpRequest) throws UserAccountException {


        // 创建新用户
        TmUser user = new TmUser();
        user.setUid(userService.getNewUserId(3));
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setCreatedAt(new Date());
        userService.saveUser(user);
        return ResponseResult.success("ok");
    }


}
