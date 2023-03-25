package net.czqu.taskmaster.security.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.czqu.taskmaster.common.dto.UserTokenInfo;
import net.czqu.taskmaster.common.utils.JacksonUtils;
import net.czqu.taskmaster.security.config.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

import static net.czqu.taskmaster.security.config.JwtConfig.ALGORITHM;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-26 23:58
 **/
@Service
public class JwtService {
    private JwtConfig jwtConfig;
    private static PublicKey publicKey;


    @Autowired
    public JwtService(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
        init();
    }

    private void init() {


        byte[] decodedPublicKeyBytes = Base64.getDecoder().decode(jwtConfig.getJwtPublicKeyConfig());
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(decodedPublicKeyBytes);
        try {
            publicKey = KeyFactory.getInstance(ALGORITHM).generatePublic(publicKeySpec);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public String getUidFromToken(String token) throws IOException {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String subject = claims.getSubject();
            UserTokenInfo userTokenInfo = JacksonUtils.deserialize(subject, UserTokenInfo.class);
            return userTokenInfo.getUid();
        } catch (Exception e) {
            return null;
        }
    }


    public boolean validateToken(String token) {

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isTokenExpired(String token) {

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            Instant expiration = claims.getExpiration().toInstant();
            return expiration.isBefore(Instant.now());
        } catch (Exception e) {
            return true;
        }
    }

    public String getSSOUrl() {
        return jwtConfig.getSsoUrl();
    }
}
