package com.roy.miscellaneous.es;

import static com.roy.miscellaneous.es.ESConfig.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.stats.IndexStats;
import org.elasticsearch.action.admin.indices.stats.IndicesStatsRequest;
import org.elasticsearch.action.admin.indices.stats.IndicesStatsResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.alibaba.fastjson.JSONObject;

public class ESBuilder {
    private volatile static String IndexName="hbdxindex";
    private volatile static String TypeName="hbdx_archive";

    private volatile static TransportClient client;//客户端对象,用于连接到Elasticsearch集群
    public static void main(String args[]) throws Exception{
        getSingleTransportClient();

        //delete
        //deleteType();
//        deleteIndex();
        //deleteByQuery();
        //deleteIndex(ESConfig.INDEX_TEL);

        //创建索引
//        createIndex();
//        getAllIndices();

        //创建type
//        defineIndexTypeMapping();
//        defineTelIndexTypeMapping();
//        defineMessageIndexTypeMapping();

        //创建document
        createDocumentByMap();
        createTelDocumentByMap();
        createMessageDocumentByMap();

        //更新document
        //updateMessage();


//        getAllIndices();
    }

    public static void updateMessage() {
        String id="1";
        Map<String,String> updateMap= new HashMap<>();
        updateMap.put("service_provider_name", "工商银行");
        updateMap.put("account_num", "666666666666");
        updateMap.put("account_name", "我的名字叫修改");
        updateMap.put("time", "2020-12-12 12:12:59");


        Map<String,String> deleteMap= new HashMap<>();
        deleteMap.put("balance", "");
        deleteMap.put("amount", "");
        deleteMap.put("counterparty_name", "");
        deleteMap.put("type", "");
        deleteMap.put("loan_amount", "");

        String indexName = INDEX_MES_PRE + "202002";;

        GetResponse response2 = client.prepareGet(indexName, TYPE_MES, id)
                .setOperationThreaded(false) // 线程安全
                .get();

        Map<String, Object> source = response2.getSource();
        System.out.println(source.toString());

        //修改数据（指定字段进行修改)
        // 检索开始
        JSONObject jsonObject = new JSONObject();
        //jsonObject.putAll(updateMap);
        jsonObject.putAll(deleteMap);
        UpdateResponse response = client.prepareUpdate(indexName, TYPE_MES, id)
                .setDoc(jsonObject.toString(), XContentType.JSON).get();
        System.out.println("当前实例状态：" + response.status());

        GetResponse response1 = client.prepareGet(indexName, TYPE_MES, id)
                .setOperationThreaded(false) // 线程安全
                .get();

        Map<String, Object> source1 = response1.getSource();
        System.out.println(source1.toString());
    }


    //删除查询数据
    public static void deleteByQuery() {
        BulkByScrollResponse response = DeleteByQueryAction.INSTANCE
                .newRequestBuilder(client)
                .filter(QueryBuilders.matchAllQuery())
                .source(INDEX_TEL)
                .get();
        long deleted = response.getDeleted();
    }

    /**
     * 获取所有index
     */
    public static Set getAllIndices() {
        ActionFuture<IndicesStatsResponse> isr = client.admin().indices().stats(new IndicesStatsRequest().all());
        IndicesAdminClient indicesAdminClient = client.admin().indices();
        Map<String, IndexStats> indexStatsMap = isr.actionGet().getIndices();
        Set<String> set = isr.actionGet().getIndices().keySet();
        System.out.println(set);
        return set;
    }



    public static TransportClient getSingleTransportClient() {
        Settings settings = Settings.builder().put("cluster.name", "docker-cluster").build();
        if (client == null) {
            synchronized (TransportClient.class) {
                try {
                    client = new PreBuiltTransportClient(settings)
                            .addTransportAddress(new InetSocketTransportAddress
                                    (InetAddress.getByName("127.0.0.1"), 9300));
                    //client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
        return client;
    }

    /**
     * 关闭连接
     * @Title: closeConnect
     * @author sunt
     * @date 2017年11月23日
     * @return void
     */
    public void closeConnect() {
        if(null != client) {
            client.close();
        }
    }

    // 创建索引
    public static void createIndex() {
        client.admin().indices().create(new CreateIndexRequest(IndexName))
            .actionGet();
        client.admin().indices().create(new CreateIndexRequest(INDEX_TEL))
                .actionGet();
        try {
            List<String> list;
            String[] indexNames;
            //list= DateUtil.getMonthBetweenByStr("2017-02-05", "2018-02-05");
//            list = DateAndTimeUtil1.getMonthBetween("2019-02-05", "2020-12-31");
            list = Arrays.asList("2015-02-05");

            indexNames = list.toArray(new String[list.size()]);
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                indexNames[i] = INDEX_MES_PRE + list.get(i);

                System.out.println("创建索引"+indexNames[i]);
                client.admin().indices().create(new CreateIndexRequest(indexNames[i]))
                        .actionGet();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("索引 telindex创建成功");
    }

    // 判断索引是否存在 传入参数为索引库名称
    public static boolean isIndexExists(String indexName) {
        boolean flag = false;
        IndicesExistsRequest inExistsRequest = new IndicesExistsRequest(indexName);
        IndicesExistsResponse inExistsResponse = client.admin().indices()
                .exists(inExistsRequest).actionGet();
        if (inExistsResponse.isExists()) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public static void deleteIndex(String indexName) {
        if (!isIndexExists(indexName)) {
            System.out.println(indexName + " not exists");
        } else {

            DeleteIndexResponse dResponse = client.admin().indices().prepareDelete(indexName)
                    .execute().actionGet();
            if (dResponse.isAcknowledged()) {
                System.out.println("delete index "+indexName+"  successfully!");
            }else{
                System.out.println("Fail to delete index "+indexName);
            }
        }
    }


    // 清除所有索引
    public static void deleteIndex() {
        IndicesExistsResponse indicesExistsResponse;
System.out.println(132);
        indicesExistsResponse = client.admin().indices()
                .exists(new IndicesExistsRequest(new String[] { INDEX_TEL }))
                .actionGet();
        if (indicesExistsResponse.isExists()) {
            client.admin().indices().delete(new DeleteIndexRequest(INDEX_TEL ))
                   .actionGet();
           System.out.println("telindex被删除");
        }
//        System.out.println(140);
//
        try {
            List<String> list;
            String[] indexNames;
            //list= DateUtil.getMonthBetweenByStr("2017-02-05", "2018-02-05");
//            list = DateAndTimeUtil1.getMonthBetween("2015-02-05", "2020-12-31");
            list = Arrays.asList("2015-02-05");

            indexNames = list.toArray(new String[list.size()]);
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                indexNames[i] = INDEX_MES_PRE + list.get(i);
                indicesExistsResponse = client.admin().indices()
                        .exists(new IndicesExistsRequest(new String[] { indexNames[i] }))
                        .actionGet();
                if (indicesExistsResponse.isExists()) {
                    client.admin().indices().delete(new DeleteIndexRequest(indexNames[i]))
                            .actionGet();
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("删除成功");
    }


    // 删除Index下的某个Type
    public static void deleteType(){
        // client.prepareDelete().setIndex(IndexName).setType(TypeName).execute().actionGet();
        DeleteIndexResponse deleteIndexResponse;
//        DeleteIndexResponse deleteIndexResponse = client.admin().indices()
//                .prepareDelete(IndexName)
//                .execute().actionGet();
//        System.out.println(deleteIndexResponse);

//         deleteIndexResponse = client.admin().indices()
//                .prepareDelete(ESConfig.TYPE_TEL)
//                .execute().actionGet();
//        System.out.println(deleteIndexResponse);
//         deleteIndexResponse = client.admin().indices()
//                .prepareDelete(messageIndexName)
//                .execute().actionGet();
//        System.out.println(deleteIndexResponse);

    }

    // 定义索引的映射类型   IndexType
    public static void defineIndexTypeMapping() {
        try {
            XContentBuilder mapBuilder = XContentFactory.jsonBuilder();
            mapBuilder.startObject()
                    .startObject(TypeName)
                    .startObject("_all").field("enabled", false).endObject()
                    .startObject("properties")
                    .startObject("id").field("type", "integer").field("store", "true").endObject()
                    .startObject("actionZone").field("type", "text").field("analyzer", "ik_smart").field("search_analyzer","ik_smart").endObject()
                    .startObject("age").field("type", "integer").endObject()
                    .startObject("income").field("type", "integer").endObject()
                    .startObject("name").field("type", "text").endObject()
                    .startObject("birthday").field("type", "text").endObject()
                    .startObject("gender").field("type", "text").endObject()
                    .startObject("language").field("type", "text").endObject()
                    .startObject("idCard").field("type", "text").endObject()
                    .startObject("address").field("type", "text").endObject()
                    .startObject("telNo").field("type", "text").endObject()
                    .startObject("tags").field("type", "text").endObject()
                    .endObject()
                    .endObject()
                    .endObject();
            System.out.println("defineIndexTypeMapping创建成功");
            PutMappingRequest putMappingRequest = Requests
                    .putMappingRequest(IndexName).type(TypeName)
                    .source(mapBuilder);
            client.admin().indices().putMapping(putMappingRequest).actionGet();

//            System.out.println("diyige suoyin type chuangjian 创建成功");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*
    {"text":["910010_M"],"archiveType":"holographic","advanceFilterBeanList":[{"filterField":"local_sex,network_sex","filterValues":["0"],"filterType":"term"},{"filterField":"local_dob,network_dob,local_yob","filterValues":[20,40],"filterType":"range"},{"filterField":"local_graduation_school,network_graduate_school","filterValues":["California Institute of Technology"],"filterType":"term"},{"filterField":"local_hh_income","filterValues":["B"],"filterType":"term"},{"filterField":"network_isinterestedin","filterValues":["Political forum"],"filterType":"term"},{"filterField":"local_race","filterValues":["C"],"filterType":"term"}],"page":{"pageNo":1,"pageSize":15}}
*/

    // 定义索引的映射类型   IndexType
    public static void defineTelIndexTypeMapping() {

        try {
            XContentBuilder mapBuilder = XContentFactory.jsonBuilder();
            mapBuilder.startObject()
                    .startObject(TYPE_TEL)
                    .startObject("_all").field("enabled", false).endObject()
                    .startObject("properties")
                    .startObject("id").field("type", "keyword").endObject()
                    .startObject("data_cycle").field("type", "keyword").endObject()
                    .startObject("phone_num").field("type", "keyword").endObject()
                    .startObject("telecom_operators").field("type", "keyword").endObject()
                    .startObject("living_accounts").field("type", "keyword").endObject()
                    .startObject("phone_brand").field("type", "keyword").endObject()
                    .startObject("tags").field("type", "keyword").endObject()
                    .startObject("roamingPlace").field("type", "keyword").endObject()
                    .startObject("location").field("type", "text").field("analyzer", "ik_max_word").field("search_analyzer","ik_max_word").endObject()
                    .startObject("certificate_num").field("type", "keyword").endObject()
                    .startObject("certificate_type").field("type", "keyword").endObject()
                    .startObject("nationality").field("type", "keyword").endObject()
                    .startObject("name").field("type", "keyword").endObject()
                    .startObject("register_time").field("type", "keyword").endObject()
                    .startObject("status").field("type", "keyword").endObject()
                    .startObject("isOnline").field("type", "keyword").endObject()
                    .startObject("contacts_cnt").field("type", "integer").endObject()
                    .startObject("msm_recipient_cnt").field("type", "integer").endObject()
                    .startObject("msm_sender_cnt").field("type", "integer").endObject()
                    .startObject("msm_receive_cnt_mon").field("type", "integer").endObject()
                    .startObject("msm_send_cnt_mon").field("type", "integer").endObject()
                    .startObject("msm_receive_nums_cnt_mon").field("type", "integer").endObject()
                    .startObject("msm_send_nums_cnt_mon").field("type", "integer").endObject()
                    .startObject("silent_days").field("type", "integer").endObject()
                    .startObject("active_time").field("type", "keyword").endObject()
                    .startObject("passive_active_time").field("type", "keyword").endObject()
                    .startObject("imei_now").field("type", "keyword").endObject()
                    .startObject("imeis_2years").field("type", "keyword").endObject()
                    .startObject("imei_cnt_2years").field("type", "integer").endObject()
                    .startObject("imsi_now").field("type", "keyword").endObject()
                    .startObject("terminal_cnt_day").field("type", "integer").endObject()
                    .startObject("terminal_cnt_mon").field("type", "integer").endObject()
                    .startObject("income_total_mon").field("type", "keyword").endObject()
                    .startObject("outcome_total_mon").field("type", "keyword").endObject()
                    .startObject("income_max_mon").field("type", "keyword").endObject()
                    .startObject("income_max_time_mon").field("type", "keyword").endObject()
                    .startObject("outcome_max_mon").field("type", "keyword").endObject()
                    .startObject("outcome_max_time_mon").field("type", "keyword").endObject()
                    .startObject("platform_account_cnt").field("type", "integer").endObject()
                    .startObject("platforms_accounts").field("type", "keyword").endObject()
                    .startObject("bank_income_total_mon").field("type", "keyword").endObject()
                    .startObject("bank_outcome_total_mon").field("type", "keyword").endObject()
                    .startObject("bank_income_max_mon").field("type", "keyword").endObject()
                    .startObject("bank_income_max_time_mon").field("type", "keyword").endObject()
                    .startObject("bank_outcome_max_mon").field("type", "keyword").endObject()
                    .startObject("bank_outcome_max_time_mon").field("type", "keyword").endObject()
                    .startObject("bank_card_cnt").field("type", "integer").endObject()
                    .startObject("bank_cards").field("type", "keyword").endObject()
                    .startObject("alipay_income_total_mon").field("type", "keyword").endObject()
                    .startObject("alipay_outcome_total_mon").field("type", "keyword").endObject()
                    .startObject("alipay_income_max_mon").field("type", "keyword").endObject()
                    .startObject("alipay_income_max_time_mon").field("type", "keyword").endObject()
                    .startObject("alipay_outcome_max_mon").field("type", "keyword").endObject()
                    .startObject("alipay_outcome_max_time_mon").field("type", "keyword").endObject()
                    .startObject("alipay_num_cnt").field("type", "integer").endObject()
                    .startObject("alipay_nums").field("type", "keyword").endObject()
                    .startObject("wechat_income_total_mon").field("type", "keyword").endObject()
                    .startObject("wechat_outcome_total_mon").field("type", "keyword").endObject()
                    .startObject("wechat_income_max_mon").field("type", "keyword").endObject()
                    .startObject("wechat_income_max_time_mon").field("type", "keyword").endObject()
                    .startObject("wechat_outcome_max_mon").field("type", "keyword").endObject()
                    .startObject("wechat_outcome_max_time_mon").field("type", "keyword").endObject()
                    .startObject("wechat_num_cnt").field("type", "integer").endObject()
                    .startObject("wechats").field("type", "keyword").endObject()
                    .startObject("others_income_total_mon").field("type", "keyword").endObject()
                    .startObject("others_outcome_total_mon").field("type", "keyword").endObject()
                    .startObject("others_income_max_mon").field("type", "keyword").endObject()
                    .startObject("others_income_max_time_mon").field("type", "keyword").endObject()
                    .startObject("others_outcome_max_mon").field("type", "keyword").endObject()
                    .startObject("others_outcome_max_time_mon").field("type", "keyword").endObject()
                    .startObject("others_card_cnt").field("type", "integer").endObject()
                    .startObject("others_cards").field("type", "keyword").endObject()
                    //.startObject("accumulation_fund_outcome_mon").field("type", "keyword").endObject()
                    //.startObject("accumulation_fund_outcome_time").field("type", "keyword").endObject()
                    .startObject("accumulation_fund_account").field("type", "keyword").endObject()
                    .startObject("platform_account_names").field("type", "keyword").endObject()
                    .startObject("involve_overseas_nums").field("type", "keyword").endObject()
                    .startObject("contents_sensitive").field("type", "keyword").endObject()
                    .startObject("apps").field("type", "keyword").endObject()
                    .startObject("apps_sensitive").field("type", "keyword").endObject()
                    .startObject("credit_cards").field("type", "keyword").endObject()
                    .startObject("virtual_accounts").field("type", "keyword").endObject()
                    .startObject("loan_accounts").field("type", "keyword").endObject()
                    .startObject("car_nums").field("type", "keyword").endObject()
                    .startObject("roam_places_2years").field("type", "keyword").endObject()
                    .startObject("roam_num_2years").field("type", "integer").endObject()
                    .startObject("languages").field("type", "keyword").endObject()
                    .startObject("junk_advertising_cnt").field("type", "integer").endObject()
                    //.startObject("msm_express_cnt").field("type", "integer").endObject()
                    //.startObject("msm_hotel_cnt").field("type", "integer").endObject()
                    .startObject("msm_travel_cnt").field("type", "integer").endObject()
                    .startObject("msm_money_cnt").field("type", "integer").endObject()
                    //.startObject("msm_frontier_in_out_cnt").field("type", "integer").endObject()
                    .startObject("msm_consumption_cnt").field("type", "integer").endObject()
                    .startObject("internet_account_cnt").field("type", "integer").endObject()
                    .startObject("interpersonal_communication_cnt").field("type", "integer").endObject()
                    .startObject("traffic_violation_cnt").field("type", "integer").endObject()
                    .startObject("investment_consulting_cnt").field("type", "integer").endObject()
                    .startObject("living_expenses_cnt").field("type", "integer").endObject()
                    .startObject("assets_amount").field("type", "keyword").endObject()
                    .startObject("loan_amount").field("type", "keyword").endObject()
                    .startObject("accumulation_fund_amount").field("type", "keyword").endObject()
                    .startObject("borrowing_consumption_amount").field("type", "keyword").endObject()
                    .startObject("assets_outcome_mon").field("type", "keyword").endObject()
                    .startObject("assets_outcome_avg_mon").field("type", "float").endObject()
                    .startObject("assets_income_mon").field("type", "keyword").endObject()
                    .startObject("assets_income_avg_mon").field("type", "float").endObject()
                    .startObject("assets_bank_amount_cnt").field("type", "integer").endObject()
                    .startObject("assets_virtual_amount_cnt").field("type", "integer").endObject()
                    .startObject("assets_msm_cnt").field("type", "integer").endObject()
                    .startObject("living_areas").field("type",  "text").field("analyzer", "ik_max_word").field("search_analyzer","ik_max_word").endObject()
                    .startObject("work_unit").field("type",  "text").field("analyzer", "ik_max_word").field("search_analyzer","ik_max_word").endObject()
                    .startObject("send_receive_living_cnt").field("type", "integer").endObject()
                    .startObject("send_receive_work_cnt").field("type", "integer").endObject()
                    .startObject("travel_aircraft_cnt").field("type", "integer").endObject()
                    .startObject("travel_railway_cnt").field("type", "integer").endObject()
                    .startObject("travel_province_cnt").field("type", "integer").endObject()
                    .startObject("travel_country_cnt").field("type", "integer").endObject()
                    .startObject("travel_hotel_cnt").field("type", "integer").endObject()
                    .startObject("travel_express_cnt").field("type", "integer").endObject()
                    .startObject("travel_frontier_in_out_cnt").field("type", "integer").endObject()
                    .startObject("roam_places_cnt").field("type", "integer").endObject()

                    .startObject("bank_icon").field("type", "keyword").endObject()
                    .startObject("house_icon").field("type", "keyword").endObject()
                    .startObject("wechat_icon").field("type", "keyword").endObject()
                    .startObject("car_icon").field("type", "keyword").endObject()
                    .startObject("railway_icon").field("type", "keyword").endObject()
                    .startObject("airport_icon").field("type", "keyword").endObject()
                    .startObject("checkin_icon").field("type", "keyword").endObject()
                    .startObject("foreigne_icon").field("type", "keyword").endObject()
                    .startObject("express_icon").field("type", "keyword").endObject()
                    .startObject("alipay_icon").field("type", "keyword").endObject()
                    .endObject()
                    .endObject()
                    .endObject();
            System.out.println("defineTelIndexTypeMapping创建成功");
            PutMappingRequest putMappingRequest = Requests
                    .putMappingRequest(INDEX_TEL).type(TYPE_TEL)
                    .source(mapBuilder);
            client.admin().indices().putMapping(putMappingRequest).actionGet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 定义索引的映射类型   IndexType
    public static void defineMessageIndexTypeMapping() {
        try {
            XContentBuilder mapBuilder = XContentFactory.jsonBuilder();
            mapBuilder.startObject()
                    .startObject(TYPE_MES)
                    .startObject("_all").field("enabled", false).endObject()
                    .startObject("properties")
                    .startObject("id").field("type", "integer").endObject()
                    .startObject("data_cycle").field("type", "keyword").endObject()
                    .startObject("num_message_send").field("type", "keyword").endObject()
                    .startObject("num_message_receive").field("type", "keyword").endObject()
                    .startObject("name_message_send").field("type", "keyword").endObject()
                    .startObject("name_message_receive").field("type", "keyword").endObject()

                    .startObject("type_num_send").field("type", "keyword").endObject()
                    .startObject("type_num_receive").field("type", "keyword").endObject()

                    .startObject("message_time").field("type", "keyword").endObject()
                    .startObject("level0").field("type", "keyword").endObject()
                    .startObject("level1").field("type", "keyword").endObject()
                    .startObject("level2").field("type", "keyword").endObject()
                    .startObject("service_provider_name").field("type", "keyword").endObject()
                    .startObject("account_num").field("type", "keyword").endObject()
                    .startObject("account_name").field("type", "keyword").endObject()
                    .startObject("loan_time").field("type", "keyword").endObject()

                    .startObject("time").field("type", "keyword").endObject()
                    .startObject("balance").field("type", "keyword").endObject()
                    .startObject("amount").field("type", "keyword").endObject()
                    .startObject("counterparty_account_num").field("type", "keyword").endObject()
                    .startObject("counterparty_name").field("type", "keyword").endObject()
                    .startObject("type").field("type", "keyword").endObject()

                    .startObject("loan_amount").field("type", "float").endObject()
                    .startObject("repayment_amount").field("type", "float").endObject()
                    .startObject("loan_remaining_amount").field("type", "float").endObject()
                    .startObject("overdue_reminder_amount").field("type", "float").endObject()
                    .startObject("overdue_remaining_amount").field("type", "float").endObject()
                    .startObject("overdue_reminder_time").field("type", "keyword").endObject()

                    .startObject("housing_payment_time").field("type", "keyword").endObject()
                    .startObject("housing_repayment_amount").field("type", "float").endObject()
                    .startObject("business_name").field("type", "keyword").endObject()
                    .startObject("trade_name").field("type", "keyword").endObject()
                    .startObject("departure_time").field("type", "keyword").endObject()

                    .startObject("train_num").field("type", "keyword").endObject()
                    .startObject("coach_num").field("type", "keyword").endObject()
                    .startObject("seat_num").field("type", "keyword").endObject()
                    .startObject("departure_station").field("type", "keyword").endObject()
                    .startObject("ticket_check_num").field("type", "keyword").endObject()
                    //.startObject("airport_departure_station").field("type", "keyword").endObject()

                    .startObject("destination_station").field("type", "keyword").endObject()
                    .startObject("flight_num").field("type", "keyword").endObject()
                    .startObject("service_place").field("type", "keyword").endObject()
                    .startObject("departure_place").field("type", "keyword").endObject()
                    .startObject("dosage_year").field("type", "keyword").endObject()
                    .startObject("consumption").field("type", "keyword").endObject()
                    .startObject("current_reading").field("type", "keyword").endObject()
                    .startObject("plate_num").field("type", "keyword").endObject()

                    .startObject("details").field("type", "text").field("analyzer", "ik_max_word").field("search_analyzer","ik_max_word").endObject()
                    .startObject("deduction").field("type", "keyword").endObject()
                    .startObject("tips").field("type", "keyword").endObject()
                    .startObject("package_pickup_way").field("type", "keyword").endObject()
                    .startObject("package_pickup_place").field("type", "text").field("analyzer", "ik_max_word").field("search_analyzer","ik_max_word").endObject()
                    .startObject("service_code").field("type", "keyword").endObject()
                    .startObject("order_num").field("type", "keyword").endObject()
                    .startObject("goods_num").field("type", "keyword").endObject()
                    .startObject("shopping_website").field("type", "keyword").endObject()
                    .startObject("courier_phone_num").field("type", "keyword").endObject()

                    .startObject("courier_name").field("type", "keyword").endObject()
                    .startObject("goods_delivery_way").field("type", "keyword").endObject()
                    .startObject("goods_delivery_place").field("type", "text").field("analyzer", "ik_max_word").field("search_analyzer","ik_max_word").endObject()
                    .startObject("hotel_phone").field("type", "keyword").endObject()
                    .startObject("destination_time").field("type", "keyword").endObject()
                    .startObject("order_way").field("type", "keyword").endObject()

                    .startObject("occupants").field("type", "keyword").endObject()
                    .startObject("room_num").field("type", "keyword").endObject()
                    .startObject("stay_days").field("type", "integer").endObject()
                    .startObject("hospital_name").field("type", "keyword").endObject()
                    .startObject("patient").field("type", "keyword").endObject()
                    .startObject("department").field("type", "keyword").endObject()
                    .startObject("text").field("type", "text").field("analyzer", "ik_max_word").field("search_analyzer","ik_max_word").endObject()
                    .startObject("translated_text").field("type", "text").field("analyzer", "ik_max_word").field("search_analyzer","ik_max_word").endObject()
                    .startObject("lmessage_anguage_type").field("type", "keyword").endObject()
                    .startObject("others").field("type", "keyword").endObject()
                    .endObject()
                    .endObject()
                    .endObject();
            System.out.println("defineMessageIndexTypeMapping创建成功");

            try {
                List<String> list;
                String[] indexNames;
                //list= DateUtil.getMonthBetweenByStr("2017-02-05", "2018-02-05");
//                list = DateAndTimeUtil1.getMonthBetween("2019-02-05", "2020-12-31");
                list = Arrays.asList("2015-02-05");

                indexNames = list.toArray(new String[list.size()]);
                for (int i = 0; i < list.size(); i++) {
                    indexNames[i] = INDEX_MES_PRE + list.get(i);

                    System.out.println(indexNames[i] );
                    PutMappingRequest putMappingRequest = Requests
                            .putMappingRequest(indexNames[i]).type(TYPE_MES)
                            .source(mapBuilder);
                    client.admin().indices().putMapping(putMappingRequest).actionGet();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTelDocumentByMap() {

        int max = 11, min = 1;
        int ran2 = (int) (Math.random() * (max - min) + min);
        System.out.println(ran2);

        String[] tags = {"发西藏方向短信", "漫游美国", "漫游朝鲜", "沉默用户", "当天主动活跃", "当月主动活跃", "收美国方向短信", "发韩国方向短信", "收台湾方向短信", "发台湾方向短信", "收印度方向短信"};

        for (int i = 0; i <= 1000; i++) {
            Map<String, Object> json = new HashMap<String, Object>();

            json.put("id", i + 1);
            json.put("data_cycle", "111111");//数据周期
            json.put("phone_num", "13554359866");//手机号码
            json.put("telecom_operators", "1");//运营商
            json.put("living_accounts","跑步;运动;看书;跳舞;书法;主持人");//生活账户串
            json.put("phone_brand","华为");//手机品牌
            json.put("location", "001000010");//归属地
            json.put("certificate_num", "42070419850933");//开户证件
            json.put("certificate_type", "身份证");//证件类型
            json.put("nationality", "中国 ");//国籍
            json.put("name", "张珊珊.尼古拉斯");//姓名
            json.put("register_time", "2015-09-22");//开户日期
            json.put("status", 1);//号码状态
            json.put("isOnline", "1");//在网

            json.put("tags", "t002,t006,t008,t009,t012,t016,t020,t025,t031,t032,t033");//标签
            json.put("roamingPlace","云南保山,江苏无锡,湖北武汉,湖北鄂州");//漫游地

            json.put("contacts_cnt", 123456);//联系人数量
            json.put("msm_recipient_cnt", 123);//收短信人数
            json.put("msm_sender_cnt", 456);//发短信人数
            json.put("msm_receive_cnt_mon", 567356);//当月收短信数
            json.put("msm_send_cnt_mon", 789);//当月发短信数
            json.put("msm_receive_nums_cnt_mon", 678);//当月收人际短信数
            json.put("msm_send_nums_cnt_mon", 890);//当月发人际短信数
            json.put("silent_days", 901);//沉默天数

            json.put("active_time", "2020-12-12");//最新主动活跃日期
            json.put("passive_active_time", "2020-12-23");//最新被动活跃日期
            json.put("imei_now", "864051042577948 ");//当前IMEI号
            json.put("imeis_2years", "864051042577948,864051042678266,864051042890812");//两年内IMEI号串
            json.put("imei_cnt_2years", 3);//两年内IMEI个数
            json.put("imsi_now", "wewewe-rrrr");//当前IMSI号
            json.put("terminal_cnt_day", 15);//当天终端个数
            json.put("terminal_cnt_mon", 80);//当月终端个数

            json.put("income_total_mon", 801390.66);//月-收入
            json.put("outcome_total_mon ", 28698.10);//月-支出
            json.put("income_max_mon", 201390.66);//月-收入最大金额
            json.put("outcome_max_mon", 25698.10);//月-支出最大金额
            json.put("income_max_time_mon", 2020-10-06);//月-收入最大金额时间
            json.put("outcome_max_time_mon", 2020-9-26);//月-支出最大金额时间
            json.put("platform_account_cnt", 16);//平台及账号数量
            json.put("platforms_accounts", "支付宝：zhifubao,微信：weixin,淘宝：taobao");//平台及账号串

            json.put("bank_income_total_mon", 223);//银行卡-月-收入
            json.put("bank_outcome_total_mon", 2256);//银行卡-月-支出
            json.put("bank_income_max_mon", 56778);//银行卡-月-收入最大金额
            json.put("bank_income_max_time_mon", 2020-8-10);//银行卡-月-收入最大金额时间
            json.put("bank_outcome_max_mon", 2090);//银行卡-月-支出最大金额
            json.put("bank_outcome_max_time_mon", 2020-10-8);//银行卡-月-支出最大金额时间
            json.put("bank_card_cnt", 6);//银行卡-数量
            json.put("bank_cards", "61235534343434,61223456789012,65889112367890,62235612367890");//银行卡-串号

            json.put("alipay_income_total_mon", 335);//支付宝-月-收入
            json.put("alipay_outcome_total_mon", 668);//支付宝-月-支出
            json.put("alipay_income_max_mon", 8897);//支付宝-月-收入最大金额
            json.put("alipay_income_max_time_mon", 2020-8-19);//支付宝-月-收入最大金额时间
            json.put("alipay_outcome_max_mon", 2909);//支付宝-月-支出最大金额
            json.put("alipay_outcome_max_time_mon", 2020-9-22);//支付宝-月-支出最大金额时间
            json.put("alipay_num_cnt", 3);//支付宝-数量
            json.put("alipay_nums", "13566601231,13800298810");//支付宝-串号

            json.put("wechat_income_total_mon", 5312);//微信-月-收入
            json.put("wechat_outcome_total_mon", 657);//微信-月-支出
            json.put("wechat_income_max_mon", 9810);//微信-月-收入最大金额
            json.put("wechat_income_max_time_mon", 2020-10-28);//微信-月-收入最大金额时间
            json.put("wechat_outcome_max_mon", 223);//微信-月-支出最大金额
            json.put("wechat_outcome_max_time_mon", 2020-10-25);//微信-月-支出最大金额时间
            json.put("wechat_num_cnt", 6);//微信-数量
            json.put("wechats", "wxtest1,wxtest2,wxtest3");//微信-串号

            json.put("others_income_total_mon", 8736);//其他类-月-收入
            json.put("others_outcome_total_mon", 345);//其他类-月-支出
            json.put("others_income_max_mon", 6785);//其他类-月-收入最大金额
            json.put("others_income_max_time_mon", 2020-10-31);//其他类-月-收入最大金额时间
            json.put("others_outcome_max_mon", 7865);//其他类-月-支出最大金额
            json.put("others_outcome_max_time_mon", 3321);//其他类-月-支出最大金额时间
            json.put("others_card_cnt", 10);//其他类-数量
            json.put("others_cards", "jdtest1,wphtest2,tbtest3,wytest4");//其他类-串号

            //json.put("accumulation_fund_outcome_mon", "2018.3");//支出
            //json.put("accumulation_fund_outcome_time", "2020-10-13");//支出时间
            json.put("accumulation_fund_account", "12229000966");//公积金账号
            json.put("platform_account_names", "gaode1,eleme2,12306");//非资金平台及账号名称串
            json.put("involve_overseas_nums", "111-中国,123-美国,134-英国");//涉外号码串及国家
            json.put("contents_sensitive", "中国地震台网;地震;抚恤金;跨国物流;基督教;酒店住宿;跨国航班;百世快递;铁路客服;长途运输;中国;星巴克;频繁换手机;伊斯兰教;抚恤金;跨国物流;基督教;酒店住宿;跨国航班;长途运输;频繁换手机;伊斯兰教;抚恤金;跨国物流;基督教;酒店住宿;跨国航班;长途运输;频繁换手机;伊斯兰教;抚恤金;跨国物流;基督教;酒店住宿;跨国航班;长途运输;频繁换手机");//敏感内容串
            json.put("apps", "高得地图;滴滴出行;铁路12306;10000社区;盒马;美团;饿了么;支付宝;微信;网易;招商银行;网易;携程网;百世快递;");//APP串
            json.put("apps_sensitive", "涉恐APP;涉维APP;海外信息APP;涉密APP;涉稳APP;涉及宗教APP;邮储;燃气;公积金;高铁;自助机;");//敏感APP串
            json.put("credit_cards", "31235534343434,31223456789012,35889112367890,36889112366780");//信用卡号串
            json.put("virtual_accounts", "virtual_account223456789012hhhhhhhhhhhhhhhhhhhhhhhhhhhh2");//虚拟账号
            json.put("loan_accounts", "loan_accounts111loan_accounts111loan_accounts111loan_accounts111loan_accounts111");//贷款账号
            json.put("car_nums", "鄂A8tU02");//车牌号
            json.put("languages", "英语,汉语,韩语,俄语,德语,法语,西班牙语,阿拉伯语,马来语,土耳其语");//语种串

            json.put("roam_places_2years", "0102,0106,0116,0205,0301,0302,0405,0407,0513,0601,0708,0712,0812,1406,1506,1514,1516,1601,1801,1814");//两年内漫游地
            json.put("roam_num_2years", 63);//两年内漫游次数

            json.put("junk_advertising_cnt", 20008);//垃圾广告短信数量
            //json.put("msm_express_cnt", 2863);//快递短信数量
            //json.put("msm_hotel_cnt", 10009);//酒店短信数量
            json.put("msm_travel_cnt", 20008);//出行短信数量
            json.put("msm_money_cnt", 666);//资金短信数量
            //json.put("msm_frontier_in_out_cnt", 235);//出入境数量
            json.put("msm_consumption_cnt", 200018);//消费短信数量
            json.put("internet_account_cnt", 300019);//网络账号类短信数量
            json.put("interpersonal_communication_cnt", 60066);//人际交往类短信数量
            json.put("traffic_violation_cnt", 2009);//违章类短信数量
            json.put("investment_consulting_cnt", 1009);//投资咨询类数量
            json.put("living_expenses_cnt", 3009);//生活缴费类短信数量
            json.put("assets_amount", 999999.11);//资产金额
            json.put("loan_amount", 88888.99);//总贷金额
            json.put("accumulation_fund_amount", 290080.01);//公积金贷款金额
            json.put("borrowing_consumption_amount", 220091.83);//借贷消费金额

            json.put("assets_outcome_mon", 11088.23);//资产类-当月支出
            json.put("assets_outcome_avg_mon", 8901.06);//资产类-月均支出
            json.put("assets_income_mon", 21982.12);//资产类-当月收入
            json.put("assets_income_avg_mon", 23982.76);//资产类-月均收入
            json.put("assets_bank_amount_cnt", 8);//资产类-银行卡个数
            json.put("assets_virtual_amount_cnt", 5);//资产类-虚拟账户个数
            json.put("assets_msm_cnt", 20089);//资产类-涉及短信条数

            json.put("living_areas", "”武汉藏龙岛阳光100");//出行轨迹-居住小区
            json.put("work_unit", "关谷软件园");//出行轨迹-工作单位
            json.put("send_receive_living_cnt", 233);//出行轨迹-单位收发次数
            json.put("send_receive_work_cnt", 2031);//出行轨迹-小区收发次数
            json.put("travel_aircraft_cnt", 39);//出行轨迹-机票出行次数
            json.put("travel_railway_cnt", 52);//出行轨迹-高铁出行次数
            json.put("travel_province_cnt", 31);//出行轨迹-省内出行次数
            json.put("travel_country_cnt", 16);//出行轨迹-酒店住宿次数
            json.put("travel_hotel_cnt", 6);//出行轨迹-国内出行次数
            json.put("travel_express_cnt", 2863);//快递短信数量
            json.put("travel_frontier_in_out_cnt", 235);//出入境数量
            json.put("roam_places_cnt", 50);//出行轨迹-漫游地市数量

            json.put("bank_icon","1");//银行卡标签
            json.put("house_icon","1");//有房标签
            json.put("car_icon","1");//有车标签
            json.put("wechat_icon","1");//支付宝标签
            json.put("alipay_icon","1");//微信标签
            json.put("railway_icon","1");//铁路标签
            json.put("airport_icon","1");//航班标签
            json.put("checkin_icon","1");//住宿标签
            json.put("foreigne_icon","1");//涉外标签
            json.put("express_icon","1");//快递标签



//        IndexRequestBuilder ib= client.prepareIndex(IndexName, TypeName,"1");
//        System.out.println(ib);

            //this.transportClient.prepareIndex 可以传入id
            final IndexResponse response = client.prepareIndex(INDEX_TEL, TYPE_TEL, String.valueOf(i))
                    .setSource(json).get();

            //获取索引
            final String _index = response.getIndex();
            //获取类型
            final String _type = response.getType();
            // 文档ID
            String _id = response.getId();
            // 版本
            long _version = response.getVersion();
            // 返回的操作状态
            RestStatus status = response.status();
            System.out.println("索引名称:" + _index + " " + "类型 :" + _type + " 文档ID：" + _id + " 版本 ：" + _version + " 返回的操作状态：" + status);
        }
    }

    public static void createDocumentByMap() {
        int max = 11, min = 1;
        int ran2 = (int) (Math.random() * (max - min) + min);
        System.out.println(ran2);

        String[] tags = {"喜欢赌博", "喜欢游戏", "购物", "运动", "打架", "吃东西", "家暴", "名车", "美女", "不喜欢说话", "沟通不行"};

        for (int i = 0; i <= 10; i++) {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("id", i + 1);
            json.put("tags", tags[ran2]);
            json.put("actionZone", "中华人民共和国湖北武汉江夏区藏龙岛阳光100大户第");
            json.put("age", 20 + i);
            json.put("income", 20 * i);
            json.put("name", "张山");
            json.put("birthday", "20080102");
            json.put("gender", "男");
            json.put("language", "***汉语");
            json.put("idCard", "42019850211");
            json.put("address", "武汉光谷");
            json.put("telNo", "13554358765");

//        IndexRequestBuilder ib= client.prepareIndex(IndexName, TypeName,"1");
//        System.out.println(ib);

            //this.transportClient.prepareIndex 可以传入id
            final IndexResponse response = client.prepareIndex(IndexName, TypeName, String.valueOf(i))
                    .setSource(json).get();

            //获取索引
            final String _index = response.getIndex();
            //获取类型
            final String _type = response.getType();
            // 文档ID
            String _id = response.getId();
            // 版本
            long _version = response.getVersion();
            // 返回的操作状态
            RestStatus status = response.status();
            System.out.println("索引名称:" + _index + " " + "类型 :" + _type + " 文档ID：" + _id + " 版本 ：" + _version + " 返回的操作状态：" + status);

        }
    }



    public static void createMessageDocumentByMap() {

        int max = 11, min = 1;
        int ran2 = (int) (Math.random() * (max - min) + min);
        System.out.println(ran2);

        String[] tags = {"tag00010", "tag00011", "tag000129", "tag00013", "tag00014", "tag00015", "tag00016", "tag00017", "tag00018", "tag00019", "tag00020"};

        try{
            List<String> list;
            String[] indexNames;
            //list= DateUtil.getMonthBetweenByStr("2017-02-05", "2018-02-05");

//            list = DateAndTimeUtil1.getMonthBetween("2019-12-05", "2020-12-31");
            list = Arrays.asList("2015-02-05");

            indexNames = list.toArray(new String[list.size()]);

            int id =110;
            for (int j = 0; j < list.size(); j++) {
                indexNames[j] = INDEX_MES_PRE + list.get(j);

                for (int i = 0; i <= 1000; i++) {
                    id++;
                    Map<String, Object> json = new HashMap<String, Object>();

                    json.put("id", id);
                    json.put("data_cycle", "月");
                    json.put("num_message_send", "13554359877");//发送号码
                    json.put("num_message_receive", "13554359866");//接收号码
                    json.put("name_message_send", "张一");//发信人姓名
                    json.put("name_message_receive", "张珊珊.尼古拉斯");//收信人姓名
                    json.put("level0", "12");//一级分类
                    json.put("level1", "11001");//二级分类
                    json.put("level2", "");//三级分类
                    json.put("service_provider_name", "中国人民银行");
                    json.put("account_num", "32232455556666");
                    json.put("account_name", "account_name");

                    json.put("type_num_send", "0");//发件类型---0非个人，1是个人
                    json.put("type_num_receive", "1");//收件类型---0非个人，1是个人
                    json.put("message_time", "20201018131952");

                    json.put("loan_time", "2020-08-13 15:33:16");//放贷时间
                    json.put("time", "2020-09-16 17:13:29");//交易时间/还款时间/消费时间/违章时间/就医时间
                    json.put("balance", "11");//余额
                    json.put("amount", "11");//动账金额/燃气金额/用电金额/用水金额/房间金额/消费金额
                    json.put("counterparty_account_num", "3");//对方账户
                    json.put("counterparty_name", "张山");//对方账户
                    json.put("type", "收支类型/汽车种类/快递类型/房间类型/挂号方式");//收支类型/汽车种类/快递类型/房间类型/挂号方式
                    json.put("loan_amount", 21);//贷款金额
                    json.put("repayment_amount", 111111);//还款金额
                    json.put("loan_remaining_amount", "5567");//还款剩余金额
                    json.put("overdue_reminder_amount", "33");//逾期提醒金额
                    json.put("overdue_remaining_amount", "223");//逾期提醒剩余金额
                    json.put("overdue_reminder_time", "2020-9-21");//逾期提醒时间
                    json.put("housing_payment_time", "2020-2-25");//公积金缴纳时间
                    json.put("housing_repayment_amount", "335");//公积金缴纳金额
                    json.put("overdue_reminder", "逾期提醒");
                    json.put("business_name", "消费商家名/商户名（购物平台店铺）");//消费商家名/商户名（购物平台店铺）
                    json.put("trade_name", "商品名");
                    json.put("departure_time", "发车时间/起飞时间/打车-预约时间/酒店入住结束时间");
                    json.put("train_num", "车次");
                    json.put("coach_num", "车厢号");
                    json.put("seat_num", "座位号");
                    json.put("departure_station", "出发站");//出发站/起飞机场
                    json.put("ticket_check_num", "检票口");
                    //json.put("airport_departure_station", "起飞机场");//冗余
                    json.put("destination_station", "目的地");
                    json.put("flight_num", "航班号");
                    json.put("service_place", "违章地点");
                    //json.put("departure_place", "出发地");
                    json.put("dosage_year", "年用量");
                    json.put("consumption", "本期用量");
                    json.put("current_reading", "本期表数");
                    json.put("plate_num", "车牌号");
                    json.put("details", "违章详情/借贷-消费事项");
                    json.put("deduction", "扣分");
                    json.put("tips", "违章-提示");
                    json.put("package_pickup_way", "取货方式");
                    json.put("package_pickup_place", "取货地点");
                    json.put("package_pickup_code", "取件码");
                    json.put("order_num", "运单号/酒店订单号");
                    json.put("goods_num", "商品订单号");
                    json.put("shopping_website", "购物网站名");
                    json.put("courier_phone_num", "快递员号码");
                    json.put("courier_name", "快递员姓名");
                    json.put("goods_delivery_way", "发货方式");
                    json.put("goods_delivery_place", "发货地点");
                    json.put("hotel_phone", "酒店电话");
                    json.put("destination_time", "2020-10-16 17:10:23");
                    json.put("order_way", "酒店预定方式、挂号方式");
                    json.put("occupants", "入住人");
                    json.put("room_num", "房间号");
                    json.put("stay_days", 3);
                    json.put("hospital_name", "医院名称");
                    json.put("patient", "病人");
                    json.put("department", "就诊科室");
                    json.put("text", "【韵达快递】亲，您的运单3833212428081已为您放在桃园镇韵达快递，汇金街南门向东100米（桃园老菜市场东），当天不取件为你代䔑签收，有问题请联系快递员陈会洋，手机号：13852051016");
                    json.put("translated_text", "【韵达快递】hello，您的运单3833212428081已为您放在桃园镇韵达快递，汇金街南门向东100米（桃园老菜市场东），当天不取件为你代䔑签收，有问题请联系快递员陈会洋，手机号：13852051016!!!");
                    json.put("lmessage_anguage_type", "中文");
                    json.put("others", "其它");


                    //this.transportClient.prepareIndex 可以传入id
                    final IndexResponse response = client.prepareIndex(indexNames[j], TYPE_MES, String.valueOf(id))
                            .setSource(json).get();

                    //获取索引
                    final String _index = response.getIndex();
                    //获取类型
                    final String _type = response.getType();
                    // 文档ID
                    String _id = response.getId();
                    // 版本
                    long _version = response.getVersion();
                    // 返回的操作状态
                    RestStatus status = response.status();
                    System.out.println("索引名称:" + _index + " " + "类型 :" + _type + " 文档ID：" + _id + " 版本 ：" + _version + " 返回的操作状态：" + status);
                }
            }
        }catch(Exception e){e.printStackTrace();}
    }
}
