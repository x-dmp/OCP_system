package cn.edu.cuit.controller;

import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther yincaiTA
 * @date 2021/1/1 11:45
 * @description 日志接口类
 */
@RestController
@RequestMapping("/syslog")
public class SyslogController {

    private final ISyslogService syslogService;

    @Autowired
    public SyslogController(ISyslogService syslogService) {
        this.syslogService = syslogService;
    }

    @GetMapping
    public Response findAll(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer size) {
        return this.syslogService.findAll(page, size);
    }

}
