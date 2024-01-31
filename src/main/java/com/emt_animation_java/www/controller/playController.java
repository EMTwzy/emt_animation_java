package com.emt_animation_java.www.controller;

import com.emt_animation_java.www.Pojo.content;
import com.emt_animation_java.www.Pojo.play;
import com.emt_animation_java.www.Pojo.videoData;
import com.emt_animation_java.www.service.serviceImp.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@ResponseBody
@Controller
public class playController {
    @Autowired
    serviceImp service;

            /**
             *
             * 这里是播放区的controller
             * */
      //根据id获取视频的数据
    @GetMapping("/selectVideoById")
    public videoData selectVideoById(int vid){
        videoData result=service.selectVideoById(vid);
        return result;
    }
    //根据id来获取视频的详细介绍
    @GetMapping("/selectContent")
    public String selectContent(int vid){
        content result=service.selectContent(vid);
        return result.getBody();
    }
    //根据id获取视频的播放数据
    @GetMapping("/getPlay")
    public List selectPlay(int vid){
        List result =service.getPlay(vid);
        return result;
    }
    //根据id获取视频的集数
    @GetMapping("/getScore")
    public List getScore(int vid){
        System.out.println("");
        List result=service.getScore(vid);
        return result;
    }

}
