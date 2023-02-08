/**
 * ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.guo.roy.research.misc.wsclient.webservice2;

public class ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceLocator extends org.apache.axis.client.Service implements ApplyNormalMerchandiseAdjustPriceHbxtServiceImplService {

    public ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceLocator() {
    }


    public ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort
    private String ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort_address = "http://localhost:8080/sco/services/applyNormalMerchandiseAdjustPriceHbxtService";

    public String getApplyNormalMerchandiseAdjustPriceHbxtServiceImplPortAddress() {
        return ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName = "ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort";

    public String getApplyNormalMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName() {
        return ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName;
    }

    public void setApplyNormalMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName(String name) {
        ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName = name;
    }

    public ApplyNormalMerchandiseAdjustPriceHbxtService getApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort(endpoint);
    }

    public ApplyNormalMerchandiseAdjustPriceHbxtService getApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.guo.roy.research.misc.wsclient.webservice2.ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub _stub = new com.guo.roy.research.misc.wsclient.webservice2.ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getApplyNormalMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setApplyNormalMerchandiseAdjustPriceHbxtServiceImplPortEndpointAddress(String address) {
        ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ApplyNormalMerchandiseAdjustPriceHbxtService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.guo.roy.research.misc.wsclient.webservice2.ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub _stub = new com.guo.roy.research.misc.wsclient.webservice2.ApplyNormalMerchandiseAdjustPriceHbxtServiceImplServiceSoapBindingStub(new java.net.URL(ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort_address), this);
                _stub.setPortName(getApplyNormalMerchandiseAdjustPriceHbxtServiceImplPortWSDDServiceName());
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
        if ("ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort".equals(inputPortName)) {
            return getApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://hbxt.peripheral.sco.powere2e.com/", "ApplyNormalMerchandiseAdjustPriceHbxtServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://hbxt.peripheral.sco.powere2e.com/", "ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("ApplyNormalMerchandiseAdjustPriceHbxtServiceImplPort".equals(portName)) {
            setApplyNormalMerchandiseAdjustPriceHbxtServiceImplPortEndpointAddress(address);
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
