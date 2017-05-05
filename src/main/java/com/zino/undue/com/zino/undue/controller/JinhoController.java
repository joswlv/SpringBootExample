package com.zino.undue.com.zino.undue.controller;

import com.zino.undue.com.zino.undue.exception.ComException;
import com.zino.undue.com.zino.undue.model.request.JinhoReqestModel;
import com.zino.undue.com.zino.undue.service.JinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Jo_seungwan on 2017. 5. 4..
 */
@RestController
public class JinhoController extends CommonController{
    @Autowired private JinhoService jinhoService;

    @RequestMapping("/")
    public @ResponseBody String root_test() throws ComException
    {
        return "Hello Jinho";
    }

    @RequestMapping("jinhotset/getAllData")
    public String getAllData() throws ComException
    {
        return jinhoService.selectAllList();
    }

    @RequestMapping(value="jinhotest/getOneData", method= RequestMethod.GET)
    public String getOneData(@RequestParam(value="name", required=false, defaultValue="-") String name ) throws ComException
    {
        return jinhoService.selectOne(name);
    }

    @RequestMapping(value="jinhotest/getPostData", method=RequestMethod.POST)
    public String getPostData(@RequestBody @Valid final JinhoReqestModel jinhoReqestModel, BindingResult bindingResult) throws ComException
    {
        if (bindingResult.hasErrors()){
            return "Request Errors";
        }
        return jinhoService.selectOne(jinhoReqestModel.getName());
    }
}
