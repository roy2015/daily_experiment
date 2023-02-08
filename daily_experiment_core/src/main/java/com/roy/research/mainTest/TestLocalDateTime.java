package com.roy.research.mainTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

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
            logger.info("时区id {}", ZoneId.of("GMT+8"));
            logger.info("时区id {}", ZoneId.of("UTC+8"));
            logger.info("时区ZoneOffset {}", ZoneOffset.of("Z"));
            //zoneOffset
            logger.info("ZoneId转zoneOffset四种种方式： ");
            ZoneOffset zoneOffset = ZoneOffset.of("+8");
            logger.info("方式一：时区ZoneOffset {}", zoneOffset);
            zoneOffset = ZoneId.of("Asia/Shanghai").getRules().getOffset(Instant.now());
            logger.info("方式二：时区ZoneOffset {}", zoneOffset);
            zoneOffset = ZonedDateTime.now(ZoneId.of("America/Chicago")).getOffset();
            logger.info("方式三：时区ZoneOffset {}", zoneOffset);
            zoneOffset = Optional.ofNullable(ZoneId.of("Asia/Aden"))
                    .map(TimeZone::getTimeZone)
                    .map(TimeZone::getRawOffset)
                    .map(Duration::ofMillis)
                    .map(Duration::getSeconds)
                    .map(Number::intValue)
                    .map(ZoneOffset::ofTotalSeconds)
                    .orElse(null);
            logger.info("方式四：时区ZoneOffset {}", zoneOffset);

            Date nowDate = new Date();
            logger.info("date:{}",nowDate);
            LocalDateTime nowLDT = LocalDateTimeUtil.of(nowDate);
            logger.info("localDateTime: {}", nowLDT);
            logger.info("Date.getTime {}", nowDate.getTime());
            logger.info("ZoneOffset.UTC {}", nowLDT.toEpochSecond(ZoneOffset.UTC));
            logger.info("ZoneOffset.of(\"+8\") 秒数 {}", nowLDT.toEpochSecond (zoneOffset));
            logger.info("ZoneOffset.of(\"+8\") 毫秒数 {}", nowLDT.toInstant(zoneOffset).toEpochMilli());
            logger.info("ZoneOffset.of(\"+8\") 毫秒数 {}", nowLDT.toInstant(zoneOffset).toEpochMilli());
            logger.info("LocalDateTime转化为date {}", new Date(nowLDT.toInstant(zoneOffset).toEpochMilli()));
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
        so.test1();
//        so.test2();
//        so.test3();
//          so.test11();
//          so.testFormat();
    }
}
