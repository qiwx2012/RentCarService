package com.rentcar.rentcar.service.impl;


import com.rentcar.rentcar.service.BaseServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xing on 2015/11/28.
 */
@RequestMapping("/mgr/test")
@RestController
public class TestServer extends BaseServer {
    @RequestMapping(value = "/aaa",method = {RequestMethod.POST})
    public String test(){
        return "王雪莹";
    }
}
