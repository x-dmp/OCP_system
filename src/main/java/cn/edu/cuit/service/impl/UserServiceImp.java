package cn.edu.cuit.service.impl;

import cn.edu.cuit.dao.OperAccountDAO;
import cn.edu.cuit.model.bo.AccountBo;
import cn.edu.cuit.model.bo.Ids;
import cn.edu.cuit.model.bo.PageResult;
import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.OperAccount;
import cn.edu.cuit.service.IUserService;
import cn.edu.cuit.utils.Md5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServiceImp implements IUserService {
    /**
     * @description: Service Operation
     * @author: zaoweiceng
     * @time: 2020/12/25 15:52
     */

    @Autowired
    private OperAccountDAO operAccountDAO;

    @Override
    public Response operAccountLogin(String operUserName, String operPassWord) {
        String msg = "用户名或密码错误";
        String code = "404";
        List<OperAccount> accountList = null;
        try {
            accountList = operAccountDAO.findAccountByAccountName(operUserName);
            if (accountList.size() > 0 && accountList.get(0).getOperPassword().trim().equals(operPassWord)) {
                code = "200";
                msg = "登录成功";
            }
        } catch (Exception e) {
        }

        // 返回的username做点手脚 验证nginx负载均衡
        Response res = new Response((accountList == null || accountList.size() == 0) ? null : accountList.get(0).setOperUserName(accountList.get(0).getOperUserName() + "~8082"), code, msg);
        return res;
    }

    @Override
    @Transactional
    public Response operAccountDelete(Ids ids) {
        String msg = "删除成功";
        String code = "200";
        try {
            for (Integer id : ids.getIds()) {
                operAccountDAO.deleteAccountById(id);
            }
        } catch (Exception e) {
            msg = "删除失败";
            code = "404";
        }
        Response res = new Response(null, code, msg);
        return res;
    }

    public Response operAccountFind(OperAccount operAccount, Integer pagenum, Integer pagesize) {

        String msg = "查询失败";
        String code = "404";
        Object data = null;
        PageInfo<OperAccount> pageInfo = null;
        List<OperAccount> accountList = null;

        PageHelper.startPage(pagenum, pagesize);
        try {
            accountList = operAccountDAO.findAccountByPage(operAccount.getOperUserName(), operAccount.getOperState(), operAccount.getSubOrgan(), operAccount.getOperRealName(), operAccount.getOperTeleNumber(), operAccount.getOperSex());
            pageInfo = new PageInfo<>(accountList);
        } catch (Exception e) {
        }
        PageResult pageResult = new PageResult<OperAccount>(pageInfo.getTotal(), pageInfo.getList());
        if (CollectionUtils.isEmpty(pageResult.getItems())) {
            msg = "没有数据";
            code = "404";
        } else {
            msg = "获取成功";
            code = "200";
            data = pageResult;
        }

        Response res = new Response(data, code, msg);
        return res;
    }

    @Override
    @Transactional
    public Response operAccountInsert(OperAccount operAccount) {
        String msg = "创建账户成功";
        String code = "201";
        Response res;
        try {
            // 密码加密
            operAccount.setOperPassword(Md5Util.md5(operAccount.getOperPassword()));
            operAccountDAO.insertIntoAccount(operAccount);
        } catch (Exception e) {
            msg = "创建账户失败";
            code = "403";
            e.printStackTrace();
        } finally {
            res = new Response(null, code, msg);
        }
        return res;
    }

    @Override
    @Transactional
    public Response operAccountChangeStatus(AccountBo accountBo) {
        String msg = "修改status成功";
        String code = "200";
        try {
            for (Integer id : accountBo.getIds()) {
                operAccountDAO.changeAccountStatus(id, accountBo.getStatus());
            }
        } catch (Exception e) {
            msg = "修改status失败";
            code = "404";
        }
        Response res = new Response(null, code, msg);
        return res;
    }

    @Override
    @Transactional
    public Response operAccountChangeRole(AccountBo accountBo) {
        String msg = "修改role成功";
        String code = "200";
        try {
            List<Integer> rids = accountBo.getRoleId();
            for (Integer id : accountBo.getIds()) {
                // 删除所有旧的角色(不能单纯update)
                this.operAccountDAO.deleteRoleOfAccount(id);

                // 新增所有新的角色
                for (Integer rid : rids) {
                    this.operAccountDAO.addRole(id, rid);
                }
            }
        } catch (Exception e) {
            msg = "修改role失败";
            code = "404";
        }
        Response res = new Response(null, code, msg);
        return res;
    }


    @Override
    public Response operAccountExist(String operUserName) {
        String msg = "不可用";
        String code = "404";
        try {
            List<OperAccount> accountList = operAccountDAO.findAccountByAccountName(operUserName);
            if (accountList != null && accountList.size() != 0) {
                msg = "可用";
                code = "200";
            }
        } catch (Exception e) {
        }
        Response res = new Response(null, code, msg);
        return res;
    }

    /**
     * 查询所有用户名
     * @return 返回用户名列表
     */
    @Override
    public List<String> findAllUsername() {
        return this.operAccountDAO.findAllUsername();
    }

    @Override
    @Transactional
    public Response modifyAccount(OperAccount account) {

        try {
            this.operAccountDAO.update(account);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("", "500", "新增账号异常");
        }

        return new Response("", "200", "查询成功");
    }
}
