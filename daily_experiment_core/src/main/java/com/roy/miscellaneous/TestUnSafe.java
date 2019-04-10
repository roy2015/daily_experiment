package com.roy.miscellaneous;

import com.roy.miscellaneous.targetObject.UserVO;
import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by apple on 2019/4/8.
 */
public class TestUnSafe {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestUnSafe.class);
    private static Unsafe unsafe = null;

    static {
        try {
            Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            unsafe = (Unsafe) theUnsafeField.get(null);
        } catch (NoSuchFieldException e) {
            logger.error(e.getMessage(),e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(),e);
        }
    }

    public void testUnsafe() throws Exception {
        long userNameOffset = unsafe.objectFieldOffset(UserVO.class.getDeclaredField("userName"));
        UserVO userVO = new UserVO();
        userVO.setUserId(1);
        userVO.setUserName("guo1");
        userVO.setUserSex("m");
        logger.debug(userVO.toString());
        logger.debug("{},偏移量 {}" ,"username", userNameOffset);
        unsafe.getAndSetObject(userVO, userNameOffset, "guo2");
//        unsafe.compareAndSwapInt()
        logger.debug(userVO.toString());

    }

    
}
