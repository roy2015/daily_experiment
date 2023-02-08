/**
 * ApplyMerchandiseIntentionHbxtServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roy.research.wsclient.webservice3;

public class ApplyMerchandiseIntentionHbxtServiceImplServiceLocator extends org.apache.axis.client.Service implements ApplyMerchandiseIntentionHbxtServiceImplService {

    public ApplyMerchandiseIntentionHbxtServiceImplServiceLocator() {
    }


    public ApplyMerchandiseIntentionHbxtServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ApplyMerchandiseIntentionHbxtServiceImplServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ApplyMerchandiseIntentionHbxtServiceImplPort
    private String ApplyMerchandiseIntentionHbxtServiceImplPort_address = "http://10.2.7.71:8082/sco/services/applyMerchandiseIntentionHbxtService";

    public String getApplyMerchandiseIntentionHbxtServiceImplPortAddress() {
        return ApplyMerchandiseIntentionHbxtServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String ApplyMerchandiseIntentionHbxtServiceImplPortWSDDServiceName = "ApplyMerchandiseIntentionHbxtServiceImplPort";

    public String getApplyMerchandiseIntentionHbxtServiceImplPortWSDDServiceName() {
        return ApplyMerchandiseIntentionHbxtServiceImplPortWSDDServiceName;
    }

    public void setApplyMerchandiseIntentionHbxtServiceImplPortWSDDServiceName(String name) {
        ApplyMerchandiseIntentionHbxtServiceImplPortWSDDServiceName = name;
    }

    public ApplyMerchandiseIntentionHbxtService getApplyMerchandiseIntentionHbxtServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ApplyMerchandiseIntentionHbxtServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getApplyMerchandiseIntentionHbxtServiceImplPort(endpoint);
    }

    public ApplyMerchandiseIntentionHbxtService getApplyMerchandiseIntentionHbxtServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.roy.research.wsclient.webservice3.ApplyMerchandiseIntentionHbxtServiceImplServiceSoapBindingStub _stub = new com.roy.research.wsclient.webservice3.ApplyMerchandiseIntentionHbxtServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getApplyMerchandiseIntentionHbxtServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setApplyMerchandiseIntentionHbxtServiceImplPortEndpointAddress(String address) {
        ApplyMerchandiseIntentionHbxtServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ApplyMerchandiseIntentionHbxtService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.roy.research.wsclient.webservice3.ApplyMerchandiseIntentionHbxtServiceImplServiceSoapBindingStub _stub = new com.roy.research.wsclient.webservice3.ApplyMerchandiseIntentionHbxtServiceImplServiceSoapBindingStub(new java.net.URL(ApplyMerchandiseIntentionHbxtServiceImplPort_address), this);
                _stub.setPortName(getApplyMerchandiseIntentionHbxtServiceImplPortWSDDServiceName());
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
        if ("ApplyMerchandiseIntentionHbxtServiceImplPort".equals(inputPortName)) {
            return getApplyMerchandiseIntentionHbxtServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://hbxt.peripheral.sco.powere2e.com/", "ApplyMerchandiseIntentionHbxtServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://hbxt.peripheral.sco.powere2e.com/", "ApplyMerchandiseIntentionHbxtServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("ApplyMerchandiseIntentionHbxtServiceImplPort".equals(portName)) {
            setApplyMerchandiseIntentionHbxtServiceImplPortEndpointAddress(address);
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
