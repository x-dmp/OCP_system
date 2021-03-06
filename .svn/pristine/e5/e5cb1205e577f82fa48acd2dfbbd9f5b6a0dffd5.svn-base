package cn.edu.cuit.dao;

import cn.edu.cuit.model.entity.OperRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OperRoleDAO {
    /**
     * @description:
     * @author: zaoweiceng
     * @time: 2020/12/25 15:57
     */

    @Select("select * from oper_role where letter like #{name} and role_state = #{status}")
    List<OperRole> findOperRoleLikeLetterAndEqualsStatus(String name, Integer status);

    @Insert("insert into oper_role(role_name, role_state, role_description, letter)" +
            " values (#{roleName}, #{roleState}, #{roleDescription}, #{letter})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insertOperRole(OperRole operRole);

    @Delete("delete from oper_role where id = #{id}")
    void delOperRoleById(Integer id);

    @Update("update oper_role set role_name = #{roleName}, role_description = #{roleDescription}, letter = #{letter} " +
            "where id = #{id}")
    void updateOperRole(OperRole operRole);

    @Select("select count(role_name) from oper_role where role_name = #{param}")
    Integer chkRoleName(String roleName);
}
