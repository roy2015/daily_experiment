package com.roy.mix.experiment.proto;

import com.google.protobuf.InvalidProtocolBufferException;
import com.roy.example.proto.dto.StudentProto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/6/11
 */
@Slf4j
public class TestProto {


    static class Solution {
        public  void main()  {
            StudentProto.Student student = StudentProto.Student.newBuilder()
                    .setSid(123)
                    .setSName("roy")
                    .setSex(true)
                    .setAge(33)
                    .build();
            byte[] bytes = student.toByteArray();
            log.info("{}", bytes);

            try {
                student = StudentProto.Student.parseFrom(bytes);
                log.info("{}", student);
            } catch (InvalidProtocolBufferException e) {
                log.error(e.getMessage(), e);
            }

        }

    }

    public static void main(String[] args)  {
        new Solution().main();
    }
}
