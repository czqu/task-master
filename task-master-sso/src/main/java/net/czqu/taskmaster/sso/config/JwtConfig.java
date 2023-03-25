package net.czqu.taskmaster.sso.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-26 23:38
 **/
@Configuration
@Getter
public class JwtConfig {
    @Value("${sso.jwt.public-key:no-set}")
    private  String jwtPublicKeyConfig;
    @Value("${sso.jwt.private-key:no-set}")
    private  String jwtPrivateKeyConfig;
    @Value("${sso.jwt.expiration:86400000}")
    private int jwtExpiration;
    private static final String HEADER_STRING = "Authorization";
    public static final String ALGORITHM = "RSA";

}
