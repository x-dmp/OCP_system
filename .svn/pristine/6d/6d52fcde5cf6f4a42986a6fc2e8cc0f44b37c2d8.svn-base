package cn.edu.cuit.service.impl;

import cn.edu.cuit.dao.PermissionDao;
import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.Permission;
import cn.edu.cuit.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther yincaiTA
 * @date 2020/12/30 21:10
 * @description 权限业务层实现类
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    private final PermissionDao permissionDao;

    @Autowired
    public PermissionServiceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    /**
     * 将某个角色的权限进行替换
     * @param rid  角色id
     * @param pids 权限id集合
     */
    @Override
    @Transactional
    public void modifyPermission(Integer rid, List<Integer> pids) {
        // 先删除角色的所有权限
        this.permissionDao.deletePermissionOfRole(rid);
        // 插入角色所有的新权限
        for (Integer pid : pids) {
            this.permissionDao.addRolePermission(rid, pid);
        }
    }

    /**
     * 查询所有权限
     * @return 所有权限列表
     */
    @Override
    public Response findAll() {
        List<Permission> permissions;
        try {
            permissions = this.permissionDao.findAll();
        } catch (Exception e) {
            return new Response(null, "500", "服务器内部异常");
        }
        return new Response(permissions, "200", "查询成功");
    }
}
