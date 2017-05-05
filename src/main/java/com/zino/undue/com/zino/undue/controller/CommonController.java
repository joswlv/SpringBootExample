package com.zino.undue.com.zino.undue.controller;

import com.zino.undue.com.zino.undue.exception.ComException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * Created by Jo_seungwan on 2017. 5. 5..
 */
public class CommonController {

    protected static Logger logger = LoggerFactory.getLogger(CommonController.class);

    @ExceptionHandler(ComException.class)
    @ResponseBody
    public String handleAnyException(ComException ex, Locale locale){
        logger.error(" =======>>>" + ex);
        logger.error(" =======>>> ComException Request : " + ex.getRequestObj().toString());
        ex.printStackTrace();
        return "Sorry! an error occurred.";
    }
}
