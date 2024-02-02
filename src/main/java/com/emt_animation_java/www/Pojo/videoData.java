package com.emt_animation_java.www.Pojo;

import lombok.Data;

@Data
public class videoData {
    private Integer vId;  //作品编号
    private String vName;  //作品名称
    private int vState;  //作品状态（集数）
    private String vPic;  //作品封面
    private String vActor;  //声优
    private int vPublishyear;  //上映时间（年份）
    private String vPublisharea;  //上映地区（制作国）
    private int vAddtime;  //添加时间（时间戳）
    private String vNote; //更新状态
    private String vLetter;  //作品开头字母
    private String vDirector;  //制作人
    private String vLang; //语种（作品语类）


}




