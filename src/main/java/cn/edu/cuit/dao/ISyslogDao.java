package cn.edu.cuit.dao;

import cn.edu.cuit.model.entity.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther yincaiTA
 * @date 2021/1/1 11:48
 * @description 日志持久层接口
 */
public interface ISyslogDao {

    @Insert("insert into t_syslog(account_name, visit_time, ip, url, execute_time, method) values(#{accountName}, #{visitTime}, #{ip}, #{url}, #{executeTime}, #{method})")
    void save(Syslog syslog);

    @Select("select * from t_syslog")
    List<Syslog> findAll();

}
