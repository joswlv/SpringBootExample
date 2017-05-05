package com.zino.undue.com.zino.undue.exception;

import lombok.Getter;

/**
 * Created by Jo_seungwan on 2017. 5. 5..
 */
public class ComException extends Exception {
    @Getter
    Object requestObj = null;

    public ComException(String message, Object requestObj){
        super(message);
        this.requestObj = requestObj;
    }

    public ComException(Throwable cause,  Object requestObj){
        super(cause);
        this.requestObj = requestObj;
    }

    public ComException(String message, Throwable cause, Object requestObj){
        super(message, cause);
        this.requestObj = requestObj;
    }
}
