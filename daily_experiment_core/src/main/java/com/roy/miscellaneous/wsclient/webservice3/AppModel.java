/**
 * AppModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roy.miscellaneous.wsclient.webservice3;

public class AppModel  extends com.roy.miscellaneous.wsclient.webservice3.BaseModel  implements java.io.Serializable {
    private String clientId;

    private String clientName;

    private String createUserName;

    private String createby;

    private java.util.Calendar created;

    private String orgId;

    private String orgName;

    private String updateUserName;

    private String updateby;

    private java.util.Calendar updated;

    public AppModel() {
    }

    public AppModel(
           com.roy.miscellaneous.wsclient.webservice3.BaseModelFieldMapEntry[] fieldMap,
           String clientId,
           String clientName,
           String createUserName,
           String createby,
           java.util.Calendar created,
           String orgId,
           String orgName,
           String updateUserName,
           String updateby,
           java.util.Calendar updated) {
        super(
            fieldMap);
        this.clientId = clientId;
        this.clientName = clientName;
        this.createUserName = createUserName;
        this.createby = createby;
        this.created = created;
        this.orgId = orgId;
        this.orgName = orgName;
        this.updateUserName = updateUserName;
        this.updateby = updateby;
        this.updated = updated;
    }


    /**
     * Gets the clientId value for this AppModel.
     * 
     * @return clientId
     */
    public String getClientId() {
        return clientId;
    }


    /**
     * Sets the clientId value for this AppModel.
     * 
     * @param clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    /**
     * Gets the clientName value for this AppModel.
     * 
     * @return clientName
     */
    public String getClientName() {
        return clientName;
    }


    /**
     * Sets the clientName value for this AppModel.
     * 
     * @param clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    /**
     * Gets the createUserName value for this AppModel.
     * 
     * @return createUserName
     */
    public String getCreateUserName() {
        return createUserName;
    }


    /**
     * Sets the createUserName value for this AppModel.
     * 
     * @param createUserName
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }


    /**
     * Gets the createby value for this AppModel.
     * 
     * @return createby
     */
    public String getCreateby() {
        return createby;
    }


    /**
     * Sets the createby value for this AppModel.
     * 
     * @param createby
     */
    public void setCreateby(String createby) {
        this.createby = createby;
    }


    /**
     * Gets the created value for this AppModel.
     * 
     * @return created
     */
    public java.util.Calendar getCreated() {
        return created;
    }


    /**
     * Sets the created value for this AppModel.
     * 
     * @param created
     */
    public void setCreated(java.util.Calendar created) {
        this.created = created;
    }


    /**
     * Gets the orgId value for this AppModel.
     * 
     * @return orgId
     */
    public String getOrgId() {
        return orgId;
    }


    /**
     * Sets the orgId value for this AppModel.
     * 
     * @param orgId
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }


    /**
     * Gets the orgName value for this AppModel.
     * 
     * @return orgName
     */
    public String getOrgName() {
        return orgName;
    }


    /**
     * Sets the orgName value for this AppModel.
     * 
     * @param orgName
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }


    /**
     * Gets the updateUserName value for this AppModel.
     * 
     * @return updateUserName
     */
    public String getUpdateUserName() {
        return updateUserName;
    }


    /**
     * Sets the updateUserName value for this AppModel.
     * 
     * @param updateUserName
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }


    /**
     * Gets the updateby value for this AppModel.
     * 
     * @return updateby
     */
    public String getUpdateby() {
        return updateby;
    }


    /**
     * Sets the updateby value for this AppModel.
     * 
     * @param updateby
     */
    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }


    /**
     * Gets the updated value for this AppModel.
     * 
     * @return updated
     */
    public java.util.Calendar getUpdated() {
        return updated;
    }


    /**
     * Sets the updated value for this AppModel.
     * 
     * @param updated
     */
    public void setUpdated(java.util.Calendar updated) {
        this.updated = updated;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof AppModel)) return false;
        AppModel other = (AppModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.clientId==null && other.getClientId()==null) || 
             (this.clientId!=null &&
              this.clientId.equals(other.getClientId()))) &&
            ((this.clientName==null && other.getClientName()==null) || 
             (this.clientName!=null &&
              this.clientName.equals(other.getClientName()))) &&
            ((this.createUserName==null && other.getCreateUserName()==null) || 
             (this.createUserName!=null &&
              this.createUserName.equals(other.getCreateUserName()))) &&
            ((this.createby==null && other.getCreateby()==null) || 
             (this.createby!=null &&
              this.createby.equals(other.getCreateby()))) &&
            ((this.created==null && other.getCreated()==null) || 
             (this.created!=null &&
              this.created.equals(other.getCreated()))) &&
            ((this.orgId==null && other.getOrgId()==null) || 
             (this.orgId!=null &&
              this.orgId.equals(other.getOrgId()))) &&
            ((this.orgName==null && other.getOrgName()==null) || 
             (this.orgName!=null &&
              this.orgName.equals(other.getOrgName()))) &&
            ((this.updateUserName==null && other.getUpdateUserName()==null) || 
             (this.updateUserName!=null &&
              this.updateUserName.equals(other.getUpdateUserName()))) &&
            ((this.updateby==null && other.getUpdateby()==null) || 
             (this.updateby!=null &&
              this.updateby.equals(other.getUpdateby()))) &&
            ((this.updated==null && other.getUpdated()==null) || 
             (this.updated!=null &&
              this.updated.equals(other.getUpdated())));
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
        if (getClientId() != null) {
            _hashCode += getClientId().hashCode();
        }
        if (getClientName() != null) {
            _hashCode += getClientName().hashCode();
        }
        if (getCreateUserName() != null) {
            _hashCode += getCreateUserName().hashCode();
        }
        if (getCreateby() != null) {
            _hashCode += getCreateby().hashCode();
        }
        if (getCreated() != null) {
            _hashCode += getCreated().hashCode();
        }
        if (getOrgId() != null) {
            _hashCode += getOrgId().hashCode();
        }
        if (getOrgName() != null) {
            _hashCode += getOrgName().hashCode();
        }
        if (getUpdateUserName() != null) {
            _hashCode += getUpdateUserName().hashCode();
        }
        if (getUpdateby() != null) {
            _hashCode += getUpdateby().hashCode();
        }
        if (getUpdated() != null) {
            _hashCode += getUpdated().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AppModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://hbxt.peripheral.service.interfaces.sco.powere2e.com/", "appModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createby");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createby"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("created");
        elemField.setXmlName(new javax.xml.namespace.QName("", "created"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updateUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateby");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updateby"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updated");
        elemField.setXmlName(new javax.xml.namespace.QName("", "updated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
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
