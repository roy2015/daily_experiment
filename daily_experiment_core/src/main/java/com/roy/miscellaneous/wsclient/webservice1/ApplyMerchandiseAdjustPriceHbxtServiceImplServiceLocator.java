/**
 * ApplyMerchandiseAdjustPriceHbxtServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roy.miscellaneous.wsclient.webservice1;

public class ApplyMerchandiseAdjustPriceHbxtServiceImplServiceLocator extends org.apache.axis.client.Service implements ApplyMerchandiseAdjustPriceHbxtServiceImplService {

    public ApplyMerchandiseAdjustPriceHbxtServiceImplServiceLocator() {
    }


    public ApplyMerchandiseAdjustPriceHbxtServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ApplyMerchandiseAdjustPriceHbxtServiceImplServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ApplyMerchandiseAdjustPriceHbxtServiceImplPort
    private String ApplyMerchandiseAdjustPriceHbxtServiceImplPort_address = "http://localhost:8080/scowebservice/services/applyMerchandiseAdjustPriceHbxtService";

    public String getApplyMerchandiseAdjustPriceHbxtServiceImplPortAddress() {
        return ApplyMerchandiseAdjustPriceHbxtServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String ApplyMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName = "ApplyMerchandiseAdjustPriceHbxtServiceImplPort";

    public String getApplyMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName() {
        return ApplyMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName;
    }

    public void setApplyMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName(String name) {
        ApplyMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName = name;
    }

    public ApplyMerchandiseAdjustPriceHbxtService getApplyMerchandiseAdjustPriceHbxtServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ApplyMerchandiseAdjustPriceHbxtServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getApplyMerchandiseAdjustPriceHbxtServiceImplPort(endpoint);
    }

    public ApplyMerchandiseAdjustPriceHbxtService getApplyMerchandiseAdjustPriceHbxtServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.roy.miscellaneous.wsclient.webservice1.ApplyMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub _stub = new com.roy.miscellaneous.wsclient.webservice1.ApplyMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getApplyMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setApplyMerchandiseAdjustPriceHbxtServiceImplPortEndpointAddress(String address) {
        ApplyMerchandiseAdjustPriceHbxtServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ApplyMerchandiseAdjustPriceHbxtService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.roy.miscellaneous.wsclient.webservice1.ApplyMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub _stub = new com.roy.miscellaneous.wsclient.webservice1.ApplyMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub(new java.net.URL(ApplyMerchandiseAdjustPriceHbxtServiceImplPort_address), this);
                _stub.setPortName(getApplyMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName());
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
        if ("ApplyMerchandiseAdjustPriceHbxtServiceImplPort".equals(inputPortName)) {
            return getApplyMerchandiseAdjustPriceHbxtServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://hbxt.peripheral.sco.powere2e.com/", "ApplyMerchandiseAdjustPriceHbxtServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://hbxt.peripheral.sco.powere2e.com/", "ApplyMerchandiseAdjustPriceHbxtServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("ApplyMerchandiseAdjustPriceHbxtServiceImplPort".equals(portName)) {
            setApplyMerchandiseAdjustPriceHbxtServiceImplPortEndpointAddress(address);
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
