package yep.greenFire.greenfirebackend.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class TokenUtils {

    private static String jwtSecretKey;
    private static Long accessTokenExpiration;
    private static Long refreshTokenExpiration;

    @Value("${jwt.secret}")
    public void setJwtSecretKey(String jwtSecretKey) {
        TokenUtils.jwtSecretKey = jwtSecretKey;
    }

    @Value("${jwt.access.expiration}")
    public void setAccessTokenExpiration(Long accessTokenExpiration) {
        TokenUtils.accessTokenExpiration = accessTokenExpiration;
    }

    @Value("${jwt.refresh.expiration}")
    public void setRefreshTokenExpiration(Long refreshTokenExpiration) {
        TokenUtils.refreshTokenExpiration = refreshTokenExpiration;
    }

    public static String createAccessToken(Map<String, Object> memberInfo) {

        Claims claims = Jwts.claims().setSubject("AccessToken");
        claims.putAll(memberInfo);

        return Jwts.builder()
                .setHeader(createHeader())
                .setSubject("AccessToken")
                .setClaims(memberInfo)
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration))
                .signWith(createSignature(), SignatureAlgorithm.HS512)
                .compact();
    }

    public static String createRefreshToken() {

        return Jwts.builder()
                .setHeader(createHeader())
                .setSubject("RefreshToken")
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpiration))
                .signWith(createSignature(), SignatureAlgorithm.HS512)
                .compact();

    }

    private static Key createSignature() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private static Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("type", "jwt");
        header.put("date", System.currentTimeMillis());
        return header;
    }
}
