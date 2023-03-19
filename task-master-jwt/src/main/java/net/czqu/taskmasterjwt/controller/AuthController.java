package net.czqu.taskmasterjwt.controller;

import io.swagger.v3.oas.annotations.Operation;

import net.czqu.taskmasterdao.pojo.TmUser;
import net.czqu.taskmasterjwt.dto.AuthDTO;
import net.czqu.taskmasterjwt.dto.JwtAuthenticationDTO;
import net.czqu.taskmasterjwt.dto.SignUpDTO;
import net.czqu.taskmasterjwt.service.JwtService;
import net.czqu.taskmasterjwt.service.TMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 22:47
 **/
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TMUserService userService;

    @Autowired
    private JwtService jwtService;


    @PostMapping("/login")
    @Operation(description = "login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthDTO loginRequest) {

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
        return ResponseEntity.ok(new JwtAuthenticationDTO(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDTO signUpRequest) {


        // 创建新用户
        TmUser user = new TmUser();
        user.setUid(UUID.randomUUID().toString());


        user.setPasswordSalt(generateSalt());

        user.setUsername(signUpRequest.getUsername());
        user.setCreatedAt(new Date());
        user.setPasswordSalt(generateSalt());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(signUpRequest.getPassword() + user.getPasswordSalt()));

        userService.saveUser(user);


        return ResponseEntity.ok("ok");
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
