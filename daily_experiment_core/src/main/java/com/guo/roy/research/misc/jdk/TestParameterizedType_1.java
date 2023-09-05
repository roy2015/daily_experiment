package com.guo.roy.research.misc.jdk;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author guojun
 * @date 2023/9/3 09:55
 * 获取泛型里的T
 *
 *
 * 需要有一个抽象类
 */
@Slf4j
public class TestParameterizedType_1 {


    @Data
    @Accessors(chain = true)
    public abstract class UserVo<T>  {
        private String userId;
        private String name;
        private String friendlyName;
        private List<T> addressVoList;

        protected UserVo () {
            Type genericSuperclass = this.getClass().getGenericSuperclass();
            Type[] _type = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            log.info("type: {}" , _type);
        }
    }

    @Data
    @Accessors(chain = true)
    static class AddressVo{
        private String province;
        private String city;
        private String street;
    }


    public  void testGeneric() {
        UserVo<AddressVo> userVo = new UserVo<AddressVo>() {
        };

    }


    public static void main(String[] args) {
        new TestParameterizedType_1().testGeneric();;
    }
}
