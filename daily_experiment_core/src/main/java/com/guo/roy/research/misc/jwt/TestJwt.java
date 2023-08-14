package com.guo.roy.research.misc.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.Base64Codec;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

/**
 * @author guojun
 * @date 2021/6/11
 *  测试JWT
 *
 * jwt组成:  header + body + sign
 */
@Slf4j
public class TestJwt {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestJwt.class);


    /**
     * token对象
     */
    @Data
    @Accessors(chain = true)
    static class Token {
        private String userId;

        private String userName;

        /**
         * 时间为秒，需要换算
         */
        private Date exp;
    }

    static class Solution {
        //消息验证码的 secret
        public static final String SECRET = "8cb3cffd0e5343ddb094ab547b559e84a7e409322c0a43a081f2a44bd05a07d1";

        /**
         * 生成jwt string
         * @param token
         * @param expireTime
         * @return
         */
        public String generateJws(Object token, Date expireTime) {
            return Jwts.builder().setClaims(JsonUtil.readValue(JsonUtil.writeValueAsString(token), Map.class))
                    .setExpiration(expireTime).signWith(SignatureAlgorithm.HS512, SECRET).compact();
        }

        /**
         * 校验jwt(校验签名)，并返回body, Token对象
         * @param token
         * @param type
         * @param <T>
         * @return
         */
        public <T> T validateJwtAndRet(String token, Class<T> type) {
            try {
                Map<String, Object> body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
                return JsonUtil.readValue(JsonUtil.writeValueAsString(body), type);
            } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException ex) {
                return null;
            }
        }

        /**
         * 由jwt字符串获取Token对象,不验证签名正确性，比validateJwtAndRet快
         * @param jws
         * @param cls
         * @param <T>
         * @return
         */
        public <T> T getToken(String jws, Class<T> cls) {
            String[] split = jws.split("\\.", 3);
            String body = Base64Codec.BASE64URL.decodeToString(split[1]);
            T ret = JsonUtil.readValue(body, cls);
            return ret;
        }

        public  void main() {
            String jws = generateJws(new Token().setUserId("123").setUserName("guo123"),
                    DateUtil.plus(new Date(), DateUtil.TimeType.YEAR, 1));
            log.debug("jws: {}", jws);
            Token token ;
            token = getToken(jws, Token.class);
            log.info("token: {}", token);
            token = validateJwtAndRet(jws, Token.class);
            //exp过期时间是秒，转换成毫秒
            token.setExp(new Date(token.getExp().getTime() * 1000));
            log.info("token: {}", token);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.main();


    }
}
