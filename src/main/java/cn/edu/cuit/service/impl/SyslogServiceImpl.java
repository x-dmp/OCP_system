package cn.edu.cuit.service.impl;

import cn.edu.cuit.dao.ISyslogDao;
import cn.edu.cuit.model.bo.PageResult;
import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.Syslog;
import cn.edu.cuit.service.ISyslogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther yincaiTA
 * @date 2021/1/1 11:31
 * @description 日志业务层实现类
 */
@Service
public class SyslogServiceImpl implements ISyslogService {

    private final ISyslogDao syslogDao;

    @Autowired
    public SyslogServiceImpl(ISyslogDao syslogDao) {
        this.syslogDao = syslogDao;
    }

    /**
     * 保存日志
     * @param syslog 日志信息
     */
    @Override
    @Transactional
    public void save(Syslog syslog) {
        this.syslogDao.save(syslog);
    }

    /**
     * 查询所有日志对象
     *
     * @param page
     * @param size
     * @return 日志对象列表
     */
    @Override
    public Response findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Syslog> syslogs = null;
        try {
            syslogs = this.syslogDao.findAll();
        } catch (Exception e) {
            return new Response("", "500", "查询失败");
        }
        PageInfo<Syslog> pageInfo = new PageInfo<>(syslogs);

        PageResult<Syslog> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

        return new Response(pageResult, "200", "查询成功!");
    }

}
