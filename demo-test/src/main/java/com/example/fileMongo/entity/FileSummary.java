package com.example.fileMongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by knny0 on 2017/1/4.
 */
@Document(collection = "file_summary")
public class FileSummary {

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 订单编号
     */
    private String orderId;


    /**
     * 身份证号码
     */
    private String idcardNo;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 签名提交时间
     */
    private Date authTime;



    /**
     * 审核状态（0待审核，1通过，-1重签）
     */
    private Integer auditStatus;

    /**
     * 备注
     */
    private String comments;



    /**
     * 设备类型app或微信端
     */
    private String deviceType;

    /**
     * 审核人
     */
    private String auditor;

    /**
     * 审核时间
     */
    private Date auditTime;



    //审核类型，0：自动，1：人工
    private String auditType;

    /**
     * 订单是否关闭
     */
    private Boolean orderLsClose;

    /**
     * 签名文件表主键
     */
    private String fileSignatureId;

    /**
     * 签名文件表名称
     */
    private String tableName;

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }



    public Date getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }



    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }



    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Boolean getOrderLsClose() {
        return orderLsClose;
    }

    public void setOrderLsClose(Boolean orderLsClose) {
        this.orderLsClose = orderLsClose;
    }

    public String getFileSignatureId() {
        return fileSignatureId;
    }

    public void setFileSignatureId(String fileSignatureId) {
        this.fileSignatureId = fileSignatureId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }
}
