package com.roy.miscellaneous.interview;

import com.roy.miscellaneous.targetObject.UserVO;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by apple on 2019/9/11.
 */
public class TestObjectSerializeFile {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestObjectSerializeFile.class);

    static class ObjectSerializeUtil {
        public boolean writeObjecctToFile () {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                        new FileOutputStream(new File("/Users/apple/guojun/testObjectSerialize.txt"))
                );
                objectOutputStream.writeObject(new UserVO(1,"guo",  "male"));
                return true;
            } catch (IOException e) {
                logger.info(e.getMessage(), e);
                return false;
            }
        }

        public boolean readObjectFromFIle() {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("/Users/apple/guojun/testObjectSerialize.txt")));
                UserVO userVO = (UserVO) objectInputStream.readObject();
                logger.info("{}", userVO);
                return true;
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            } catch (ClassNotFoundException e) {
                logger.error(e.getMessage(), e);
            }
            return false;

        }


    }

    public static void testWriteObjecctToFile() {
        boolean serialToFile = new ObjectSerializeUtil().writeObjecctToFile();
        logger.info("{}", serialToFile);
    }

    public static void testReadObjectFromFIle() {
        boolean serialToFile = new ObjectSerializeUtil().readObjectFromFIle();
        logger.info("{}", serialToFile);
    }


}
