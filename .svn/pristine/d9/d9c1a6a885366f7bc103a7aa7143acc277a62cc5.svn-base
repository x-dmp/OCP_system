package cn.edu.cuit.model.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther yincaiTA
 * @date 2020/12/31 14:08
 * @description 暂作为 退货订单 实体类
 */
@ExcelTarget("order")
public class Order implements Serializable {

    // 主键id
    @Excel(name = "id")
    private Long id;

    // 退换货订单编号
    @Excel(name = "退换货订单编号", width = 20)
    private String returnNumber;

    // 退货方式，默认为客户发货
    @Excel(name = "退货方式")
    private String returnWay;

    // 提交退货订单的时间
    @Excel(name = "提交退货订单的时间", format = "yyyy-MM-dd HH:mm:ss", width = 20)
    private Date commitTime;

    // 退回仓库的名称
    @Excel(name = "退回仓库的名称", width = 18)
    private String returnWarehouse;

    // 退货金额
    @Excel(name = "退货金额(元)", width = 14)
    private Double refund;

    // 运费金额
    @Excel(name = "运费金额(元)", width = 14)
    private Double freight;

    // 寄回快递公司的名称
    @Excel(name = "寄回快递公司的名称", width = 20)
    private String reTranFirm;

    // 寄回快递单号
    @Excel(name = "寄回快递单号", width = 20)
    private String reTranNumber;

    // 原发货仓库名称
    @Excel(name = "原发货仓库名称")
    private String deliverWarehouse;

    // 应恢复运营商贷款金额
    @Excel(name = "应恢复运营商贷款金额")
    private Double recoverPrice;

    // 支付方式 0支付宝 1微信
    @Excel(name = "支付方式", replace = { "支付宝_0", "微信_1" })
    private Integer payWay;

    // 退货收件人
    @Excel(name = "退货收件人", width = 14)
    private String reConsignee;

    // 退货人电话号码
    @Excel(name = "退货人电话号码", width = 18)
    private String reTeleNumber;

    // 退货地址
    @Excel(name = "退货地址")
    private String reAddress;

    // 退货人邮编
    @Excel(name = "退货人邮编", width = 14)
    private String reZipCode;

    // 是否为物流原因 0不是 1是
    @Excel(name = "是否为物流原因", replace = { "不是_0", "是_1" })
    private Integer logReason;

    // 驳回原因
    @Excel(name = "驳回原因")
    private String rejectReason;

    // 备注
    @Excel(name = "备注")
    private String remark;

    // 订单编号 对应销售订单的编号
    @Excel(name = "订单编号")
    private String saleNumber;

    // 订单来源编号
    @Excel(name = "订单来源编号", width = 18)
    private String sourceNumber;

    // 000待审核、001待收货、010待结算、011已完成、100已作废
    @Excel(name = "订单状态", replace = { "待审核_000", "待收货_001", "待结算_010", "已完成_011", "已作废_100" })
    private String state;

    // 发票备注
    @Excel(name = "发票备注")
    private String invoiceNote;

    // 卖家昵称
    @Excel(name = "卖家昵称")
    private String nickname;

    // 发票号
    @Excel(name = "发票号", width = 20)
    private String invoiceNumber;

    // 退货原因
    @Excel(name = "退货原因")
    private String refundReason;

    // 产品型号
    @Excel(name = "产品型号")
    private String type;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", returnNumber='" + returnNumber + '\'' +
                ", returnWay='" + returnWay + '\'' +
                ", commitTime=" + commitTime +
                ", returnWarehouse='" + returnWarehouse + '\'' +
                ", refund=" + refund +
                ", freight=" + freight +
                ", reTranFirm='" + reTranFirm + '\'' +
                ", reTranNumber='" + reTranNumber + '\'' +
                ", deliverWarehouse='" + deliverWarehouse + '\'' +
                ", recoverPrice=" + recoverPrice +
                ", payWay=" + payWay +
                ", reConsignee='" + reConsignee + '\'' +
                ", reTeleNumber='" + reTeleNumber + '\'' +
                ", reAddress='" + reAddress + '\'' +
                ", reZipCode='" + reZipCode + '\'' +
                ", logReason=" + logReason +
                ", rejectReason='" + rejectReason + '\'' +
                ", remark='" + remark + '\'' +
                ", saleNumber='" + saleNumber + '\'' +
                ", sourceNumber='" + sourceNumber + '\'' +
                ", state='" + state + '\'' +
                ", invoiceNote='" + invoiceNote + '\'' +
                ", nickname='" + nickname + '\'' +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", refundReason='" + refundReason + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public Order setType(String type) {
        this.type = type;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getReturnNumber() {
        return returnNumber;
    }

    public Order setReturnNumber(String returnNumber) {
        this.returnNumber = returnNumber;
        return this;
    }

    public String getReturnWay() {
        return returnWay;
    }

    public Order setReturnWay(String returnWay) {
        this.returnWay = returnWay;
        return this;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public Order setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
        return this;
    }

    public String getReturnWarehouse() {
        return returnWarehouse;
    }

    public Order setReturnWarehouse(String returnWarehouse) {
        this.returnWarehouse = returnWarehouse;
        return this;
    }

    public Double getRefund() {
        return refund;
    }

    public Order setRefund(Double refund) {
        this.refund = refund;
        return this;
    }

    public Double getFreight() {
        return freight;
    }

    public Order setFreight(Double freight) {
        this.freight = freight;
        return this;
    }

    public String getReTranFirm() {
        return reTranFirm;
    }

    public Order setReTranFirm(String reTranFirm) {
        this.reTranFirm = reTranFirm;
        return this;
    }

    public String getReTranNumber() {
        return reTranNumber;
    }

    public Order setReTranNumber(String reTranNumber) {
        this.reTranNumber = reTranNumber;
        return this;
    }

    public String getDeliverWarehouse() {
        return deliverWarehouse;
    }

    public Order setDeliverWarehouse(String deliverWarehouse) {
        this.deliverWarehouse = deliverWarehouse;
        return this;
    }

    public Double getRecoverPrice() {
        return recoverPrice;
    }

    public Order setRecoverPrice(Double recoverPrice) {
        this.recoverPrice = recoverPrice;
        return this;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public Order setPayWay(Integer payWay) {
        this.payWay = payWay;
        return this;
    }

    public String getReConsignee() {
        return reConsignee;
    }

    public Order setReConsignee(String reConsignee) {
        this.reConsignee = reConsignee;
        return this;
    }

    public String getReTeleNumber() {
        return reTeleNumber;
    }

    public Order setReTeleNumber(String reTeleNumber) {
        this.reTeleNumber = reTeleNumber;
        return this;
    }

    public String getReAddress() {
        return reAddress;
    }

    public Order setReAddress(String reAddress) {
        this.reAddress = reAddress;
        return this;
    }

    public String getReZipCode() {
        return reZipCode;
    }

    public Order setReZipCode(String reZipCode) {
        this.reZipCode = reZipCode;
        return this;
    }

    public Integer getLogReason() {
        return logReason;
    }

    public Order setLogReason(Integer logReason) {
        this.logReason = logReason;
        return this;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public Order setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Order setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public Order setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
        return this;
    }

    public String getSourceNumber() {
        return sourceNumber;
    }

    public Order setSourceNumber(String sourceNumber) {
        this.sourceNumber = sourceNumber;
        return this;
    }

    public String getState() {
        return state;
    }

    public Order setState(String state) {
        this.state = state;
        return this;
    }

    public String getInvoiceNote() {
        return invoiceNote;
    }

    public Order setInvoiceNote(String invoiceNote) {
        this.invoiceNote = invoiceNote;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public Order setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Order setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public Order setRefundReason(String refundReason) {
        this.refundReason = refundReason;
        return this;
    }
}
