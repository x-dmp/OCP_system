package cn.edu.cuit.dao;

import cn.edu.cuit.model.bo.TransferSlipBo;
import cn.edu.cuit.model.entity.Transfer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface TransferDao {

    @Select("select sub_organ from oper_account where id = #{id}")
    String getOrganizationById(Integer id);

    @Select("select oper_real_name from oper_account where id = #{id}")
    String getUserNameById(Integer id);

    @Select("select * from transfer_slip")
    List<Transfer> getGain();

    @Select("select * from transfer_slip where transfer_number like concat('%', #{transferNumber}, '%') ")
    List<Transfer> getAllTransferByTransferNumber(String transferNumber);

    @Select("select * from transfer_slip where creater like concat('%', #{creater}, '%') ")
    List<Transfer> getAllTransferByCreater(String creater);

    @Select("select * from transfer_slip where create_date > #{startDate} and create_date < #{endDate}")
    List<Transfer> getAllTransferByDate(Date startDate, Date endDate);

    /**
     * 根据条件查询调拨单列表
     * @param transferSlipBo 封装的条件及对应的值
     * @return 调拨单列表
     */
    @Select({"<script> " +
            "select * from transfer_slip " +
            "where 1=1 " +
            "<if test='transferBoNumber!=null'> and transfer_number like concat('%', #{transferBoNumber}, '%') </if> " +
            "<if test='creator!=null'> and creater like concat('%', #{creator}, '%') </if> " +
            "<if test='startDate!=null'> and create_date &gt; #{startDate} </if> " +
            "<if test='endDate!=null'> and create_date &lt; #{endDate} </if> " +
            "</script>"})
    List<Transfer> findByCondition(TransferSlipBo transferSlipBo);

    /**
     * 查询所有id的Transfer
     * @param ids id列表
     * @return List<Transfer>
     */
    @Select({"<script>",
            "select * from transfer_slip ",
                "<if test='array != null and array.length>0' >",
                    "where id in ",
                    "<foreach collection='array' item='id' open='(' separator=',' close=')'>",
                        "#{id}",
                    "</foreach>",
                "</if>",
            "</script>"})
    List<Transfer> findByIds(Long[] ids);

    @Insert("INSERT INTO `ocp`.`transfer_slip`(`transfer_number`, `create_date`, `transfer_way`, `ex_warehouse_code`, `ex_warehouse_name`, `pro_code`, `pro_name`, `type`, `transfer_amount`, `volume`, `creater`, `tran_consignee`, `dealer`, `deliver_way`, `related_order_number`, `transfer_address`, `consignee_tele`, `consignee_id`, `transfer_note`)" +
            "  VALUES (#{transferNumber}, #{createDate}, #{transferWay}, #{exWarehouseCode}, #{exWarehouseName}, #{proCode}, #{proName}, 'type', #{transferAmount}, #{volume}, #{creater}, #{tranConsignee}, #{dealer}, #{deliverWay}, #{relatedOrderNumber}, #{transferAddress}, #{consigneeTele}, #{consigneeId}, #{transferNote});")
    void insert(Transfer transfer);
}
