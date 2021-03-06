package cn.edu.cuit.service.impl;

import cn.edu.cuit.dao.IOrderDao;
import cn.edu.cuit.model.bo.OrderQuery;
import cn.edu.cuit.model.bo.PageResult;
import cn.edu.cuit.model.entity.Order;
import cn.edu.cuit.service.IOrderService;
import cn.edu.cuit.utils.ChineseToSpell;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther yincaiTA
 * @date 2020/12/31 14:22
 * @description 退货层业务层实现类
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderDao orderDao;

    @Autowired
    public OrderServiceImpl(IOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * 订单条件分页
     * @param page  第几页
     * @param size  每页多少条
     * @param query 查询条件
     * @return 分页结果集
     */
    @Override
    public PageResult<Order> queryPage(Integer page, Integer size, OrderQuery query) {
        PageHelper.startPage(page, size);

        if (null != query.getNickname()) {
            query.setNickname(ChineseToSpell.getPingYin(query.getNickname()));
        }
        List<Order> orders = this.orderDao.queryPage(query);

        PageInfo<Order> pageInfo = new PageInfo<Order>(orders);

        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 修改退货订单的部分字段
     * @param order 新订单对象
     */
    @Override
    @Transactional
    public void updatePart(Order order) {
        // 如果要更新状态
        if (order.getState() != null) {
            this.orderDao.updateState(order);
        }
        // 如果要更新结算金额
        if (order.getRecoverPrice() != null) {
            this.orderDao.updateRecoverPrice(order);
        }
        // 如果要更新驳回原因
        if (order.getRejectReason() != null) {
            this.orderDao.updateRejectReason(order);
        }
    }
}
