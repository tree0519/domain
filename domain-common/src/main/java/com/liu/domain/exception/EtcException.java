package com.liu.domain.exception;

/**
 * etc抛出异常类
 * @author ZYW
 * @date 2018/5/31
 */
public class EtcException extends RuntimeException {

    private Integer status;
    private String code;
    private String message;

    public EtcException() {
    }

    public EtcException(Integer status, String code, String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public EtcException(Integer status, String code, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public EtcException(Integer status, String code, Throwable cause) {
        super(cause);
        this.status = status;
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}