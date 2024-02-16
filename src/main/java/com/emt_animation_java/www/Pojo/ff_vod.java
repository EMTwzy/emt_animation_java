package com.emt_animation_java.www.Pojo;

import lombok.Data;

@Data
public class ff_vod {
    public Integer vodId;//视频id号
    public String vodName;//视频名称
    public String vodTitle;//对标note(当前番剧状态)
    public String vodActor;//配音
    public String vodContent;//番剧简介
    public String vodPic;//封面
    public String vodArea;//地区，对标v_publicarea
    public String vodLanguage;//语言类别
    public Integer vodYear;//上映年份
    public String vodAddtime;//时间戳
    public String vodUrl;//播放地址
    public String vodLetter;//开头字母大小写
}
