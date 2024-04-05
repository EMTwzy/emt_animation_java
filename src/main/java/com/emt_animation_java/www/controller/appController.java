package com.emt_animation_java.www.controller;

import com.emt_animation_java.www.Pojo.emt_history;
import com.emt_animation_java.www.Pojo.emt_subscribe;
import com.emt_animation_java.www.Pojo.emt_user;
import com.emt_animation_java.www.service.serviceImp.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
public class appController {
    @Autowired
    serviceImp service;

    //注册
    @GetMapping("/register")
    public Boolean register(emt_user emtUser){
        Integer result= service.register(emtUser);
        return result==1?true:false;
    }

    //修改用户信息
    @GetMapping("/changeUser")
    public Boolean changeUser(emt_user emtUser){
        Integer result= service.changeUser(emtUser);
        return result==1?true:false;
    }

    //检测用户是否已经存在
    @GetMapping("/selectUserName")
    public Boolean selectUserName(String userName){
        Integer result= service.selectUserName(userName);
        return result==1?true:false;
    }

    //登录
    @GetMapping("/loginUser")
    public emt_user loginUser(String userName,String userPassword){
        emt_user result=service.loginUser(userName, userPassword);
        return result;
    }

    //添加追番
    @GetMapping("/addSubscribe")
    public Boolean addSubscribe(Integer userId,Integer userSubId){
        Integer result=service.addSubscribe(userId, userSubId);
        return result==1?true:false;
    }

    //获取用户追番列表
    @GetMapping("/selectSubscribe")
    public List<emt_subscribe> selectSubscribe(Integer userId){
        List<emt_subscribe> result= service.selectSubscribe(userId);
        return result;
    }

    //是否已经追番
    @GetMapping("/isSubscribe")
    public Boolean isSubscribe(Integer userId,Integer userSubId){
        Integer result=service.isSubscribe(userId, userSubId);
        return result==1?true:false;
    }

    //取消追番
    @GetMapping("/deleteSubscribe")
    public Boolean deleteSubscribe(Integer userId,Integer userSubId){
        Integer result=service.deleteSubscribe(userId, userSubId);
        return result==1?true:false;
    }

    //获取用户历史记录
    @GetMapping("/getHistory")
    public List<emt_history> getHistory(Integer userId){
        List<emt_history> result=service.getHistory(userId);
        return result;
    }

    //添加历史记录
    @GetMapping("/addHistory")
    public Boolean addHistory(emt_history emtHistory){
        Integer result= service.addHistory(emtHistory);
        return result==1?true:false;
    }

    //删除历史记录
    @GetMapping("/deleteHistory")
    public Boolean deleteHistory(emt_history emtHistory){
        Integer result=service.deleteHistory(emtHistory);
        return result==1?true:false;
    }

    //查看历史记录是否已经存在
    @GetMapping("/selectHistory")
    public emt_history selectHistory(emt_history emtHistory){
        emt_history result=service.selectHistory(emtHistory);
        return result;
    }

    //更新历史记录
    @GetMapping("/updateHistory")
    public Boolean updateHistory(emt_history emtHistory){
        Integer result=service.updateHistory(emtHistory);
        return result==1?true:false;
    }
}
