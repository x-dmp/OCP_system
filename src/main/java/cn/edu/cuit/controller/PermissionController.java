package cn.edu.cuit.controller;

import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @auther yincaiTA
 * @date 2020/12/30 20:51
 * @description 操作权限接口 这里只写修改接口，仅用于测试
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    private final IPermissionService permissionService;

    @Autowired
    public PermissionController(IPermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * 将rid这个角色的权限修改为pid集合内的权限
     * @param data { "rid": 1, "pid": [1, 2] } rid为角色id pid为权限id集合
     * @return Response
     */
    @PutMapping
    @Transactional
    public Response modifyPermission(@RequestBody HashMap<String, Object> data) {
        Integer rid = (Integer) data.get("rid");
        // 不建议强转
        ArrayList<Integer> pids = (ArrayList<Integer>) data.get("pids");

        // 没做全局异常处理
        this.permissionService.modifyPermission(rid, pids);
        return new Response(null, "200", "修改成功");
    }

    /**
     * 获取权限集合信息
     * @return Response
     */
    @GetMapping
    public Response getPermissions() {
        return this.permissionService.findAll();
    }

}
