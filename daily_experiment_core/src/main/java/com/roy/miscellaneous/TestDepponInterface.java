package com.roy.miscellaneous;

import com.alibaba.fastjson.JSON;
import com.roy.miscellaneous.util.JacksonUtil;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guojun
 * @date 2021/1/25 上午9:35
 */
public class TestDepponInterface {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestDepponInterface.class);

    static class Solution {

        public void queryRouteCode() {
        List<DepponRouteDto> logisticsInterface = new ArrayList<>();
        DepponRouteDto routeDto = new DepponRouteDto();
        DepponRouteAddressDto senderAddress = new DepponRouteAddressDto();
        senderAddress.setProvince("浙江省").setCity("杭州市").setArea("余杭").setTown("余杭街道").setDetail("狮山路11号");
        DepponRouteAddressDto receiverAddress = new DepponRouteAddressDto();
        receiverAddress.setProvince("江苏省").setCity("南京市").setArea("江宁").setTown("东山街道").setDetail("东麒路33号A座");
        routeDto.setObjectId(1);
        routeDto.setSenderAddress(senderAddress);
        routeDto.setReceiverAddress(receiverAddress);
        logisticsInterface.add(routeDto);
            String logisticsJson = JacksonUtil.toJsonString(logisticsInterface);
            String secretKey = "256ba2a62a46402396cfe4922c4b5dcf";
            String url = "http://dpapi.deppon.com/dop-interface-sync/dop-nonstandard-extension/queryRuleBatch.action";

            String digest = generateDigest(logisticsJson, secretKey);
            DepponRouteReq depponRouteReq = new DepponRouteReq();
            depponRouteReq.setDataDigest(digest);
            depponRouteReq.setLogisticsInterface(logisticsInterface);
            String bodyJson = JacksonUtil.toJsonString(depponRouteReq);

            logger.info("url:{}", url);
            logger.info("digest:{}", digest);
            logger.info("bodyJson:{}", bodyJson);
        }

        /**
         * 设置秘钥
         *
         * @param logisticsInterface JSON地址
         * @param secret 秘钥
         * @return
         */
        private String generateDigest(String logisticsInterface, String secret) {
            return Base64.encodeBase64String(getMD5(logisticsInterface + secret));
        }

        /**
         * md5
         *
         * @param plainText plainText
         * @return
         */
        private byte[] getMD5(String plainText) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(plainText.getBytes("UTF-8"));
                return md5.digest();
            } catch (Exception e) {
                throw new RuntimeException("获取md5值失败");
            }
        }
    }

    @Data
    @ToString(callSuper = true)
    @Accessors(chain = true)
    static class DepponRouteReq implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 公司编码(开放平台里面的companycode)
         */
        private String wpCode;
        /**
         * 请求签名
         */
        private String dataDigest;
        /**
         * 请求报文内容
         */
        private List<DepponRouteDto> logisticsInterface;
    }


    @Data
    @ToString(callSuper = true)
    @Accessors(chain = true)
    static class DepponRouteDto implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 发件地址
         */
        private DepponRouteAddressDto senderAddress;

        /**
         * 收件地址
         */
        private DepponRouteAddressDto receiverAddress;

        /**
         * 发件/收件地址对ID，单次请求中唯一
         */
        private Integer objectId;
        /**
         * 发件/收件地址对ID，单次请求中唯一
         */
        private String branchCode;

    }

    @ToString(callSuper = true)
    @Accessors(chain = true)
    @Data
    static class DepponRouteAddressDto implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 省
         */
        private String province;
        /**
         * 市
         */
        private String city;
        /**
         * 区
         */
        private String area;
        /**
         * 街道/镇
         */
        private String town;
        /**
         * 剩余详细地址
         */
        private String detail;
        /**
         * 邮编
         */
        private String zip;
    }




    public static void main(String[] args) {
        new Solution().queryRouteCode();


    }

}
