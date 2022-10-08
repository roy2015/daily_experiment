package com.roy.guo.news.okhttp;

import lombok.Data;

/**
 * @author guojun
 * @date 2022/9/22 10:27
 */
@Data
public class GetTokenRequest {

    private String name;

    private String password;

    private String type = "aksk";
}
