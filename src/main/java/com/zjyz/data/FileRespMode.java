package com.zjyz.data;

/**
 * 第三方公司上传文件 返回
 */
public class FileRespMode {
    /**
     * 返回码
     */
    int code;

    /**
     * 返回信息
     */
    String message;

    /**
     * 返回文件上传路径
     */
    String file;

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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
