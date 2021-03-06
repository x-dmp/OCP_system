package cn.edu.cuit.controller;

import cn.edu.cuit.model.bo.AccountBo;
import cn.edu.cuit.model.bo.Ids;
import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.OperAccount;
import cn.edu.cuit.service.IUserService;
import cn.edu.cuit.utils.Md5Util;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/users/")
public class OperAccountController {
/**
 * @description: Account Operation
 * @author: zaoweiceng
 * @time: 2020/12/25 15:51
 */
    @Autowired
    private IUserService userServie;
    @Autowired
    private HttpServletRequest request;

    //用户登录
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody Response accountLogin(@RequestBody HashMap<String, Object> data){
        String operUserName = (String) data.get("operUserName");
        String operPassWord = (String) data.get("operPassword");

        Response response = userServie.operAccountLogin(operUserName, Md5Util.md5(operPassWord));
        // 成功 将用户存入session(这是一种方式)
        if ("200".equals(response.getCode())) {
            request.getSession().setAttribute("user", response.getData());
        }
        return response;
    }

    @GetMapping("/logout")
    public void logout() {
        request.getSession().removeAttribute("user");
    }

    //用户删除
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public @ResponseBody Response accountDelete(@RequestParam(name = "ids") Integer[] idarr){
        Ids ids= new Ids();
        ids.setIds(Arrays.asList(idarr));

        return userServie.operAccountDelete(ids);
    }

    //查找是否存在
    @RequestMapping(value = "chkname", method = RequestMethod.GET)
    public @ResponseBody Response accountExist(String name){
        return userServie.operAccountExist(name);
    }

    //用户新增
    @RequestMapping(value = "insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody Response accountInsert(@RequestBody HashMap<String, Object> data){
        Gson gson = new Gson();
        OperAccount operAccount= gson.fromJson(data.get("account").toString(), OperAccount.class);
        return userServie.operAccountInsert(operAccount);
    }

    //用户修改Status
    @RequestMapping(value = "status", method = RequestMethod.PATCH, produces = "application/json;charset=UTF-8")
    public @ResponseBody Response accountChangeStatus(@RequestBody HashMap<String, Object> data){
        Gson gson = new Gson();
        AccountBo accountBo= gson.fromJson(data.get("accountBo").toString(), AccountBo.class);

        return userServie.operAccountChangeStatus(accountBo);
    }

    //用户修改Role
    @RequestMapping(value = "role", method = RequestMethod.PATCH, produces = "application/json;charset=UTF-8")
    public @ResponseBody Response accountChangeRole(@RequestBody HashMap<String, Object> data){
        Gson gson = new Gson();
        AccountBo accountBo= gson.fromJson(data.get("accountBo").toString(), AccountBo.class);

        return userServie.operAccountChangeRole(accountBo);
    }

    //用户按条件分页查询
    @RequestMapping(value = "query", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody Response accountFind(@RequestParam(defaultValue = "1") Integer page,
                                              @RequestParam(defaultValue = "10") Integer size,
                                              OperAccount operAccount){

        return this.userServie.operAccountFind(operAccount, page, size);
    }

    /**
     * 查询所有经销商账号的用户名
     * @return 用户名列表
     */
    @GetMapping("/names")
    public @ResponseBody Response findAllUsername() {
        List<String> usernames;
        try {
            usernames = this.userServie.findAllUsername();
        } catch (Exception e) {
            return new Response("", "500", "服务器内部异常");
        }
        return new Response(usernames, "200", "操作成功");
    }

}
