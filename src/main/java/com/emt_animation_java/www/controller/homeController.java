package com.emt_animation_java.www.controller;

import com.emt_animation_java.www.Pojo.ff_vod;
import com.emt_animation_java.www.Pojo.videoData;
import com.emt_animation_java.www.service.serviceImp.serviceImp;
import com.emt_animation_java.www.utils.picUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@ResponseBody
@Controller
public class homeController {
    @Autowired
    serviceImp service;

    //获取所有数据的总额
    @GetMapping("/totalVideo")
    public Integer totalVideo(){
        Integer result= service.totalVideo();
        return result;
    }

    //根据名称获取模糊数据
    @GetMapping("/selectVideoByName")
    public List<ff_vod> selectVideoByName(String name){
        List<ff_vod> result=service.selectVideoByName(name);
        System.out.println("测试获取"+result);
        return result;
    }

    //随机推荐
    @GetMapping("/randomVideo")
    public List<ff_vod> randomVideo(){
        List<ff_vod> result= service.randomVideo();
        return result;
    }

    //每周更新榜单
    @GetMapping("/weekNew")
    public List<ff_vod> weekNew(Integer day){
        List<ff_vod> result= service.weekNew(day);
        return result;
    }

    //验证图片能否访问
    @GetMapping("/picUtils")
    public boolean picUtils(String vpic){
        boolean result= false;
        try {
            result = picUtils.inputOut(vpic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
