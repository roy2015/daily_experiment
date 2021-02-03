package com.roy.miscellaneous.hutool.job;

import cn.hutool.cron.CronUtil;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * hutool定时任务
 *
 * @author guojun
 * @date 2021/1/27 下午5:51
 */

@Slf4j
public class TestHutoolCronTask {

    public static void main(String[] args) {
        CronUtil.setMatchSecond(true);
        CronUtil.start(false);
    }
}
