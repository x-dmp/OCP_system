package cn.edu.cuit.service;

import cn.edu.cuit.model.bo.OrderQuery;
import cn.edu.cuit.model.bo.PageResult;
import cn.edu.cuit.model.entity.Order;

/**
 * @auther yincaiTA
 * @date 2020/12/31 14:22
 * @description 退货订单业务层接口
 */
public interface IOrderService {

    /**
     * 修改退货订单的部分字段
     * @param order 新订单对象
     */
    void updatePart(Order order);

    /**
     * 订单条件分页
     * @param page 第几页
     * @param size 每页多少条
     * @param query 查询条件
     * @return 分页结果集
     */
    PageResult<Order> queryPage(Integer page, Integer size, OrderQuery query);
}
