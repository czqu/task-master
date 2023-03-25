package net.czqu.taskmasterjwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.Test;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-25 22:38
 **/


public class QuickTest {
    @Test
    public void test() throws JsonProcessingException {
        String randomNum = RandomStringUtils.randomNumeric(5);
        System.out.println(randomNum);

    }

    @Test
    public void test2() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

// 将公钥和私钥转换为Base64字符串
        String privateKeyStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        String publicKeyStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());

// 打印Base64编码的公钥和私钥字符串
        System.out.println("Private Key: " + privateKeyStr);
        System.out.println("Public Key: " + publicKeyStr);

// 将Base64编码的私钥字符串解码为字节数组
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);

// 使用PKCS8EncodedKeySpec解析私钥字节数组
        PrivateKey decodedPrivateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));

// 验证解析后的私钥是否与原始私钥相同
        System.out.println("Private key matches: " + Arrays.equals(privateKey.getEncoded(), decodedPrivateKey.getEncoded()));

    }
}
