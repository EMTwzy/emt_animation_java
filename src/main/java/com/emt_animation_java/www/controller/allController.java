package com.emt_animation_java.www.controller;

import com.emt_animation_java.www.Pojo.ff_vod;
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
public class allController {
    @Autowired
    serviceImp service;

    /**
     * 分类/大全区域
     * */

    @GetMapping("/selectVideo")
    public List<ff_vod> selectVideo(String lang, String publisharea, String publishyear, String letter, Integer pageNum){
        System.out.println(lang+"\t"+publisharea+"\t"+publishyear+"\t"+letter+"\t"+pageNum);
        List<ff_vod> result=service.selectVideo(lang,publisharea,publishyear,letter,pageNum);
        return result;
    }

    @GetMapping("/selectVideoNum")
    public Integer selectVideoNum(String lang, String publisharea, String publishyear,String letter){
        Integer result=service.selectVideoNum(lang,publisharea,publishyear,letter);
        return result;
    }

}
