package cn.edu.cuit.service;

import cn.edu.cuit.model.entity.Transfer;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @auther yincaiTA
 * @date 2021/1/1 09:08
 * @description 导出业务层接口
 */
public interface IExcelService {

    /**
     * 根据ids导出excel
     * @param sign 导出哪个表的标志，0是导出调拨单表，1是导出退货订单表
     * @param keys 主键集合
     * @return Workbook
     */
    Workbook export(Integer sign, Long[] keys);

    /**
     * 数据导入处理，若要保存数据库，需点击前端的'制作调拨单'
     * @param file excel文件
     */
    List<Transfer> importExcel(MultipartFile file);
}
