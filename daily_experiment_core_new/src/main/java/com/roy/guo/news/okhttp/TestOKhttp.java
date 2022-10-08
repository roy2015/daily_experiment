package com.roy.guo.news.okhttp;

import com.roy.guo.news.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import javax.crypto.NoSuchPaddingException;
import java.io.Closeable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;

/**
 * @author guojun
 * @date 2021/6/11
 */
@Slf4j
public class TestOKhttp {


    static class Solution implements Closeable {

        private static final String SERVER_URL = "http://172.30.13.177:30016";
//        private static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySWQiOiI3N2E3NDQ2My0xM2E0LTQwZGEtOTU3Yy02ZGUxOGQ2ZDRlY2EiLCJ1c2VyTmFtZSI6ImFkbWluIiwidXNlck5pY2tuYW1lIjoi566h55CG5ZGYIiwib3JnYW5pemF0aW9uTmFtZSI6IuaxiemrmOaPkOa1iyIsIm5hbWVzcGFjZUlkIjoibnNfdGVzdGhpZ2hnb190ZXN0aGlnaGdvIiwibG9naW5UeXBlIjoidXNlciIsImV4cGlyZWQiOiIyMDIyLTA5LTIyIDE3OjAyOjE1IiwiZXhwIjoxNjYzODM3MzM1fQ.IZK_lWK9RZiM9BuiHmY7VbsUvp6w_OgsQW49NlNnWZnNauiIv107rHn9l23xgMU_IVvEOAQt4acMXWak2IthxA";
        private static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("application/json; charset=utf-8");

        private final OkHttpClient httpClient = newHttpClient();

        @Override
        public void close() {
            httpClient.dispatcher().executorService().shutdown();
            httpClient.connectionPool().evictAll();
        }

        private static OkHttpClient newHttpClient()
        {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            return builder.build();
        }

        //add  header
        private Request.Builder prepareHeader(HttpUrl url, String token) {
            Request.Builder builder = new Request.Builder()
                    .addHeader("x-token", token)
                    .url(url);
            return builder;
        }

        public void executeSql(String token, String sql) {
            //server:port
            HttpUrl url = HttpUrl.get(SERVER_URL);
            if (url == null) {
                throw new RuntimeException("Invalid server URL ");
            }
            //sub path
            url = url.newBuilder().encodedPath("/x-bigdata-os-service/engines/sql").build();
            SqlRequest sqlRequest = new SqlRequest();
            sqlRequest.setIncludeHeaders(true);
            sqlRequest.setResultFormat("JSON_ARRAY");
            sqlRequest.setTimeout(30000);
            sqlRequest.setSql(sql);

            Request.Builder builder = prepareHeader(url, token)
                    .post(RequestBody.create(MEDIA_TYPE_TEXT, JsonUtil.writeValueAsString(sqlRequest)));
            try (Response response = httpClient.newCall(builder.build()).execute()) {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    if (responseBody != null) {
                        String responseStr = responseBody.string();
                        log.debug(" 返回结果:{}", responseStr);
//                        List<DataLableEntity> dataLableEntities = JsonUtil.readListValue(responseStr, DataLableEntity.class);
//                        log.debug("{}", JsonUtil.writeValueAsString(dataLableEntities));
                    }
                } else {
                    response.close();
                    Objects.requireNonNull(response.body()).close();
                }

            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        private  String getToken() throws Exception {
            String cipherText = getCipherText("MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCaAVZoUHpFdV0wCcdRD7SpDq+pkM4hWxhI0sEwugBIQsIi0tiytdhnSK5yiKjbcCKqQyg9altRdpGR+9Zn4rF8ABwCoZ0m43/RbmdRQOVK0vV0RUr1wkuu+BSs8gr78R8wkl5XrWMjEcZSXPE3daaFNVXAPbHDiB/xG/5cPv6HytZltkdb5rjnts8SXiF3FinwBnRuFrwg99RJUr5+OlHwD1obc/D+fmHJ3fYVkcky41OnS5ams1/goBWRl0BhTeS7LCIaRsuNbDciJlx0Yxmk+SXHAqmf2BFD1bq83Kl3QCZa6vnJPaGkCEOuQHrC6yWOGY9ek8PO8Dc40hbRmWaDAgMBAAECggEBAI6FcluzLpSdGpJcWlKQQFa7uqEn2ztPPFgYgqT/XUeCUHs9uUEZvJ1Iy/g+tFXvnoUHBXRguwXWvrzk3PTi+/GPgFyHCBJ3M1Cz5XVyoz/tny3s+oQZPUU9XJT4omWqLX0b16c4VKidyHVsgecbP/HC/AqejaYwka7mgy0HNzKedbLeFoGpr3I4JFd0R1ea7DeJnjn+2cOXS4cGZavsf995Sv/PfUD+NyUCsbGYY4BLelLfWzHz3pbJXRYnyotF20zyAWNHsyh7lUM7UJ2i7TP3dIsuFif/hhwJSsXIFgbt2Sw/M2FEVTWeQeOEuX6tgRSYWOUDVmvvXVMQhLXjWeECgYEA6vzLhDDsdQkb6DE9kyxfgWHMMOSPJ55tgAG9tY1MOTvQef8ydpZJ953xHcz0Bgbr/lXIunNAttvwNnMFO41dlUCKVNDh6f5I4RvXijHoL/rUqrBXbQRTq20iDssLznmGVYSLle4II4DATSU0RQUv0qrlYvVfETMfYai7fhwnOvkCgYEAp8a9sZ5Gpqgl9ELwy/f9i66yHTrHekvIJx9mLfdCwKWejb8qRFWzz4Cy/4Ux4QTzvAMsAFodmyMYSADcFb/WP3pw2JW/DAVhXA6hEBEudaTjjVqmEI6yABlYNXvNnVPMvfYAtR/RPCXZhR6gdBhrK02ZZvdvBD6kxU93YjTO8FsCgYEAtf/7hLP7wB3A/pJ8tWttwSDE7K1pbu8Wskkm7OG2QrHgI00TgaOfQGiU4lbmPXDJAWDhqf8wBTDNmO53BAvWio3FVjG+d+QaADf3NbK3ucmVQ2p3HBl40FIjSb/bshyPfda94e7NYOoMhvOkyzxcMNdp+L5A1mp5CMOOC/u0KskCgYEAk3Eqn39S4379680wRG/pl+msiddwGl+ixA7qAxc6yIZD8pm/EVKntIGLzNZG4VMyx1WaQ6zuO7n5yr1GrK5sIFj/9raSsIPB7d7FWJNg2u5PM5goPIDKmR+sz0O/jLVqRr58HLCbdlpk8IHbzGrxM5r8Zuqn23kZ4HRXnCyAd+UCgYB5rahL5yC1k9KcnKCuiQ/d2mgrp4l17o0THhtdVZMz42MWNWgXz7+r66o6C1iRW0e1HHetM+CP5BVYVtVbavBJVWneZiU/3K9OK3AJzS+lSpPYxbAVpefMuUx1heJdvtGT1UCdFiQn+5Xy4JiXWXTlj5Bwr/m8U5inlFJZDzJOQA==");

            HttpUrl url = HttpUrl.get(SERVER_URL);
            if (url == null) {
                throw new RuntimeException("Invalid server URL ");
            }
            //sub path
            url = url.newBuilder().encodedPath("/x-authorization-service/authorizations/logins").build();
            GetTokenRequest getTokenRequest = new GetTokenRequest();
            getTokenRequest.setName("949370c6-33b3-4a9b-8c35-201fb8445684");
            getTokenRequest.setPassword(cipherText);

            Request.Builder builder = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(MEDIA_TYPE_TEXT, JsonUtil.writeValueAsString(getTokenRequest)));

            try (Response response = httpClient.newCall(builder.build()).execute()) {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    if (responseBody != null) {
                        String responseStr = responseBody.string();
                        log.debug(" 返回结果:{}", responseStr);
                        GetTokenResponse getTokenResponse = JsonUtil.readValue(responseStr, GetTokenResponse.class);
                        return getTokenResponse.getToken();
                    }
                } else {
                    response.close();
                    Objects.requireNonNull(response.body()).close();
                }

            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return null;
        }


        /** 通过 AKSK 生成密文 * @param privateKeyString 私钥 */
        private  String getCipherText(String privateKeyString) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, SignatureException {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyString));
            PrivateKey privateKey = factory.generatePrivate(privateKeySpec);
            Signature privateSignature = Signature.getInstance("SHA256withRSA");
            privateSignature.initSign(privateKey);
            String input = String.format("%s@%s", UUID.randomUUID(), 3600 * 2);
            privateSignature.update(input.getBytes(StandardCharsets.UTF_8));
            String resStr = input.concat("#").concat(new String(Base64.getEncoder().encode(privateSignature.sign()), StandardCharsets.UTF_8));
            log.info("密文: {}", resStr);
            return resStr;
        }

    }

    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        //        new Solution().executeSql("select * from data_label_biaoqian_47");
//        new Solution().executeSql("show table data_label_biaoqian_47");


        String token = solution.getToken();
        log.info("token: {}", token);
        solution.executeSql(token, "select * from data_tag_process_test");

//        log.info("");
    }
}
