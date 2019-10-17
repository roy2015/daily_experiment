package com.roy.miscellaneous.wsclient.webservice1;

import java.io.*;

public class TestWsClient {

    public static void main(String[] args) {
        try {
            /*ApplyMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub stub = new ApplyMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub
                    (new java.net.URL("http://localhost:8080/scowebservice/services/applyMerchandiseAdjustPriceHbxtService?wsdl")
                    ,null);*/

            /*ApplyMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub stub = new ApplyMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub
                    (new java.net.URL("http://localhost:8080/sco/services/applyMerchandiseAdjustPriceHbxtService?wsdl")
                            ,null);*/

            ApplyMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub stub = new ApplyMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub
                    (new java.net.URL("http://10.2.7.71:8082/sco/services/applyMerchandiseAdjustPriceHbxtService?wsdl")
                            ,null);

            CxfFileWrapper[] cxfFileWrappers = new CxfFileWrapper[2];
            CxfFileWrapper cxfFileWrapper = new CxfFileWrapper();
            cxfFileWrappers[0]= resolveCxfFileWrappers("D:\\owms的表机构.xlsx", "owms的表机构", "xlsx");
            cxfFileWrappers[1]= resolveCxfFileWrappers("D:\\111.txt", "111", "txt");

            MerchandiseAdjustPriceApplyResponseResult merchandiseAdjustPriceApplication =
                    stub.createMerchandiseAdjustPriceApplication("813001239", cxfFileWrappers);
            System.out.println(merchandiseAdjustPriceApplication);


        } catch (IOException axisFault) {
            axisFault.printStackTrace();
        }
    }

    public static CxfFileWrapper resolveCxfFileWrappers (String path, String fileName, String fileExtension) {

        try {
            CxfFileWrapper cxfFileWrapper = new CxfFileWrapper();

            File file = new File(path);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024*1024];
            int len;
            while ( (len = fis.read(buffer)) != -1) {
                baos.write(buffer,0 , len);
            }

            cxfFileWrapper.setFile(baos.toByteArray());
            cxfFileWrapper.setFileName(fileName);
            cxfFileWrapper.setFileExtension(fileExtension);

            return cxfFileWrapper;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
