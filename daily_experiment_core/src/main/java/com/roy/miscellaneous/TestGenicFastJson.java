package com.roy.miscellaneous;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.roy.miscellaneous.targetObject.*;
import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/5/26.
 *
 *
 * 测试fastjson对泛型对象的支持
 * 总结：TypeRefeence实际上是个抽象类（构造方式是protected）,因为获取泛型的T需要有父类，所有用的时候要
 * 弄个匿名实现，参考TypeReference
 *
 */
public class TestGenicFastJson {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestGenicFastJson.class);


    public void testGenicFastJson () {
        PCNotiWebsocketMsg<UserVO> websocketMsg = new PCNotiWebsocketMsg<>();
        UserVO userVO = new UserVO();
        userVO.setUserId(123);
        userVO.setUserSex("nan");
        userVO.setUserName("roy");
        websocketMsg.setData(userVO);
        websocketMsg.setMessageCategory("123");
        websocketMsg.setMessageLevel("1");
        logger.debug(JSON.toJSONString(websocketMsg));
    }

    public void testGenicFastJsonStrToObj() {
        String str = "{\"data\":{\"userId\":123,\"userName\":\"roy\",\"userSex\":\"nan\"},\"messageCategory\":\"123\",\"messageLevel\":\"1\"}";
        PCNotiWebsocketMsg obj = JSON.parseObject(str, new TypeReference<PCNotiWebsocketMsg<UserVO>>(){});
        logger.debug(obj.toString());

    }

    public static void testGenicFastJsonStr () {

        UserVO userVO = new UserVO();
        userVO.setUserId(123);
        userVO.setUserSex("nan");
        userVO.setUserName("roy");



        User1VO user1VO = new User1VO();
        User2VO user2VO = new User2VO();
        BeanUtil.copyProperties(userVO, user1VO);
        BeanUtil.copyProperties(userVO, user2VO);
        user1VO.setUserId(1231);
        user2VO.setUserId(1232);

        PCNotiWebsocketMsgCopy<UserVO, User1VO, User2VO> websocketMsg = new PCNotiWebsocketMsgCopy<>();
        websocketMsg.setData(userVO);
        websocketMsg.setData1(user1VO);
        websocketMsg.setData2(user2VO);
        websocketMsg.setMessageCategory("123");
        websocketMsg.setMessageLevel("1");

        logger.debug(JSON.toJSONString(websocketMsg, true));
    }

    public static void testGenicFastJsonStrToObj1() {
        String str = "{\n" +
                "\t\"data\":{\n" +
                "\t\t\"userId\":123,\n" +
                "\t\t\"userName\":\"roy\",\n" +
                "\t\t\"userSex\":\"nan\"\n" +
                "\t},\n" +
                "\t\"data1\":{\n" +
                "\t\t\"userId\":1231,\n" +
                "\t\t\"userName\":\"roy\",\n" +
                "\t\t\"userSex\":\"nan\"\n" +
                "\t},\n" +
                "\t\"data2\":{\n" +
                "\t\t\"userId\":1232,\n" +
                "\t\t\"userName\":\"roy\",\n" +
                "\t\t\"userSex\":\"nan\"\n" +
                "\t},\n" +
                "\t\"messageCategory\":\"123\",\n" +
                "\t\"messageLevel\":\"1\"\n" +
                "}";
        PCNotiWebsocketMsgCopy<UserVO, User1VO, User2VO> obj = JSON.parseObject(str, new TypeReference<PCNotiWebsocketMsgCopy<UserVO, User1VO, User2VO>>(UserVO.class, User1VO.class, User2VO.class) {
        });
        logger.debug(obj.toString());

    }

    public static void main(String[] args) {
        testGenicFastJsonStrToObj1();
    }
}
