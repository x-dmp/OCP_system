package cn.edu.cuit.controller;

import cn.edu.cuit.model.bo.OrderQuery;
import cn.edu.cuit.model.bo.PageResult;
import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.Order;
import cn.edu.cuit.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther yincaiTA
 * @date 2020/12/31 14:23
 * @description 业务层控制层接口
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 修改退货订单部分信息，可能只含部分更新字段
     * @param newOrder 新订单对象：包含修改订单状态/应恢复运营商货款金额/驳回原因
     * @return Response
     */
    @PatchMapping("/retorder")
    public Response simpleModify(Order newOrder) {
        this.orderService.updatePart(newOrder);
        return new Response("", "200", "更新成功");
    }

    /**
     * @param page
     * @param size
     * @param query 查询条件(只取 昵称、时间间隔、订单状态)
     * @return
     */
    @GetMapping
    public Response queryPage(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer size,
                              OrderQuery query) {

        PageResult<Order> orders = this.orderService.queryPage(page, size, query);

        return new Response(orders, "200", "查询成功");
    }


}
