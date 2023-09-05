package com.guo.roy.research.misc.jdk;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author guojun
 * @date 2023/9/3 09:55
 *
 * 获取泛型里的T
 *
 * 自己写一个TypeReference实现
 */
@Slf4j
public class TestParameterizedType {

    public TestParameterizedType() {
    }

    @Data
    @Accessors(chain = true)
    public static class UserVo<T>  {
        private String userId;
        private String name;
        private String friendlyName;
        private List<T> addressVoList;
    }

    @Data
    @Accessors(chain = true)
    static class AddressVo{
        private String province;
        private String city;
        private String street;
    }

    @Data
     abstract class TypeRefernce<T>{
        public ParameterizedType _genericSuperclass;
        protected final Type _type;

        public List<Type> _allTypes;

        protected TypeRefernce()   {
            Type superClass = getClass().getGenericSuperclass();
            if (superClass instanceof Class<?>) { // sanity check, should never happen
                throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
            }
            _type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
            _genericSuperclass =  ((ParameterizedType) superClass);
            _allTypes = new ArrayList<>();
        }

        public void buildAllGenericTypes(Type[] types) {
            for (Type type : types) {
                ParameterizedType result = null;
                if (type instanceof ParameterizedType) {
                    _allTypes.add(type);
                    buildAllGenericTypes(((ParameterizedType)type).getActualTypeArguments());
                } else if (type instanceof Class) {
                    _allTypes.add(type);
                    return;
                }
            }
        }

        public  List<Type>  getAllParameterizedTypes() {
            buildAllGenericTypes(_genericSuperclass.getActualTypeArguments());
            return _allTypes;
        }

    }



    public  void testGeneric() {
        TypeRefernce<UserVo<AddressVo>> typeRefernce = new TypeRefernce<UserVo<AddressVo>>() {
        };
        for (Type allType : typeRefernce.getAllParameterizedTypes()) {
            log.info("{}", allType);
        }
    }


    public static void main(String[] args) {
        new TestParameterizedType().testGeneric();;
    }
}
