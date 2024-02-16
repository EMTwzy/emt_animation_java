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

    //feifei
    @Test
    public void test02(){
        // 输入的字符串数据
        /*String data = "上部$https://v.cdnlz17.com/share/a8d972f22527b09a03564f854a3eb9a3\n" +
                "下部$https://v.cdnlz17.com/share/2d273973a88b3ab45f0d0763300b0695";*ok*/
        /*String data="OVA$https://vip1.lz-cdn5.com/share/9ea68e97266389f3fe227b9c0e0084f3";*ok*/
        /*String data="日语$https://vip1.lz-cdn5.com/share/bba744f5b4581db0ecf8eb6385c4c92a\n" +
                "普通话$https://vip1.lz-cdn5.com/share/a640f3accaebcb81205e773a65e3d894";*ok*/
        /*String data="粤语中字$https://vip.lz-cdn10.com/share/23ad3e314e2a2b43b4c720507cec0723\n" +
                "国语中字$https://vip.lz-cdn10.com/share/59f51fd6937412b7e56ded1ea2470c25\n" +
                "英语中字$https://vip.lz-cdn10.com/share/54072f485cdb7897ebbcaf7525139561";*ok*/
        /*String data="01集$https://vip1.lz-cdn5.com/share/d1f491a404d6854880943e5c3cd9ca25\n" +
                "02集$https://vip1.lz-cdn5.com/share/9b8619251a19057cff70779273e95aa6\n" +
                "03集$https://vip1.lz-cdn5.com/share/1afa34a7f984eeabdbb0a7d494132ee5\n" +
                "04集$https://vip1.lz-cdn5.com/share/65ded5353c5ee48d0b7d48c591b8f430\n" +
                "05集$https://vip1.lz-cdn5.com/share/9fc3d7152ba9336a670e36d0ed79bc43\n" +
                "06集$https://vip1.lz-cdn5.com/share/7f1de29e6da19d22b51c68001e7e0e54\n" +
                "07集$https://vip1.lz-cdn5.com/share/02522a2b2726fb0a03bb19f2d8d9524d\n" +
                "08集$https://vip1.lz-cdn5.com/share/3988c7f88ebcb58c6ce932b957b6f332\n" +
                "09集$https://vip1.lz-cdn5.com/share/42a0e188f5033bc65bf8d78622277c4e\n" +
                "10集$https://vip1.lz-cdn5.com/share/013d407166ec4fa56eb1e1f8cbe183b9\n" +
                "11集$https://vip1.lz-cdn5.com/share/e00da03b685a0dd18fb6a08af0923de0\n" +
                "12集$https://vip1.lz-cdn5.com/share/1385974ed5904a438616ff7bdb3f7439";*ok*/
        /*String data="少女与战车\u200B01\u200B$https://vip.lz-cdn3.com/share/82cadb0649a3af4968404c9f6031b233\n" +
                "少女与战车\u200B02\u200B$https://vip.lz-cdn3.com/share/7385db9a3f11415bc0e9e2625fae3734\n" +
                "少女与战车\u200B03\u200B$https://vip.lz-cdn3.com/share/cd63a3eec3319fd9c84c942a08316e00\n" +
                "少女与战车\u200B04\u200B$https://vip.lz-cdn3.com/share/eb1e78328c46506b46a4ac4a1e378b91\n" +
                "少女与战车\u200B05\u200B$https://vip.lz-cdn3.com/share/ff1418e8cc993fe8abcfe3ce2003e5c5\n" +
                "少女与战车\u200B05.5\u200B$https://vip.lz-cdn3.com/share/8c3039bd5842dca3d944faab91447818\n" +
                "少女与战车\u200B06\u200B$https://vip.lz-cdn3.com/share/6ae07dcb33ec3b7c814df797cbda0f87\n" +
                "少女与战车\u200B07\u200B$https://vip.lz-cdn3.com/share/49ad23d1ec9fa4bd8d77d02681df5cfa\n" +
                "少女与战车\u200B08\u200B$https://vip.lz-cdn3.com/share/7503cfacd12053d309b6bed5c89de212\n" +
                "少女与战车\u200B09\u200B$https://vip.lz-cdn3.com/share/3c947bc2f7ff007b86a9428b74654de5\n" +
                "少女与战车\u200B10\u200B$https://vip.lz-cdn3.com/share/d7fd118e6f226a71b5f1ffe10efd0a78\n" +
                "少女与战车\u200B10.5\u200B$https://vip.lz-cdn3.com/share/a3545bd79d31f9a72d3a78690adf73fc\n" +
                "少女与战车\u200B11\u200B$https://vip.lz-cdn3.com/share/537de305e941fccdbba5627e3eefbb24\n" +
                "少女与战车\u200B12\u200B$https://vip.lz-cdn3.com/share/96c5c28becf18e71190460a9955aa4d8";*ok*/

        /*String data="范马刃牙2.E01$https://vip.lz-cdn14.com/share/dd0894e849355e5d45b412747ca2c171\n" +
                "范马刃牙2.E02$https://vip.lz-cdn14.com/share/e7a180ba295bede84074fba08a8feea4\n" +
                "范马刃牙2.E03$https://vip.lz-cdn14.com/share/51ca813b865fb6a3be61edd9fdf0b157\n" +
                "范马刃牙2.E04$https://vip.lz-cdn14.com/share/7b01caa07b92e8424d45487ee923bdd4\n" +
                "范马刃牙2.E05$https://vip.lz-cdn14.com/share/96998fec57d81a588cb70dfd7a56bab8\n" +
                "范马刃牙2.E06$https://vip.lz-cdn14.com/share/6a80f2ad74fa2f0970862d9e35b138a5\n" +
                "范马刃牙2.E07$https://vip.lz-cdn14.com/share/02e21fb779dbb8b83fd0b59d5c1aa47a\n" +
                "范马刃牙2.E08$https://vip.lz-cdn14.com/share/8982b5cddffd5fac453edda6bf3499f2\n" +
                "范马刃牙2.E09$https://vip.lz-cdn14.com/share/1e4f05d264788b72ffd120140ca80f70\n" +
                "范马刃牙2.E10$https://vip.lz-cdn14.com/share/6db77179478187c6a0479a878afa4990\n" +
                "范马刃牙2.E11$https://vip.lz-cdn14.com/share/b24c2746c61a04d2ee059ada217c39a7\n" +
                "范马刃牙2.E12$https://vip.lz-cdn14.com/share/50f5a0b224ddb1270e0f523c7efae216\n" +
                "范马刃牙2.E13$https://vip.lz-cdn14.com/share/d6979f4b1fc40f9d720e42d4ce13bb10";*ok*/

        String data="第01集$https://vip1.lz-cdn5.com/share/a6143dafe10eb30e48832f3a092674e0\n" +
                "第02集$https://vip1.lz-cdn5.com/share/dcf702356e8c9c78c3fd3e87f0d8896f\n" +
                "第03集$https://vip1.lz-cdn5.com/share/751d8d469b4f5508690047d65cbdac1b\n" +
                "第04集$https://vip1.lz-cdn5.com/share/d4dcf709a96dca127d0429d73c443afb\n" +
                "第05集$https://vip1.lz-cdn5.com/share/70fa3e3aed5e5da45f0114c00fadfb41\n" +
                "第06集$https://vip1.lz-cdn5.com/share/4c74dcfeac90df69aed5c8a90125e696\n" +
                "第07集$https://vip1.lz-cdn5.com/share/320274ee8b7f2e8a82d37d07f64c0e0b\n" +
                "第08集$https://vip1.lz-cdn5.com/share/7992308d89ff6b43bc197c8ef9bd934b\n" +
                "第09集$https://vip1.lz-cdn5.com/share/8f7b2d9100577f77aa8fbb4f51c0366e\n" +
                "第10集$https://vip1.lz-cdn5.com/share/c8be071dc1fa4062d7638bb7c9d17afb\n" +
                "第11集$https://vip1.lz-cdn5.com/share/8513351ff7f10b0f156c9d1f669e1210\n" +
                "第12集$https://vip1.lz-cdn5.com/share/6dc4a31db60d3da6b1d477315619952e";
        List collection1=getScore2(data);
        List collection2=getUrl2(data);

        // 输出结果
        System.out.println("第**集集合: " + collection1);
        System.out.println("链接地址集合: " + collection2);
    }
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
        //String regex = "(第\\d+集)\\$(https://[^\\s]+)";
        String regex="([^$]+)\\$(https://[^\\s]+)";
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
    //sea
    @Test
    public void test() {
        //String result = "$$HD中字$https://v.cdnlz3.com/20240115/22790_1d9c990e/index.m3u8$lzm3u8";
        String result = "$$第01集$https://v.cdnlz9.com/share/6d94f9a8ea3ab919370c4bbd22ce9956$liangzi#第02集$https://v.cdnlz9.com/share/ee2a8f73ebe363a55544a8f4891798e1$liangzi#第03集$https://v.cdnlz9.com/share/bc80ecf162f29b1afc2c38244c970619$liangzi#第04集$https://v.cdnlz9.com/share/06c41ca6bbfc0e9c3fae6c256ba5e5b1$liangzi#第05集$https://v.cdnlz9.com/share/c50963c801026896bcfaa38b535b5e88$liangzi#第06集$https://v.cdnlz9.com/share/14c7eca07aae3fc68903321ffdbea120$liangzi#第07集$https://v.cdnlz9.com/share/9fa382e159884a63dc1a118b00bed446$liangzi#第08集$https://v.cdnlz9.com/share/a1a3170911eaa82c07fccbcbdf61f6bb$liangzi$$$$$第01集$https://v.cdnlz9.com/20231027/19695_aad860f6/index.m3u8$lzm3u8#第02集$https://v.cdnlz9.com/20231027/19696_e2276274/index.m3u8$lzm3u8#第03集$https://v.cdnlz9.com/20231027/19697_83bebbc9/index.m3u8$lzm3u8#第04集$https://v.cdnlz9.com/20231027/19698_21e493d5/index.m3u8$lzm3u8#第05集$https://v.cdnlz9.com/20231027/19699_08671c78/index.m3u8$lzm3u8#第06集$https://v.cdnlz9.com/20231027/19701_9b54061b/index.m3u8$lzm3u8#第07集$https://v.cdnlz9.com/20231027/19700_ec77ea8f/index.m3u8$lzm3u8#第08集$https://v.cdnlz9.com/20231027/19702_ae9bc280/index.m3u8$lzm3u8";
        /*String result="第01集$https://v.cdnlz14.com/share/cb92ee0067e7481c88954b7d8abd8f4a" +
                "第02集$https://v.cdnlz14.com/share/429b0e69b87e2517efea925bab949a63" +
                "第03集$https://v.cdnlz14.com/share/5da4215028c3f94fbb1c42dab58ab173" +
                "第04集$https://v.cdnlz14.com/share/564ed2dbdd6f0567500e8a1b7981f28b" +
                "第05集$https://v.cdnlz14.com/share/90c0f9bdcc0baee52fc7928a6548af9b" +
                "第06集$https://v.cdnlz14.com/share/66a34e4b7bb6b9bb0e4897a7041a93b2";*/
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
