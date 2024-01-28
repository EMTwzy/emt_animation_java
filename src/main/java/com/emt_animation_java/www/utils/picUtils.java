package com.emt_animation_java.www.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class picUtils {
    public static boolean inputOut(String inputPath) throws IOException {
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

            if(response.length()>0)
                return true;
            else
                return false;
        } finally {
            // 确保连接关闭，释放资源
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
