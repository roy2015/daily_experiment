/**
 * MerchandiseIntention.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roy.miscellaneous.wsclient.webservice3;

public class MerchandiseIntention  extends AppModel  implements java.io.Serializable {
    private String applicationCode;

    private String applicationLink;

    private String applicationStatus;

    private String applicationStatusName;

    private java.util.Calendar bbtgDate;

    private Integer bzDay;

    private Integer bzsjcgqrBzDay;

    private java.util.Calendar bzsjcgqrDate;

    private Integer bzsjcgqrSjDay;

    private Integer bzsjcgqrStatus;

    private Integer bzsjsqBzDay;

    private java.util.Calendar bzsjsqDate;

    private Integer bzsjsqSjDay;

    private Integer bzsjsqStatus;

    private Integer bzsjsqwcBzDay;

    private java.util.Calendar bzsjsqwcDate;

    private Integer bzsjsqwcSjDay;

    private Integer bzsjsqwcStatus;

    private java.util.Calendar bzsjwgtgDate;

    private Integer bzsjwgtgStatus;

    private String centreTypeCode;

    private String centreTypeName;

    private String deliveryType;

    private String detailTypeCode;

    private String detailTypeName;

    private String dlRoleCode;

    private String dlRoleName;

    private String dxRoleCode;

    private String dxRoleName;

    private java.util.Calendar dyqrDate;

    private String elseTypeName;

    private java.util.Calendar enquiryDate;

    private String evaluate;

    private String fineTypeCode;

    private String fineTypeName;

    private java.util.Calendar foretasteDate;

    private java.math.BigDecimal foretasteGrade;

    private java.util.Calendar foretastePassDate;

    private java.util.Calendar gyssdgpDate;

    private java.util.Calendar gzysqrDate;

    private java.util.Calendar htqdDate;

    private String intentionCode;

    private String intentionName;

    private String intentionSapCode;

    private String intentionSupplierCode;

    private String intentionSupplierName;

    private String isForetastePass;

    private String isTrueMerchandise;

    private Integer jlbzsjcgqrBzDay;

    private Integer jlbzsjcgqrSjDay;

    private Integer jlwlzsjsqsptgBzDay;

    private Integer jlwlzsjsqsptgSjDay;

    private String merchandiseCode;

    private String merchandiseName;

    private String oaApplicationCode;

    private java.util.Calendar oaApplicationDate;

    private String oaApplicationName;

    private String oaContacts;

    private String orderType;

    private String packageApplicationLink;

    private String packageApplicationStatus;

    private String packageApplicationStatusName;

    private String packingType;

    private String paymentType;

    private Integer pksjxcBzDay;

    private java.util.Calendar pksjxcDate;

    private Integer pksjxcSjDay;

    private Integer pksjxcStatus;

    private java.util.Calendar pkxcDate;

    private String purchaseDepartments;

    private String purchaseDepartmentsName;

    private String purchaseType;

    private String purchaseTypeName;

    private java.util.Calendar qdgpDate;

    private String quotedCurrency;

    private java.util.Calendar quotedDate;

    private String rationed;

    private String rationedName;

    private String saleType;

    private Integer sctgBzDay;

    private Integer sctgSjDay;

    private Integer sjDay;

    private String smallTypeCode;

    private String smallTypeName;

    private java.util.Calendar spdddcDate;

    private String specification;

    private java.util.Calendar ssDate;

    private String supCompanySite;

    private String supContacts;

    private String supContactsPhone;

    private String supplierCode;

    private String supplierName;

    private String visitApplicationLink;

    private String visitApplicationStatus;

    private String visitApplicationStatusName;

    private java.util.Calendar xcsqDate;

    private Integer xcsqshtgBzDay;

    private java.util.Calendar xcsqshtgDate;

    private Integer xcsqshtgSjDay;

    private Integer xcsqshtgStatus;

    private Integer xcsqtjBzDay;

    private java.util.Calendar xcsqtjDate;

    private Integer xcsqtjSjDay;

    private Integer xcsqtjStatus;

    private Integer xpffBzDay;

    private java.util.Calendar xpffDate;

    private Integer xpffSjDay;

    private Integer xpffStatus;

    private Integer xpyjbgsptgBzDay;

    private java.util.Calendar xpyjbgsptgDate;

    private Integer xpyjbgsptgSjDay;

    private Integer xpyjbgsptgStatus;

    private Integer xpyjbgtjBzDay;

    private java.util.Calendar xpyjbgtjDate;

    private Integer xpyjbgtjSjDay;

    private Integer xpyjbgtjStatus;

    private java.util.Calendar yjbgtjDate;

    private java.util.Calendar yjbgwcDate;

    private java.util.Calendar zsjsqDate;

    private Integer zsjsqsptgBzDay;

    private java.util.Calendar zsjsqsptgDate;

    private Integer zsjsqsptgSjDay;

    private Integer zsjsqsptgStatus;

    private java.util.Calendar zsjsqwcDate;

    public MerchandiseIntention() {
    }

    public MerchandiseIntention(
           BaseModelFieldMapEntry[] fieldMap,
           String clientId,
           String clientName,
           String createUserName,
           String createby,
           java.util.Calendar created,
           String orgId,
           String orgName,
           String updateUserName,
           String updateby,
           java.util.Calendar updated,
           String applicationCode,
           String applicationLink,
           String applicationStatus,
           String applicationStatusName,
           java.util.Calendar bbtgDate,
           Integer bzDay,
           Integer bzsjcgqrBzDay,
           java.util.Calendar bzsjcgqrDate,
           Integer bzsjcgqrSjDay,
           Integer bzsjcgqrStatus,
           Integer bzsjsqBzDay,
           java.util.Calendar bzsjsqDate,
           Integer bzsjsqSjDay,
           Integer bzsjsqStatus,
           Integer bzsjsqwcBzDay,
           java.util.Calendar bzsjsqwcDate,
           Integer bzsjsqwcSjDay,
           Integer bzsjsqwcStatus,
           java.util.Calendar bzsjwgtgDate,
           Integer bzsjwgtgStatus,
           String centreTypeCode,
           String centreTypeName,
           String deliveryType,
           String detailTypeCode,
           String detailTypeName,
           String dlRoleCode,
           String dlRoleName,
           String dxRoleCode,
           String dxRoleName,
           java.util.Calendar dyqrDate,
           String elseTypeName,
           java.util.Calendar enquiryDate,
           String evaluate,
           String fineTypeCode,
           String fineTypeName,
           java.util.Calendar foretasteDate,
           java.math.BigDecimal foretasteGrade,
           java.util.Calendar foretastePassDate,
           java.util.Calendar gyssdgpDate,
           java.util.Calendar gzysqrDate,
           java.util.Calendar htqdDate,
           String intentionCode,
           String intentionName,
           String intentionSapCode,
           String intentionSupplierCode,
           String intentionSupplierName,
           String isForetastePass,
           String isTrueMerchandise,
           Integer jlbzsjcgqrBzDay,
           Integer jlbzsjcgqrSjDay,
           Integer jlwlzsjsqsptgBzDay,
           Integer jlwlzsjsqsptgSjDay,
           String merchandiseCode,
           String merchandiseName,
           String oaApplicationCode,
           java.util.Calendar oaApplicationDate,
           String oaApplicationName,
           String oaContacts,
           String orderType,
           String packageApplicationLink,
           String packageApplicationStatus,
           String packageApplicationStatusName,
           String packingType,
           String paymentType,
           Integer pksjxcBzDay,
           java.util.Calendar pksjxcDate,
           Integer pksjxcSjDay,
           Integer pksjxcStatus,
           java.util.Calendar pkxcDate,
           String purchaseDepartments,
           String purchaseDepartmentsName,
           String purchaseType,
           String purchaseTypeName,
           java.util.Calendar qdgpDate,
           String quotedCurrency,
           java.util.Calendar quotedDate,
           String rationed,
           String rationedName,
           String saleType,
           Integer sctgBzDay,
           Integer sctgSjDay,
           Integer sjDay,
           String smallTypeCode,
           String smallTypeName,
           java.util.Calendar spdddcDate,
           String specification,
           java.util.Calendar ssDate,
           String supCompanySite,
           String supContacts,
           String supContactsPhone,
           String supplierCode,
           String supplierName,
           String visitApplicationLink,
           String visitApplicationStatus,
           String visitApplicationStatusName,
           java.util.Calendar xcsqDate,
           Integer xcsqshtgBzDay,
           java.util.Calendar xcsqshtgDate,
           Integer xcsqshtgSjDay,
           Integer xcsqshtgStatus,
           Integer xcsqtjBzDay,
           java.util.Calendar xcsqtjDate,
           Integer xcsqtjSjDay,
           Integer xcsqtjStatus,
           Integer xpffBzDay,
           java.util.Calendar xpffDate,
           Integer xpffSjDay,
           Integer xpffStatus,
           Integer xpyjbgsptgBzDay,
           java.util.Calendar xpyjbgsptgDate,
           Integer xpyjbgsptgSjDay,
           Integer xpyjbgsptgStatus,
           Integer xpyjbgtjBzDay,
           java.util.Calendar xpyjbgtjDate,
           Integer xpyjbgtjSjDay,
           Integer xpyjbgtjStatus,
           java.util.Calendar yjbgtjDate,
           java.util.Calendar yjbgwcDate,
           java.util.Calendar zsjsqDate,
           Integer zsjsqsptgBzDay,
           java.util.Calendar zsjsqsptgDate,
           Integer zsjsqsptgSjDay,
           Integer zsjsqsptgStatus,
           java.util.Calendar zsjsqwcDate) {
        super(
            fieldMap,
            clientId,
            clientName,
            createUserName,
            createby,
            created,
            orgId,
            orgName,
            updateUserName,
            updateby,
            updated);
        this.applicationCode = applicationCode;
        this.applicationLink = applicationLink;
        this.applicationStatus = applicationStatus;
        this.applicationStatusName = applicationStatusName;
        this.bbtgDate = bbtgDate;
        this.bzDay = bzDay;
        this.bzsjcgqrBzDay = bzsjcgqrBzDay;
        this.bzsjcgqrDate = bzsjcgqrDate;
        this.bzsjcgqrSjDay = bzsjcgqrSjDay;
        this.bzsjcgqrStatus = bzsjcgqrStatus;
        this.bzsjsqBzDay = bzsjsqBzDay;
        this.bzsjsqDate = bzsjsqDate;
        this.bzsjsqSjDay = bzsjsqSjDay;
        this.bzsjsqStatus = bzsjsqStatus;
        this.bzsjsqwcBzDay = bzsjsqwcBzDay;
        this.bzsjsqwcDate = bzsjsqwcDate;
        this.bzsjsqwcSjDay = bzsjsqwcSjDay;
        this.bzsjsqwcStatus = bzsjsqwcStatus;
        this.bzsjwgtgDate = bzsjwgtgDate;
        this.bzsjwgtgStatus = bzsjwgtgStatus;
        this.centreTypeCode = centreTypeCode;
        this.centreTypeName = centreTypeName;
        this.deliveryType = deliveryType;
        this.detailTypeCode = detailTypeCode;
        this.detailTypeName = detailTypeName;
        this.dlRoleCode = dlRoleCode;
        this.dlRoleName = dlRoleName;
        this.dxRoleCode = dxRoleCode;
        this.dxRoleName = dxRoleName;
        this.dyqrDate = dyqrDate;
        this.elseTypeName = elseTypeName;
        this.enquiryDate = enquiryDate;
        this.evaluate = evaluate;
        this.fineTypeCode = fineTypeCode;
        this.fineTypeName = fineTypeName;
        this.foretasteDate = foretasteDate;
        this.foretasteGrade = foretasteGrade;
        this.foretastePassDate = foretastePassDate;
        this.gyssdgpDate = gyssdgpDate;
        this.gzysqrDate = gzysqrDate;
        this.htqdDate = htqdDate;
        this.intentionCode = intentionCode;
        this.intentionName = intentionName;
        this.intentionSapCode = intentionSapCode;
        this.intentionSupplierCode = intentionSupplierCode;
        this.intentionSupplierName = intentionSupplierName;
        this.isForetastePass = isForetastePass;
        this.isTrueMerchandise = isTrueMerchandise;
        this.jlbzsjcgqrBzDay = jlbzsjcgqrBzDay;
        this.jlbzsjcgqrSjDay = jlbzsjcgqrSjDay;
        this.jlwlzsjsqsptgBzDay = jlwlzsjsqsptgBzDay;
        this.jlwlzsjsqsptgSjDay = jlwlzsjsqsptgSjDay;
        this.merchandiseCode = merchandiseCode;
        this.merchandiseName = merchandiseName;
        this.oaApplicationCode = oaApplicationCode;
        this.oaApplicationDate = oaApplicationDate;
        this.oaApplicationName = oaApplicationName;
        this.oaContacts = oaContacts;
        this.orderType = orderType;
        this.packageApplicationLink = packageApplicationLink;
        this.packageApplicationStatus = packageApplicationStatus;
        this.packageApplicationStatusName = packageApplicationStatusName;
        this.packingType = packingType;
        this.paymentType = paymentType;
        this.pksjxcBzDay = pksjxcBzDay;
        this.pksjxcDate = pksjxcDate;
        this.pksjxcSjDay = pksjxcSjDay;
        this.pksjxcStatus = pksjxcStatus;
        this.pkxcDate = pkxcDate;
        this.purchaseDepartments = purchaseDepartments;
        this.purchaseDepartmentsName = purchaseDepartmentsName;
        this.purchaseType = purchaseType;
        this.purchaseTypeName = purchaseTypeName;
        this.qdgpDate = qdgpDate;
        this.quotedCurrency = quotedCurrency;
        this.quotedDate = quotedDate;
        this.rationed = rationed;
        this.rationedName = rationedName;
        this.saleType = saleType;
        this.sctgBzDay = sctgBzDay;
        this.sctgSjDay = sctgSjDay;
        this.sjDay = sjDay;
        this.smallTypeCode = smallTypeCode;
        this.smallTypeName = smallTypeName;
        this.spdddcDate = spdddcDate;
        this.specification = specification;
        this.ssDate = ssDate;
        this.supCompanySite = supCompanySite;
        this.supContacts = supContacts;
        this.supContactsPhone = supContactsPhone;
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.visitApplicationLink = visitApplicationLink;
        this.visitApplicationStatus = visitApplicationStatus;
        this.visitApplicationStatusName = visitApplicationStatusName;
        this.xcsqDate = xcsqDate;
        this.xcsqshtgBzDay = xcsqshtgBzDay;
        this.xcsqshtgDate = xcsqshtgDate;
        this.xcsqshtgSjDay = xcsqshtgSjDay;
        this.xcsqshtgStatus = xcsqshtgStatus;
        this.xcsqtjBzDay = xcsqtjBzDay;
        this.xcsqtjDate = xcsqtjDate;
        this.xcsqtjSjDay = xcsqtjSjDay;
        this.xcsqtjStatus = xcsqtjStatus;
        this.xpffBzDay = xpffBzDay;
        this.xpffDate = xpffDate;
        this.xpffSjDay = xpffSjDay;
        this.xpffStatus = xpffStatus;
        this.xpyjbgsptgBzDay = xpyjbgsptgBzDay;
        this.xpyjbgsptgDate = xpyjbgsptgDate;
        this.xpyjbgsptgSjDay = xpyjbgsptgSjDay;
        this.xpyjbgsptgStatus = xpyjbgsptgStatus;
        this.xpyjbgtjBzDay = xpyjbgtjBzDay;
        this.xpyjbgtjDate = xpyjbgtjDate;
        this.xpyjbgtjSjDay = xpyjbgtjSjDay;
        this.xpyjbgtjStatus = xpyjbgtjStatus;
        this.yjbgtjDate = yjbgtjDate;
        this.yjbgwcDate = yjbgwcDate;
        this.zsjsqDate = zsjsqDate;
        this.zsjsqsptgBzDay = zsjsqsptgBzDay;
        this.zsjsqsptgDate = zsjsqsptgDate;
        this.zsjsqsptgSjDay = zsjsqsptgSjDay;
        this.zsjsqsptgStatus = zsjsqsptgStatus;
        this.zsjsqwcDate = zsjsqwcDate;
    }


    /**
     * Gets the applicationCode value for this MerchandiseIntention.
     * 
     * @return applicationCode
     */
    public String getApplicationCode() {
        return applicationCode;
    }


    /**
     * Sets the applicationCode value for this MerchandiseIntention.
     * 
     * @param applicationCode
     */
    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }


    /**
     * Gets the applicationLink value for this MerchandiseIntention.
     * 
     * @return applicationLink
     */
    public String getApplicationLink() {
        return applicationLink;
    }


    /**
     * Sets the applicationLink value for this MerchandiseIntention.
     * 
     * @param applicationLink
     */
    public void setApplicationLink(String applicationLink) {
        this.applicationLink = applicationLink;
    }


    /**
     * Gets the applicationStatus value for this MerchandiseIntention.
     * 
     * @return applicationStatus
     */
    public String getApplicationStatus() {
        return applicationStatus;
    }


    /**
     * Sets the applicationStatus value for this MerchandiseIntention.
     * 
     * @param applicationStatus
     */
    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }


    /**
     * Gets the applicationStatusName value for this MerchandiseIntention.
     * 
     * @return applicationStatusName
     */
    public String getApplicationStatusName() {
        return applicationStatusName;
    }


    /**
     * Sets the applicationStatusName value for this MerchandiseIntention.
     * 
     * @param applicationStatusName
     */
    public void setApplicationStatusName(String applicationStatusName) {
        this.applicationStatusName = applicationStatusName;
    }


    /**
     * Gets the bbtgDate value for this MerchandiseIntention.
     * 
     * @return bbtgDate
     */
    public java.util.Calendar getBbtgDate() {
        return bbtgDate;
    }


    /**
     * Sets the bbtgDate value for this MerchandiseIntention.
     * 
     * @param bbtgDate
     */
    public void setBbtgDate(java.util.Calendar bbtgDate) {
        this.bbtgDate = bbtgDate;
    }


    /**
     * Gets the bzDay value for this MerchandiseIntention.
     * 
     * @return bzDay
     */
    public Integer getBzDay() {
        return bzDay;
    }


    /**
     * Sets the bzDay value for this MerchandiseIntention.
     * 
     * @param bzDay
     */
    public void setBzDay(Integer bzDay) {
        this.bzDay = bzDay;
    }


    /**
     * Gets the bzsjcgqrBzDay value for this MerchandiseIntention.
     * 
     * @return bzsjcgqrBzDay
     */
    public Integer getBzsjcgqrBzDay() {
        return bzsjcgqrBzDay;
    }


    /**
     * Sets the bzsjcgqrBzDay value for this MerchandiseIntention.
     * 
     * @param bzsjcgqrBzDay
     */
    public void setBzsjcgqrBzDay(Integer bzsjcgqrBzDay) {
        this.bzsjcgqrBzDay = bzsjcgqrBzDay;
    }


    /**
     * Gets the bzsjcgqrDate value for this MerchandiseIntention.
     * 
     * @return bzsjcgqrDate
     */
    public java.util.Calendar getBzsjcgqrDate() {
        return bzsjcgqrDate;
    }


    /**
     * Sets the bzsjcgqrDate value for this MerchandiseIntention.
     * 
     * @param bzsjcgqrDate
     */
    public void setBzsjcgqrDate(java.util.Calendar bzsjcgqrDate) {
        this.bzsjcgqrDate = bzsjcgqrDate;
    }


    /**
     * Gets the bzsjcgqrSjDay value for this MerchandiseIntention.
     * 
     * @return bzsjcgqrSjDay
     */
    public Integer getBzsjcgqrSjDay() {
        return bzsjcgqrSjDay;
    }


    /**
     * Sets the bzsjcgqrSjDay value for this MerchandiseIntention.
     * 
     * @param bzsjcgqrSjDay
     */
    public void setBzsjcgqrSjDay(Integer bzsjcgqrSjDay) {
        this.bzsjcgqrSjDay = bzsjcgqrSjDay;
    }


    /**
     * Gets the bzsjcgqrStatus value for this MerchandiseIntention.
     * 
     * @return bzsjcgqrStatus
     */
    public Integer getBzsjcgqrStatus() {
        return bzsjcgqrStatus;
    }


    /**
     * Sets the bzsjcgqrStatus value for this MerchandiseIntention.
     * 
     * @param bzsjcgqrStatus
     */
    public void setBzsjcgqrStatus(Integer bzsjcgqrStatus) {
        this.bzsjcgqrStatus = bzsjcgqrStatus;
    }


    /**
     * Gets the bzsjsqBzDay value for this MerchandiseIntention.
     * 
     * @return bzsjsqBzDay
     */
    public Integer getBzsjsqBzDay() {
        return bzsjsqBzDay;
    }


    /**
     * Sets the bzsjsqBzDay value for this MerchandiseIntention.
     * 
     * @param bzsjsqBzDay
     */
    public void setBzsjsqBzDay(Integer bzsjsqBzDay) {
        this.bzsjsqBzDay = bzsjsqBzDay;
    }


    /**
     * Gets the bzsjsqDate value for this MerchandiseIntention.
     * 
     * @return bzsjsqDate
     */
    public java.util.Calendar getBzsjsqDate() {
        return bzsjsqDate;
    }


    /**
     * Sets the bzsjsqDate value for this MerchandiseIntention.
     * 
     * @param bzsjsqDate
     */
    public void setBzsjsqDate(java.util.Calendar bzsjsqDate) {
        this.bzsjsqDate = bzsjsqDate;
    }


    /**
     * Gets the bzsjsqSjDay value for this MerchandiseIntention.
     * 
     * @return bzsjsqSjDay
     */
    public Integer getBzsjsqSjDay() {
        return bzsjsqSjDay;
    }


    /**
     * Sets the bzsjsqSjDay value for this MerchandiseIntention.
     * 
     * @param bzsjsqSjDay
     */
    public void setBzsjsqSjDay(Integer bzsjsqSjDay) {
        this.bzsjsqSjDay = bzsjsqSjDay;
    }


    /**
     * Gets the bzsjsqStatus value for this MerchandiseIntention.
     * 
     * @return bzsjsqStatus
     */
    public Integer getBzsjsqStatus() {
        return bzsjsqStatus;
    }


    /**
     * Sets the bzsjsqStatus value for this MerchandiseIntention.
     * 
     * @param bzsjsqStatus
     */
    public void setBzsjsqStatus(Integer bzsjsqStatus) {
        this.bzsjsqStatus = bzsjsqStatus;
    }


    /**
     * Gets the bzsjsqwcBzDay value for this MerchandiseIntention.
     * 
     * @return bzsjsqwcBzDay
     */
    public Integer getBzsjsqwcBzDay() {
        return bzsjsqwcBzDay;
    }


    /**
     * Sets the bzsjsqwcBzDay value for this MerchandiseIntention.
     * 
     * @param bzsjsqwcBzDay
     */
    public void setBzsjsqwcBzDay(Integer bzsjsqwcBzDay) {
        this.bzsjsqwcBzDay = bzsjsqwcBzDay;
    }


    /**
     * Gets the bzsjsqwcDate value for this MerchandiseIntention.
     * 
     * @return bzsjsqwcDate
     */
    public java.util.Calendar getBzsjsqwcDate() {
        return bzsjsqwcDate;
    }


    /**
     * Sets the bzsjsqwcDate value for this MerchandiseIntention.
     * 
     * @param bzsjsqwcDate
     */
    public void setBzsjsqwcDate(java.util.Calendar bzsjsqwcDate) {
        this.bzsjsqwcDate = bzsjsqwcDate;
    }


    /**
     * Gets the bzsjsqwcSjDay value for this MerchandiseIntention.
     * 
     * @return bzsjsqwcSjDay
     */
    public Integer getBzsjsqwcSjDay() {
        return bzsjsqwcSjDay;
    }


    /**
     * Sets the bzsjsqwcSjDay value for this MerchandiseIntention.
     * 
     * @param bzsjsqwcSjDay
     */
    public void setBzsjsqwcSjDay(Integer bzsjsqwcSjDay) {
        this.bzsjsqwcSjDay = bzsjsqwcSjDay;
    }


    /**
     * Gets the bzsjsqwcStatus value for this MerchandiseIntention.
     * 
     * @return bzsjsqwcStatus
     */
    public Integer getBzsjsqwcStatus() {
        return bzsjsqwcStatus;
    }


    /**
     * Sets the bzsjsqwcStatus value for this MerchandiseIntention.
     * 
     * @param bzsjsqwcStatus
     */
    public void setBzsjsqwcStatus(Integer bzsjsqwcStatus) {
        this.bzsjsqwcStatus = bzsjsqwcStatus;
    }


    /**
     * Gets the bzsjwgtgDate value for this MerchandiseIntention.
     * 
     * @return bzsjwgtgDate
     */
    public java.util.Calendar getBzsjwgtgDate() {
        return bzsjwgtgDate;
    }


    /**
     * Sets the bzsjwgtgDate value for this MerchandiseIntention.
     * 
     * @param bzsjwgtgDate
     */
    public void setBzsjwgtgDate(java.util.Calendar bzsjwgtgDate) {
        this.bzsjwgtgDate = bzsjwgtgDate;
    }


    /**
     * Gets the bzsjwgtgStatus value for this MerchandiseIntention.
     * 
     * @return bzsjwgtgStatus
     */
    public Integer getBzsjwgtgStatus() {
        return bzsjwgtgStatus;
    }


    /**
     * Sets the bzsjwgtgStatus value for this MerchandiseIntention.
     * 
     * @param bzsjwgtgStatus
     */
    public void setBzsjwgtgStatus(Integer bzsjwgtgStatus) {
        this.bzsjwgtgStatus = bzsjwgtgStatus;
    }


    /**
     * Gets the centreTypeCode value for this MerchandiseIntention.
     * 
     * @return centreTypeCode
     */
    public String getCentreTypeCode() {
        return centreTypeCode;
    }


    /**
     * Sets the centreTypeCode value for this MerchandiseIntention.
     * 
     * @param centreTypeCode
     */
    public void setCentreTypeCode(String centreTypeCode) {
        this.centreTypeCode = centreTypeCode;
    }


    /**
     * Gets the centreTypeName value for this MerchandiseIntention.
     * 
     * @return centreTypeName
     */
    public String getCentreTypeName() {
        return centreTypeName;
    }


    /**
     * Sets the centreTypeName value for this MerchandiseIntention.
     * 
     * @param centreTypeName
     */
    public void setCentreTypeName(String centreTypeName) {
        this.centreTypeName = centreTypeName;
    }


    /**
     * Gets the deliveryType value for this MerchandiseIntention.
     * 
     * @return deliveryType
     */
    public String getDeliveryType() {
        return deliveryType;
    }


    /**
     * Sets the deliveryType value for this MerchandiseIntention.
     * 
     * @param deliveryType
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }


    /**
     * Gets the detailTypeCode value for this MerchandiseIntention.
     * 
     * @return detailTypeCode
     */
    public String getDetailTypeCode() {
        return detailTypeCode;
    }


    /**
     * Sets the detailTypeCode value for this MerchandiseIntention.
     * 
     * @param detailTypeCode
     */
    public void setDetailTypeCode(String detailTypeCode) {
        this.detailTypeCode = detailTypeCode;
    }


    /**
     * Gets the detailTypeName value for this MerchandiseIntention.
     * 
     * @return detailTypeName
     */
    public String getDetailTypeName() {
        return detailTypeName;
    }


    /**
     * Sets the detailTypeName value for this MerchandiseIntention.
     * 
     * @param detailTypeName
     */
    public void setDetailTypeName(String detailTypeName) {
        this.detailTypeName = detailTypeName;
    }


    /**
     * Gets the dlRoleCode value for this MerchandiseIntention.
     * 
     * @return dlRoleCode
     */
    public String getDlRoleCode() {
        return dlRoleCode;
    }


    /**
     * Sets the dlRoleCode value for this MerchandiseIntention.
     * 
     * @param dlRoleCode
     */
    public void setDlRoleCode(String dlRoleCode) {
        this.dlRoleCode = dlRoleCode;
    }


    /**
     * Gets the dlRoleName value for this MerchandiseIntention.
     * 
     * @return dlRoleName
     */
    public String getDlRoleName() {
        return dlRoleName;
    }


    /**
     * Sets the dlRoleName value for this MerchandiseIntention.
     * 
     * @param dlRoleName
     */
    public void setDlRoleName(String dlRoleName) {
        this.dlRoleName = dlRoleName;
    }


    /**
     * Gets the dxRoleCode value for this MerchandiseIntention.
     * 
     * @return dxRoleCode
     */
    public String getDxRoleCode() {
        return dxRoleCode;
    }


    /**
     * Sets the dxRoleCode value for this MerchandiseIntention.
     * 
     * @param dxRoleCode
     */
    public void setDxRoleCode(String dxRoleCode) {
        this.dxRoleCode = dxRoleCode;
    }


    /**
     * Gets the dxRoleName value for this MerchandiseIntention.
     * 
     * @return dxRoleName
     */
    public String getDxRoleName() {
        return dxRoleName;
    }


    /**
     * Sets the dxRoleName value for this MerchandiseIntention.
     * 
     * @param dxRoleName
     */
    public void setDxRoleName(String dxRoleName) {
        this.dxRoleName = dxRoleName;
    }


    /**
     * Gets the dyqrDate value for this MerchandiseIntention.
     * 
     * @return dyqrDate
     */
    public java.util.Calendar getDyqrDate() {
        return dyqrDate;
    }


    /**
     * Sets the dyqrDate value for this MerchandiseIntention.
     * 
     * @param dyqrDate
     */
    public void setDyqrDate(java.util.Calendar dyqrDate) {
        this.dyqrDate = dyqrDate;
    }


    /**
     * Gets the elseTypeName value for this MerchandiseIntention.
     * 
     * @return elseTypeName
     */
    public String getElseTypeName() {
        return elseTypeName;
    }


    /**
     * Sets the elseTypeName value for this MerchandiseIntention.
     * 
     * @param elseTypeName
     */
    public void setElseTypeName(String elseTypeName) {
        this.elseTypeName = elseTypeName;
    }


    /**
     * Gets the enquiryDate value for this MerchandiseIntention.
     * 
     * @return enquiryDate
     */
    public java.util.Calendar getEnquiryDate() {
        return enquiryDate;
    }


    /**
     * Sets the enquiryDate value for this MerchandiseIntention.
     * 
     * @param enquiryDate
     */
    public void setEnquiryDate(java.util.Calendar enquiryDate) {
        this.enquiryDate = enquiryDate;
    }


    /**
     * Gets the evaluate value for this MerchandiseIntention.
     * 
     * @return evaluate
     */
    public String getEvaluate() {
        return evaluate;
    }


    /**
     * Sets the evaluate value for this MerchandiseIntention.
     * 
     * @param evaluate
     */
    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }


    /**
     * Gets the fineTypeCode value for this MerchandiseIntention.
     * 
     * @return fineTypeCode
     */
    public String getFineTypeCode() {
        return fineTypeCode;
    }


    /**
     * Sets the fineTypeCode value for this MerchandiseIntention.
     * 
     * @param fineTypeCode
     */
    public void setFineTypeCode(String fineTypeCode) {
        this.fineTypeCode = fineTypeCode;
    }


    /**
     * Gets the fineTypeName value for this MerchandiseIntention.
     * 
     * @return fineTypeName
     */
    public String getFineTypeName() {
        return fineTypeName;
    }


    /**
     * Sets the fineTypeName value for this MerchandiseIntention.
     * 
     * @param fineTypeName
     */
    public void setFineTypeName(String fineTypeName) {
        this.fineTypeName = fineTypeName;
    }


    /**
     * Gets the foretasteDate value for this MerchandiseIntention.
     * 
     * @return foretasteDate
     */
    public java.util.Calendar getForetasteDate() {
        return foretasteDate;
    }


    /**
     * Sets the foretasteDate value for this MerchandiseIntention.
     * 
     * @param foretasteDate
     */
    public void setForetasteDate(java.util.Calendar foretasteDate) {
        this.foretasteDate = foretasteDate;
    }


    /**
     * Gets the foretasteGrade value for this MerchandiseIntention.
     * 
     * @return foretasteGrade
     */
    public java.math.BigDecimal getForetasteGrade() {
        return foretasteGrade;
    }


    /**
     * Sets the foretasteGrade value for this MerchandiseIntention.
     * 
     * @param foretasteGrade
     */
    public void setForetasteGrade(java.math.BigDecimal foretasteGrade) {
        this.foretasteGrade = foretasteGrade;
    }


    /**
     * Gets the foretastePassDate value for this MerchandiseIntention.
     * 
     * @return foretastePassDate
     */
    public java.util.Calendar getForetastePassDate() {
        return foretastePassDate;
    }


    /**
     * Sets the foretastePassDate value for this MerchandiseIntention.
     * 
     * @param foretastePassDate
     */
    public void setForetastePassDate(java.util.Calendar foretastePassDate) {
        this.foretastePassDate = foretastePassDate;
    }


    /**
     * Gets the gyssdgpDate value for this MerchandiseIntention.
     * 
     * @return gyssdgpDate
     */
    public java.util.Calendar getGyssdgpDate() {
        return gyssdgpDate;
    }


    /**
     * Sets the gyssdgpDate value for this MerchandiseIntention.
     * 
     * @param gyssdgpDate
     */
    public void setGyssdgpDate(java.util.Calendar gyssdgpDate) {
        this.gyssdgpDate = gyssdgpDate;
    }


    /**
     * Gets the gzysqrDate value for this MerchandiseIntention.
     * 
     * @return gzysqrDate
     */
    public java.util.Calendar getGzysqrDate() {
        return gzysqrDate;
    }


    /**
     * Sets the gzysqrDate value for this MerchandiseIntention.
     * 
     * @param gzysqrDate
     */
    public void setGzysqrDate(java.util.Calendar gzysqrDate) {
        this.gzysqrDate = gzysqrDate;
    }


    /**
     * Gets the htqdDate value for this MerchandiseIntention.
     * 
     * @return htqdDate
     */
    public java.util.Calendar getHtqdDate() {
        return htqdDate;
    }


    /**
     * Sets the htqdDate value for this MerchandiseIntention.
     * 
     * @param htqdDate
     */
    public void setHtqdDate(java.util.Calendar htqdDate) {
        this.htqdDate = htqdDate;
    }


    /**
     * Gets the intentionCode value for this MerchandiseIntention.
     * 
     * @return intentionCode
     */
    public String getIntentionCode() {
        return intentionCode;
    }


    /**
     * Sets the intentionCode value for this MerchandiseIntention.
     * 
     * @param intentionCode
     */
    public void setIntentionCode(String intentionCode) {
        this.intentionCode = intentionCode;
    }


    /**
     * Gets the intentionName value for this MerchandiseIntention.
     * 
     * @return intentionName
     */
    public String getIntentionName() {
        return intentionName;
    }


    /**
     * Sets the intentionName value for this MerchandiseIntention.
     * 
     * @param intentionName
     */
    public void setIntentionName(String intentionName) {
        this.intentionName = intentionName;
    }


    /**
     * Gets the intentionSapCode value for this MerchandiseIntention.
     * 
     * @return intentionSapCode
     */
    public String getIntentionSapCode() {
        return intentionSapCode;
    }


    /**
     * Sets the intentionSapCode value for this MerchandiseIntention.
     * 
     * @param intentionSapCode
     */
    public void setIntentionSapCode(String intentionSapCode) {
        this.intentionSapCode = intentionSapCode;
    }


    /**
     * Gets the intentionSupplierCode value for this MerchandiseIntention.
     * 
     * @return intentionSupplierCode
     */
    public String getIntentionSupplierCode() {
        return intentionSupplierCode;
    }


    /**
     * Sets the intentionSupplierCode value for this MerchandiseIntention.
     * 
     * @param intentionSupplierCode
     */
    public void setIntentionSupplierCode(String intentionSupplierCode) {
        this.intentionSupplierCode = intentionSupplierCode;
    }


    /**
     * Gets the intentionSupplierName value for this MerchandiseIntention.
     * 
     * @return intentionSupplierName
     */
    public String getIntentionSupplierName() {
        return intentionSupplierName;
    }


    /**
     * Sets the intentionSupplierName value for this MerchandiseIntention.
     * 
     * @param intentionSupplierName
     */
    public void setIntentionSupplierName(String intentionSupplierName) {
        this.intentionSupplierName = intentionSupplierName;
    }


    /**
     * Gets the isForetastePass value for this MerchandiseIntention.
     * 
     * @return isForetastePass
     */
    public String getIsForetastePass() {
        return isForetastePass;
    }


    /**
     * Sets the isForetastePass value for this MerchandiseIntention.
     * 
     * @param isForetastePass
     */
    public void setIsForetastePass(String isForetastePass) {
        this.isForetastePass = isForetastePass;
    }


    /**
     * Gets the isTrueMerchandise value for this MerchandiseIntention.
     * 
     * @return isTrueMerchandise
     */
    public String getIsTrueMerchandise() {
        return isTrueMerchandise;
    }


    /**
     * Sets the isTrueMerchandise value for this MerchandiseIntention.
     * 
     * @param isTrueMerchandise
     */
    public void setIsTrueMerchandise(String isTrueMerchandise) {
        this.isTrueMerchandise = isTrueMerchandise;
    }


    /**
     * Gets the jlbzsjcgqrBzDay value for this MerchandiseIntention.
     * 
     * @return jlbzsjcgqrBzDay
     */
    public Integer getJlbzsjcgqrBzDay() {
        return jlbzsjcgqrBzDay;
    }


    /**
     * Sets the jlbzsjcgqrBzDay value for this MerchandiseIntention.
     * 
     * @param jlbzsjcgqrBzDay
     */
    public void setJlbzsjcgqrBzDay(Integer jlbzsjcgqrBzDay) {
        this.jlbzsjcgqrBzDay = jlbzsjcgqrBzDay;
    }


    /**
     * Gets the jlbzsjcgqrSjDay value for this MerchandiseIntention.
     * 
     * @return jlbzsjcgqrSjDay
     */
    public Integer getJlbzsjcgqrSjDay() {
        return jlbzsjcgqrSjDay;
    }


    /**
     * Sets the jlbzsjcgqrSjDay value for this MerchandiseIntention.
     * 
     * @param jlbzsjcgqrSjDay
     */
    public void setJlbzsjcgqrSjDay(Integer jlbzsjcgqrSjDay) {
        this.jlbzsjcgqrSjDay = jlbzsjcgqrSjDay;
    }


    /**
     * Gets the jlwlzsjsqsptgBzDay value for this MerchandiseIntention.
     * 
     * @return jlwlzsjsqsptgBzDay
     */
    public Integer getJlwlzsjsqsptgBzDay() {
        return jlwlzsjsqsptgBzDay;
    }


    /**
     * Sets the jlwlzsjsqsptgBzDay value for this MerchandiseIntention.
     * 
     * @param jlwlzsjsqsptgBzDay
     */
    public void setJlwlzsjsqsptgBzDay(Integer jlwlzsjsqsptgBzDay) {
        this.jlwlzsjsqsptgBzDay = jlwlzsjsqsptgBzDay;
    }


    /**
     * Gets the jlwlzsjsqsptgSjDay value for this MerchandiseIntention.
     * 
     * @return jlwlzsjsqsptgSjDay
     */
    public Integer getJlwlzsjsqsptgSjDay() {
        return jlwlzsjsqsptgSjDay;
    }


    /**
     * Sets the jlwlzsjsqsptgSjDay value for this MerchandiseIntention.
     * 
     * @param jlwlzsjsqsptgSjDay
     */
    public void setJlwlzsjsqsptgSjDay(Integer jlwlzsjsqsptgSjDay) {
        this.jlwlzsjsqsptgSjDay = jlwlzsjsqsptgSjDay;
    }


    /**
     * Gets the merchandiseCode value for this MerchandiseIntention.
     * 
     * @return merchandiseCode
     */
    public String getMerchandiseCode() {
        return merchandiseCode;
    }


    /**
     * Sets the merchandiseCode value for this MerchandiseIntention.
     * 
     * @param merchandiseCode
     */
    public void setMerchandiseCode(String merchandiseCode) {
        this.merchandiseCode = merchandiseCode;
    }


    /**
     * Gets the merchandiseName value for this MerchandiseIntention.
     * 
     * @return merchandiseName
     */
    public String getMerchandiseName() {
        return merchandiseName;
    }


    /**
     * Sets the merchandiseName value for this MerchandiseIntention.
     * 
     * @param merchandiseName
     */
    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName;
    }


    /**
     * Gets the oaApplicationCode value for this MerchandiseIntention.
     * 
     * @return oaApplicationCode
     */
    public String getOaApplicationCode() {
        return oaApplicationCode;
    }


    /**
     * Sets the oaApplicationCode value for this MerchandiseIntention.
     * 
     * @param oaApplicationCode
     */
    public void setOaApplicationCode(String oaApplicationCode) {
        this.oaApplicationCode = oaApplicationCode;
    }


    /**
     * Gets the oaApplicationDate value for this MerchandiseIntention.
     * 
     * @return oaApplicationDate
     */
    public java.util.Calendar getOaApplicationDate() {
        return oaApplicationDate;
    }


    /**
     * Sets the oaApplicationDate value for this MerchandiseIntention.
     * 
     * @param oaApplicationDate
     */
    public void setOaApplicationDate(java.util.Calendar oaApplicationDate) {
        this.oaApplicationDate = oaApplicationDate;
    }


    /**
     * Gets the oaApplicationName value for this MerchandiseIntention.
     * 
     * @return oaApplicationName
     */
    public String getOaApplicationName() {
        return oaApplicationName;
    }


    /**
     * Sets the oaApplicationName value for this MerchandiseIntention.
     * 
     * @param oaApplicationName
     */
    public void setOaApplicationName(String oaApplicationName) {
        this.oaApplicationName = oaApplicationName;
    }


    /**
     * Gets the oaContacts value for this MerchandiseIntention.
     * 
     * @return oaContacts
     */
    public String getOaContacts() {
        return oaContacts;
    }


    /**
     * Sets the oaContacts value for this MerchandiseIntention.
     * 
     * @param oaContacts
     */
    public void setOaContacts(String oaContacts) {
        this.oaContacts = oaContacts;
    }


    /**
     * Gets the orderType value for this MerchandiseIntention.
     * 
     * @return orderType
     */
    public String getOrderType() {
        return orderType;
    }


    /**
     * Sets the orderType value for this MerchandiseIntention.
     * 
     * @param orderType
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }


    /**
     * Gets the packageApplicationLink value for this MerchandiseIntention.
     * 
     * @return packageApplicationLink
     */
    public String getPackageApplicationLink() {
        return packageApplicationLink;
    }


    /**
     * Sets the packageApplicationLink value for this MerchandiseIntention.
     * 
     * @param packageApplicationLink
     */
    public void setPackageApplicationLink(String packageApplicationLink) {
        this.packageApplicationLink = packageApplicationLink;
    }


    /**
     * Gets the packageApplicationStatus value for this MerchandiseIntention.
     * 
     * @return packageApplicationStatus
     */
    public String getPackageApplicationStatus() {
        return packageApplicationStatus;
    }


    /**
     * Sets the packageApplicationStatus value for this MerchandiseIntention.
     * 
     * @param packageApplicationStatus
     */
    public void setPackageApplicationStatus(String packageApplicationStatus) {
        this.packageApplicationStatus = packageApplicationStatus;
    }


    /**
     * Gets the packageApplicationStatusName value for this MerchandiseIntention.
     * 
     * @return packageApplicationStatusName
     */
    public String getPackageApplicationStatusName() {
        return packageApplicationStatusName;
    }


    /**
     * Sets the packageApplicationStatusName value for this MerchandiseIntention.
     * 
     * @param packageApplicationStatusName
     */
    public void setPackageApplicationStatusName(String packageApplicationStatusName) {
        this.packageApplicationStatusName = packageApplicationStatusName;
    }


    /**
     * Gets the packingType value for this MerchandiseIntention.
     * 
     * @return packingType
     */
    public String getPackingType() {
        return packingType;
    }


    /**
     * Sets the packingType value for this MerchandiseIntention.
     * 
     * @param packingType
     */
    public void setPackingType(String packingType) {
        this.packingType = packingType;
    }


    /**
     * Gets the paymentType value for this MerchandiseIntention.
     * 
     * @return paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }


    /**
     * Sets the paymentType value for this MerchandiseIntention.
     * 
     * @param paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }


    /**
     * Gets the pksjxcBzDay value for this MerchandiseIntention.
     * 
     * @return pksjxcBzDay
     */
    public Integer getPksjxcBzDay() {
        return pksjxcBzDay;
    }


    /**
     * Sets the pksjxcBzDay value for this MerchandiseIntention.
     * 
     * @param pksjxcBzDay
     */
    public void setPksjxcBzDay(Integer pksjxcBzDay) {
        this.pksjxcBzDay = pksjxcBzDay;
    }


    /**
     * Gets the pksjxcDate value for this MerchandiseIntention.
     * 
     * @return pksjxcDate
     */
    public java.util.Calendar getPksjxcDate() {
        return pksjxcDate;
    }


    /**
     * Sets the pksjxcDate value for this MerchandiseIntention.
     * 
     * @param pksjxcDate
     */
    public void setPksjxcDate(java.util.Calendar pksjxcDate) {
        this.pksjxcDate = pksjxcDate;
    }


    /**
     * Gets the pksjxcSjDay value for this MerchandiseIntention.
     * 
     * @return pksjxcSjDay
     */
    public Integer getPksjxcSjDay() {
        return pksjxcSjDay;
    }


    /**
     * Sets the pksjxcSjDay value for this MerchandiseIntention.
     * 
     * @param pksjxcSjDay
     */
    public void setPksjxcSjDay(Integer pksjxcSjDay) {
        this.pksjxcSjDay = pksjxcSjDay;
    }


    /**
     * Gets the pksjxcStatus value for this MerchandiseIntention.
     * 
     * @return pksjxcStatus
     */
    public Integer getPksjxcStatus() {
        return pksjxcStatus;
    }


    /**
     * Sets the pksjxcStatus value for this MerchandiseIntention.
     * 
     * @param pksjxcStatus
     */
    public void setPksjxcStatus(Integer pksjxcStatus) {
        this.pksjxcStatus = pksjxcStatus;
    }


    /**
     * Gets the pkxcDate value for this MerchandiseIntention.
     * 
     * @return pkxcDate
     */
    public java.util.Calendar getPkxcDate() {
        return pkxcDate;
    }


    /**
     * Sets the pkxcDate value for this MerchandiseIntention.
     * 
     * @param pkxcDate
     */
    public void setPkxcDate(java.util.Calendar pkxcDate) {
        this.pkxcDate = pkxcDate;
    }


    /**
     * Gets the purchaseDepartments value for this MerchandiseIntention.
     * 
     * @return purchaseDepartments
     */
    public String getPurchaseDepartments() {
        return purchaseDepartments;
    }


    /**
     * Sets the purchaseDepartments value for this MerchandiseIntention.
     * 
     * @param purchaseDepartments
     */
    public void setPurchaseDepartments(String purchaseDepartments) {
        this.purchaseDepartments = purchaseDepartments;
    }


    /**
     * Gets the purchaseDepartmentsName value for this MerchandiseIntention.
     * 
     * @return purchaseDepartmentsName
     */
    public String getPurchaseDepartmentsName() {
        return purchaseDepartmentsName;
    }


    /**
     * Sets the purchaseDepartmentsName value for this MerchandiseIntention.
     * 
     * @param purchaseDepartmentsName
     */
    public void setPurchaseDepartmentsName(String purchaseDepartmentsName) {
        this.purchaseDepartmentsName = purchaseDepartmentsName;
    }


    /**
     * Gets the purchaseType value for this MerchandiseIntention.
     * 
     * @return purchaseType
     */
    public String getPurchaseType() {
        return purchaseType;
    }


    /**
     * Sets the purchaseType value for this MerchandiseIntention.
     * 
     * @param purchaseType
     */
    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }


    /**
     * Gets the purchaseTypeName value for this MerchandiseIntention.
     * 
     * @return purchaseTypeName
     */
    public String getPurchaseTypeName() {
        return purchaseTypeName;
    }


    /**
     * Sets the purchaseTypeName value for this MerchandiseIntention.
     * 
     * @param purchaseTypeName
     */
    public void setPurchaseTypeName(String purchaseTypeName) {
        this.purchaseTypeName = purchaseTypeName;
    }


    /**
     * Gets the qdgpDate value for this MerchandiseIntention.
     * 
     * @return qdgpDate
     */
    public java.util.Calendar getQdgpDate() {
        return qdgpDate;
    }


    /**
     * Sets the qdgpDate value for this MerchandiseIntention.
     * 
     * @param qdgpDate
     */
    public void setQdgpDate(java.util.Calendar qdgpDate) {
        this.qdgpDate = qdgpDate;
    }


    /**
     * Gets the quotedCurrency value for this MerchandiseIntention.
     * 
     * @return quotedCurrency
     */
    public String getQuotedCurrency() {
        return quotedCurrency;
    }


    /**
     * Sets the quotedCurrency value for this MerchandiseIntention.
     * 
     * @param quotedCurrency
     */
    public void setQuotedCurrency(String quotedCurrency) {
        this.quotedCurrency = quotedCurrency;
    }


    /**
     * Gets the quotedDate value for this MerchandiseIntention.
     * 
     * @return quotedDate
     */
    public java.util.Calendar getQuotedDate() {
        return quotedDate;
    }


    /**
     * Sets the quotedDate value for this MerchandiseIntention.
     * 
     * @param quotedDate
     */
    public void setQuotedDate(java.util.Calendar quotedDate) {
        this.quotedDate = quotedDate;
    }


    /**
     * Gets the rationed value for this MerchandiseIntention.
     * 
     * @return rationed
     */
    public String getRationed() {
        return rationed;
    }


    /**
     * Sets the rationed value for this MerchandiseIntention.
     * 
     * @param rationed
     */
    public void setRationed(String rationed) {
        this.rationed = rationed;
    }


    /**
     * Gets the rationedName value for this MerchandiseIntention.
     * 
     * @return rationedName
     */
    public String getRationedName() {
        return rationedName;
    }


    /**
     * Sets the rationedName value for this MerchandiseIntention.
     * 
     * @param rationedName
     */
    public void setRationedName(String rationedName) {
        this.rationedName = rationedName;
    }


    /**
     * Gets the saleType value for this MerchandiseIntention.
     * 
     * @return saleType
     */
    public String getSaleType() {
        return saleType;
    }


    /**
     * Sets the saleType value for this MerchandiseIntention.
     * 
     * @param saleType
     */
    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }


    /**
     * Gets the sctgBzDay value for this MerchandiseIntention.
     * 
     * @return sctgBzDay
     */
    public Integer getSctgBzDay() {
        return sctgBzDay;
    }


    /**
     * Sets the sctgBzDay value for this MerchandiseIntention.
     * 
     * @param sctgBzDay
     */
    public void setSctgBzDay(Integer sctgBzDay) {
        this.sctgBzDay = sctgBzDay;
    }


    /**
     * Gets the sctgSjDay value for this MerchandiseIntention.
     * 
     * @return sctgSjDay
     */
    public Integer getSctgSjDay() {
        return sctgSjDay;
    }


    /**
     * Sets the sctgSjDay value for this MerchandiseIntention.
     * 
     * @param sctgSjDay
     */
    public void setSctgSjDay(Integer sctgSjDay) {
        this.sctgSjDay = sctgSjDay;
    }


    /**
     * Gets the sjDay value for this MerchandiseIntention.
     * 
     * @return sjDay
     */
    public Integer getSjDay() {
        return sjDay;
    }


    /**
     * Sets the sjDay value for this MerchandiseIntention.
     * 
     * @param sjDay
     */
    public void setSjDay(Integer sjDay) {
        this.sjDay = sjDay;
    }


    /**
     * Gets the smallTypeCode value for this MerchandiseIntention.
     * 
     * @return smallTypeCode
     */
    public String getSmallTypeCode() {
        return smallTypeCode;
    }


    /**
     * Sets the smallTypeCode value for this MerchandiseIntention.
     * 
     * @param smallTypeCode
     */
    public void setSmallTypeCode(String smallTypeCode) {
        this.smallTypeCode = smallTypeCode;
    }


    /**
     * Gets the smallTypeName value for this MerchandiseIntention.
     * 
     * @return smallTypeName
     */
    public String getSmallTypeName() {
        return smallTypeName;
    }


    /**
     * Sets the smallTypeName value for this MerchandiseIntention.
     * 
     * @param smallTypeName
     */
    public void setSmallTypeName(String smallTypeName) {
        this.smallTypeName = smallTypeName;
    }


    /**
     * Gets the spdddcDate value for this MerchandiseIntention.
     * 
     * @return spdddcDate
     */
    public java.util.Calendar getSpdddcDate() {
        return spdddcDate;
    }


    /**
     * Sets the spdddcDate value for this MerchandiseIntention.
     * 
     * @param spdddcDate
     */
    public void setSpdddcDate(java.util.Calendar spdddcDate) {
        this.spdddcDate = spdddcDate;
    }


    /**
     * Gets the specification value for this MerchandiseIntention.
     * 
     * @return specification
     */
    public String getSpecification() {
        return specification;
    }


    /**
     * Sets the specification value for this MerchandiseIntention.
     * 
     * @param specification
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }


    /**
     * Gets the ssDate value for this MerchandiseIntention.
     * 
     * @return ssDate
     */
    public java.util.Calendar getSsDate() {
        return ssDate;
    }


    /**
     * Sets the ssDate value for this MerchandiseIntention.
     * 
     * @param ssDate
     */
    public void setSsDate(java.util.Calendar ssDate) {
        this.ssDate = ssDate;
    }


    /**
     * Gets the supCompanySite value for this MerchandiseIntention.
     * 
     * @return supCompanySite
     */
    public String getSupCompanySite() {
        return supCompanySite;
    }


    /**
     * Sets the supCompanySite value for this MerchandiseIntention.
     * 
     * @param supCompanySite
     */
    public void setSupCompanySite(String supCompanySite) {
        this.supCompanySite = supCompanySite;
    }


    /**
     * Gets the supContacts value for this MerchandiseIntention.
     * 
     * @return supContacts
     */
    public String getSupContacts() {
        return supContacts;
    }


    /**
     * Sets the supContacts value for this MerchandiseIntention.
     * 
     * @param supContacts
     */
    public void setSupContacts(String supContacts) {
        this.supContacts = supContacts;
    }


    /**
     * Gets the supContactsPhone value for this MerchandiseIntention.
     * 
     * @return supContactsPhone
     */
    public String getSupContactsPhone() {
        return supContactsPhone;
    }


    /**
     * Sets the supContactsPhone value for this MerchandiseIntention.
     * 
     * @param supContactsPhone
     */
    public void setSupContactsPhone(String supContactsPhone) {
        this.supContactsPhone = supContactsPhone;
    }


    /**
     * Gets the supplierCode value for this MerchandiseIntention.
     * 
     * @return supplierCode
     */
    public String getSupplierCode() {
        return supplierCode;
    }


    /**
     * Sets the supplierCode value for this MerchandiseIntention.
     * 
     * @param supplierCode
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }


    /**
     * Gets the supplierName value for this MerchandiseIntention.
     * 
     * @return supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }


    /**
     * Sets the supplierName value for this MerchandiseIntention.
     * 
     * @param supplierName
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }


    /**
     * Gets the visitApplicationLink value for this MerchandiseIntention.
     * 
     * @return visitApplicationLink
     */
    public String getVisitApplicationLink() {
        return visitApplicationLink;
    }


    /**
     * Sets the visitApplicationLink value for this MerchandiseIntention.
     * 
     * @param visitApplicationLink
     */
    public void setVisitApplicationLink(String visitApplicationLink) {
        this.visitApplicationLink = visitApplicationLink;
    }


    /**
     * Gets the visitApplicationStatus value for this MerchandiseIntention.
     * 
     * @return visitApplicationStatus
     */
    public String getVisitApplicationStatus() {
        return visitApplicationStatus;
    }


    /**
     * Sets the visitApplicationStatus value for this MerchandiseIntention.
     * 
     * @param visitApplicationStatus
     */
    public void setVisitApplicationStatus(String visitApplicationStatus) {
        this.visitApplicationStatus = visitApplicationStatus;
    }


    /**
     * Gets the visitApplicationStatusName value for this MerchandiseIntention.
     * 
     * @return visitApplicationStatusName
     */
    public String getVisitApplicationStatusName() {
        return visitApplicationStatusName;
    }


    /**
     * Sets the visitApplicationStatusName value for this MerchandiseIntention.
     * 
     * @param visitApplicationStatusName
     */
    public void setVisitApplicationStatusName(String visitApplicationStatusName) {
        this.visitApplicationStatusName = visitApplicationStatusName;
    }


    /**
     * Gets the xcsqDate value for this MerchandiseIntention.
     * 
     * @return xcsqDate
     */
    public java.util.Calendar getXcsqDate() {
        return xcsqDate;
    }


    /**
     * Sets the xcsqDate value for this MerchandiseIntention.
     * 
     * @param xcsqDate
     */
    public void setXcsqDate(java.util.Calendar xcsqDate) {
        this.xcsqDate = xcsqDate;
    }


    /**
     * Gets the xcsqshtgBzDay value for this MerchandiseIntention.
     * 
     * @return xcsqshtgBzDay
     */
    public Integer getXcsqshtgBzDay() {
        return xcsqshtgBzDay;
    }


    /**
     * Sets the xcsqshtgBzDay value for this MerchandiseIntention.
     * 
     * @param xcsqshtgBzDay
     */
    public void setXcsqshtgBzDay(Integer xcsqshtgBzDay) {
        this.xcsqshtgBzDay = xcsqshtgBzDay;
    }


    /**
     * Gets the xcsqshtgDate value for this MerchandiseIntention.
     * 
     * @return xcsqshtgDate
     */
    public java.util.Calendar getXcsqshtgDate() {
        return xcsqshtgDate;
    }


    /**
     * Sets the xcsqshtgDate value for this MerchandiseIntention.
     * 
     * @param xcsqshtgDate
     */
    public void setXcsqshtgDate(java.util.Calendar xcsqshtgDate) {
        this.xcsqshtgDate = xcsqshtgDate;
    }


    /**
     * Gets the xcsqshtgSjDay value for this MerchandiseIntention.
     * 
     * @return xcsqshtgSjDay
     */
    public Integer getXcsqshtgSjDay() {
        return xcsqshtgSjDay;
    }


    /**
     * Sets the xcsqshtgSjDay value for this MerchandiseIntention.
     * 
     * @param xcsqshtgSjDay
     */
    public void setXcsqshtgSjDay(Integer xcsqshtgSjDay) {
        this.xcsqshtgSjDay = xcsqshtgSjDay;
    }


    /**
     * Gets the xcsqshtgStatus value for this MerchandiseIntention.
     * 
     * @return xcsqshtgStatus
     */
    public Integer getXcsqshtgStatus() {
        return xcsqshtgStatus;
    }


    /**
     * Sets the xcsqshtgStatus value for this MerchandiseIntention.
     * 
     * @param xcsqshtgStatus
     */
    public void setXcsqshtgStatus(Integer xcsqshtgStatus) {
        this.xcsqshtgStatus = xcsqshtgStatus;
    }


    /**
     * Gets the xcsqtjBzDay value for this MerchandiseIntention.
     * 
     * @return xcsqtjBzDay
     */
    public Integer getXcsqtjBzDay() {
        return xcsqtjBzDay;
    }


    /**
     * Sets the xcsqtjBzDay value for this MerchandiseIntention.
     * 
     * @param xcsqtjBzDay
     */
    public void setXcsqtjBzDay(Integer xcsqtjBzDay) {
        this.xcsqtjBzDay = xcsqtjBzDay;
    }


    /**
     * Gets the xcsqtjDate value for this MerchandiseIntention.
     * 
     * @return xcsqtjDate
     */
    public java.util.Calendar getXcsqtjDate() {
        return xcsqtjDate;
    }


    /**
     * Sets the xcsqtjDate value for this MerchandiseIntention.
     * 
     * @param xcsqtjDate
     */
    public void setXcsqtjDate(java.util.Calendar xcsqtjDate) {
        this.xcsqtjDate = xcsqtjDate;
    }


    /**
     * Gets the xcsqtjSjDay value for this MerchandiseIntention.
     * 
     * @return xcsqtjSjDay
     */
    public Integer getXcsqtjSjDay() {
        return xcsqtjSjDay;
    }


    /**
     * Sets the xcsqtjSjDay value for this MerchandiseIntention.
     * 
     * @param xcsqtjSjDay
     */
    public void setXcsqtjSjDay(Integer xcsqtjSjDay) {
        this.xcsqtjSjDay = xcsqtjSjDay;
    }


    /**
     * Gets the xcsqtjStatus value for this MerchandiseIntention.
     * 
     * @return xcsqtjStatus
     */
    public Integer getXcsqtjStatus() {
        return xcsqtjStatus;
    }


    /**
     * Sets the xcsqtjStatus value for this MerchandiseIntention.
     * 
     * @param xcsqtjStatus
     */
    public void setXcsqtjStatus(Integer xcsqtjStatus) {
        this.xcsqtjStatus = xcsqtjStatus;
    }


    /**
     * Gets the xpffBzDay value for this MerchandiseIntention.
     * 
     * @return xpffBzDay
     */
    public Integer getXpffBzDay() {
        return xpffBzDay;
    }


    /**
     * Sets the xpffBzDay value for this MerchandiseIntention.
     * 
     * @param xpffBzDay
     */
    public void setXpffBzDay(Integer xpffBzDay) {
        this.xpffBzDay = xpffBzDay;
    }


    /**
     * Gets the xpffDate value for this MerchandiseIntention.
     * 
     * @return xpffDate
     */
    public java.util.Calendar getXpffDate() {
        return xpffDate;
    }


    /**
     * Sets the xpffDate value for this MerchandiseIntention.
     * 
     * @param xpffDate
     */
    public void setXpffDate(java.util.Calendar xpffDate) {
        this.xpffDate = xpffDate;
    }


    /**
     * Gets the xpffSjDay value for this MerchandiseIntention.
     * 
     * @return xpffSjDay
     */
    public Integer getXpffSjDay() {
        return xpffSjDay;
    }


    /**
     * Sets the xpffSjDay value for this MerchandiseIntention.
     * 
     * @param xpffSjDay
     */
    public void setXpffSjDay(Integer xpffSjDay) {
        this.xpffSjDay = xpffSjDay;
    }


    /**
     * Gets the xpffStatus value for this MerchandiseIntention.
     * 
     * @return xpffStatus
     */
    public Integer getXpffStatus() {
        return xpffStatus;
    }


    /**
     * Sets the xpffStatus value for this MerchandiseIntention.
     * 
     * @param xpffStatus
     */
    public void setXpffStatus(Integer xpffStatus) {
        this.xpffStatus = xpffStatus;
    }


    /**
     * Gets the xpyjbgsptgBzDay value for this MerchandiseIntention.
     * 
     * @return xpyjbgsptgBzDay
     */
    public Integer getXpyjbgsptgBzDay() {
        return xpyjbgsptgBzDay;
    }


    /**
     * Sets the xpyjbgsptgBzDay value for this MerchandiseIntention.
     * 
     * @param xpyjbgsptgBzDay
     */
    public void setXpyjbgsptgBzDay(Integer xpyjbgsptgBzDay) {
        this.xpyjbgsptgBzDay = xpyjbgsptgBzDay;
    }


    /**
     * Gets the xpyjbgsptgDate value for this MerchandiseIntention.
     * 
     * @return xpyjbgsptgDate
     */
    public java.util.Calendar getXpyjbgsptgDate() {
        return xpyjbgsptgDate;
    }


    /**
     * Sets the xpyjbgsptgDate value for this MerchandiseIntention.
     * 
     * @param xpyjbgsptgDate
     */
    public void setXpyjbgsptgDate(java.util.Calendar xpyjbgsptgDate) {
        this.xpyjbgsptgDate = xpyjbgsptgDate;
    }


    /**
     * Gets the xpyjbgsptgSjDay value for this MerchandiseIntention.
     * 
     * @return xpyjbgsptgSjDay
     */
    public Integer getXpyjbgsptgSjDay() {
        return xpyjbgsptgSjDay;
    }


    /**
     * Sets the xpyjbgsptgSjDay value for this MerchandiseIntention.
     * 
     * @param xpyjbgsptgSjDay
     */
    public void setXpyjbgsptgSjDay(Integer xpyjbgsptgSjDay) {
        this.xpyjbgsptgSjDay = xpyjbgsptgSjDay;
    }


    /**
     * Gets the xpyjbgsptgStatus value for this MerchandiseIntention.
     * 
     * @return xpyjbgsptgStatus
     */
    public Integer getXpyjbgsptgStatus() {
        return xpyjbgsptgStatus;
    }


    /**
     * Sets the xpyjbgsptgStatus value for this MerchandiseIntention.
     * 
     * @param xpyjbgsptgStatus
     */
    public void setXpyjbgsptgStatus(Integer xpyjbgsptgStatus) {
        this.xpyjbgsptgStatus = xpyjbgsptgStatus;
    }


    /**
     * Gets the xpyjbgtjBzDay value for this MerchandiseIntention.
     * 
     * @return xpyjbgtjBzDay
     */
    public Integer getXpyjbgtjBzDay() {
        return xpyjbgtjBzDay;
    }


    /**
     * Sets the xpyjbgtjBzDay value for this MerchandiseIntention.
     * 
     * @param xpyjbgtjBzDay
     */
    public void setXpyjbgtjBzDay(Integer xpyjbgtjBzDay) {
        this.xpyjbgtjBzDay = xpyjbgtjBzDay;
    }


    /**
     * Gets the xpyjbgtjDate value for this MerchandiseIntention.
     * 
     * @return xpyjbgtjDate
     */
    public java.util.Calendar getXpyjbgtjDate() {
        return xpyjbgtjDate;
    }


    /**
     * Sets the xpyjbgtjDate value for this MerchandiseIntention.
     * 
     * @param xpyjbgtjDate
     */
    public void setXpyjbgtjDate(java.util.Calendar xpyjbgtjDate) {
        this.xpyjbgtjDate = xpyjbgtjDate;
    }


    /**
     * Gets the xpyjbgtjSjDay value for this MerchandiseIntention.
     * 
     * @return xpyjbgtjSjDay
     */
    public Integer getXpyjbgtjSjDay() {
        return xpyjbgtjSjDay;
    }


    /**
     * Sets the xpyjbgtjSjDay value for this MerchandiseIntention.
     * 
     * @param xpyjbgtjSjDay
     */
    public void setXpyjbgtjSjDay(Integer xpyjbgtjSjDay) {
        this.xpyjbgtjSjDay = xpyjbgtjSjDay;
    }


    /**
     * Gets the xpyjbgtjStatus value for this MerchandiseIntention.
     * 
     * @return xpyjbgtjStatus
     */
    public Integer getXpyjbgtjStatus() {
        return xpyjbgtjStatus;
    }


    /**
     * Sets the xpyjbgtjStatus value for this MerchandiseIntention.
     * 
     * @param xpyjbgtjStatus
     */
    public void setXpyjbgtjStatus(Integer xpyjbgtjStatus) {
        this.xpyjbgtjStatus = xpyjbgtjStatus;
    }


    /**
     * Gets the yjbgtjDate value for this MerchandiseIntention.
     * 
     * @return yjbgtjDate
     */
    public java.util.Calendar getYjbgtjDate() {
        return yjbgtjDate;
    }


    /**
     * Sets the yjbgtjDate value for this MerchandiseIntention.
     * 
     * @param yjbgtjDate
     */
    public void setYjbgtjDate(java.util.Calendar yjbgtjDate) {
        this.yjbgtjDate = yjbgtjDate;
    }


    /**
     * Gets the yjbgwcDate value for this MerchandiseIntention.
     * 
     * @return yjbgwcDate
     */
    public java.util.Calendar getYjbgwcDate() {
        return yjbgwcDate;
    }


    /**
     * Sets the yjbgwcDate value for this MerchandiseIntention.
     * 
     * @param yjbgwcDate
     */
    public void setYjbgwcDate(java.util.Calendar yjbgwcDate) {
        this.yjbgwcDate = yjbgwcDate;
    }


    /**
     * Gets the zsjsqDate value for this MerchandiseIntention.
     * 
     * @return zsjsqDate
     */
    public java.util.Calendar getZsjsqDate() {
        return zsjsqDate;
    }


    /**
     * Sets the zsjsqDate value for this MerchandiseIntention.
     * 
     * @param zsjsqDate
     */
    public void setZsjsqDate(java.util.Calendar zsjsqDate) {
        this.zsjsqDate = zsjsqDate;
    }


    /**
     * Gets the zsjsqsptgBzDay value for this MerchandiseIntention.
     * 
     * @return zsjsqsptgBzDay
     */
    public Integer getZsjsqsptgBzDay() {
        return zsjsqsptgBzDay;
    }


    /**
     * Sets the zsjsqsptgBzDay value for this MerchandiseIntention.
     * 
     * @param zsjsqsptgBzDay
     */
    public void setZsjsqsptgBzDay(Integer zsjsqsptgBzDay) {
        this.zsjsqsptgBzDay = zsjsqsptgBzDay;
    }


    /**
     * Gets the zsjsqsptgDate value for this MerchandiseIntention.
     * 
     * @return zsjsqsptgDate
     */
    public java.util.Calendar getZsjsqsptgDate() {
        return zsjsqsptgDate;
    }


    /**
     * Sets the zsjsqsptgDate value for this MerchandiseIntention.
     * 
     * @param zsjsqsptgDate
     */
    public void setZsjsqsptgDate(java.util.Calendar zsjsqsptgDate) {
        this.zsjsqsptgDate = zsjsqsptgDate;
    }


    /**
     * Gets the zsjsqsptgSjDay value for this MerchandiseIntention.
     * 
     * @return zsjsqsptgSjDay
     */
    public Integer getZsjsqsptgSjDay() {
        return zsjsqsptgSjDay;
    }


    /**
     * Sets the zsjsqsptgSjDay value for this MerchandiseIntention.
     * 
     * @param zsjsqsptgSjDay
     */
    public void setZsjsqsptgSjDay(Integer zsjsqsptgSjDay) {
        this.zsjsqsptgSjDay = zsjsqsptgSjDay;
    }


    /**
     * Gets the zsjsqsptgStatus value for this MerchandiseIntention.
     * 
     * @return zsjsqsptgStatus
     */
    public Integer getZsjsqsptgStatus() {
        return zsjsqsptgStatus;
    }


    /**
     * Sets the zsjsqsptgStatus value for this MerchandiseIntention.
     * 
     * @param zsjsqsptgStatus
     */
    public void setZsjsqsptgStatus(Integer zsjsqsptgStatus) {
        this.zsjsqsptgStatus = zsjsqsptgStatus;
    }


    /**
     * Gets the zsjsqwcDate value for this MerchandiseIntention.
     * 
     * @return zsjsqwcDate
     */
    public java.util.Calendar getZsjsqwcDate() {
        return zsjsqwcDate;
    }


    /**
     * Sets the zsjsqwcDate value for this MerchandiseIntention.
     * 
     * @param zsjsqwcDate
     */
    public void setZsjsqwcDate(java.util.Calendar zsjsqwcDate) {
        this.zsjsqwcDate = zsjsqwcDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MerchandiseIntention)) return false;
        MerchandiseIntention other = (MerchandiseIntention) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.applicationCode==null && other.getApplicationCode()==null) || 
             (this.applicationCode!=null &&
              this.applicationCode.equals(other.getApplicationCode()))) &&
            ((this.applicationLink==null && other.getApplicationLink()==null) || 
             (this.applicationLink!=null &&
              this.applicationLink.equals(other.getApplicationLink()))) &&
            ((this.applicationStatus==null && other.getApplicationStatus()==null) || 
             (this.applicationStatus!=null &&
              this.applicationStatus.equals(other.getApplicationStatus()))) &&
            ((this.applicationStatusName==null && other.getApplicationStatusName()==null) || 
             (this.applicationStatusName!=null &&
              this.applicationStatusName.equals(other.getApplicationStatusName()))) &&
            ((this.bbtgDate==null && other.getBbtgDate()==null) || 
             (this.bbtgDate!=null &&
              this.bbtgDate.equals(other.getBbtgDate()))) &&
            ((this.bzDay==null && other.getBzDay()==null) || 
             (this.bzDay!=null &&
              this.bzDay.equals(other.getBzDay()))) &&
            ((this.bzsjcgqrBzDay==null && other.getBzsjcgqrBzDay()==null) || 
             (this.bzsjcgqrBzDay!=null &&
              this.bzsjcgqrBzDay.equals(other.getBzsjcgqrBzDay()))) &&
            ((this.bzsjcgqrDate==null && other.getBzsjcgqrDate()==null) || 
             (this.bzsjcgqrDate!=null &&
              this.bzsjcgqrDate.equals(other.getBzsjcgqrDate()))) &&
            ((this.bzsjcgqrSjDay==null && other.getBzsjcgqrSjDay()==null) || 
             (this.bzsjcgqrSjDay!=null &&
              this.bzsjcgqrSjDay.equals(other.getBzsjcgqrSjDay()))) &&
            ((this.bzsjcgqrStatus==null && other.getBzsjcgqrStatus()==null) || 
             (this.bzsjcgqrStatus!=null &&
              this.bzsjcgqrStatus.equals(other.getBzsjcgqrStatus()))) &&
            ((this.bzsjsqBzDay==null && other.getBzsjsqBzDay()==null) || 
             (this.bzsjsqBzDay!=null &&
              this.bzsjsqBzDay.equals(other.getBzsjsqBzDay()))) &&
            ((this.bzsjsqDate==null && other.getBzsjsqDate()==null) || 
             (this.bzsjsqDate!=null &&
              this.bzsjsqDate.equals(other.getBzsjsqDate()))) &&
            ((this.bzsjsqSjDay==null && other.getBzsjsqSjDay()==null) || 
             (this.bzsjsqSjDay!=null &&
              this.bzsjsqSjDay.equals(other.getBzsjsqSjDay()))) &&
            ((this.bzsjsqStatus==null && other.getBzsjsqStatus()==null) || 
             (this.bzsjsqStatus!=null &&
              this.bzsjsqStatus.equals(other.getBzsjsqStatus()))) &&
            ((this.bzsjsqwcBzDay==null && other.getBzsjsqwcBzDay()==null) || 
             (this.bzsjsqwcBzDay!=null &&
              this.bzsjsqwcBzDay.equals(other.getBzsjsqwcBzDay()))) &&
            ((this.bzsjsqwcDate==null && other.getBzsjsqwcDate()==null) || 
             (this.bzsjsqwcDate!=null &&
              this.bzsjsqwcDate.equals(other.getBzsjsqwcDate()))) &&
            ((this.bzsjsqwcSjDay==null && other.getBzsjsqwcSjDay()==null) || 
             (this.bzsjsqwcSjDay!=null &&
              this.bzsjsqwcSjDay.equals(other.getBzsjsqwcSjDay()))) &&
            ((this.bzsjsqwcStatus==null && other.getBzsjsqwcStatus()==null) || 
             (this.bzsjsqwcStatus!=null &&
              this.bzsjsqwcStatus.equals(other.getBzsjsqwcStatus()))) &&
            ((this.bzsjwgtgDate==null && other.getBzsjwgtgDate()==null) || 
             (this.bzsjwgtgDate!=null &&
              this.bzsjwgtgDate.equals(other.getBzsjwgtgDate()))) &&
            ((this.bzsjwgtgStatus==null && other.getBzsjwgtgStatus()==null) || 
             (this.bzsjwgtgStatus!=null &&
              this.bzsjwgtgStatus.equals(other.getBzsjwgtgStatus()))) &&
            ((this.centreTypeCode==null && other.getCentreTypeCode()==null) || 
             (this.centreTypeCode!=null &&
              this.centreTypeCode.equals(other.getCentreTypeCode()))) &&
            ((this.centreTypeName==null && other.getCentreTypeName()==null) || 
             (this.centreTypeName!=null &&
              this.centreTypeName.equals(other.getCentreTypeName()))) &&
            ((this.deliveryType==null && other.getDeliveryType()==null) || 
             (this.deliveryType!=null &&
              this.deliveryType.equals(other.getDeliveryType()))) &&
            ((this.detailTypeCode==null && other.getDetailTypeCode()==null) || 
             (this.detailTypeCode!=null &&
              this.detailTypeCode.equals(other.getDetailTypeCode()))) &&
            ((this.detailTypeName==null && other.getDetailTypeName()==null) || 
             (this.detailTypeName!=null &&
              this.detailTypeName.equals(other.getDetailTypeName()))) &&
            ((this.dlRoleCode==null && other.getDlRoleCode()==null) || 
             (this.dlRoleCode!=null &&
              this.dlRoleCode.equals(other.getDlRoleCode()))) &&
            ((this.dlRoleName==null && other.getDlRoleName()==null) || 
             (this.dlRoleName!=null &&
              this.dlRoleName.equals(other.getDlRoleName()))) &&
            ((this.dxRoleCode==null && other.getDxRoleCode()==null) || 
             (this.dxRoleCode!=null &&
              this.dxRoleCode.equals(other.getDxRoleCode()))) &&
            ((this.dxRoleName==null && other.getDxRoleName()==null) || 
             (this.dxRoleName!=null &&
              this.dxRoleName.equals(other.getDxRoleName()))) &&
            ((this.dyqrDate==null && other.getDyqrDate()==null) || 
             (this.dyqrDate!=null &&
              this.dyqrDate.equals(other.getDyqrDate()))) &&
            ((this.elseTypeName==null && other.getElseTypeName()==null) || 
             (this.elseTypeName!=null &&
              this.elseTypeName.equals(other.getElseTypeName()))) &&
            ((this.enquiryDate==null && other.getEnquiryDate()==null) || 
             (this.enquiryDate!=null &&
              this.enquiryDate.equals(other.getEnquiryDate()))) &&
            ((this.evaluate==null && other.getEvaluate()==null) || 
             (this.evaluate!=null &&
              this.evaluate.equals(other.getEvaluate()))) &&
            ((this.fineTypeCode==null && other.getFineTypeCode()==null) || 
             (this.fineTypeCode!=null &&
              this.fineTypeCode.equals(other.getFineTypeCode()))) &&
            ((this.fineTypeName==null && other.getFineTypeName()==null) || 
             (this.fineTypeName!=null &&
              this.fineTypeName.equals(other.getFineTypeName()))) &&
            ((this.foretasteDate==null && other.getForetasteDate()==null) || 
             (this.foretasteDate!=null &&
              this.foretasteDate.equals(other.getForetasteDate()))) &&
            ((this.foretasteGrade==null && other.getForetasteGrade()==null) || 
             (this.foretasteGrade!=null &&
              this.foretasteGrade.equals(other.getForetasteGrade()))) &&
            ((this.foretastePassDate==null && other.getForetastePassDate()==null) || 
             (this.foretastePassDate!=null &&
              this.foretastePassDate.equals(other.getForetastePassDate()))) &&
            ((this.gyssdgpDate==null && other.getGyssdgpDate()==null) || 
             (this.gyssdgpDate!=null &&
              this.gyssdgpDate.equals(other.getGyssdgpDate()))) &&
            ((this.gzysqrDate==null && other.getGzysqrDate()==null) || 
             (this.gzysqrDate!=null &&
              this.gzysqrDate.equals(other.getGzysqrDate()))) &&
            ((this.htqdDate==null && other.getHtqdDate()==null) || 
             (this.htqdDate!=null &&
              this.htqdDate.equals(other.getHtqdDate()))) &&
            ((this.intentionCode==null && other.getIntentionCode()==null) || 
             (this.intentionCode!=null &&
              this.intentionCode.equals(other.getIntentionCode()))) &&
            ((this.intentionName==null && other.getIntentionName()==null) || 
             (this.intentionName!=null &&
              this.intentionName.equals(other.getIntentionName()))) &&
            ((this.intentionSapCode==null && other.getIntentionSapCode()==null) || 
             (this.intentionSapCode!=null &&
              this.intentionSapCode.equals(other.getIntentionSapCode()))) &&
            ((this.intentionSupplierCode==null && other.getIntentionSupplierCode()==null) || 
             (this.intentionSupplierCode!=null &&
              this.intentionSupplierCode.equals(other.getIntentionSupplierCode()))) &&
            ((this.intentionSupplierName==null && other.getIntentionSupplierName()==null) || 
             (this.intentionSupplierName!=null &&
              this.intentionSupplierName.equals(other.getIntentionSupplierName()))) &&
            ((this.isForetastePass==null && other.getIsForetastePass()==null) || 
             (this.isForetastePass!=null &&
              this.isForetastePass.equals(other.getIsForetastePass()))) &&
            ((this.isTrueMerchandise==null && other.getIsTrueMerchandise()==null) || 
             (this.isTrueMerchandise!=null &&
              this.isTrueMerchandise.equals(other.getIsTrueMerchandise()))) &&
            ((this.jlbzsjcgqrBzDay==null && other.getJlbzsjcgqrBzDay()==null) || 
             (this.jlbzsjcgqrBzDay!=null &&
              this.jlbzsjcgqrBzDay.equals(other.getJlbzsjcgqrBzDay()))) &&
            ((this.jlbzsjcgqrSjDay==null && other.getJlbzsjcgqrSjDay()==null) || 
             (this.jlbzsjcgqrSjDay!=null &&
              this.jlbzsjcgqrSjDay.equals(other.getJlbzsjcgqrSjDay()))) &&
            ((this.jlwlzsjsqsptgBzDay==null && other.getJlwlzsjsqsptgBzDay()==null) || 
             (this.jlwlzsjsqsptgBzDay!=null &&
              this.jlwlzsjsqsptgBzDay.equals(other.getJlwlzsjsqsptgBzDay()))) &&
            ((this.jlwlzsjsqsptgSjDay==null && other.getJlwlzsjsqsptgSjDay()==null) || 
             (this.jlwlzsjsqsptgSjDay!=null &&
              this.jlwlzsjsqsptgSjDay.equals(other.getJlwlzsjsqsptgSjDay()))) &&
            ((this.merchandiseCode==null && other.getMerchandiseCode()==null) || 
             (this.merchandiseCode!=null &&
              this.merchandiseCode.equals(other.getMerchandiseCode()))) &&
            ((this.merchandiseName==null && other.getMerchandiseName()==null) || 
             (this.merchandiseName!=null &&
              this.merchandiseName.equals(other.getMerchandiseName()))) &&
            ((this.oaApplicationCode==null && other.getOaApplicationCode()==null) || 
             (this.oaApplicationCode!=null &&
              this.oaApplicationCode.equals(other.getOaApplicationCode()))) &&
            ((this.oaApplicationDate==null && other.getOaApplicationDate()==null) || 
             (this.oaApplicationDate!=null &&
              this.oaApplicationDate.equals(other.getOaApplicationDate()))) &&
            ((this.oaApplicationName==null && other.getOaApplicationName()==null) || 
             (this.oaApplicationName!=null &&
              this.oaApplicationName.equals(other.getOaApplicationName()))) &&
            ((this.oaContacts==null && other.getOaContacts()==null) || 
             (this.oaContacts!=null &&
              this.oaContacts.equals(other.getOaContacts()))) &&
            ((this.orderType==null && other.getOrderType()==null) || 
             (this.orderType!=null &&
              this.orderType.equals(other.getOrderType()))) &&
            ((this.packageApplicationLink==null && other.getPackageApplicationLink()==null) || 
             (this.packageApplicationLink!=null &&
              this.packageApplicationLink.equals(other.getPackageApplicationLink()))) &&
            ((this.packageApplicationStatus==null && other.getPackageApplicationStatus()==null) || 
             (this.packageApplicationStatus!=null &&
              this.packageApplicationStatus.equals(other.getPackageApplicationStatus()))) &&
            ((this.packageApplicationStatusName==null && other.getPackageApplicationStatusName()==null) || 
             (this.packageApplicationStatusName!=null &&
              this.packageApplicationStatusName.equals(other.getPackageApplicationStatusName()))) &&
            ((this.packingType==null && other.getPackingType()==null) || 
             (this.packingType!=null &&
              this.packingType.equals(other.getPackingType()))) &&
            ((this.paymentType==null && other.getPaymentType()==null) || 
             (this.paymentType!=null &&
              this.paymentType.equals(other.getPaymentType()))) &&
            ((this.pksjxcBzDay==null && other.getPksjxcBzDay()==null) || 
             (this.pksjxcBzDay!=null &&
              this.pksjxcBzDay.equals(other.getPksjxcBzDay()))) &&
            ((this.pksjxcDate==null && other.getPksjxcDate()==null) || 
             (this.pksjxcDate!=null &&
              this.pksjxcDate.equals(other.getPksjxcDate()))) &&
            ((this.pksjxcSjDay==null && other.getPksjxcSjDay()==null) || 
             (this.pksjxcSjDay!=null &&
              this.pksjxcSjDay.equals(other.getPksjxcSjDay()))) &&
            ((this.pksjxcStatus==null && other.getPksjxcStatus()==null) || 
             (this.pksjxcStatus!=null &&
              this.pksjxcStatus.equals(other.getPksjxcStatus()))) &&
            ((this.pkxcDate==null && other.getPkxcDate()==null) || 
             (this.pkxcDate!=null &&
              this.pkxcDate.equals(other.getPkxcDate()))) &&
            ((this.purchaseDepartments==null && other.getPurchaseDepartments()==null) || 
             (this.purchaseDepartments!=null &&
              this.purchaseDepartments.equals(other.getPurchaseDepartments()))) &&
            ((this.purchaseDepartmentsName==null && other.getPurchaseDepartmentsName()==null) || 
             (this.purchaseDepartmentsName!=null &&
              this.purchaseDepartmentsName.equals(other.getPurchaseDepartmentsName()))) &&
            ((this.purchaseType==null && other.getPurchaseType()==null) || 
             (this.purchaseType!=null &&
              this.purchaseType.equals(other.getPurchaseType()))) &&
            ((this.purchaseTypeName==null && other.getPurchaseTypeName()==null) || 
             (this.purchaseTypeName!=null &&
              this.purchaseTypeName.equals(other.getPurchaseTypeName()))) &&
            ((this.qdgpDate==null && other.getQdgpDate()==null) || 
             (this.qdgpDate!=null &&
              this.qdgpDate.equals(other.getQdgpDate()))) &&
            ((this.quotedCurrency==null && other.getQuotedCurrency()==null) || 
             (this.quotedCurrency!=null &&
              this.quotedCurrency.equals(other.getQuotedCurrency()))) &&
            ((this.quotedDate==null && other.getQuotedDate()==null) || 
             (this.quotedDate!=null &&
              this.quotedDate.equals(other.getQuotedDate()))) &&
            ((this.rationed==null && other.getRationed()==null) || 
             (this.rationed!=null &&
              this.rationed.equals(other.getRationed()))) &&
            ((this.rationedName==null && other.getRationedName()==null) || 
             (this.rationedName!=null &&
              this.rationedName.equals(other.getRationedName()))) &&
            ((this.saleType==null && other.getSaleType()==null) || 
             (this.saleType!=null &&
              this.saleType.equals(other.getSaleType()))) &&
            ((this.sctgBzDay==null && other.getSctgBzDay()==null) || 
             (this.sctgBzDay!=null &&
              this.sctgBzDay.equals(other.getSctgBzDay()))) &&
            ((this.sctgSjDay==null && other.getSctgSjDay()==null) || 
             (this.sctgSjDay!=null &&
              this.sctgSjDay.equals(other.getSctgSjDay()))) &&
            ((this.sjDay==null && other.getSjDay()==null) || 
             (this.sjDay!=null &&
              this.sjDay.equals(other.getSjDay()))) &&
            ((this.smallTypeCode==null && other.getSmallTypeCode()==null) || 
             (this.smallTypeCode!=null &&
              this.smallTypeCode.equals(other.getSmallTypeCode()))) &&
            ((this.smallTypeName==null && other.getSmallTypeName()==null) || 
             (this.smallTypeName!=null &&
              this.smallTypeName.equals(other.getSmallTypeName()))) &&
            ((this.spdddcDate==null && other.getSpdddcDate()==null) || 
             (this.spdddcDate!=null &&
              this.spdddcDate.equals(other.getSpdddcDate()))) &&
            ((this.specification==null && other.getSpecification()==null) || 
             (this.specification!=null &&
              this.specification.equals(other.getSpecification()))) &&
            ((this.ssDate==null && other.getSsDate()==null) || 
             (this.ssDate!=null &&
              this.ssDate.equals(other.getSsDate()))) &&
            ((this.supCompanySite==null && other.getSupCompanySite()==null) || 
             (this.supCompanySite!=null &&
              this.supCompanySite.equals(other.getSupCompanySite()))) &&
            ((this.supContacts==null && other.getSupContacts()==null) || 
             (this.supContacts!=null &&
              this.supContacts.equals(other.getSupContacts()))) &&
            ((this.supContactsPhone==null && other.getSupContactsPhone()==null) || 
             (this.supContactsPhone!=null &&
              this.supContactsPhone.equals(other.getSupContactsPhone()))) &&
            ((this.supplierCode==null && other.getSupplierCode()==null) || 
             (this.supplierCode!=null &&
              this.supplierCode.equals(other.getSupplierCode()))) &&
            ((this.supplierName==null && other.getSupplierName()==null) || 
             (this.supplierName!=null &&
              this.supplierName.equals(other.getSupplierName()))) &&
            ((this.visitApplicationLink==null && other.getVisitApplicationLink()==null) || 
             (this.visitApplicationLink!=null &&
              this.visitApplicationLink.equals(other.getVisitApplicationLink()))) &&
            ((this.visitApplicationStatus==null && other.getVisitApplicationStatus()==null) || 
             (this.visitApplicationStatus!=null &&
              this.visitApplicationStatus.equals(other.getVisitApplicationStatus()))) &&
            ((this.visitApplicationStatusName==null && other.getVisitApplicationStatusName()==null) || 
             (this.visitApplicationStatusName!=null &&
              this.visitApplicationStatusName.equals(other.getVisitApplicationStatusName()))) &&
            ((this.xcsqDate==null && other.getXcsqDate()==null) || 
             (this.xcsqDate!=null &&
              this.xcsqDate.equals(other.getXcsqDate()))) &&
            ((this.xcsqshtgBzDay==null && other.getXcsqshtgBzDay()==null) || 
             (this.xcsqshtgBzDay!=null &&
              this.xcsqshtgBzDay.equals(other.getXcsqshtgBzDay()))) &&
            ((this.xcsqshtgDate==null && other.getXcsqshtgDate()==null) || 
             (this.xcsqshtgDate!=null &&
              this.xcsqshtgDate.equals(other.getXcsqshtgDate()))) &&
            ((this.xcsqshtgSjDay==null && other.getXcsqshtgSjDay()==null) || 
             (this.xcsqshtgSjDay!=null &&
              this.xcsqshtgSjDay.equals(other.getXcsqshtgSjDay()))) &&
            ((this.xcsqshtgStatus==null && other.getXcsqshtgStatus()==null) || 
             (this.xcsqshtgStatus!=null &&
              this.xcsqshtgStatus.equals(other.getXcsqshtgStatus()))) &&
            ((this.xcsqtjBzDay==null && other.getXcsqtjBzDay()==null) || 
             (this.xcsqtjBzDay!=null &&
              this.xcsqtjBzDay.equals(other.getXcsqtjBzDay()))) &&
            ((this.xcsqtjDate==null && other.getXcsqtjDate()==null) || 
             (this.xcsqtjDate!=null &&
              this.xcsqtjDate.equals(other.getXcsqtjDate()))) &&
            ((this.xcsqtjSjDay==null && other.getXcsqtjSjDay()==null) || 
             (this.xcsqtjSjDay!=null &&
              this.xcsqtjSjDay.equals(other.getXcsqtjSjDay()))) &&
            ((this.xcsqtjStatus==null && other.getXcsqtjStatus()==null) || 
             (this.xcsqtjStatus!=null &&
              this.xcsqtjStatus.equals(other.getXcsqtjStatus()))) &&
            ((this.xpffBzDay==null && other.getXpffBzDay()==null) || 
             (this.xpffBzDay!=null &&
              this.xpffBzDay.equals(other.getXpffBzDay()))) &&
            ((this.xpffDate==null && other.getXpffDate()==null) || 
             (this.xpffDate!=null &&
              this.xpffDate.equals(other.getXpffDate()))) &&
            ((this.xpffSjDay==null && other.getXpffSjDay()==null) || 
             (this.xpffSjDay!=null &&
              this.xpffSjDay.equals(other.getXpffSjDay()))) &&
            ((this.xpffStatus==null && other.getXpffStatus()==null) || 
             (this.xpffStatus!=null &&
              this.xpffStatus.equals(other.getXpffStatus()))) &&
            ((this.xpyjbgsptgBzDay==null && other.getXpyjbgsptgBzDay()==null) || 
             (this.xpyjbgsptgBzDay!=null &&
              this.xpyjbgsptgBzDay.equals(other.getXpyjbgsptgBzDay()))) &&
            ((this.xpyjbgsptgDate==null && other.getXpyjbgsptgDate()==null) || 
             (this.xpyjbgsptgDate!=null &&
              this.xpyjbgsptgDate.equals(other.getXpyjbgsptgDate()))) &&
            ((this.xpyjbgsptgSjDay==null && other.getXpyjbgsptgSjDay()==null) || 
             (this.xpyjbgsptgSjDay!=null &&
              this.xpyjbgsptgSjDay.equals(other.getXpyjbgsptgSjDay()))) &&
            ((this.xpyjbgsptgStatus==null && other.getXpyjbgsptgStatus()==null) || 
             (this.xpyjbgsptgStatus!=null &&
              this.xpyjbgsptgStatus.equals(other.getXpyjbgsptgStatus()))) &&
            ((this.xpyjbgtjBzDay==null && other.getXpyjbgtjBzDay()==null) || 
             (this.xpyjbgtjBzDay!=null &&
              this.xpyjbgtjBzDay.equals(other.getXpyjbgtjBzDay()))) &&
            ((this.xpyjbgtjDate==null && other.getXpyjbgtjDate()==null) || 
             (this.xpyjbgtjDate!=null &&
              this.xpyjbgtjDate.equals(other.getXpyjbgtjDate()))) &&
            ((this.xpyjbgtjSjDay==null && other.getXpyjbgtjSjDay()==null) || 
             (this.xpyjbgtjSjDay!=null &&
              this.xpyjbgtjSjDay.equals(other.getXpyjbgtjSjDay()))) &&
            ((this.xpyjbgtjStatus==null && other.getXpyjbgtjStatus()==null) || 
             (this.xpyjbgtjStatus!=null &&
              this.xpyjbgtjStatus.equals(other.getXpyjbgtjStatus()))) &&
            ((this.yjbgtjDate==null && other.getYjbgtjDate()==null) || 
             (this.yjbgtjDate!=null &&
              this.yjbgtjDate.equals(other.getYjbgtjDate()))) &&
            ((this.yjbgwcDate==null && other.getYjbgwcDate()==null) || 
             (this.yjbgwcDate!=null &&
              this.yjbgwcDate.equals(other.getYjbgwcDate()))) &&
            ((this.zsjsqDate==null && other.getZsjsqDate()==null) || 
             (this.zsjsqDate!=null &&
              this.zsjsqDate.equals(other.getZsjsqDate()))) &&
            ((this.zsjsqsptgBzDay==null && other.getZsjsqsptgBzDay()==null) || 
             (this.zsjsqsptgBzDay!=null &&
              this.zsjsqsptgBzDay.equals(other.getZsjsqsptgBzDay()))) &&
            ((this.zsjsqsptgDate==null && other.getZsjsqsptgDate()==null) || 
             (this.zsjsqsptgDate!=null &&
              this.zsjsqsptgDate.equals(other.getZsjsqsptgDate()))) &&
            ((this.zsjsqsptgSjDay==null && other.getZsjsqsptgSjDay()==null) || 
             (this.zsjsqsptgSjDay!=null &&
              this.zsjsqsptgSjDay.equals(other.getZsjsqsptgSjDay()))) &&
            ((this.zsjsqsptgStatus==null && other.getZsjsqsptgStatus()==null) || 
             (this.zsjsqsptgStatus!=null &&
              this.zsjsqsptgStatus.equals(other.getZsjsqsptgStatus()))) &&
            ((this.zsjsqwcDate==null && other.getZsjsqwcDate()==null) || 
             (this.zsjsqwcDate!=null &&
              this.zsjsqwcDate.equals(other.getZsjsqwcDate())));
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
        if (getApplicationCode() != null) {
            _hashCode += getApplicationCode().hashCode();
        }
        if (getApplicationLink() != null) {
            _hashCode += getApplicationLink().hashCode();
        }
        if (getApplicationStatus() != null) {
            _hashCode += getApplicationStatus().hashCode();
        }
        if (getApplicationStatusName() != null) {
            _hashCode += getApplicationStatusName().hashCode();
        }
        if (getBbtgDate() != null) {
            _hashCode += getBbtgDate().hashCode();
        }
        if (getBzDay() != null) {
            _hashCode += getBzDay().hashCode();
        }
        if (getBzsjcgqrBzDay() != null) {
            _hashCode += getBzsjcgqrBzDay().hashCode();
        }
        if (getBzsjcgqrDate() != null) {
            _hashCode += getBzsjcgqrDate().hashCode();
        }
        if (getBzsjcgqrSjDay() != null) {
            _hashCode += getBzsjcgqrSjDay().hashCode();
        }
        if (getBzsjcgqrStatus() != null) {
            _hashCode += getBzsjcgqrStatus().hashCode();
        }
        if (getBzsjsqBzDay() != null) {
            _hashCode += getBzsjsqBzDay().hashCode();
        }
        if (getBzsjsqDate() != null) {
            _hashCode += getBzsjsqDate().hashCode();
        }
        if (getBzsjsqSjDay() != null) {
            _hashCode += getBzsjsqSjDay().hashCode();
        }
        if (getBzsjsqStatus() != null) {
            _hashCode += getBzsjsqStatus().hashCode();
        }
        if (getBzsjsqwcBzDay() != null) {
            _hashCode += getBzsjsqwcBzDay().hashCode();
        }
        if (getBzsjsqwcDate() != null) {
            _hashCode += getBzsjsqwcDate().hashCode();
        }
        if (getBzsjsqwcSjDay() != null) {
            _hashCode += getBzsjsqwcSjDay().hashCode();
        }
        if (getBzsjsqwcStatus() != null) {
            _hashCode += getBzsjsqwcStatus().hashCode();
        }
        if (getBzsjwgtgDate() != null) {
            _hashCode += getBzsjwgtgDate().hashCode();
        }
        if (getBzsjwgtgStatus() != null) {
            _hashCode += getBzsjwgtgStatus().hashCode();
        }
        if (getCentreTypeCode() != null) {
            _hashCode += getCentreTypeCode().hashCode();
        }
        if (getCentreTypeName() != null) {
            _hashCode += getCentreTypeName().hashCode();
        }
        if (getDeliveryType() != null) {
            _hashCode += getDeliveryType().hashCode();
        }
        if (getDetailTypeCode() != null) {
            _hashCode += getDetailTypeCode().hashCode();
        }
        if (getDetailTypeName() != null) {
            _hashCode += getDetailTypeName().hashCode();
        }
        if (getDlRoleCode() != null) {
            _hashCode += getDlRoleCode().hashCode();
        }
        if (getDlRoleName() != null) {
            _hashCode += getDlRoleName().hashCode();
        }
        if (getDxRoleCode() != null) {
            _hashCode += getDxRoleCode().hashCode();
        }
        if (getDxRoleName() != null) {
            _hashCode += getDxRoleName().hashCode();
        }
        if (getDyqrDate() != null) {
            _hashCode += getDyqrDate().hashCode();
        }
        if (getElseTypeName() != null) {
            _hashCode += getElseTypeName().hashCode();
        }
        if (getEnquiryDate() != null) {
            _hashCode += getEnquiryDate().hashCode();
        }
        if (getEvaluate() != null) {
            _hashCode += getEvaluate().hashCode();
        }
        if (getFineTypeCode() != null) {
            _hashCode += getFineTypeCode().hashCode();
        }
        if (getFineTypeName() != null) {
            _hashCode += getFineTypeName().hashCode();
        }
        if (getForetasteDate() != null) {
            _hashCode += getForetasteDate().hashCode();
        }
        if (getForetasteGrade() != null) {
            _hashCode += getForetasteGrade().hashCode();
        }
        if (getForetastePassDate() != null) {
            _hashCode += getForetastePassDate().hashCode();
        }
        if (getGyssdgpDate() != null) {
            _hashCode += getGyssdgpDate().hashCode();
        }
        if (getGzysqrDate() != null) {
            _hashCode += getGzysqrDate().hashCode();
        }
        if (getHtqdDate() != null) {
            _hashCode += getHtqdDate().hashCode();
        }
        if (getIntentionCode() != null) {
            _hashCode += getIntentionCode().hashCode();
        }
        if (getIntentionName() != null) {
            _hashCode += getIntentionName().hashCode();
        }
        if (getIntentionSapCode() != null) {
            _hashCode += getIntentionSapCode().hashCode();
        }
        if (getIntentionSupplierCode() != null) {
            _hashCode += getIntentionSupplierCode().hashCode();
        }
        if (getIntentionSupplierName() != null) {
            _hashCode += getIntentionSupplierName().hashCode();
        }
        if (getIsForetastePass() != null) {
            _hashCode += getIsForetastePass().hashCode();
        }
        if (getIsTrueMerchandise() != null) {
            _hashCode += getIsTrueMerchandise().hashCode();
        }
        if (getJlbzsjcgqrBzDay() != null) {
            _hashCode += getJlbzsjcgqrBzDay().hashCode();
        }
        if (getJlbzsjcgqrSjDay() != null) {
            _hashCode += getJlbzsjcgqrSjDay().hashCode();
        }
        if (getJlwlzsjsqsptgBzDay() != null) {
            _hashCode += getJlwlzsjsqsptgBzDay().hashCode();
        }
        if (getJlwlzsjsqsptgSjDay() != null) {
            _hashCode += getJlwlzsjsqsptgSjDay().hashCode();
        }
        if (getMerchandiseCode() != null) {
            _hashCode += getMerchandiseCode().hashCode();
        }
        if (getMerchandiseName() != null) {
            _hashCode += getMerchandiseName().hashCode();
        }
        if (getOaApplicationCode() != null) {
            _hashCode += getOaApplicationCode().hashCode();
        }
        if (getOaApplicationDate() != null) {
            _hashCode += getOaApplicationDate().hashCode();
        }
        if (getOaApplicationName() != null) {
            _hashCode += getOaApplicationName().hashCode();
        }
        if (getOaContacts() != null) {
            _hashCode += getOaContacts().hashCode();
        }
        if (getOrderType() != null) {
            _hashCode += getOrderType().hashCode();
        }
        if (getPackageApplicationLink() != null) {
            _hashCode += getPackageApplicationLink().hashCode();
        }
        if (getPackageApplicationStatus() != null) {
            _hashCode += getPackageApplicationStatus().hashCode();
        }
        if (getPackageApplicationStatusName() != null) {
            _hashCode += getPackageApplicationStatusName().hashCode();
        }
        if (getPackingType() != null) {
            _hashCode += getPackingType().hashCode();
        }
        if (getPaymentType() != null) {
            _hashCode += getPaymentType().hashCode();
        }
        if (getPksjxcBzDay() != null) {
            _hashCode += getPksjxcBzDay().hashCode();
        }
        if (getPksjxcDate() != null) {
            _hashCode += getPksjxcDate().hashCode();
        }
        if (getPksjxcSjDay() != null) {
            _hashCode += getPksjxcSjDay().hashCode();
        }
        if (getPksjxcStatus() != null) {
            _hashCode += getPksjxcStatus().hashCode();
        }
        if (getPkxcDate() != null) {
            _hashCode += getPkxcDate().hashCode();
        }
        if (getPurchaseDepartments() != null) {
            _hashCode += getPurchaseDepartments().hashCode();
        }
        if (getPurchaseDepartmentsName() != null) {
            _hashCode += getPurchaseDepartmentsName().hashCode();
        }
        if (getPurchaseType() != null) {
            _hashCode += getPurchaseType().hashCode();
        }
        if (getPurchaseTypeName() != null) {
            _hashCode += getPurchaseTypeName().hashCode();
        }
        if (getQdgpDate() != null) {
            _hashCode += getQdgpDate().hashCode();
        }
        if (getQuotedCurrency() != null) {
            _hashCode += getQuotedCurrency().hashCode();
        }
        if (getQuotedDate() != null) {
            _hashCode += getQuotedDate().hashCode();
        }
        if (getRationed() != null) {
            _hashCode += getRationed().hashCode();
        }
        if (getRationedName() != null) {
            _hashCode += getRationedName().hashCode();
        }
        if (getSaleType() != null) {
            _hashCode += getSaleType().hashCode();
        }
        if (getSctgBzDay() != null) {
            _hashCode += getSctgBzDay().hashCode();
        }
        if (getSctgSjDay() != null) {
            _hashCode += getSctgSjDay().hashCode();
        }
        if (getSjDay() != null) {
            _hashCode += getSjDay().hashCode();
        }
        if (getSmallTypeCode() != null) {
            _hashCode += getSmallTypeCode().hashCode();
        }
        if (getSmallTypeName() != null) {
            _hashCode += getSmallTypeName().hashCode();
        }
        if (getSpdddcDate() != null) {
            _hashCode += getSpdddcDate().hashCode();
        }
        if (getSpecification() != null) {
            _hashCode += getSpecification().hashCode();
        }
        if (getSsDate() != null) {
            _hashCode += getSsDate().hashCode();
        }
        if (getSupCompanySite() != null) {
            _hashCode += getSupCompanySite().hashCode();
        }
        if (getSupContacts() != null) {
            _hashCode += getSupContacts().hashCode();
        }
        if (getSupContactsPhone() != null) {
            _hashCode += getSupContactsPhone().hashCode();
        }
        if (getSupplierCode() != null) {
            _hashCode += getSupplierCode().hashCode();
        }
        if (getSupplierName() != null) {
            _hashCode += getSupplierName().hashCode();
        }
        if (getVisitApplicationLink() != null) {
            _hashCode += getVisitApplicationLink().hashCode();
        }
        if (getVisitApplicationStatus() != null) {
            _hashCode += getVisitApplicationStatus().hashCode();
        }
        if (getVisitApplicationStatusName() != null) {
            _hashCode += getVisitApplicationStatusName().hashCode();
        }
        if (getXcsqDate() != null) {
            _hashCode += getXcsqDate().hashCode();
        }
        if (getXcsqshtgBzDay() != null) {
            _hashCode += getXcsqshtgBzDay().hashCode();
        }
        if (getXcsqshtgDate() != null) {
            _hashCode += getXcsqshtgDate().hashCode();
        }
        if (getXcsqshtgSjDay() != null) {
            _hashCode += getXcsqshtgSjDay().hashCode();
        }
        if (getXcsqshtgStatus() != null) {
            _hashCode += getXcsqshtgStatus().hashCode();
        }
        if (getXcsqtjBzDay() != null) {
            _hashCode += getXcsqtjBzDay().hashCode();
        }
        if (getXcsqtjDate() != null) {
            _hashCode += getXcsqtjDate().hashCode();
        }
        if (getXcsqtjSjDay() != null) {
            _hashCode += getXcsqtjSjDay().hashCode();
        }
        if (getXcsqtjStatus() != null) {
            _hashCode += getXcsqtjStatus().hashCode();
        }
        if (getXpffBzDay() != null) {
            _hashCode += getXpffBzDay().hashCode();
        }
        if (getXpffDate() != null) {
            _hashCode += getXpffDate().hashCode();
        }
        if (getXpffSjDay() != null) {
            _hashCode += getXpffSjDay().hashCode();
        }
        if (getXpffStatus() != null) {
            _hashCode += getXpffStatus().hashCode();
        }
        if (getXpyjbgsptgBzDay() != null) {
            _hashCode += getXpyjbgsptgBzDay().hashCode();
        }
        if (getXpyjbgsptgDate() != null) {
            _hashCode += getXpyjbgsptgDate().hashCode();
        }
        if (getXpyjbgsptgSjDay() != null) {
            _hashCode += getXpyjbgsptgSjDay().hashCode();
        }
        if (getXpyjbgsptgStatus() != null) {
            _hashCode += getXpyjbgsptgStatus().hashCode();
        }
        if (getXpyjbgtjBzDay() != null) {
            _hashCode += getXpyjbgtjBzDay().hashCode();
        }
        if (getXpyjbgtjDate() != null) {
            _hashCode += getXpyjbgtjDate().hashCode();
        }
        if (getXpyjbgtjSjDay() != null) {
            _hashCode += getXpyjbgtjSjDay().hashCode();
        }
        if (getXpyjbgtjStatus() != null) {
            _hashCode += getXpyjbgtjStatus().hashCode();
        }
        if (getYjbgtjDate() != null) {
            _hashCode += getYjbgtjDate().hashCode();
        }
        if (getYjbgwcDate() != null) {
            _hashCode += getYjbgwcDate().hashCode();
        }
        if (getZsjsqDate() != null) {
            _hashCode += getZsjsqDate().hashCode();
        }
        if (getZsjsqsptgBzDay() != null) {
            _hashCode += getZsjsqsptgBzDay().hashCode();
        }
        if (getZsjsqsptgDate() != null) {
            _hashCode += getZsjsqsptgDate().hashCode();
        }
        if (getZsjsqsptgSjDay() != null) {
            _hashCode += getZsjsqsptgSjDay().hashCode();
        }
        if (getZsjsqsptgStatus() != null) {
            _hashCode += getZsjsqsptgStatus().hashCode();
        }
        if (getZsjsqwcDate() != null) {
            _hashCode += getZsjsqwcDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MerchandiseIntention.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://hbxt.peripheral.service.interfaces.sco.powere2e.com/", "merchandiseIntention"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationLink");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicationLink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicationStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationStatusName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicationStatusName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bbtgDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bbtgDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjcgqrBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjcgqrBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjcgqrDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjcgqrDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjcgqrSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjcgqrSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjcgqrStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjcgqrStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjsqBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjsqBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjsqDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjsqDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjsqSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjsqSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjsqStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjsqStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjsqwcBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjsqwcBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjsqwcDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjsqwcDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjsqwcSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjsqwcSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjsqwcStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjsqwcStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjwgtgDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjwgtgDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bzsjwgtgStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bzsjwgtgStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("centreTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "centreTypeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("centreTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "centreTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveryType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deliveryType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detailTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "detailTypeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detailTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "detailTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dlRoleCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dlRoleCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dlRoleName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dlRoleName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dxRoleCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dxRoleCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dxRoleName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dxRoleName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dyqrDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dyqrDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elseTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "elseTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enquiryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enquiryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evaluate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "evaluate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fineTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fineTypeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fineTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fineTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foretasteDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "foretasteDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foretasteGrade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "foretasteGrade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foretastePassDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "foretastePassDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gyssdgpDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gyssdgpDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gzysqrDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gzysqrDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("htqdDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "htqdDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intentionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intentionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intentionName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intentionName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intentionSapCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intentionSapCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intentionSupplierCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intentionSupplierCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intentionSupplierName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intentionSupplierName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isForetastePass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isForetastePass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTrueMerchandise");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isTrueMerchandise"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jlbzsjcgqrBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jlbzsjcgqrBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jlbzsjcgqrSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jlbzsjcgqrSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jlwlzsjsqsptgBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jlwlzsjsqsptgBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jlwlzsjsqsptgSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jlwlzsjsqsptgSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchandiseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "merchandiseCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchandiseName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "merchandiseName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oaApplicationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oaApplicationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oaApplicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oaApplicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oaApplicationName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oaApplicationName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oaContacts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oaContacts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packageApplicationLink");
        elemField.setXmlName(new javax.xml.namespace.QName("", "packageApplicationLink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packageApplicationStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "packageApplicationStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packageApplicationStatusName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "packageApplicationStatusName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packingType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "packingType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pksjxcBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pksjxcBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pksjxcDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pksjxcDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pksjxcSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pksjxcSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pksjxcStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pksjxcStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pkxcDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pkxcDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("purchaseDepartments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "purchaseDepartments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("purchaseDepartmentsName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "purchaseDepartmentsName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("purchaseType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "purchaseType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("purchaseTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "purchaseTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qdgpDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qdgpDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quotedCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quotedCurrency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quotedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quotedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rationed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rationed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rationedName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rationedName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saleType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saleType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sctgBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sctgBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sctgSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sctgSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smallTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smallTypeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smallTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smallTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spdddcDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "spdddcDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specification");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ssDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ssDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supCompanySite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supCompanySite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supContacts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supContacts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supContactsPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supContactsPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supplierCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supplierCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supplierName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supplierName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visitApplicationLink");
        elemField.setXmlName(new javax.xml.namespace.QName("", "visitApplicationLink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visitApplicationStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "visitApplicationStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visitApplicationStatusName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "visitApplicationStatusName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xcsqDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xcsqDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xcsqshtgBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xcsqshtgBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xcsqshtgDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xcsqshtgDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xcsqshtgSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xcsqshtgSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xcsqshtgStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xcsqshtgStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xcsqtjBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xcsqtjBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xcsqtjDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xcsqtjDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xcsqtjSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xcsqtjSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xcsqtjStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xcsqtjStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpffBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpffBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpffDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpffDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpffSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpffSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpffStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpffStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpyjbgsptgBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpyjbgsptgBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpyjbgsptgDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpyjbgsptgDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpyjbgsptgSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpyjbgsptgSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpyjbgsptgStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpyjbgsptgStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpyjbgtjBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpyjbgtjBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpyjbgtjDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpyjbgtjDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpyjbgtjSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpyjbgtjSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xpyjbgtjStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xpyjbgtjStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yjbgtjDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "yjbgtjDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yjbgwcDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "yjbgwcDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zsjsqDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zsjsqDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zsjsqsptgBzDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zsjsqsptgBzDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zsjsqsptgDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zsjsqsptgDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zsjsqsptgSjDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zsjsqsptgSjDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zsjsqsptgStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zsjsqsptgStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zsjsqwcDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zsjsqwcDate"));
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
