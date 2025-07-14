package com.cognizant.spring_learn.controller;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START authenticate()");
        String user = getUser(authHeader);
        String token = generateJwt(user);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        LOGGER.info("END authenticate()");
        return map;
    }
    private String getUser(String authHeader) {
        LOGGER.info("START getUser()");
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded);
        String user = credentials.split(":")[0];
        LOGGER.info("Decoded User: {}", user);
        LOGGER.info("END getUser()");
        return user;
    }


    private String generateJwt(String user) {
        LOGGER.info("START generateJwt()");
        String token = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20 minutes
                .signWith(key)
                .compact();
        LOGGER.info("END generateJwt()");
        return token;
    }
}
