package com.emt_animation_java.www.service.serviceImp;

import com.emt_animation_java.www.Pojo.content;
import com.emt_animation_java.www.Pojo.ff_vod;
import com.emt_animation_java.www.Pojo.play;
import com.emt_animation_java.www.Pojo.videoData;
import com.emt_animation_java.www.mapper.mapper;
import com.emt_animation_java.www.service.service;
import com.emt_animation_java.www.utils.playUtils;
import com.emt_animation_java.www.utils.timeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Repository
public class serviceImp implements service {
    //引入mapper
    @Autowired
    mapper mapper;

    //数据总额
    Integer total;

    //随机推荐
    @Override
    public List<ff_vod> randomVideo() {
        total=mapper.totalVideo();
        Integer start=(int)Math.floor(Math.random()*total)-10;
        if (start < 0) {
            start = 0;
        }
        List<ff_vod> result=mapper.randomVideo(start);
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
    public List<ff_vod> selectVideoByName(String name) {
        List<ff_vod> result= mapper.selectVideoByName(name);
        System.out.println("service测试"+result+"\t"+name);
        return result;
    }

    //每周更新榜单
    @Override
    public List<ff_vod> weekNew(Integer day) {
        System.out.println(day+"\t!!!!!!!!!!!!!!!!!!!!!!");
        long[] weekTime= timeUtils.time_utils();
        System.out.println("更新榜单参数:\t上个星期的今天"+weekTime[day-1]+"\t上个星期的明天"+weekTime[day]+"\t今天"+weekTime[day+6]+"\t明天"+weekTime[day+7]+"\t年份"+LocalDate.now().getYear());
        List<ff_vod> result= mapper.weekNew(weekTime[day-1],weekTime[day], weekTime[day+6],weekTime[day+7],LocalDate.now().getYear()-1,LocalDate.now().getYear());  //传入的参数是从1开始的
        System.out.println("今日更新内容\n"+result);
        return result;
    }



    /**
     * 分类大全区域
     * */
    //获取指定条件的数据
    @Override
    public List<ff_vod> selectVideo(String lang, String publisharea, String publishyear,String letter, Integer pageNum) {
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
        List<ff_vod> result= mapper.selectVideo(lang, publisharea,year,before,letter,pagenum);
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
    public ff_vod selectVideoById(int vid) {
        ff_vod result=mapper.selectVideoById(vid);
        return result;
    }

    // 根据视频id来获取视频的详细信息
    @Override
    public String selectContent(int vid) {
        String result= mapper.selectContent(vid);
        return result;
    }

    // 根据视频id来获取视频的播放数据
    @Override
    public List getPlay(int vid) {
        String result=mapper.selectPlay(vid);
        System.out.println("@@getPlay"+result);
        List list=playUtils.getUrl2(result);
        return list;
    }
    // 根据视频id来获取视频的集数
    @Override
    public List getScore(int vid) {
        String result=mapper.selectPlay(vid);
        List list=playUtils.getScore2(result);
        return list;
    }
}
