package com.guo.roy.research.misc.bitops;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * @author guojun
 * @date 2023/1/6 10:21
 */

@Slf4j
public class TestSnowflake {
    /**
     * 雪花算法，生成唯一id
     */


    @Data
    static class SnowFlakeUtil {

        private Date epochDate;
        private long topBit = 0L;//默认0
        private long timestampBits = 41;
        private long dataCenterIdBits = 5;
        private long workIdBits = 5;
        private long sequenceBits = 12;

        private long topBitShift =       timestampBits + dataCenterIdBits + workIdBits + sequenceBits;
        private long timestampShift =    dataCenterIdBits + workIdBits + sequenceBits;
        private long dataCenterIdShift = workIdBits + sequenceBits;
        private long workerIdShift = sequenceBits;
        private long sequenceMask = ~(-1 << sequenceBits);

        public static SnowFlakeUtil snowFlakeUtil;


        private long lastSeqInMillSec = 0;

        private SnowFlakeUtil() {
        }

        public static synchronized SnowFlakeUtil getInstance() {
            if (snowFlakeUtil == null) {
                snowFlakeUtil = new SnowFlakeUtil();
                snowFlakeUtil.init();
            }

//            log.info("sequenceMask: {}", Long.toBinaryString(snowFlakeUtil.getSequenceMask()));

            return snowFlakeUtil;
        }


        public synchronized long nexId() {
            long timestamp = new Date().getTime() - epochDate.getTime();
            long dateCenter = 0b101;
            long worker = 0b1;
            long seqInMillSec = this.lastSeqInMillSec + 1;
            seqInMillSec = (seqInMillSec & sequenceMask);
            lastSeqInMillSec = seqInMillSec;

            log.info("epoch time: {}" , new Date(timestamp));
//            log.info("123: {}" , Long.toBinaryString(timestamp));
//            log.info("123: {}" , Long.toBinaryString(timestamp << timestampShift));
//            log.info("{}" , new Date(timestamp << timestampShift >> timestampShift));

            long nextId = topBit << topBitShift
                    |(timestamp << timestampShift)
                    | dateCenter << dataCenterIdShift
                    | worker << workerIdShift
                    | seqInMillSec;

            log.info("next id: {}", Long.toBinaryString(nextId));
            log.info("解析出时间戳 {}", SnowFlakeUtil.getTimestampFromId(nextId));
            return nextId;
        }

        public static Date getTimestampFromId(long id) {
            long epochMask =  (-1L ^ (1L << 63)) >> 22 << 22;
//            log.info("{}" , Long.toBinaryString(epochMask));
            long millsec = (epochMask & id) >> 22;
//            log.info("123: {}" , Long.toBinaryString(epochMask ^ id));
            return new Date(millsec);
        }

        public void init() {
            String[] possibleDateFormats =
                    {
                            "yyyyMMddHHmmssSSS",
                            "yyyyMMddHHmmss",
                            "yyyyMMddHHmm",
                            "yyyyMMddHH",
                            "yyyyMMdd",
                            "yyyy-MM-dd HH:mm:ss.SSS",
                            "yyyy-MM-dd HH:mm:ss",
                            "yyyy-MM-dd HH:mm",
                            "yyyy-MM-dd HH",
                            "yyyy-MM-dd",
                            "yyyy/MM/dd HH:mm:ss.SSS",
                            "yyyy/MM/dd HH:mm:ss",
                            "yyyy/MM/dd HH:mm",
                            "yyyy/MM/dd HH",
                            "yyyy/MM/dd",
                            "yyyy年MM月dd日HH时mm分ss秒",
                            "yyyy年MM月dd日HH时mm分",
                            "yyyy年MM月dd日HH时",
                            "yyyy年MM月dd日",
                    };
            try {
                epochDate = DateUtils.parseDate("2000-01-01 08:00:00.000", possibleDateFormats);
                log.info("epochDate: {}", epochDate);
            } catch (Exception e) {
                log.error("initDate error");

            }
        }
    }

    public static void main(String[] args) {
        SnowFlakeUtil instance = SnowFlakeUtil.getInstance();
        for (int i = 0; i < 1; i++) {
            long nexId = instance.nexId();
            log.info("{}, {}", nexId, StringUtils.leftPad(Long.toBinaryString(nexId),64, "0"));
        }
    }
}
