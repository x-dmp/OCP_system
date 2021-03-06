package cn.edu.cuit.model.bo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果集封装
 * @param <T> 装什么类型数据
 */
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 7024451190339643425L;

    /**
     * 查询的总结果数
     */
    private Long total;

    /**
     * 分页结果集合
     */
    private List<T> items;

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
