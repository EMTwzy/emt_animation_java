package com.emt_animation_java.www.service;

import com.emt_animation_java.www.Pojo.content;
import com.emt_animation_java.www.Pojo.play;
import com.emt_animation_java.www.Pojo.ff_vod;

import java.util.List;

public interface service {
    /**
     *
     * 首页区域
     * */

    //随机推荐
    List<ff_vod> randomVideo();
    //获取所有数据的总额
    Integer totalVideo();
    //根据名称获取模糊数据
    List<ff_vod> selectVideoByName(String name);
    //每周更新榜单
    List<ff_vod> weekNew(Integer day);

    /**
     *
     * 分类大全区
     * */
    //获取指定条件的数据
    List<ff_vod> selectVideo(String lang,String publisharea,String publishyear,String letter,Integer pageNum);
    //获取指定条件的数据总额
    Integer selectVideoNum(String lang,String publisharea,String publishyear,String letter);
    /***
     *
     * 播放区      play
     *
     * **/
    // 根据视频id来获取视频的信息
    ff_vod selectVideoById(int vid);
    // 根据视频id来获取视频的详细信息
    String selectContent(int vid);
    // 根据视频id来获取视频的播放数据
    List getPlay(int vid);
    List getScore(int vid);
}
