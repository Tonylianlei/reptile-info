package com.example.reptile.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 创建人:连磊
 * 日期: 2019/5/13. 17:43
 * 描述：
 */
public class UrlUtil {

    public static String getUrlHtml(String url){

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        String htmlInfo = null;

        try {
            CloseableHttpResponse execute = httpClient.execute(httpGet);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (200 == statusCode){
                HttpEntity entity = execute.getEntity();
                String string = EntityUtils.toString(entity);
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return htmlInfo;
    }

    public static void main(String[] args) {
        getUrlHtml("https://www.csdn.net/");
    }

}
