package cn.edu.cuit.service;

import cn.edu.cuit.model.bo.Response;

import java.util.List;

/**
 * @auther yincaiTA
 * @date 2020/12/30 21:08
 * @description 权限业务层接口
 */
public interface IPermissionService {

    /**
     * 将某个角色的权限进行替换
     * @param rid  角色id
     * @param pids 权限id集合
     */
    void modifyPermission(Integer rid, List<Integer> pids);

    /**
     * 查询所有权限
     * @return 所有权限列表
     */
    Response findAll();
}
