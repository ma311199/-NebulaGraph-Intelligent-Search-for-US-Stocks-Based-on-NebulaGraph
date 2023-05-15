package com.example.distributed_graph_stock;

import com.vesoft.nebula.client.graph.NebulaPoolConfig;
import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.data.ResultSet;
import com.vesoft.nebula.client.graph.net.NebulaPool;
import com.vesoft.nebula.client.graph.net.Session;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/30 10:41
 * @PACKAGE_NAME: com.example.distributed_graph_stock
 * @CLASS_NAME: RunNebulaJavaTest
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public class RunNebulaJavaTest {
    @Test
    public void test(){
        NebulaPool nebulaPool = new NebulaPool();
        Session session = null;
        try{
            NebulaPoolConfig config = new NebulaPoolConfig();
            config.setMaxConnSize(100);//最大连接数
            List<HostAddress> address = Arrays.asList(new HostAddress("192.168.10.20",9669));
            nebulaPool.init(address,config);
            session = nebulaPool.getSession("root","nebula",false);
            ResultSet result = session.execute("SHOW SPACES");//显示所有图空间  参数就是nGql语句
            System.out.println(session.executeJson("use xstock_analyse ;match p=(v:Stock_cname{cname:'谷'})-[e]->(v1) return p limit 10;"));
            //根据result 获取图空间的列名。
            List<String> columns = result.getColumnNames();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            nebulaPool.close();//此处加上异常捕获，防止空指针
        }

    }
}
