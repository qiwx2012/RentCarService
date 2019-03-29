package com.rentcar.rentcar.controller;

import com.alibaba.fastjson.JSON;
import com.rentcar.rentcar.dao.UserDao;
import com.rentcar.rentcar.pojo.ResultVo;
import com.rentcar.rentcar.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST )
    public String login(@RequestParam(value = "PhoneNum", defaultValue = "") String phone,@RequestParam(value = "smscode", defaultValue = "") String smscode) {
        ResultVo<User> resultVo=new ResultVo();
        if("111111".equals(smscode)){
           resultVo.setMsg("成功");
           resultVo.setStatus(200);
           User user=new User();
           user.setUserName("小明");
           user.setMemberLevel(25);
           user.setPhoneNum(phone);
           resultVo.setData(user);

        }else {
            resultVo.setMsg("失败");
            resultVo.setStatus(-100);
        }
        return JSON.toJSONString(resultVo,true);

    }

}
