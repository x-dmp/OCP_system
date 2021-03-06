package cn.edu.cuit.dao;

import cn.edu.cuit.model.entity.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther yincaiTA
 * @date 2020/12/30 21:17
 * @description 权限逻辑持久层
 */
public interface PermissionDao {

    /**
     * 查询所有集合
     * @return 所有权限集合
     */
    @Select("select * from t_permission")
    List<Permission> findAll();

    /**
     * 删除这个角色id的所有权限
     * @param roleId 角色id
     */
    @Delete("delete from t_role_permission where role_id = #{param}")
    void deletePermissionOfRole(Integer roleId);

    /**
     * 用新的权限替换这个角色旧的权限
     * @param roleId 角色id
     * @param permissionId 这个角色新的权限
     */
    @Insert("insert into t_role_permission(role_id, permission_id) values(#{roleId}, #{permissionId})")
    void addRolePermission(Integer roleId, Integer permissionId);
}
