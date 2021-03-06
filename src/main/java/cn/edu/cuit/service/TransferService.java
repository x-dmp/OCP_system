package cn.edu.cuit.service;

import cn.edu.cuit.model.bo.TransferSlipBo;
import cn.edu.cuit.model.bo.TransferVo;
import cn.edu.cuit.model.entity.Transfer;

import java.util.List;
import java.util.Map;

public interface TransferService {
    String getOrganizationById(Integer id);

    String getUserNameById(Integer id);

    List<TransferVo> getGain();

    Map<String, Object> getAllTransfer(TransferSlipBo transferSlipBo, Integer page, Integer page_number);

    void saveTransfer(Transfer transfer);
}
