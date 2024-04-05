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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class proxy_test {

    //feifei
    @Test
    public void test02() {
        // 输入的字符串数据
        String data="\n" +
                "第01集$https://vip1.lz-cdn5.com/20220503/13818_8a2c9373/index.m3u8\n" +
                "第02集$https://vip1.lz-cdn5.com/20220503/13821_b92c0aac/index.m3u8\n" +
                "第03集$https://vip1.lz-cdn5.com/20220503/13820_e6946ba7/index.m3u8\n" +
                "第04集$https://vip1.lz-cdn5.com/20220503/13823_0d484e57/index.m3u8\n" +
                "第05集$https://vip1.lz-cdn5.com/20220503/13822_3a812d2e/index.m3u8\n" +
                "第06集$https://vip1.lz-cdn5.com/20220503/13824_58fafe2d/index.m3u8\n" +
                "第07集$https://vip1.lz-cdn5.com/20220503/13825_477b66d4/index.m3u8\n" +
                "第08集$https://vip1.lz-cdn5.com/20220503/13826_5ff85632/index.m3u8\n" +
                "第09集$https://vip1.lz-cdn5.com/20220503/13827_20bc070a/index.m3u8\n" +
                "第10集$https://vip1.lz-cdn5.com/20220503/13828_c6ade55b/index.m3u8\n" +
                "第11集$https://vip1.lz-cdn5.com/20220503/13829_2c333d90/index.m3u8\n" +
                "第12集$https://vip1.lz-cdn5.com/20220503/13830_cdd3ac5f/index.m3u8\n" +
                "第13集$https://vip1.lz-cdn5.com/20220503/13832_65444653/index.m3u8\n" +
                "第14集$https://vip1.lz-cdn5.com/20220503/13831_f81d1f5a/index.m3u8\n" +
                "第15集$https://vip1.lz-cdn5.com/20220503/13834_6983edcc/index.m3u8\n" +
                "第16集$https://vip1.lz-cdn5.com/20220503/13833_cf121b34/index.m3u8\n" +
                "第17集$https://vip1.lz-cdn5.com/20220503/13836_8f9baa8d/index.m3u8\n" +
                "第18集$https://vip1.lz-cdn5.com/20220503/13835_9a5b77c3/index.m3u8\n" +
                "第19集$https://vip1.lz-cdn5.com/20220503/13837_b452033e/index.m3u8\n" +
                "第20集$https://vip1.lz-cdn5.com/20220503/13838_9319be1a/index.m3u8\n" +
                "第21集$https://vip1.lz-cdn5.com/20220503/13839_69c23197/index.m3u8\n" +
                "第22集$https://vip1.lz-cdn5.com/20220503/13840_37d670e1/index.m3u8\n" +
                "第23集$https://vip1.lz-cdn5.com/20220503/13841_351f2fec/index.m3u8\n" +
                "第24集$https://vip1.lz-cdn5.com/20220503/13842_5853ce1a/index.m3u8\n" +
                "第25集$https://vip1.lz-cdn5.com/20220503/13846_4fead01c/index.m3u8$$$第01集$https://vip1.lz-cdn5.com/share/a5dcd040486a679c3f649e721d8351dc\n" +
                "第02集$https://vip1.lz-cdn5.com/share/4ef5a564be51e55d5a1b86168a99f528\n" +
                "第03集$https://vip1.lz-cdn5.com/share/51934729f32d36841a17e43e9390483a\n" +
                "第04集$https://vip1.lz-cdn5.com/share/16e66f0d674db0deec510772414cd5b1\n" +
                "第05集$https://vip1.lz-cdn5.com/share/4ab3564cc099eb3b31a16042f06bd31e\n" +
                "第06集$https://vip1.lz-cdn5.com/share/1408358fe6a7f9327dd41a5651ac284c\n" +
                "第07集$https://vip1.lz-cdn5.com/share/a74d1ff33e951286f8b41bd995f0c5e0\n" +
                "第08集$https://vip1.lz-cdn5.com/share/af6ed7985af478ed7c4ab93cee8772de\n" +
                "第09集$https://vip1.lz-cdn5.com/share/f075ae724a0ea982e4f09f003990a0e7\n" +
                "第10集$https://vip1.lz-cdn5.com/share/7cd5a1d4664804885ed5092f68ff1842\n" +
                "第11集$https://vip1.lz-cdn5.com/share/822bfaa40020f5d6b232139160b48b05\n" +
                "第12集$https://vip1.lz-cdn5.com/share/376dc62eeb4b777df0f1e58a91a7818f\n" +
                "第13集$https://vip1.lz-cdn5.com/share/2d8fe42de2f833581faa077f788329fa\n" +
                "第14集$https://vip1.lz-cdn5.com/share/aba2b11d01c3742d77a4391276731579\n" +
                "第15集$https://vip1.lz-cdn5.com/share/042aec9e604155f2f06c0a16c5f9ba06\n" +
                "第16集$https://vip1.lz-cdn5.com/share/08b94fd98ee63a60c5d191649dcfe29a\n" +
                "第17集$https://vip1.lz-cdn5.com/share/bbc4cd33ff8bc2cfdff66557dbd84a85\n" +
                "第18集$https://vip1.lz-cdn5.com/share/51e2038e383ecfc953bf1ab5a0747c63\n" +
                "第19集$https://vip1.lz-cdn5.com/share/c55c6eea07345c455a100597687a61d2\n" +
                "第20集$https://vip1.lz-cdn5.com/share/29f81692d9af87c8826aafca8ff5dad3\n" +
                "第21集$https://vip1.lz-cdn5.com/share/e286a04b20bc52074820789fd5eb78f6\n" +
                "第22集$https://vip1.lz-cdn5.com/share/b1fb3726a5a825732f9a25e210426c4a\n" +
                "第23集$https://vip1.lz-cdn5.com/share/cdcc686a434d09ed24e4b736d593858f\n" +
                "第24集$https://vip1.lz-cdn5.com/share/ebd58b8a3f1d72f4206201da62fb1204\n" +
                "第25集$https://vip1.lz-cdn5.com/share/9c25dc28b94e5226f1983330dc421cec";
        //String data="HD$https://vip1.lz-cdn5.com/share/403ea2e851b9ab04a996beab4a480a30$$$HD$https://vip1.lz-cdn5.com/20220331/2713_3e84e5ed/index.m3u8";
        //String data="HD中字$https://v.cdnlz3.com/20231228/22506_2ce0a4d6/index.m3u8$$$HD中字$https://v.cdnlz3.com/share/5b8ee00e850bd94529d0d55a4bc72f10";
        //String data="DVD高清$https://vip1.lz-cdn1.com/20220403/782_afccbb77$$$DVD高清$https://vip1.lz-cdn1.com/20220403/782_afccbb77/index.m3u8";
        /*String data = "日语$https://v.cdnlz2.com/20231129/27079_740e70d0/index.m3u8\n" +
                "国语$https://v.cdnlz20.com/20240327/1073_0068051e/index.m3u8$$$日语$https://v.cdnlz2.com/share/13941bddb1399810f387f38dc7c775f0\n" +
                "国语$https://v.cdnlz20.com/share/390e982518a50e280d8e2b535462ec1f";*/
        List collection1 = getScore2(data, 1);
        List collection2 = getUrl2(data, 1);    //假设0为web端，1为app端

        // 输出结果
        System.out.println("第**集集合: " + collection1);
        System.out.println("链接地址集合: " + collection2);
    }

    //获取集数
    public static List<String> getScore2(String result, Integer options) {
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

        if (collection1.size() < 1) {

            //regex = "([^$]+)\\$https://[^\\s]+";
            //regex = "[^$]+(?=\\$https)";
            /*regex = "([^$]+)(?:\\$https?|$)";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(result);
            while (matcher.find()) {
                collection1.add(matcher.group());//1

            }*/
            // Exclude links
            String withoutLinks = result.replaceAll("https?://[^$\\s]+", "");

            // Match non-link content
            pattern = Pattern.compile("([^$]+)");
            matcher = pattern.matcher(withoutLinks);

            // Store non-link content in a list
            List<String> resultList = new ArrayList<>();
            while (matcher.find()) {
                String match = matcher.group(1).trim();
                if (!match.isEmpty()) { // Check if match is not empty
                    collection1.add(match);
                }
            }


        }

        /*List webApp=null;
        int length= collection1.size()/2;
        webApp = IntStream.range(0, length) // [0,length);
                .mapToObj(collection1::get) // 使用索引从原始集合中获取元素
                .collect(Collectors.toList()); // 收集结果到新的List*/

        return collection1;
    }

    //获取播放链接
    public static List<String> getUrl2(String url, int options) {
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


        int length = collection2.size() / 2;   // 2/2=1    但是java的索引值也是从0开始计数的
        List<String> webList = null;
        List<String> appList = null;

        System.out.println("测试:" + collection2.get(0).contains("index.m3u8"));

        if (collection2.get(0).contains("index.m3u8")) {
            //如果第一个是app端的
            appList = IntStream.range(0, length) // [0,length);
                    .mapToObj(collection2::get) // 使用索引从原始集合中获取元素
                    .collect(Collectors.toList()); // 收集结果到新的List
            webList = IntStream.range(length, collection2.size())
                    .mapToObj(collection2::get)
                    .collect(Collectors.toList());
        } else {       //如果app端的在后面
            appList = IntStream.range(length, collection2.size())
                    .mapToObj(collection2::get)
                    .collect(Collectors.toList());
            webList = IntStream.range(0, length)
                    .mapToObj(collection2::get)
                    .collect(Collectors.toList());
        }

        return options == 0 ? webList : appList;
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
        List<String> list2 = getUrl(result);

        System.out.println("Episode List: " + list);
        System.out.println("Episode List: " + list.size());
        System.out.println("url:\t" + list2.size());
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
        System.out.println("数据表中的集数" + list.size());
        if (list.size() != 0) {
            int j = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("第01集")) {
                    j++;
                    System.out.println("01" + i + "\t  jj" + j);
                }
                if (j == 2) {
                    List res = list.subList(i, list.size());
                    res.clear();
                    break;
                }
            }
        } else {
            regex = "\\$([^$]+)\\$";
            ;

            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(result);

            list = new ArrayList<>();

            while (matcher.find()) {
                String ed = matcher.group(1);
                list.add(ed);
            }
            if (list.size() > 1) {
                List list3 = list.subList(1, list.size());
                list3.clear();
            }
        }


        return list;
    }

    public List<String> getUrl(String url) {
        List list = new ArrayList();
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
        List list2 = filterEpisode(url);
        System.out.println("go" + list2.size());

        if (list2.size() != list.size()) {
            List clear = list.subList(list2.size(), list.size());
            clear.clear();
        }
        System.out.println("过滤后的url长度" + list2.size());

        return list;
    }

    @Test
    public void hdtest() {
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
        if (resultList.size() > 1) {
            List list3 = resultList.subList(1, resultList.size());
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
