package com.example.distributed_graph_stock.stock.bean;



import com.alibaba.fastjson.JSONObject;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.restful.HanLPClient;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import com.vesoft.nebula.client.graph.NebulaPoolConfig;
import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.exception.IOErrorException;
import com.vesoft.nebula.client.graph.net.NebulaPool;
import com.vesoft.nebula.client.graph.net.Session;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/13 10:39
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.bean
 * @CLASS_NAME: Tset
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public class Tset {
//https://github.com/hankcs/HanLP/blob/1.x/README.md

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
            result=session.executeJson("use xstock_analyse ;match p=(v2)-[e1]->(v:Stock_cname)-[e]->(v1) WHERE v.Stock_cname.cname IN "+words+" return p;");
//            System.out.println("use xstock_analyse ;match p=(v:Stock_cname)-[e]->(v1) WHERE v.Stock_cname.cname IN "+words+" return p;");
        } catch (IOErrorException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String hanLP(String text) throws IOException {
        // 动态增加
        InputStream fileInputStream = new FileInputStream("D:\\NLP\\stock_cname.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while ((str=bufferedReader.readLine()) !=null){
            String words[]=str.split("<END>");
            CustomDictionary.insert(words[0], words[1]);
//            System.out.println(Arrays.toString(str.split("<END>")));
        }
        CustomDictionary.add("攻城狮");
        // 强行插入
//        CustomDictionary.insert("谷歌", "ntc 1004");
//        CustomDictionary.insert("特斯拉", "ntc 1004");
        // 删除词语（注释掉试试）
//        CustomDictionary.remove("谷歌");
//        添加词，如果词已经存在，则不更改，如果需要更改使用insert强制
//        System.out.println(CustomDictionary.add("谷歌", "ntc 1024"));
//        查看词的词性和词频
//        System.out.println(CustomDictionary.get("谷歌"));

        // AhoCorasickDoubleArrayTrie自动机扫描文本中出现的自定义词语
        final char[] charArray = text.toCharArray();
        final String[] str1 = {"["};
        CustomDictionary.parseText(charArray, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>()
        {
            @Override
            public void hit(int begin, int end, CoreDictionary.Attribute value)
            {
                if(value.toString().contains("ntc")) {
                    //System.out.printf("[%d:%d]=%s %s\n", begin, end, new String(charArray, begin, end - begin), value);
                    String s = new String(charArray, begin, end - begin);
                    str1[0] = str1[0]+",'"+s+"'";
                }
            }
        });
        // 自定义词典在所有分词器中都有效
//        System.out.println(HanLP.segment(text));
//        System.out.println(str1[0].replaceFirst(",","")+"]");
        String strquary=str1[0].replaceFirst(",","")+"]";
        return strquary;
    }
    public static void main(String[] args) throws IOException {

        NebulaPool nebulaPool = new NebulaPool();
        Session session = connectNebulaQuary(nebulaPool);
        String text="查看谷歌和苹果公司的收盘价、开盘价,查看特斯拉的振幅,涨跌额大于一百的";
        String s = hanLP(text);
        System.out.println(s);
        String quary = execute(session, s);
        if(quary.contains("meta")) {
            System.out.println(quary);
            System.out.println("请选择xstock_analyse图空间,然后执行这个NGQL语句: match p=(v2)-[e1]->(v:Stock_cname)-[e]->(v1) WHERE v.Stock_cname.cname IN "+s+" return p;");
        }
        nebulaPool.close();
    }
}
