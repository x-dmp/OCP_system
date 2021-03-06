package cn.edu.cuit.service;

import cn.edu.cuit.model.bo.AccountBo;
import cn.edu.cuit.model.bo.Ids;
import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.OperAccount;

import java.util.List;

public interface IUserService {
    /**
     * @author: zaoweiceng
     * @time: 2020/12/25 15:52
     */

    Response operAccountLogin(String operUserName, String operPassWord);

    Response operAccountDelete(Ids ids);

    Response operAccountFind(OperAccount operAccount, Integer pagenum, Integer pagesize);

    Response operAccountInsert(OperAccount operAccount);

    Response operAccountChangeStatus(AccountBo accountBo);

    Response operAccountChangeRole(AccountBo accountBo);

    Response operAccountExist(String operUserName);

    /**
     * 查询所有用户名
     * @return
     */
    List<String> findAllUsername();

    Response modifyAccount(OperAccount account);
}
