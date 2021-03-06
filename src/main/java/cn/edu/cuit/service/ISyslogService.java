package cn.edu.cuit.service;

import cn.edu.cuit.model.bo.Response;
import cn.edu.cuit.model.entity.Syslog;

/**
 * @auther yincaiTA
 * @date 2021/1/1 11:31
 * @description 日志业务层接口
 */
public interface ISyslogService {
    /**
     * 保存日志
     * @param syslog 日志信息
     */
    void save(Syslog syslog);

    /**
     * 查询所有日志对象
     * @return 日志对象列表
     */
    Response findAll(Integer page, Integer size);
}
