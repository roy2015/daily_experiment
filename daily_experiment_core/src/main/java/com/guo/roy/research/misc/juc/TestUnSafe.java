package com.guo.roy.research.misc.juc;

import com.guo.roy.research.misc.targetObject.UserVO;
import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

/**
 * Created by apple on 2019/4/8.
 */
public class TestUnSafe {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestUnSafe.class);
    private static final Unsafe unsafe ;

    static {
        try {
            //获取unSafe
            unsafe = AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>) () -> {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                return (Unsafe) theUnsafe.get(null);
            });
        }
        catch (Exception e){
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }

    /**
     * 直接操作内存地址
     * @throws Exception
     */
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
