package com.roy.guo.news.http;

import com.roy.guo.news.okhttp.GetTokenRequest;
import com.roy.guo.news.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author guojun
 * @date 2021/6/11
 */
@Slf4j
public class TestSolutionHttp {

    private static final String SERVER_URL = "http://172.30.13.177:30016/x-authorization-service/authorizations/logins";


    static class Solution {
        public  void test() {
            GetTokenRequest getTokenRequest = new GetTokenRequest();
            getTokenRequest.setName("949370c6-33b3-4a9b-8c35-201fb8445684");
            getTokenRequest.setPassword("4c4311cc-6884-498a-84f3-dd9f9bc981c6@7200#Ov5jscD3s4m7DjO4Gx+F3cgBxjBR5Kq6RR6vucPlHiaPARp+afsvcmh/ks3CZT97I8z4lF4LTFHnXqMLHf/LV1/WQ6Zp/FmUFyvYCOrtGtm+Y/wLvr5/IJAVmoljUeF4+jQwK+ExWhYU/mRHZbNC2H1RFFhHEWT7X2NWk9EaZ7+onE49Nv5yHGcTBGn97pxC7JxIDOKc4nbNBsG7WJxRDLGqP7ofXrH+sP0qIU5bB42C5hWiTzFK4HyI4MzgStcdosX3TLJ6RSqotQ2epNfDYIwt4aQWclXuf/FGMuK2p+ZpPraXNvbKm1mt0s6unisDUVWbWB5onRqPBjB3s3RQ5Q==");
            log.info("body: {}",  HttpRequest.post(SERVER_URL).contentType("application/json", StandardCharsets.UTF_8.displayName()).send(JsonUtil.writeValueAsString(getTokenRequest)).body());
        }

    }

    public static void main(String[] args) {
        new Solution().test();
        log.info("{}", new Solution());
    }
}
