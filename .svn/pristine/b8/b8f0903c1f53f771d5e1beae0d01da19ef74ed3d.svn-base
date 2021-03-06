package cn.edu.cuit.controller;

import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.OperAccount;
import cn.edu.cuit.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {

    @Autowired
    private IUserService userService;

    @PutMapping("/users")
    public Response modifyAccount(@RequestBody OperAccount account) {
        Response response = this.userService.modifyAccount(account);

        return response;
    }

}
