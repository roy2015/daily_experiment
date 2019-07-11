package com.roy.miscellaneous.webservice3;

import org.apache.axis.AxisFault;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

public class TestWsClient {

    public static void main(String[] args) {
        try {
            ApplyMerchandiseIntentionHbxtServiceImplServiceSoapBindingStub serviceSoapBindingStub = new ApplyMerchandiseIntentionHbxtServiceImplServiceSoapBindingStub(
                    new URL("http://10.2.7.71:8082/sco/services/applyMerchandiseIntentionHbxtService?wsdl"), null

            );
            MerchandiseIntentionApplyResponseResult result = serviceSoapBindingStub.applyMerchandiseIntentionHbxt("", "", "",
                    "", "", "",
                    "", "", "",
                    "", "", "",
                    "", "", "",
                    "", "");
            System.out.println(result);
        } catch (AxisFault axisFault) {

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
