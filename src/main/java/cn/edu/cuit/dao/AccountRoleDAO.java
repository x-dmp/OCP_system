package cn.edu.cuit.dao;

import cn.edu.cuit.model.entity.AccountRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountRoleDAO {
    /**
     * @description:
     * @author: zaoweiceng
     * @time: 2020/12/25 16:02
     */

    @Select("select * from account_role where id = #{id}")
    List<AccountRole> findAccountRoleByid(Integer id);

    @Select("select * from account_role where account_id = #{id}")
    List<AccountRole> findAccountRoleByAccountId(Integer id);

    @Select("select * from account_role where role_id = #{id}")
    List<AccountRole> findAccountRoleByRoleId(Integer id);


}
