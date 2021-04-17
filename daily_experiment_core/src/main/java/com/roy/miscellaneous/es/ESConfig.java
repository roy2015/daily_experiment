package com.roy.miscellaneous.es;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author zhunji
 * @Date 2020/6/29 15:24
 */

public class ESConfig {

    public static String CLUSTER_NAME = "ESCluster1";

    public static String HOST = "172.31.100.50";

    public static int PORT = 9300;

//    @Value("${fulltextsearch.es.index}")
//    public String INDEX = "hbdxindex";
//
//    @Value("${fulltextsearch.es.type.tel}")
//    public String TYPE = "hbdx_archive";

    public static String INDEX_TEL = "telindex";

    public static String TYPE_TEL = "teltype";


    public static String INDEX_MES_PRE = "messageindex";

    public static String TYPE_MES = "message";

    public static String INDEX_MES_TOPIC = "messagetopic";

    public static String TYPE_MES_TOPIC = "messagetopictype";

    //手机消费明细
    public static String INDEX_ASSETS_PRE = "assetsindexdetail";
    public static String TYPE_ASSETS = "assetsdetail";

    //银行卡资产信息
    public  String INDEX_TEL_AGG = "telassetsindex";
    public  String TYPE_TEL_AGG = "telaassetstype";

    //银行卡 ，后期考虑迁移到clickhouse
    public  String INDEX_ASSETS_BANK = "assetsindexbank";
    public  String TYPE_ASSETS_BANK = "assetsbank";


    //资产分类表，后期考虑迁移到clickhouse
    public  String INDEX_ASSETS_TYPE = "assetsindextype";
    public  String TYPE_ASSETS_TYPE = "assetstype";


    //出行表，后期考虑迁移到clickhouse
    public  String INDEX_CX = "trajectoryindex";
    public  String TYPE_CX = "trajectorytype";

    //资产分类表，后期考虑迁移到clickhouse
    public static String INDEX_CX_DETAIL = "trajectorydetailindex";
    public static String TYPE_CX_DETAIL = "trajectorydetailtype";

}
