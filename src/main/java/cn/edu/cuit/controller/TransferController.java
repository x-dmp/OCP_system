package cn.edu.cuit.controller;

import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.bo.TransferSlipBo;
import cn.edu.cuit.model.bo.TransferVo;
import cn.edu.cuit.model.entity.Transfer;
import cn.edu.cuit.service.TransferService;
import cn.edu.cuit.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TransferController {

    @Resource
    TransferService transferService;

    @ResponseBody
    @RequestMapping(value = "/transfer/organization",method = RequestMethod.GET)
    public ResponseResult getOrganizationById(Integer aid){
        String sub_organ = transferService.getOrganizationById(aid);

        return ResponseResult.ok("操作成功",sub_organ);
    }

    @ResponseBody
    @RequestMapping(value = "/transfer/initinfo",method = RequestMethod.GET)
    public ResponseResult getInitinfoById(Integer aid){
        String userName = transferService.getUserNameById(aid);
        Map<String,String> map = new HashMap<>();
        map.put("creator",userName);
        map.put("transferNumber",UUID.randomUUID().toString().replace("-", ""));

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

        map.put("createDate",sdf.format(d));

        return ResponseResult.ok("操作成功", map);
    }

    @ResponseBody
    @RequestMapping(value = "/transfer/gain",method = RequestMethod.GET)
    public ResponseResult getGain(){
        List<TransferVo> list = transferService.getGain();
        return ResponseResult.ok("操作成功",list);
    }

    /**
     * 分页条件查询所有挑拨单信息
     * @param transferSlipBo 查询条件
     * @param page 查询第几页，默认查询第一页
     * @param size 每页多少条数据，默认10条
     * @return 分页结果集及状态码、描述信息
     */
    @ResponseBody
    @RequestMapping(value = "transfer",method = RequestMethod.GET)
    public ResponseResult getAllTransfer(TransferSlipBo transferSlipBo,
                                         @RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "10") Integer size){
        Map<String,Object> map = transferService.getAllTransfer(transferSlipBo,page,size);
        return ResponseResult.ok("操作成功",map);
    }

    @PutMapping
    public Response addTransfer(Transfer transfer) {
        try {
            this.transferService.saveTransfer(transfer);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("", "500", "新增异常");
        }
        return new Response("", "200", "新增成功");
    }
}
