package com.roy.miscellaneous.io.gen_csv;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guojun
 * @date 2022/10/8 16:42
 */
public class MainTest {

    public void doMain() throws Exception {

        List<CsvDto> dtoList = new ArrayList<>();
        //id
        //name
        //age
        //create_time
        for (int i = 90000; i < 190000; i++) {
            dtoList.add(new CsvDto().setId(i).setName("test"+i).setAge(25).setCreateTime(new Date()));
        }

        List<String> finList =
                dtoList.stream().map(dto -> String.join(",", String.valueOf(dto.getId()),
                        dto.getName(), String.valueOf(dto.getAge()), DateUtil.format(dto.getCreateTime(), DatePattern.NORM_DATETIME_MS_PATTERN)))
                        .collect(Collectors.toList());
        FileOutputStream outputStream = new FileOutputStream("/Users/apple/Desktop/123.csv");
        IOUtils.writeLines(finList, null, outputStream);
        IOUtils.closeQuietly(outputStream);
    }

    public static void main(String[] args) throws Exception {
        new MainTest().doMain();


    }
}
