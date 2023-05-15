package com.example.distributed_graph_stock;

import com.alibaba.fastjson.JSONObject;
import com.vesoft.nebula.client.graph.NebulaPoolConfig;
import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.data.ResultSet;
import com.vesoft.nebula.client.graph.exception.IOErrorException;
import com.vesoft.nebula.client.graph.net.NebulaPool;
import com.vesoft.nebula.client.graph.net.Session;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/5/4 17:39
 * @PACKAGE_NAME: com.example.distributed_graph_stock
 * @CLASS_NAME: NebulaGraphHanLP
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public class NebulaGraphHanLP {

//    连接NebulaGraph
    public static Session connectNebulaQuary(NebulaPool nebulaPool){
        Session session = null;
        try{
            NebulaPoolConfig config = new NebulaPoolConfig();
            config.setMaxConnSize(100);//最大连接数
            List<HostAddress> address = Arrays.asList(new HostAddress("192.168.10.20",9669));
            nebulaPool.init(address,config);
            session = nebulaPool.getSession("root","nebula",false);
            return session;

        }catch(Exception e){
            e.printStackTrace();
        }
//        finally{
//            nebulaPool.close();//此处加上异常捕获，防止空指针
//        }
        return null;
    }

    public static String execute(Session session,String words){
        String result="";
        try {
            result=session.executeJson("use xstock_analyse ;match p=(v:Stock_cname)-[e]->(v1) WHERE v.Stock_cname.cname IN "+words+" return p;");
//            System.out.println("use xstock_analyse ;match p=(v:Stock_cname)-[e]->(v1) WHERE v.Stock_cname.cname IN "+words+" return p;");
        } catch (IOErrorException e) {
            e.printStackTrace();
        }
        return result;
    }
//    执行分词，获取名词
    public static String hanLP(String token,String url,String text){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("text", text);
        //执行api
        String params1=doHanlpApi(token,url,params);
        System.out.println(params1);
        JSONObject jsonObject = JSONObject.parseObject(params1);
        //假如返回值为简单的类型，也就是单个值，使用getString("key")获取
        String flag=jsonObject.getString("data");//结果就是简单的值类型
        String replace = flag.replace("[", "");
        String replace1 = replace.replace("]", "");
        String replace2 = replace1.replace(",{", "&n{");
        String[] split = replace2.split("&n");
        String str="[";
        for (String s : split) {
            JSONObject jsonObject1 = JSONObject.parseObject(s);
            if(jsonObject1.getString("nature").equals("n") || jsonObject1.getString("nature").equals("ntc") ){
                str=str+",'"+jsonObject1.getString("word")+"'";
            }
//            System.out.println(str);
        }
//        System.out.println("===flag值为==="+str);
        return str.replaceFirst(",","")+"]";
    }

//    实际执行分词
    public static String doHanlpApi(String token, String url, Map<String,Object> params) {
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

    public static void main(String[] args) {
        //请求头中的token
        String token = "bc906f0a8f5741bda7a3f916bb2741591683254785294token";
        //申请的接口地址
        String url = "http://comdo.hanlp.com/hanlp/v1/segment/nlp";

        String text="查看谷歌和苹果公司的收盘价、开盘价,查看特斯拉的振幅,涨跌额大于一百的";

        String s = hanLP(token, url, text);
//        System.out.println(s);
//        String[] words = s.split(" ");
        NebulaPool nebulaPool = new NebulaPool();
        Session session = connectNebulaQuary(nebulaPool);
        String quary = execute(session, s);
        if (quary.contains("meta")) {
            System.out.println(quary);
            System.out.println("请选择xstock_analyse图空间,然后执行这个NGQL语句: match p=(v:Stock_cname)-[e]->(v1) WHERE v.Stock_cname.cname IN "+s+" return p;");
        }

        nebulaPool.close(); //关闭连接
    }
}
