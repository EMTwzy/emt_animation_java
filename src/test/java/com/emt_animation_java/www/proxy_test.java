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
        String result = "$$第01集$https://v.cdnlz19.com/share/cf67355a3333e6e143439161adc2d82e$liangzi#第02集$https://v.cdnlz19.com/share/38913e1d6a7b94cb0f55994f679f5956$liangzi#第03集$https://v.cdnlz19.com/share/ebd9629fc3ae5e9f6611e2ee05a31cef$liangzi#第04集$https://v.cdnlz19.com/share/63538fe6ef330c13a05a3ed7e599d5f7$liangzi#第05集$https://v.cdnlz19.com/share/07563a3fe3bbe7e3ba84431ad9d055af$liangzi#第06集$https://v.cdnlz19.com/share/2bb232c0b13c774965ef8558f0fbd615$liangzi#第07集$https://v.cdnlz19.com/share/ba2fd310dcaa8781a9a652a31baf3c68$liangzi#第08集$https://v.cdnlz19.com/share/53fde96fcc4b4ce72d7739202324cd49$liangzi#第09集$https://v.cdnlz19.com/share/85422afb467e9456013a2a51d4dff702$liangzi#第10集$https://v.cdnlz19.com/share/13f320e7b5ead1024ac95c3b208610db$liangzi#第11集$https://v.cdnlz19.com/share/69421f032498c97020180038fddb8e24$liangzi#第12集$https://v.cdnlz19.com/share/0fcbc61acd0479dc77e3cccc0f5ffca7$liangzi#第13集$https://v.cdnlz19.com/share/37f0e884fbad9667e38940169d0a3c95$liangzi#第14集$https://v.cdnlz19.com/share/f4be00279ee2e0a53eafdaa94a151e2c$liangzi#第15集$https://v.cdnlz19.com/share/d64a340bcb633f536d56e51874281454$liangzi#第16集$https://v.cdnlz19.com/share/df877f3865752637daa540ea9cbc474f$liangzi#第17集$https://v.cdnlz19.com/share/c399862d3b9d6b76c8436e924a68c45b$liangzi#第18集$https://v.cdnlz19.com/share/298f95e1bf9136124592c8d4825a06fc$liangzi#第19集$https://v.cdnlz19.com/share/5ea1649a31336092c05438df996a3e59$liangzi#第20集$https://v.cdnlz19.com/share/33e8075e9970de0cfea955afd4644bb2$liangzi#第21集$https://v.cdnlz19.com/share/7bcdf75ad237b8e02e301f4091fb6bc8$liangzi#第22集$https://v.cdnlz19.com/share/65658fde58ab3c2b6e5132a39fae7cb9$liangzi#第23集$https://v.cdnlz19.com/share/5737034557ef5b8c02c0e46513b98f90$liangzi#第24集$https://v.cdnlz19.com/share/16c222aa19898e5058938167c8ab6c57$liangzi#第25集$https://v.cdnlz19.com/share/9b72e31dac81715466cd580a448cf823$liangzi#第26集$https://v.cdnlz19.com/share/81448138f5f163ccdba4acc69819f280$liangzi$$$$$第01集$https://v.cdnlz19.com/20230923/520_ca029fe5/index.m3u8$lzm3u8#第02集$https://v.cdnlz19.com/20230923/517_81f87b39/index.m3u8$lzm3u8#第03集$https://v.cdnlz19.com/20230923/518_9cf95f54/index.m3u8$lzm3u8#第04集$https://v.cdnlz19.com/20230923/519_cd529221/index.m3u8$lzm3u8#第05集$https://v.cdnlz19.com/20230923/521_14d5360b/index.m3u8$lzm3u8#第06集$https://v.cdnlz19.com/20230923/523_84d964f6/index.m3u8$lzm3u8#第07集$https://v.cdnlz19.com/20230923/524_f39ff863/index.m3u8$lzm3u8#第08集$https://v.cdnlz19.com/20230923/522_8fd30e17/index.m3u8$lzm3u8#第09集$https://v.cdnlz19.com/20230923/526_1423da87/index.m3u8$lzm3u8#第10集$https://v.cdnlz19.com/20230923/527_b3898655/index.m3u8$lzm3u8#第11集$https://v.cdnlz19.com/20230923/525_81388b4f/index.m3u8$lzm3u8#第12集$https://v.cdnlz19.com/20230923/531_536bb411/index.m3u8$lzm3u8#第13集$https://v.cdnlz19.com/20230923/529_7faee7d4/index.m3u8$lzm3u8#第14集$https://v.cdnlz19.com/20230923/528_9287f0d9/index.m3u8$lzm3u8#第15集$https://v.cdnlz19.com/20230923/530_8a138e55/index.m3u8$lzm3u8#第16集$https://v.cdnlz19.com/20230923/533_c7ab83b8/index.m3u8$lzm3u8#第17集$https://v.cdnlz19.com/20230923/534_9b15a6ad/index.m3u8$lzm3u8#第18集$https://v.cdnlz19.com/20230923/532_09aa9bb0/index.m3u8$lzm3u8#第19集$https://v.cdnlz19.com/20230923/537_93ed30a7/index.m3u8$lzm3u8#第20集$https://v.cdnlz19.com/20230923/535_74710d0e/index.m3u8$lzm3u8#第21集$https://v.cdnlz19.com/20230923/538_cacf4628/index.m3u8$lzm3u8#第22集$https://v.cdnlz19.com/20230923/536_3a4a382f/index.m3u8$lzm3u8#第23集$https://v.cdnlz19.com/20230923/539_08f2c545/index.m3u8$lzm3u8#第24集$https://v.cdnlz19.com/20230923/541_5f72d60b/index.m3u8$lzm3u8#第25集$https://v.cdnlz19.com/20230923/540_783aba5d/index.m3u8$lzm3u8#第26集$https://v.cdnlz19.com/20230923/543_01f492bc/index.m3u8$lzm3u8";
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
        if (list.size() > list2.size()) {
            System.out.println("set1 is larger");
        } else if (list.size() < list2.size()) {
            System.out.println("set2 is larger");
        } else {
            System.out.println("Both sets are the same size");
        }
        if(list2.size()!=list.size()){
            List clear=list.subList(list2.size(), list.size());
            clear.clear();
        }

        return list;
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
