package com.emt_animation_java.www.service.serviceImp;

import com.emt_animation_java.www.Pojo.content;
import com.emt_animation_java.www.Pojo.play;
import com.emt_animation_java.www.Pojo.videoData;
import com.emt_animation_java.www.mapper.mapper;
import com.emt_animation_java.www.service.service;
import com.emt_animation_java.www.utils.playUtils;
import com.emt_animation_java.www.utils.timeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class serviceImp implements service {
    //引入mapper
    @Autowired
    mapper mapper;

    //数据总额
    Integer total;

    //随机推荐
    @Override
    public List<videoData> randomVideo() {
        total=mapper.totalVideo();
        Integer start=(int)Math.floor(Math.random()*total)-10;
        if (start < 0) {
            start = 0;
        }
        List<videoData> result=mapper.randomVideo(start);
        return result;
    }

    //获取视频数据总额
    @Override
    public Integer totalVideo() {
        Integer result= mapper.totalVideo();
        total=result;
        System.out.println("总额"+result);
        return result;
    }

    //根据名称获取模糊数据
    @Override
    public List<videoData> selectVideoByName(String name) {
        List<videoData> result= mapper.selectVideoByName(name);
        System.out.println("service测试"+result+"\t"+name);
        return result;
    }

    //每周更新榜单
    @Override
    public List<videoData> weekNew(Integer day) {
        System.out.println(day+"\t!!!!!!!!!!!!!!!!!!!!!!");
        long[] weekTime= timeUtils.time_utils();
        List<videoData> result= mapper.weekNew(weekTime[day-1],weekTime[day], weekTime[day+6],weekTime[day+7],LocalDate.now().getYear());  //传入的参数是从1开始的
        return result;
    }



    /**
     * 分类大全区域
     * */
    //获取指定条件的数据
    @Override
    public List<videoData> selectVideo(String lang, String publisharea, String publishyear,String letter, Integer pageNum) {
        LocalDate local=LocalDate.now();
        Integer year=0;
        Integer before=0;
        if(publishyear.equals("更早以前")){
            before=local.getYear()-8;
            year=local.getYear()-8;
        }else{
            if(!publishyear.equals(""))
            year=Integer.parseInt(publishyear);
        }

        Integer pagenum=(pageNum-1)*20;
        List<videoData> result= mapper.selectVideo(lang, publisharea,year,before,letter,pagenum);
        return result;
    }

    //获取指定条件的数据的总额
    @Override
    public Integer selectVideoNum(String lang, String publisharea, String publishyear, String letter) {
        LocalDate local=LocalDate.now();
        Integer year=0;
        Integer before=0;
        if(publishyear.equals("更早以前")){
            before=local.getYear()-8;
            year=local.getYear()-8;
        }else{
            if(!publishyear.equals(""))
                year=Integer.parseInt(publishyear);
        }

        Integer result= mapper.selectVideoNum(lang, publisharea,year,before,letter);
        return result;
    }

    // 根据视频id来获取视频的信息
    @Override
    public videoData selectVideoById(int vid) {
        videoData result=mapper.selectVideoById(vid);
        return result;
    }

    // 根据视频id来获取视频的详细信息
    @Override
    public content selectContent(int vid) {
        content result= mapper.selectContent(vid);
        return result;
    }

    // 根据视频id来获取视频的播放数据
    @Override
    public List getPlay(int vid) {
        play result=mapper.selectPlay(vid);
        List list=playUtils.getUrl(result.getBody());
        return list;
    }
    // 根据视频id来获取视频的集数
    @Override
    public List getScore(int vid) {
        play result=mapper.selectPlay(vid);
        List list=playUtils.getScore(result.getBody());
        return list;
    }
}