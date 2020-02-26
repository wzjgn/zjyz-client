package com.zjyz.data;


public class DataRespModel implements  java.io.Serializable {

    /**
     * 返回码
     */
    private int code;

    /**
     *返回码描述
     */
    private String message;

    /**
     * 流水号
     */
    private String serialNum;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }
}
