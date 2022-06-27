package com.roy.miscellaneous.mainTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.slf4j.LoggerFactory;

import cn.hutool.core.date.LocalDateTimeUtil;

/**
 *
 * 测试data localDateTime
 * @author guojun
 * @date 2021/6/11
 */
public class TestLocalDateTime {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(
        TestLocalDateTime.class);


    static class Solution {

        public  LocalDateTime getTodayStartTime() {
            return LocalDateTimeUtil.beginOfDay(LocalDateTimeUtil.of(new Date()));
        }

        public  LocalDateTime getTodayEndTime() {
            return LocalDateTimeUtil.endOfDay(LocalDateTimeUtil.of(new Date()));
        }

        public  LocalDateTime getMinus7Day() {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime today = LocalDateTimeUtil.beginOfDay(now);
            return LocalDateTimeUtil.offset(today, -7, ChronoUnit.DAYS);
        }

        public  LocalDateTime getMinus1Month() {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime today = LocalDateTimeUtil.beginOfDay(now);
            return LocalDateTimeUtil.offset(today, -1, ChronoUnit.MONTHS);
        }

        public  void testParseDate() {
            //date -> instant -> localDateTime
            logger.info("================================");
            logger.info("默认时区 {}", ZoneId.systemDefault());
            logger.info("时区列表 {}", ZoneId.getAvailableZoneIds());
            logger.info("时区id {}", ZoneId.of("Asia/Shanghai"));
            logger.info("时区ZoneOffset {}", ZoneOffset.of("Z"));
            Date nowDate = new Date();
            logger.info("date:{}",nowDate);
            LocalDateTime nowLDT = LocalDateTimeUtil.of(nowDate);
            logger.info("localDateTime: {}", nowLDT);
            logger.info("Date.getTime {}", nowDate.getTime());
            logger.info("ZoneOffset.UTC {}", nowLDT.toEpochSecond(ZoneOffset.UTC));
            logger.info("ZoneOffset.of(\"+8\") 秒数 {}", nowLDT.toEpochSecond (ZoneOffset.of("+8")));
            logger.info("ZoneOffset.of(\"+8\") 毫秒数 {}", nowLDT.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        }

        public void test1() {
            logger.info("{}", LocalDateTime.now());
            logger.info("{}", LocalDateTime.now());
            logger.info("{}", new Solution().getTodayStartTime());
            logger.info("{}", new Solution().getTodayStartTime());
            logger.info("{}", new Solution().getTodayStartTime().toEpochSecond(ZoneOffset.of("+8")));
            logger.info("{}", new Solution().getTodayEndTime());
            logger.info("{}", new Solution().getMinus7Day());
            logger.info("{}", new Solution().getMinus1Month());
        }

        public void test2() {
            LocalDateTime now = LocalDateTime.now();
            logger.info("{}", now);
            int hour = now.getHour();
            logger.info("{}", hour);
            LocalDateTime parse = LocalDateTimeUtil.parse("2022-05-25 16:00:00", "yyyy-MM-dd HH:mm:ss");
            logger.info("{}", parse);
            LocalDate parse1 = LocalDateTimeUtil.parseDate("2022-05-25 16:00:00", "yyyy-MM-dd HH:mm:ss");
            logger.info("{}", parse1);
        }

        public void test3() {
            Instant startInstant = getMinus7Day().toInstant(ZoneOffset.of("+8")).plus(1, ChronoUnit.DAYS);
            LocalDateTime localDateTime = LocalDateTimeUtil.of(startInstant);
            LocalDate localDate = localDateTime.toLocalDate();
            logger.info("{}", localDate.toString());
            logger.info("{}-{}", localDate.getMonthValue(),localDate.getDayOfMonth());
            int k =3;
        }

        public void test11() {
            logger.info("本地时间： {}", LocalDateTime.now());
            logger.info("国际标准时间： {}", Instant.now());
            logger.info("LocalDateTime.now().toInstant： {}", LocalDateTime.now().toInstant(ZoneOffset.UTC));
            logger.info("{}", ZoneId.systemDefault());
        }

        public void testFormat() {
            Date now = new Date();
            LocalDateTime nowLDT = LocalDateTimeUtil.of(now);
            LocalDate nowLD = nowLDT.toLocalDate();
            LocalTime nowLT = nowLDT.toLocalTime();
            logger.info("{}", nowLDT);
            logger.info("{}", nowLD);
            logger.info("{}", nowLT);
            logger.info("{}", nowLD.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            logger.info("{}", nowLT.format(DateTimeFormatter.ofPattern("HHmmss")));
        }

    }

    public static void main(String[] args) {
        Solution so = new Solution();
//        so.testParseDate();
//        so.test2();
//        so.test3();
//          so.test11();
          so.testFormat();
    }
}
