package cn.edu.cuit.model.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;

@ExcelTarget("transfer")
public class Transfer implements Serializable {
    private static final long serialVersionUID = -7775222589941408947L;

    private Integer aid;//运营商账号表id号
    private String subOrgan;//隶属机构

    @Excel(name = "id")
    private Integer id;// 主键id
    @Excel(name = "调拨单号", width = 20)
    private String transferNumber;//调拨单号
    @Excel(name = "调拨单创建日期", format = "yyyy-MM-dd HH:mm:ss", width = 20)
    private Date createDate;//调拨单创建日期
    @Excel(name = "运输方式", replace = { "工厂调拨_0", "普通搬仓_1" })
    private Integer transferWay;//调拨类型 0为工厂调拨 1为普通搬仓
    @Excel(name = "调出仓库编码", width = 16)
    private String exWarehouseCode;//调出仓库编码
    @Excel(name = "调出仓库名称", width = 20)
    private String exWarehouseName;//调出仓库名称
    @Excel(name = "调出产品编码", width = 16)
    private String proCode;//调出产品编码
    @Excel(name = "调出商品名称", width = 16)
    private String proName;//调出商品名称
    @Excel(name = "调出产品类型", width = 16)
    private String type;//调出产品类型
    @Excel(name = "调拨数量(件)", width = 16)
    private Integer transferAmount;//调拨数量
    @Excel(name = "调拨体积(m³)", width = 16)
    private Double volume;//调拨体积
    @Excel(name = "创建人")
    private String creater;//创建人
    @Excel(name = "调出产品收件人", width = 20)
    private String tranConsignee;//调出产品收件人
    @Excel(name = "经销商名称", width = 20)
    private String dealer;//经销商名称
    @Excel(name = "发货方式")
    private String deliverWay;//发货方式
    @Excel(name = "关联备货订单编号", width = 20)
    private String relatedOrderNumber;//关联备货订单编号
    @Excel(name = "调拨收货地址", width = 28)
    private String transferAddress;//调拨收货地址
    @Excel(name = "调拨收件人电话", width = 14)
    private String consigneeTele;//调拨收件人电话
    @Excel(name = "调拨收件人身份证号", width = 20)
    private String consigneeId;//调拨收件人身份证号
    @Excel(name = "调拨单备注", width = 16)
    private String transferNote;//调拨单备注

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getSubOrgan() {
        return subOrgan;
    }

    public void setSubOrgan(String subOrgan) {
        this.subOrgan = subOrgan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer tranId) {
        this.id = tranId;
    }

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getTransferWay() {
        return transferWay;
    }

    public void setTransferWay(Integer transferWay) {
        this.transferWay = transferWay;
    }

    public String getExWarehouseCode() {
        return exWarehouseCode;
    }

    public void setExWarehouseCode(String exWarehouseCode) {
        this.exWarehouseCode = exWarehouseCode;
    }

    public String getExWarehouseName() {
        return exWarehouseName;
    }

    public void setExWarehouseName(String exWarehouseName) {
        this.exWarehouseName = exWarehouseName;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Integer transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getTranConsignee() {
        return tranConsignee;
    }

    public void setTranConsignee(String tranConsignee) {
        this.tranConsignee = tranConsignee;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getDeliverWay() {
        return deliverWay;
    }

    public void setDeliverWay(String deliverWay) {
        this.deliverWay = deliverWay;
    }

    public String getRelatedOrderNumber() {
        return relatedOrderNumber;
    }

    public void setRelatedOrderNumber(String relatedOrderNumber) {
        this.relatedOrderNumber = relatedOrderNumber;
    }

    public String getTransferAddress() {
        return transferAddress;
    }

    public void setTransferAddress(String transferAddress) {
        this.transferAddress = transferAddress;
    }

    public String getConsigneeTele() {
        return consigneeTele;
    }

    public void setConsigneeTele(String consigneeTele) {
        this.consigneeTele = consigneeTele;
    }

    public String getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(String consigneeId) {
        this.consigneeId = consigneeId;
    }

    public String getTransferNote() {
        return transferNote;
    }

    public void setTransferNote(String transferNote) {
        this.transferNote = transferNote;
    }
}
