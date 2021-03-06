package cn.edu.cuit.dao;

import cn.edu.cuit.model.entity.OperAccount;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OperAccountDAO {
    /**
     * @description: DAO Operation
     * @author: zaoweiceng
     * @time: 2020/12/25 15:51
     */

    @Select("select * from oper_account where oper_user_name = #{oper_user_name}")
    List<OperAccount> findAccountByAccountName(String oper_user_name);

    @Insert("insert into oper_account(oper_user_name, oper_password, oper_real_name, sub_organ, pro_line, role_department, oper_sex, oper_tele_number, oper_email, oper_state) " +
            "values (#{operUserName}, #{operPassword}, #{operRealName}, #{subOrgan}, #{proLine}, #{roleDepartment}, #{operSex}, #{operTeleNumber}, #{operEmail}, #{operState})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insertIntoAccount(OperAccount operAccount);

    @Select({"<script> " +
            "select * from oper_account " +
            "where 1=1 " +
            "<if test='operUserName!=null'> and oper_user_name like concat('%', #{operUserName}, '%') </if> " +
            "<if test='operState!=null'> and oper_state like concat('%', #{operState}, '%') </if> " +
            "<if test='subOrgan!=null'> and sub_organ like concat('%', #{subOrgan}, '%') </if> " +
            "<if test='operRealName!=null'> and oper_real_name like concat('%', #{operRealName}, '%') </if> " +
            "<if test='operTeleNumber!=null'> and oper_tele_number like concat('%', #{operTeleNumber}, '%') </if> " +
            "<if test='operSex!=null'> and oper_sex = #{operSex}</if> " +
            "</script>"})
    List<OperAccount> findAccountByPage(String operUserName, Integer operState, String subOrgan, String operRealName, String operTeleNumber, Integer operSex);

    @Update("UPDATE oper_account set oper_state = #{oper_state} WHERE id = #{id}")
    void changeAccountStatus(Integer id, Integer oper_state);

    @Update("UPDATE account_role set role_id = #{role_id} WHERE account_id = #{account_id}")
    void changeAccountRole(Integer account_id, Integer role_id);

    @Delete("DELETE FROM oper_account WHERE id = #{id}")
    void deleteAccountById(Integer id);

    @Delete("delete from account_role where account_id = #{aid}")
    void deleteRoleOfAccount(Integer aid);

    @Insert("insert into account_role(account_id, role_id) values(#{aid}, #{rid})")
    void addRole(Integer aid, Integer rid);

    /**
     * 查询所有用户名
     * @return 用户名集合
     */
    @Select("select oper_user_name from oper_account")
    List<String> findAllUsername();

    @Update("update oper_account set oper_user_name=#{operUserName}, oper_real_name=#{operRealName}, sub_organ=#{subOrgan}" +
            ", pro_line=#{proLine}, role_department=#{roleDepartment}, oper_sex=#{operSex}, oper_tele_number=#{operTeleNumber}" +
            ", oper_email=#{operEmail}, oper_state=#{operState}, oper_password=#{operPassword}")
    void update(OperAccount account);
}
