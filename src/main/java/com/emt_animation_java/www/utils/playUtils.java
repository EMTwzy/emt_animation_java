package com.emt_animation_java.www.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public static List<String> getScore2(String result,Integer options){
        // 正则表达式
        //String regex = "(第\\d+集)\\$(https://[^\\s]+)";
        String regex = "第\\d+集";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);

        // 创建1个集合
        List<String> collection1 = new ArrayList<>();


        // 分别放入集合
        while (matcher.find()) {
            collection1.add(matcher.group(0));

        }

        if(collection1.size()<1){
            //regex = "([^$]+)\\$https://[^\\s]+";
           /* regex = "([^$\\n]+)(?=\\n*\\$https)";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(result);
            while (matcher.find()) {
                collection1.add(matcher.group()); //1

            }*/
            // Exclude links
            String withoutLinks = result.replaceAll("https?://[^$\\s]+", "");

            // Match non-link content
            pattern = Pattern.compile("([^$]+)");
            matcher = pattern.matcher(withoutLinks);

            // Store non-link content in a list
            while (matcher.find()) {
                String match = matcher.group(1).trim();
                if (!match.isEmpty()) { // Check if match is not empty
                    collection1.add(match);
                }
            }

        }

        //整理数据
        List webApp=null;
        int length= collection1.size()/2;
        int i=length==1?0:1;
        for (int i1 = 0; i1 < collection1.size(); i1++) {
            System.out.print(collection1.get(i1)+"\t");
        }
        System.out.println("看看i和length\t"+i+"\t"+length+"\t"+collection1.size());
        System.out.println("\n看看i\t"+(length+i));
        webApp = IntStream.range(0, length) // [0,length);
                .mapToObj(collection1::get) // 使用索引从原始集合中获取元素
                .collect(Collectors.toList()); // 收集结果到新的List

        return webApp;
    }
    //获取播放链接
    public static List<String> getUrl2(String url,Integer options){
        // 正则表达式
        //String regex = "(第\\d+集)\\$(https://[^\\s]+)";
        //String regex="([^$]+)\\$(https://[^\\s]+)";
        String regex = "(?<=\\$https://)[^\\s$]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        // 创建两个集合
        List<String> collection2 = new ArrayList<>();


        // 分别放入集合
        while (matcher.find()) {
            collection2.add("https://" + matcher.group());

        }
        int length= collection2.size()/2;   // 2/2=1    但是java的索引值也是从0开始计数的
        List<String> webList=null;
        List<String> appList=null;

        System.out.println("测试:"+collection2.get(0).contains("index.m3u8"));

        if(collection2.get(0).contains("index.m3u8"))
        {
            //如果第一个是app端的
            appList = IntStream.range(0, length) // [0,length);
                    .mapToObj(collection2::get) // 使用索引从原始集合中获取元素
                    .collect(Collectors.toList()); // 收集结果到新的List
            webList=IntStream.range(length, collection2.size())
                    .mapToObj(collection2::get)
                    .collect(Collectors.toList());
        }else{       //如果app端的在后面
            appList = IntStream.range(length, collection2.size())
                    .mapToObj(collection2::get)
                    .collect(Collectors.toList());
            webList=IntStream.range(0, length)
                    .mapToObj(collection2::get)
                    .collect(Collectors.toList());
        }

        return options==0?webList:appList;
    }

}
