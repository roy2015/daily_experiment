package com.roy.guo.news.okhttp;

import lombok.Data;

/**
 * @author guojun
 * @date 2022/9/22 10:34
 */
@Data
public class GetTokenResponse {
    private int code;
    private String message;
    private String token;

}
