package com.emt_animation_java.www.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class playUtils {
    /**
     * sea
     * */
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
        if(list.size()>0){
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
        }else{
            regex = "\\$([^$]+)\\$";;
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(result);
            list = new ArrayList<>();
            while (matcher.find()) {
                String ed = matcher.group(1);
                list.add(ed);
            }
            if(list.size()>1){
                List list3=list.subList(1, list.size());      //希望不会有剧场版分上下集采集在一起
                list3.clear();
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

    /**
     * feifei
     * */
    //获取集数
    public static List<String> getScore2(String result){
        // 正则表达式
        String regex = "(第\\d+集)\\$(https://[^\\s]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);

        // 创建1个集合
        List<String> collection1 = new ArrayList<>();


        // 分别放入集合
        while (matcher.find()) {
            collection1.add(matcher.group(1));

        }

        if(collection1.size()<1){
            regex = "([^$]+)\\$https://[^\\s]+";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(result);
            while (matcher.find()) {
                collection1.add(matcher.group(1));

            }
        }
        return collection1;
    }
    //获取播放链接
    public static List<String> getUrl2(String url){
        // 正则表达式
        String regex = "(第\\d+集)\\$(https://[^\\s]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        // 创建两个集合
        List<String> collection2 = new ArrayList<>();


        // 分别放入集合
        while (matcher.find()) {
            collection2.add(matcher.group(2));

        }
        return collection2;
    }

}
