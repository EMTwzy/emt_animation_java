package com.emt_animation_java.www.service;

import com.emt_animation_java.www.Pojo.content;
import com.emt_animation_java.www.Pojo.play;
import com.emt_animation_java.www.Pojo.videoData;

import java.util.List;

public interface service {
    /**
     *
     * 首页区域
     * */

    //随机推荐
    List<videoData> randomVideo();
    //获取所有数据的总额
    Integer totalVideo();
    //根据名称获取模糊数据
    List<videoData> selectVideoByName(String name);
    //每周更新榜单
    List<videoData> weekNew(Integer day);

    /**
     *
     * 分类大全区
     * */
    //获取指定条件的数据
    List<videoData> selectVideo(String lang,String publisharea,String publishyear,String letter,Integer pageNum);
    //获取指定条件的数据总额
    Integer selectVideoNum(String lang,String publisharea,String publishyear,String letter);
    /***
     *
     * 播放区      play
     *
     * **/
    // 根据视频id来获取视频的信息
    videoData selectVideoById(int vid);
    // 根据视频id来获取视频的详细信息
    content selectContent(int vid);
    // 根据视频id来获取视频的播放数据
    List getPlay(int vid);
    List getScore(int vid);
}
