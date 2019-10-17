/**
 * UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roy.miscellaneous.wsclient.webservice;

public class UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceLocator extends org.apache.axis.client.Service implements UpdateAccessoryOaApplicationLinkTbpmServiceImplService {

    public UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceLocator() {
    }


    public UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UpdateAccessoryOaApplicationLinkTbpmServiceImplPort
    private String UpdateAccessoryOaApplicationLinkTbpmServiceImplPort_address = "http://localhost:8081/services/updateAccessoryOaApplicationLinkTbmpService";

    public String getUpdateAccessoryOaApplicationLinkTbpmServiceImplPortAddress() {
        return UpdateAccessoryOaApplicationLinkTbpmServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String UpdateAccessoryOaApplicationLinkTbpmServiceImplPortWSDDServiceName = "UpdateAccessoryOaApplicationLinkTbpmServiceImplPort";

    public String getUpdateAccessoryOaApplicationLinkTbpmServiceImplPortWSDDServiceName() {
        return UpdateAccessoryOaApplicationLinkTbpmServiceImplPortWSDDServiceName;
    }

    public void setUpdateAccessoryOaApplicationLinkTbpmServiceImplPortWSDDServiceName(String name) {
        UpdateAccessoryOaApplicationLinkTbpmServiceImplPortWSDDServiceName = name;
    }

    public UpdateAccessoryOaApplicationLinkTbmpService getUpdateAccessoryOaApplicationLinkTbpmServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UpdateAccessoryOaApplicationLinkTbpmServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUpdateAccessoryOaApplicationLinkTbpmServiceImplPort(endpoint);
    }

    public UpdateAccessoryOaApplicationLinkTbmpService getUpdateAccessoryOaApplicationLinkTbpmServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.roy.miscellaneous.wsclient.webservice.UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceSoapBindingStub _stub = new com.roy.miscellaneous.wsclient.webservice.UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getUpdateAccessoryOaApplicationLinkTbpmServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUpdateAccessoryOaApplicationLinkTbpmServiceImplPortEndpointAddress(String address) {
        UpdateAccessoryOaApplicationLinkTbpmServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (UpdateAccessoryOaApplicationLinkTbmpService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.roy.miscellaneous.wsclient.webservice.UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceSoapBindingStub _stub = new com.roy.miscellaneous.wsclient.webservice.UpdateAccessoryOaApplicationLinkTbpmServiceImplServiceSoapBindingStub(new java.net.URL(UpdateAccessoryOaApplicationLinkTbpmServiceImplPort_address), this);
                _stub.setPortName(getUpdateAccessoryOaApplicationLinkTbpmServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("UpdateAccessoryOaApplicationLinkTbpmServiceImplPort".equals(inputPortName)) {
            return getUpdateAccessoryOaApplicationLinkTbpmServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tbpm.peripheral.sco.powere2e.com/", "UpdateAccessoryOaApplicationLinkTbpmServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tbpm.peripheral.sco.powere2e.com/", "UpdateAccessoryOaApplicationLinkTbpmServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("UpdateAccessoryOaApplicationLinkTbpmServiceImplPort".equals(portName)) {
            setUpdateAccessoryOaApplicationLinkTbpmServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
