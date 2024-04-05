package com.emt_animation_java.www.service;

import com.emt_animation_java.www.Pojo.*;

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
    List getPlay(int vid,Integer options);
    List getScore(int vid,Integer options);

    /************手机端**************/
    //注册用户
    Integer register(emt_user emtUser);
    //修改用户 根据用户id  修改用户
    Integer changeUser(emt_user emtUser);
    //检测用户名是否已经存在
    Integer selectUserName(String userName);
    //用户登录
    emt_user loginUser(String userName,String userPassword);

    //添加追番
    Integer addSubscribe(Integer userId,Integer userSubId);
    //获取用户的追番内容
    List<emt_subscribe> selectSubscribe(Integer userId);
    //检测是否已经属于追番内容
    Integer isSubscribe(Integer userId,Integer userSubId);
    //删除追番
    Integer deleteSubscribe(Integer userId,Integer userSubId);

    //获取观看历史
    List<emt_history> getHistory(Integer userId);
    //添加历史记录
    Integer addHistory(emt_history emtHistory);
    //删除历史记录
    Integer deleteHistory(emt_history emtHistory);
    //查看历史记录是否已经存在
    emt_history selectHistory(emt_history emtHistory);
    //更新历史记录
    Integer updateHistory(emt_history emtHistory);
}
