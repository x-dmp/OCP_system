package cn.edu.cuit.service;

import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.OperRole;

public interface IOperService {
    /**
     * @description:
     * @author: zaoweiceng
     * @time: 2020/12/25 16:24
     */

    Response delOperRole(Integer id);

    Response insertOperRole(OperRole operRole);

    Response findOperRole(String name, Integer status ,Integer pagenum, Integer pagesize);

    Response modifyOperRole(OperRole operRole);

}
