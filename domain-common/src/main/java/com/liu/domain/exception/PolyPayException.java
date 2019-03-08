package com.liu.domain.exception;

public class PolyPayException extends BasePayException {
    public PolyPayException() {
    }

    public PolyPayException(Integer status, String code, String message) {
        super(status,code,message);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public PolyPayException(Integer status, String code, String message, Throwable cause) {
        super(status,code,message, cause);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public PolyPayException(Integer status, String code, Throwable cause) {
        super(status,code,cause);
        this.status = status;
        this.code = code;
    }
}
