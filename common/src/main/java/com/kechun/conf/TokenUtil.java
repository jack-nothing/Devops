package com.kechun.conf;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Date;

public class TokenUtil {

    private static Logger logger = LoggerFactory.getLogger(TokenUtil.class);

    public static void main(String[] args) {
        String test = "";
        System.out.println(test);
        String token = createJWT("0", "admin", "123456", Contants.TOKEN_TIMEOUT);//2小时
        System.out.println(token);
        Object data = parseJWT(token);
    }

    public static final String HS256_STR = "ZXCV@qwer";

    public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(HS256_STR);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        String token = builder.compact();
        try {
            BASE64Encoder bASE64Encoder = new BASE64Encoder();
            String tokenBase64 = bASE64Encoder.encode((token + Contants.TOKEN).getBytes("UTF-8"));

            return tokenBase64;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Object parseJWT(String jwt) {
        Claims claims = null;
        try {
            BASE64Decoder bASE64Decoder = new BASE64Decoder();
            jwt = new String(bASE64Decoder.decodeBuffer(jwt), "UTF-8");
            jwt = jwt.replace(Contants.TOKEN, "");

            claims = Jwts.parser().
                    setSigningKey(DatatypeConverter.parseBase64Binary(HS256_STR))
                    .parseClaimsJws(jwt).getBody();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        Long exp = claims.getExpiration().getTime(); //过期的时间
        Long nowMillis = System.currentTimeMillis();//现在的时间
        if (exp < nowMillis) {
            return "update";
        }
        return "success";
    }

    public static int getUserIdByParseJWT(String jwt) {
        int userId = -1;
        Claims claims = null;
        BASE64Decoder bASE64Decoder = new BASE64Decoder();
        try {
            jwt = new String(bASE64Decoder.decodeBuffer(jwt), "UTF-8");
            jwt = jwt.replace(Contants.TOKEN, "");
            claims = Jwts.parser().
                    setSigningKey(DatatypeConverter.parseBase64Binary(HS256_STR))
                    .parseClaimsJws(jwt).getBody();
            userId = Integer.parseInt(claims.getId());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Exception:");
            return userId;
        }
        return userId;
    }
}
