package com.example.distributed_graph_stock;

import com.alibaba.fastjson.JSONObject;
import com.hankcs.hanlp.restful.HanLPClient;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/5/3 10:12
 * @PACKAGE_NAME: com.example.distributed_graph_stock
 * @CLASS_NAME: HanLPClientTest
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public class HanLPClientTest {
    @Test
    public void test1() throws IOException {  //分词
        //请求头中的token
        String token = "c99d1f8dfe2342a9823f2f57a66dc7641683172627051token";
        //申请的接口地址
        String url = "http://comdo.hanlp.com/hanlp/v1/tagger/HMM";

        //请求头中的token
        //所有参数
        String text="查看谷歌的开盘价。查看苹果的收盘价,涨跌额大于一百的";
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("text", text);
        //执行api
        String params1=doHanlpApi(token,url,params);
        JSONObject jsonObject = JSONObject.parseObject(params1);
        //假如返回值为简单的类型，也就是单个值，使用getString("key")获取
        String flag=jsonObject.getString("data");//结果就是简单的值类型
        String replace = flag.replace("[", "");
        String replace1 = replace.replace("]", "");
        String replace2 = replace1.replace(",{", "&n{");
        String[] split = replace2.split("&n");
        String str="";
        for (String s : split) {
            JSONObject jsonObject1 = JSONObject.parseObject(s);
            if(jsonObject1.getString("nature").equals("n") || jsonObject1.getString("nature").equals("ntc") ){
                str=str+" "+jsonObject1.getString("word");
            }
//            System.out.println(str);
        }
        System.out.println("===flag值为==="+str);
//        System.out.println(params1);

    }
    public static String doHanlpApi(String token,String url,Map<String,Object> params) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            //添加header请求头，token请放在header里
            httpPost.setHeader("token", token);
            // 创建参数列表
            List<NameValuePair> paramList = new ArrayList<>();
            if (params != null) {
                for (String key : params.keySet()) {
                    //所有参数依次放在paramList中
                    paramList.add(new BasicNameValuePair(key, (String) params.get(key)));
                }
                //模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            return resultString;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(response!=null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}