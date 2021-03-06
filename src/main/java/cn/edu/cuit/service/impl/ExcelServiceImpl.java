package cn.edu.cuit.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.edu.cuit.dao.IOrderDao;
import cn.edu.cuit.dao.TransferDao;
import cn.edu.cuit.model.entity.Order;
import cn.edu.cuit.model.entity.Transfer;
import cn.edu.cuit.service.IExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @auther yincaiTA
 * @date 2021/1/1 09:08
 * @description 导出业务层实现类
 */
@Service
public class ExcelServiceImpl implements IExcelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelServiceImpl.class);

    // 只设置支持这两种扩展名
    private List<String> extension = Arrays.asList("xls", "xlsx");

    private final IOrderDao orderDao;

    private final TransferDao transferDao;

    @Autowired
    public ExcelServiceImpl(IOrderDao orderDao, TransferDao transferDao) {
        this.orderDao = orderDao;
        this.transferDao = transferDao;
    }


    /**
     * 根据ids导出excel
     * @param sign 导出哪个表的标志，0是导出调拨单表，1是导出退货订单表
     * @param keys 主键集合
     * @return Workbook
     */
    @Override
    public Workbook export(Integer sign, Long[] keys) {
        if (sign == 0) {   // 导出调拨单表
            List<Transfer> transfers = this.transferDao.findByIds(keys);
            // 导出excel
            ExportParams exportParams = new ExportParams();
            exportParams.setTitle("调拨单信息表");
            exportParams.setSheetName("调拨单簿");
            exportParams.setHeight(Short.parseShort("22"));
            return ExcelExportUtil.exportExcel(exportParams, Transfer.class, transfers);
        } else if (sign == 1) {
            List<Order> orders = this.orderDao.findByIds(keys);
            // 导出excel
            ExportParams exportParams = new ExportParams();
            exportParams.setTitle("退货订单信息表");
            exportParams.setSheetName("退货订单簿");
            exportParams.setHeight(Short.parseShort("22"));
            return ExcelExportUtil.exportExcel(exportParams, Order.class, orders);
        }
        return null;
    }

    /**
     * 数据导入处理，若要保存数据库，需点击前端的'制作调拨单'
     * @param file excel文件
     */
    @Override
    public List<Transfer> importExcel(MultipartFile file) {
        String filename = file.getOriginalFilename();
        LOGGER.info("上传的文件名: [{}]", filename);

        String ext = filename.substring(filename.lastIndexOf('.') + 1);
        // 包含，允许上传
        if (!extension.contains(ext)) {
            return null;
        }

        InputStream is = null;
        List<Transfer> transfers = null;
        try {
            // 解析excel为Transfer集合
            is = file.getInputStream();
            ImportParams importParams = new ImportParams();
            // 设置导入参数
            importParams.setTitleRows(1);  // 标题有几行
            transfers = ExcelImportUtil.importExcel(is, Transfer.class, importParams);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        LOGGER.info("导入的数据总数为: {}", transfers.size());

        // 这里不保存数据到数据库中，而将数据返回前端先进行显示
        return transfers;
    }
}
