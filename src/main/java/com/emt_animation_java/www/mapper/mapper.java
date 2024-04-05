package com.emt_animation_java.www.mapper;

import com.emt_animation_java.www.Pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface mapper{

    /**
     *
     * 首页区域    home
     * */
    //随机推荐
    List<ff_vod> randomVideo(Integer start);
    //获取所有数据的总额
    Integer totalVideo();
    //根据名称获取模糊数据
    List<ff_vod> selectVideoByName(String name);
    //每周更新榜单
    List<ff_vod> weekNew(@Param("beforeDate1") long beforeDate1,@Param("beforeDate2") long beforeDate2,@Param("nowDate1")long nowDate1,@Param("nowDate2") long nowDate2,@Param("beforeyear") int beforeyear,@Param("year") int year);

    /**
     *
     * 分类大全区域    all
     *
     * */
    //获取指定条件的数据
    List<ff_vod> selectVideo(@Param("lang") String lang,@Param("publisharea") String publisharea,@Param("publishyear") Integer publishyear,@Param("before") Integer before,@Param("letter")String letter,@Param("pageNum") Integer pageNum);
    //获取指定条件的数据总额
    Integer selectVideoNum(@Param("lang") String lang,@Param("publisharea") String publisharea,@Param("publishyear") Integer publishyear,@Param("before") Integer before,@Param("letter")String letter);

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
    String selectPlay(int vid);

    /***************************************手机端接口***********************************************************/
    //注册用户
    Integer register(emt_user emtUser);
    //修改用户 根据用户id  修改用户
    Integer changeUser(emt_user emtUser);
    //检测用户名是否已经存在
    Integer selectUserName(String userName);
    //用户登录
    emt_user loginUser(@Param("userName") String userName,@Param("userPassword") String userPassword);

    //添加追番
    Integer addSubscribe(@Param("userId") Integer userId,@Param("userSubId") Integer userSubId);
    //获取用户的追番内容
    List<emt_subscribe> selectSubscribe(Integer userId);
    //检测是否已经属于追番内容
    Integer isSubscribe(@Param("userId") Integer userId,@Param("userSubId") Integer userSubId);
    //删除追番
    Integer deleteSubscribe(@Param("userId") Integer userId,@Param("userSubId") Integer userSubId);

    //获取观看历史
    List<emt_history> getHistory(Integer userId);
    //添加历史记录
    Integer addHistory(emt_history emtHistory);
    //查看历史记录是否已经存在
    emt_history selectHistory(emt_history emtHistory);
    //删除历史记录
    Integer deleteHistory(emt_history emtHistory);
    //更新历史记录
    Integer updateHistory(emt_history emtHistory);

}
