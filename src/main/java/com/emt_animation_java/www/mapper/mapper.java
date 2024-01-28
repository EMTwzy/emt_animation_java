package com.emt_animation_java.www.mapper;

import com.emt_animation_java.www.Pojo.content;
import com.emt_animation_java.www.Pojo.play;
import com.emt_animation_java.www.Pojo.videoData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface mapper {

    /**
     *
     * 首页区域    home
     * */
    //随机推荐
    List<videoData> randomVideo(Integer start);
    //获取所有数据的总额
    Integer totalVideo();
    //根据名称获取模糊数据
    List<videoData> selectVideoByName(String name);
    //每周更新榜单
    List<videoData> weekNew(@Param("beforeDate1") long beforeDate1,@Param("beforeDate2") long beforeDate2,@Param("nowDate1")long nowDate1,@Param("nowDate2") long nowDate2,@Param("year") int year);

    /**
     *
     * 分类大全区域    all
     *
     * */
    //获取指定条件的数据
    List<videoData> selectVideo(@Param("lang") String lang,@Param("publisharea") String publisharea,@Param("publishyear") Integer publishyear,@Param("before") Integer before,@Param("letter")String letter,@Param("pageNum") Integer pageNum);
    //获取指定条件的数据总额
    Integer selectVideoNum(@Param("lang") String lang,@Param("publisharea") String publisharea,@Param("publishyear") Integer publishyear,@Param("before") Integer before,@Param("letter")String letter);

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
    play selectPlay(int vid);
}
