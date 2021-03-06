package cn.edu.cuit.service.impl;

import cn.edu.cuit.dao.OperRoleDAO;
import cn.edu.cuit.model.bo.PageResult;
import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.OperRole;
import cn.edu.cuit.service.IOperService;
import cn.edu.cuit.utils.ChineseToSpell;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class OperServiceImp implements IOperService {

    @Autowired
    OperRoleDAO operRoleDAO;

    @Override
    public Response delOperRole(Integer id) {
        String msg = "删除失败";
        String code = "404";
        Response res = new Response();
        try {
            operRoleDAO.delOperRoleById(id);
            msg = "删除成功";
            code = "200";
            res.setCode(code);
            res.setMsg(msg);
        } catch (Exception e) {}
        return res;
    }

    @Override
    public Response insertOperRole(OperRole operRole) {
        String msg = "失败";
        String code = "404";
        // 前端最开始创建角色时未传值
        if (operRole.getRoleState() == null) {
            operRole.setRoleState(1);
        }
        try {
            if (this.operRoleDAO.chkRoleName(operRole.getRoleName()) > 0) {
                return new Response(null, "406", "角色名不能重复");
            }
            operRole.setLetter(ChineseToSpell.getPingYin(operRole.getRoleDescription()));
            operRoleDAO.insertOperRole(operRole);
            msg = "成功";
            code = "200";
        } catch (Exception e) {}
        return new Response(null, code, msg);
    }

    @Override
    public Response findOperRole(String name, Integer status, Integer pagenum, Integer pagesize) {

        String msg = "获取失败";
        String code = "404";
        Object data = null;
        PageInfo<OperRole> pageInfo = null;
        List<OperRole> roleList = null;

        PageHelper.startPage(pagenum, pagesize);
        try {
            roleList = operRoleDAO.findOperRoleLikeLetterAndEqualsStatus("%" + name + "%", status);
            pageInfo = new PageInfo<>(roleList);
        }catch(Exception e){}
        PageResult pageResult = new PageResult<OperRole>(pageInfo.getTotal(), pageInfo.getList());
        if (CollectionUtils.isEmpty(pageResult.getItems())) {
            msg = "没有数据";
            code = "404";
        }
        else{
            msg = "获取成功";
            code = "200";
            data = pageResult;
        }
        Response res = new Response(data, code, msg);
        return res;
    }

    @Override
    public Response modifyOperRole(OperRole operRole) {
        String msg = "失败";
        String code = "404";
        try {
            operRole.setLetter(ChineseToSpell.getPingYin(operRole.getRoleDescription()));
            operRoleDAO.updateOperRole(operRole);
            msg = "成功";
            code = "200";
        } catch (Exception e) {}

        Response res = new Response(null, code, msg);
        return res;
    }
}
