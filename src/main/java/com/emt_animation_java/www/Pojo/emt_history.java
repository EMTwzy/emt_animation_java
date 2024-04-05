package com.emt_animation_java.www.Pojo;

import lombok.Data;

//观看历史
@Data
public class emt_history {
    private Integer userId;    //用户id
    private Integer vodPreId;  //上次观看番剧的id号
    private String vodEpisode;  //上次观看的集数
    private Integer vodWatchTime;  //上次观看的时间

}
