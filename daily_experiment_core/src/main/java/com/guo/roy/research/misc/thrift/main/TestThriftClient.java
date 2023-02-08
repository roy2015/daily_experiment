package com.guo.roy.research.misc.thrift.main;

import com.guo.roy.research.misc.thrift.dto.ResultInt;
import com.guo.roy.research.misc.thrift.dto.ResultStr;
import com.guo.roy.research.misc.thrift.service.TestThriftService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.layered.TFramedTransport;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author guojun
 * @date 2022/9/19 18:24
 */
@Slf4j
public class TestThriftClient {


    private static final String THRIFT_HOST = "localhost";
    private static final int THRIFT_PORT = 12356;


    public  void process() {

        try {
            TSocket m_transport = new TSocket(THRIFT_HOST, THRIFT_PORT, 2000);
            TFramedTransport tFramedTransport = new TFramedTransport(m_transport);
            TProtocol protocol = new TBinaryProtocol(tFramedTransport);
            TestThriftService.Client testClient = new TestThriftService.Client(protocol);
            m_transport.open();

            ResultStr str = testClient.getStr("test1", "test2");
            ResultInt anInt = testClient.getInt(1);

            log.debug("res: {}", str.getValue());
            log.debug("anInt: {}", anInt.getValue());

            TimeUnit.SECONDS.sleep(3);
            m_transport.close();
            log.debug("m_transport.close()");
        } catch (Exception e){
            // TODO Auto-generated catch block
            log.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> new TestThriftClient().process());
        }

    }
}
