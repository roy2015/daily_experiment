/**
 * BaseModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roy.research.wsclient.webservice3;

public class BaseModel  extends Model  implements java.io.Serializable {
    private com.roy.research.wsclient.webservice3.BaseModelFieldMapEntry[] fieldMap;

    public BaseModel() {
    }

    public BaseModel(
           com.roy.research.wsclient.webservice3.BaseModelFieldMapEntry[] fieldMap) {
        this.fieldMap = fieldMap;
    }


    /**
     * Gets the fieldMap value for this BaseModel.
     * 
     * @return fieldMap
     */
    public com.roy.research.wsclient.webservice3.BaseModelFieldMapEntry[] getFieldMap() {
        return fieldMap;
    }


    /**
     * Sets the fieldMap value for this BaseModel.
     * 
     * @param fieldMap
     */
    public void setFieldMap(com.roy.research.wsclient.webservice3.BaseModelFieldMapEntry[] fieldMap) {
        this.fieldMap = fieldMap;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof BaseModel)) return false;
        BaseModel other = (BaseModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.fieldMap==null && other.getFieldMap()==null) || 
             (this.fieldMap!=null &&
              java.util.Arrays.equals(this.fieldMap, other.getFieldMap())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getFieldMap() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFieldMap());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getFieldMap(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://hbxt.peripheral.service.interfaces.sco.powere2e.com/", "baseModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fieldMap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fieldMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://hbxt.peripheral.service.interfaces.sco.powere2e.com/", ">>baseModel>fieldMap>entry"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "entry"));
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
