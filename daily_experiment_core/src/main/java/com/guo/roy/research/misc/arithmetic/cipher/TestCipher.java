package com.guo.roy.research.misc.arithmetic.cipher;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLServerSocketFactory;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.*;

/**
 * Created by apple on 2019/9/26.
 *
 * Cipher的工具类， 列举providers的所以service
 */
public class TestCipher {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestDES3.class);

    public void listSupportedCiphers() {
        Provider[] providers = Security.getProviders();
        TreeSet<Service> serviceTreeSet = new TreeSet<Service>( new Comparator<Service>() {

            @Override
            public int compare(Service o1, Service o2) {
                StringBuffer sb1 = new StringBuffer();
                StringBuffer sb2 = new StringBuffer();
                sb1.append(o1.getType()).append("::").append(o1.getProvider().toString()).append("::") .append(o1.getAlgorithm());
                sb2.append(o2.getType()).append("::").append(o2.getProvider().toString()).append("::") .append(o2.getAlgorithm());
                return sb1.toString().compareTo(sb2.toString());
            }
        } );

        if (null != providers) {
            logger.info("所有的Cipher列表");
            for (Provider provider : providers) {
                Set<Service> services = provider.getServices();

                serviceTreeSet.addAll(services);
                for (Service service : services) {
                    if ("Cipher".equals(service.getType())) {
                        logger.info("[type]:{},[algorithm]:{},[provider]:{}", StringUtils.rightPad(service.getType(), 20, " "),
                                StringUtils.rightPad(service.getAlgorithm(), 30, " "),
                                StringUtils.rightPad(service.getProvider().toString(), 30, " "));
                    }
                }
            }

            logger.info("所有的service列表");
            logger.info("");
            logger.info("");
            serviceTreeSet.forEach( service ->  logger.info("[type]:{},[algorithm]:{},[provider]:{}",
                    StringUtils.rightPad(service.getType(), 20, " "),
                    StringUtils.rightPad(service.getAlgorithm(), 30, " "),
                    StringUtils.rightPad( service.getProvider().toString(), 30, " ")
                     ));


        }
    }

    public  void list1() {
        SSLServerSocketFactory ssf = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();

        String[] defaultCiphers = ssf.getDefaultCipherSuites();
        String[] availableCiphers = ssf.getSupportedCipherSuites();

        TreeMap ciphers = new TreeMap();

        for(int i=0; i<availableCiphers.length; ++i )
            ciphers.put(availableCiphers[i], Boolean.FALSE);

        for(int i=0; i<defaultCiphers.length; ++i ) {
            ciphers.put(defaultCiphers[i], Boolean.TRUE);
        }

        System.out.println("Default\tCipher");
        for(Iterator i = ciphers.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry cipher=(Map.Entry)i.next();

            if(Boolean.TRUE.equals(cipher.getValue()))
                System.out.print('*');
            else
                System.out.print(' ');

            System.out.print('\t');
            System.out.println(cipher.getKey());
        }
    }


    public static void main(String[] args) {
        new TestCipher().listSupportedCiphers();
//        new TestCipher().list1();
    }
}
