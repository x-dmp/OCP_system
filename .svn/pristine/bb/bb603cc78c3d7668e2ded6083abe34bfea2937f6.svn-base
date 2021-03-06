package cn.edu.cuit.controller;

import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.OperRole;
import cn.edu.cuit.service.IOperService;
import cn.edu.cuit.utils.ChineseToSpell;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/role/")
public class OperRoleController {

    @Autowired
    private IOperService operService;

    @RequestMapping(value = "insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody Response OperRoleInsert(@RequestBody HashMap<String, Object> data){
        Gson gson = new Gson();
        OperRole operRole= gson.fromJson(data.get("role").toString(), OperRole.class);
        return operService.insertOperRole(operRole);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public @ResponseBody Response OperRoleDelete(Integer id){
        return operService.delOperRole(id);
    }

    @RequestMapping(value = "find", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody Response OperRoleFind(@RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "10") Integer size,
                                               @RequestParam(defaultValue = "") String name,
                                               @RequestParam(defaultValue = "1") Integer status){
        return operService.findOperRole(ChineseToSpell.getPingYin(name), status, page, size);
    }

    @RequestMapping(value = "modify", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public @ResponseBody Response OperRoleModify(@RequestBody HashMap<String, Object> data){
        Gson gson = new Gson();
        OperRole operRole= gson.fromJson(data.get("role").toString(), OperRole.class);
        return operService.modifyOperRole(operRole);
    }

}
