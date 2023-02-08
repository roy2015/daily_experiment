package com.roy.research.io;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.roy.research.targetObject.UserVO;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

/**
 * Created by apple on 2019/10/16.
 *
 * Hessian序列化协议
 *
 *
 */
public class TestHessianSerialize  {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestHessianSerialize.class);

    static class TestHessianSerializeUtil<T extends Serializable> {
        public byte[] doSerialize (T obj) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                HessianOutput hessianOutput = new HessianOutput(byteArrayOutputStream);
                hessianOutput.writeObject(obj);
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            return null;
        }

        public T doDeserialization (byte[] bytes) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                HessianInput hessianInput = new HessianInput(byteArrayInputStream);
                return (T) hessianInput.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


    }

    public static void main(String[] args) {
        TestHessianSerializeUtil<UserVO> hessianSerializeUtil = new TestHessianSerializeUtil<>();
        byte[] bytes = hessianSerializeUtil.doSerialize(new UserVO(1, "guo", "male"));
        logger.info("{}",bytes);
        logger.info(Base64.encodeBase64String(bytes));
        UserVO userVO = hessianSerializeUtil.doDeserialization(bytes);
        logger.info("{}", userVO);

    }


}
