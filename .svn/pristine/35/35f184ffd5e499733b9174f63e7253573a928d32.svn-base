package cn.edu.cuit.model.bo;

import java.io.Serializable;

/**
 * @auther yincaiTA
 * @date 2020/11/30 09:36
 * @description 统一响应格式
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 8364630117680820860L;

    /**
     * 响应数据
     */
    private Object data;

    /**
     * 状态码
     */
    private String code;

    /**
     * 响应提示信息
     */
    private String msg;

    public Response() {
    }

    public Response(Object data, String code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public Response setData(Object data) {
        this.data = data;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Response setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Response setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
