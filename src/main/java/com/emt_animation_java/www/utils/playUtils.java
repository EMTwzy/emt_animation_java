package com.emt_animation_java.www.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class playUtils {
    //获取集数
    public static List<String> getScore(String result) {
        List<String> list = new ArrayList<>();
        String regex = "第(\\d+)集";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            String episode = matcher.group(1).trim();
            list.add("第" + episode + "集");
        }

        int j=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("第01集")){
                j++;
            }
            if(j==2){
                List res=list.subList(i, list.size());
                res.clear();
                break;
            }
        }
        return list;
    }
    //获取播放链接
    public static List<String> getUrl(String url){
        List list=new ArrayList();
        String regex = "\\$https://[^$]+\\$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        while (matcher.find()) {
            String group = matcher.group().replace("$", "").trim();
            // 去除可能包含的无关字符
            if (group.startsWith("https://")) {
                list.add(group);
            }
        }
        List list2=getScore(url);
        if(list2.size()!=list.size()){
            List clear=list.subList(list2.size(),list.size());
            clear.clear();
        }
        return list;
    }



}