package com.roy.miscellaneous.webservice;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Service;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestWsClient {

    public static void main(String[] args) {
        try {
            Service service = new Service();

            UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceSoapBindingStub stub =
                    new UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceSoapBindingStub(
                            new java.net.URL("http://localhost:8081/services/updateAccessoryOaApplicationLinkTbmpService?wsdl"), service
                    );
            stub.updateAccessoryOaApplicationLinkTbmp("1","2","3");

        } catch (RemoteException | MalformedURLException axisFault) {
            axisFault.printStackTrace();
        }


    }
}
