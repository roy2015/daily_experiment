package com.guo.roy.research.misc.io.gen_csv;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author guojun
 * @date 2022/10/8 16:41
 */

@Data
@Accessors(chain = true)
public class CsvDto {
    private int id;
    private String name;
    private int age;
    private Date createTime;
}
