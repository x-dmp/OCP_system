package cn.edu.cuit.controller;

import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.Transfer;
import cn.edu.cuit.service.IExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @auther yincaiTA
 * @date 2021/1/1 09:04
 * @description 导出Excel的控制层接口
 */
@RestController
public class ExcelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelController.class);
    private final IExcelService excelService;

    @Autowired
    public ExcelController(IExcelService excelService) {
        this.excelService = excelService;
    }

    /**
     * 根据选中的ids导出excel
     * @param sign 导出哪个表的标志，暂定为0是导出调拨单表，1是导出退货订单表
     * @param keys 调拨单表/退货订单表的唯一标识，暂定为主键
     * @return 执行成功/失败的信息
     */
    @GetMapping("/export")
    public Response exportExcel(Integer sign, @RequestParam(value = "ids", required = false) Long[] keys, HttpServletResponse response) {
        // 导出excel
        Workbook workbook = this.excelService.export(sign, keys);
        if (workbook == null) {
            LOGGER.info("sign参数异常，异常值为 {} .", sign);
            return new Response(null, "500", "导出失败");
        }

        ServletOutputStream os = null;
        String filename = sign == 0 ? "调拨单表" : "退货订单表";
        try {
            // 设置响应参数
            String type = new MimetypesFileTypeMap().getContentType("excel.xls");
            response.setHeader("Content-type", type);
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename + ".xls", "utf-8"));
            // 输出流 以下载方式导出excel文件
            os = response.getOutputStream();
            workbook.write(os);
        } catch (IOException e) {
//            e.printStackTrace();
            this.close(os, workbook);
            LOGGER.info("导出 {} 失败.", filename);
            return new Response(null, "500", "导出失败");
        } finally {
            this.close(os, workbook);
        }

        LOGGER.info("导出 {} 成功.", filename);
//        return new Response("", "200", "导出成功");  猜测是easypoi写完后将流关闭了 不能再写了
        return null;
    }

    /**
     * 只做了调拨单excel的上传的处理
     * 读取excel文件信息，响应调拨单对象集合给前端
     * @param file excel文件
     * @return 执行状态信息
     */
    @PostMapping("/import")
    public Response importExcel(@RequestParam("file") MultipartFile file) {
        List<Transfer> transfers = this.excelService.importExcel(file);

        if (null == transfers) {
            return new Response("", "500", "导入失败!");
        }

        return new Response(transfers, "200", "导入成功!");
    }

    private void close(ServletOutputStream os, Workbook workbook) {
        try {
            if (os != null) {
                os.close();
            }
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
