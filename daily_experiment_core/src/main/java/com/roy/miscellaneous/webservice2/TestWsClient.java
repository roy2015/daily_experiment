package com.roy.miscellaneous.webservice2;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestWsClient {

    public static void main(String[] args) {
        try {

            ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub stub = new ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub
                    (new java.net.URL("http://localhost:8080/sco/services/applyNormalMerchandiseAdjustPriceHbxtService?wsdl")
                            ,null);

            /*ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub stub = new ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub
                    (new java.net.URL("http://10.2.7.71:8082/sco/services/applyNormalMerchandiseAdjustPriceHbxtService?wsdl")
                            ,null);*/

            CxfFileWrapper cxfFileWrapper1 = resolveCxfFileWrappers("D:\\owms的表机构.xlsx", "owms的表机构", "xlsx");
            CxfFileWrapper cxfFileWrapper2 = resolveCxfFileWrappers("D:\\111.txt", "111", "txt");

            MerchandiseAdjustPriceApplyResponseResult merchandiseAdjustPriceApplication =
                    stub.createNormalMerchandiseAdjustPriceApplication ("813001239", null, null, null);
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
