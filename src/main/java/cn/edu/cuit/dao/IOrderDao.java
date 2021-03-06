package cn.edu.cuit.dao;

import cn.edu.cuit.model.bo.OrderQuery;
import cn.edu.cuit.model.entity.Order;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @auther yincaiTA
 * @date 2020/12/31 14:21
 * @description 订单持久层
 */
public interface IOrderDao {

    /**
     * 变更订单状态
     * @param order 订单对象
     */
    @Update("update return_order set state = #{state} where id = #{id} ")
    void updateState(Order order);

    /**
     * 变更订单结算金额
     * @param order 订单对象
     */
    @Update("update return_order set recover_price = #{recoverPrice} where id = #{id} ")
    void updateRecoverPrice(Order order);

    /**
     * 变更订单驳回原因
     * @param order 订单对象
     */
    @Update("update return_order set reject_reason = #{rejectReason} where id = #{id} ")
    void updateRejectReason(Order order);

    /**
     * 根据查询条件查询订单列表
     * @param query 查询条件
     * @return 订单列表
     */
    @Select({"<script> " +
            "select * from return_order " +
            "where 1=1 " +
            "<if test='nickname!=null'> and nickname_letter like concat('%', #{nickname}, '%') </if> " +
            "<if test='state!=null'> and state = #{state} </if> " +
            "<if test='returnNumber!=null'> and return_number like concat('%', #{returnNumber}, '%') </if> " +
            "<if test='returnWarehouse!=null'> and return_warehouse like concat('%', #{returnWarehouse}, '%') </if> " +
            "<if test='reTranFirm!=null'> and re_tran_firm like concat('%', #{reTranFirm}, '%') </if> " +
            "<if test='reTranNumber!=null'> and re_tran_number like concat('%', #{reTranNumber}, '%') </if> " +
            "<if test='saleNumber!=null'> and sale_number like concat('%', #{saleNumber}, '%') </if> " +
            "<if test='startTime!=null'> and commit_time &gt; #{startTime} </if> " +
            "<if test='endTime!=null'> and commit_time &lt; #{endTime} </if> " +
            "<if test='timeSort!=null and timeSort==0'> order by commit_time asc </if> " +
            "<if test='timeSort!=null and timeSort==1'> order by commit_time desc </if> " +
            "</script>"})
    List<Order> queryPage(OrderQuery query);

    /**
     * 查询所有id的Order
     * @param ids id列表
     * @return List<Order>
     */
    @Select({"<script>",
                "select * from return_order ",
                "<if test='array != null and array.length>0' >",
                    " where id in ",
                    "<foreach collection='array' item='id' open='(' separator=',' close=')'>",
                        "#{id}",
                    "</foreach>",
                "</if>",
            "</script>"})
    List<Order> findByIds(Long[] ids);
}
