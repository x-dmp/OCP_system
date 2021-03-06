package cn.edu.cuit.model.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @auther yincaiTA
 * @date 2020/12/31 14:58
 * @description Order订单类的查询条件封装
 */
public class OrderQuery {

    // 会员名称/昵称
    private String nickname;
    // 需要查询的开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    // 需要查询的结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    // 订单状态
    private String state;
    // 退换货订单编号
    private String returnNumber;
    // 退回仓库名称
    private  String returnWarehouse;
    // 寄回快递公司名称
    private String reTranFirm;
    // 寄回快递单号
    private String reTranNumber;
    // 订单编号
    private String saleNumber;
    // 时间排序 0顺序 1逆序 不传则按数据库上下顺序
    private Integer timeSort;

    @Override
    public String toString() {
        return "OrderQuery{" +
                "nickname='" + nickname + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", state='" + state + '\'' +
                ", returnNumber='" + returnNumber + '\'' +
                ", returnWarehouse='" + returnWarehouse + '\'' +
                ", reTranFirm='" + reTranFirm + '\'' +
                ", reTranNumber='" + reTranNumber + '\'' +
                ", saleNumber='" + saleNumber + '\'' +
                ", timeSort=" + timeSort +
                '}';
    }

    public String getReturnNumber() {
        return returnNumber;
    }

    public OrderQuery setReturnNumber(String returnNumber) {
        this.returnNumber = returnNumber;
        return this;
    }

    public String getReturnWarehouse() {
        return returnWarehouse;
    }

    public OrderQuery setReturnWarehouse(String returnWarehouse) {
        this.returnWarehouse = returnWarehouse;
        return this;
    }

    public String getReTranFirm() {
        return reTranFirm;
    }

    public OrderQuery setReTranFirm(String reTranFirm) {
        this.reTranFirm = reTranFirm;
        return this;
    }

    public String getReTranNumber() {
        return reTranNumber;
    }

    public OrderQuery setReTranNumber(String reTranNumber) {
        this.reTranNumber = reTranNumber;
        return this;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public OrderQuery setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
        return this;
    }

    public Integer getTimeSort() {
        return timeSort;
    }

    public OrderQuery setTimeSort(Integer timeSort) {
        this.timeSort = timeSort;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public OrderQuery setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public OrderQuery setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public OrderQuery setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getState() {
        return state;
    }

    public OrderQuery setState(String state) {
        this.state = state;
        return this;
    }
}
