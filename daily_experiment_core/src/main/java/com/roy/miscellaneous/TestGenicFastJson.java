package com.roy.miscellaneous;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.roy.miscellaneous.targetObject.PCNotiWebsocketMsg;
import com.roy.miscellaneous.targetObject.UserVO;
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
}
