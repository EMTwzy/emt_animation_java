package com.emt_animation_java.www;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class proxy_test {

    @Test
    public void test() {
        //String result = "$$HD中字$https://v.cdnlz3.com/20240115/22790_1d9c990e/index.m3u8$lzm3u8";
        String result = "$$第01集$https://v.cdnlz9.com/share/6d94f9a8ea3ab919370c4bbd22ce9956$liangzi#第02集$https://v.cdnlz9.com/share/ee2a8f73ebe363a55544a8f4891798e1$liangzi#第03集$https://v.cdnlz9.com/share/bc80ecf162f29b1afc2c38244c970619$liangzi#第04集$https://v.cdnlz9.com/share/06c41ca6bbfc0e9c3fae6c256ba5e5b1$liangzi#第05集$https://v.cdnlz9.com/share/c50963c801026896bcfaa38b535b5e88$liangzi#第06集$https://v.cdnlz9.com/share/14c7eca07aae3fc68903321ffdbea120$liangzi#第07集$https://v.cdnlz9.com/share/9fa382e159884a63dc1a118b00bed446$liangzi#第08集$https://v.cdnlz9.com/share/a1a3170911eaa82c07fccbcbdf61f6bb$liangzi$$$$$第01集$https://v.cdnlz9.com/20231027/19695_aad860f6/index.m3u8$lzm3u8#第02集$https://v.cdnlz9.com/20231027/19696_e2276274/index.m3u8$lzm3u8#第03集$https://v.cdnlz9.com/20231027/19697_83bebbc9/index.m3u8$lzm3u8#第04集$https://v.cdnlz9.com/20231027/19698_21e493d5/index.m3u8$lzm3u8#第05集$https://v.cdnlz9.com/20231027/19699_08671c78/index.m3u8$lzm3u8#第06集$https://v.cdnlz9.com/20231027/19701_9b54061b/index.m3u8$lzm3u8#第07集$https://v.cdnlz9.com/20231027/19700_ec77ea8f/index.m3u8$lzm3u8#第08集$https://v.cdnlz9.com/20231027/19702_ae9bc280/index.m3u8$lzm3u8";
        List<String> list = filterEpisode(result);
        List<String> list2=getUrl(result);

        System.out.println("Episode List: "+ list);
        System.out.println("Episode List: "+ list.size());
        System.out.println("url:\t"+list2.size());
    }

    private List<String> filterEpisode(String result) {
        List<String> list = new ArrayList<>();

        String regex = "第(\\d+)集";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);

            while (matcher.find()) {
                String episode = matcher.group(1).trim();
                list.add("第" + episode + "集");
            }
            System.out.println("数据表中的集数"+list.size());
            if(list.size()!=0){
                int j=0;
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).equals("第01集")){
                        j++;
                        System.out.println("01"+i+"\t  jj"+j);
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
                    List list3=list.subList(1, list.size());
                    list3.clear();
                }
            }


        return list;
    }
    public List<String> getUrl(String url){
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
        List list2=filterEpisode(url);
        System.out.println("go"+list2.size());

        if(list2.size()!=list.size()){
            List clear=list.subList(list2.size(), list.size());
            clear.clear();
        }
        System.out.println("过滤后的url长度"+list2.size());

        return list;
    }

    @Test
    public void hdtest(){
        String input = "$$HD中字$https://v.cdnlz3.com/share/5b8ee00e850bd94529d0d55a4bc72f10$liangziHD中字$https://v.cdnlz3.com/20231228/22506_2ce0a4d6/index.m3u8$lzm3u8";
        //String input = "$$HD中字$https://v.cdnlz3.com/20240115/22790_1d9c990e/index.m3u8$lzm3u8";
        String regex = "\\$([^$]+)\\$";




        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> resultList = new ArrayList<>();

        while (matcher.find()) {
            String result = matcher.group(1);
            resultList.add(result);
        }
        if(resultList.size()>1){
            List list3=resultList.subList(1, resultList.size());
            list3.clear();
        }

        System.out.println(resultList);
    }

    private static void inputOut(String inputPath) throws IOException {
        HttpURLConnection connection = null;

        try {
            // 创建URL连接
            URL url = new URL(inputPath);

            // 连接网站
            connection = (HttpURLConnection) url.openConnection();

            // 创建文件输入流
            InputStream inputStream = connection.getInputStream();

            // 使用BufferedReader读取资源内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            System.out.println("资源内容：" + response.toString());
        } finally {
            // 确保连接关闭，释放资源
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        String src = "https://pic.mazc.org/uploads/d63b9ce63f4670.jpg";
        try {
            inputOut(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
