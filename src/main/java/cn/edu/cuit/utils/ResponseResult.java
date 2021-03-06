package cn.edu.cuit.utils;

public class ResponseResult {
    private int code;

    private String msg;

    private Object data;

    private static ResponseResult responseResult = new ResponseResult();

    private ResponseResult() {
    }

    public static ResponseResult getInstance(int code, String msg, Object data) {
        responseResult.code = code;
        responseResult.msg = msg;
        responseResult.data = data;
        return responseResult;
    }

    public static ResponseResult ok(String msg,Object data) {
        return getInstance(200, msg,data);
    }

    public static ResponseResult error(int code,String msg) {
        return getInstance(code, msg, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
