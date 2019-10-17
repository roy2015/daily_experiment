/**
 * MerchandiseAdjustPriceApplyResponseResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roy.miscellaneous.wsclient.webservice1;

public class MerchandiseAdjustPriceApplyResponseResult  implements java.io.Serializable {
    private AdjustPriceApplyReturnVO data;

    private String message;

    private boolean sucess;

    public MerchandiseAdjustPriceApplyResponseResult() {
    }

    public MerchandiseAdjustPriceApplyResponseResult(
           AdjustPriceApplyReturnVO data,
           String message,
           boolean sucess) {
           this.data = data;
           this.message = message;
           this.sucess = sucess;
    }


    /**
     * Gets the data value for this MerchandiseAdjustPriceApplyResponseResult.
     * 
     * @return data
     */
    public AdjustPriceApplyReturnVO getData() {
        return data;
    }


    /**
     * Sets the data value for this MerchandiseAdjustPriceApplyResponseResult.
     * 
     * @param data
     */
    public void setData(AdjustPriceApplyReturnVO data) {
        this.data = data;
    }


    /**
     * Gets the message value for this MerchandiseAdjustPriceApplyResponseResult.
     * 
     * @return message
     */
    public String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this MerchandiseAdjustPriceApplyResponseResult.
     * 
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * Gets the sucess value for this MerchandiseAdjustPriceApplyResponseResult.
     * 
     * @return sucess
     */
    public boolean isSucess() {
        return sucess;
    }


    /**
     * Sets the sucess value for this MerchandiseAdjustPriceApplyResponseResult.
     * 
     * @param sucess
     */
    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MerchandiseAdjustPriceApplyResponseResult)) return false;
        MerchandiseAdjustPriceApplyResponseResult other = (MerchandiseAdjustPriceApplyResponseResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            this.sucess == other.isSucess();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        _hashCode += (isSucess() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MerchandiseAdjustPriceApplyResponseResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://hbxt.peripheral.service.interfaces.sco.powere2e.com/", "merchandiseAdjustPriceApplyResponseResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://hbxt.peripheral.service.interfaces.sco.powere2e.com/", "adjustPriceApplyReturnVO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sucess");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sucess"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
