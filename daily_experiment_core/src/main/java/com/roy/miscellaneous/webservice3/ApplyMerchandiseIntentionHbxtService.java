/**
 * ApplyMerchandiseIntentionHbxtService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roy.miscellaneous.webservice3;

public interface ApplyMerchandiseIntentionHbxtService extends java.rmi.Remote {
    public MerchandiseIntentionApplyResponseResult applyMerchandiseIntentionHbxt(String purchaseDepartments, String intentionName, String rationed, String purchaseType, String saleType, String orderType, String centreTypeCode, String smallTypeCode, String elseTypeName, String detailTypeCode, String fineTypeCode, String quotedCurrency, String paymentType, String deliveryType, String specification, String packingType, String intentionSupplierName) throws java.rmi.RemoteException;
}
