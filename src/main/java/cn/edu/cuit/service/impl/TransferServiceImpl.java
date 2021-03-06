package cn.edu.cuit.service.impl;

import cn.edu.cuit.dao.TransferDao;
import cn.edu.cuit.model.bo.TransferSlipBo;
import cn.edu.cuit.model.bo.TransferVo;
import cn.edu.cuit.model.entity.Transfer;
import cn.edu.cuit.service.TransferService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransferServiceImpl implements TransferService {

    @Resource
    TransferDao transferDao;

    @Override
    public String getOrganizationById(Integer id) {
        return transferDao.getOrganizationById(id);
    }

    @Override
    public String getUserNameById(Integer aid) {
        return transferDao.getUserNameById(aid);
    }

    @Override
    public List<TransferVo> getGain() {
        List<TransferVo> transferVoList = new ArrayList<>();

        List<Transfer> list = transferDao.getGain();
        for (int i = 0; i<list.size();i++){
            TransferVo transferVo = new TransferVo();
            transferVo.setConsigneeVoId(list.get(i).getConsigneeId());
            transferVo.setConsigneeVoTele(list.get(i).getConsigneeTele());
            transferVo.setTransferVoConsignee(list.get(i).getTranConsignee());
            transferVo.setTransferVoAddress(list.get(i).getTransferAddress());
            transferVoList.add(transferVo);
        }
        return transferVoList;
    }

    /**
     * 对调拨单进行分页条件查询
     * @param transferSlipBo 查询条件
     * @param page 起始页
     * @param size 每页多少条数据
     * @return 封装total、结果集的键值对对象
     */
    @Override
    public Map<String, Object> getAllTransfer(TransferSlipBo transferSlipBo, Integer page, Integer size) {
        PageHelper.startPage(page, size);

        List<Transfer> transfers = this.transferDao.findByCondition(transferSlipBo);
        PageInfo<Transfer> pageInfo = new PageInfo<>(transfers);

        Map<String,Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("items", pageInfo.getList());
        return map;
    }

    @Override
    @Transactional
    public void saveTransfer(Transfer transfer) {
        this.transferDao.insert(transfer);
    }
}
