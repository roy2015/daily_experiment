package com.roy.guo.news.okhttp;

import lombok.Data;

/**
 * @author guojun
 * @date 2022/9/21 18:07
 */
@Data
public class SqlRequest {
    private Boolean includeHeaders;
    private String resultFormat;
    private String sql;
    private Integer timeout;




}
