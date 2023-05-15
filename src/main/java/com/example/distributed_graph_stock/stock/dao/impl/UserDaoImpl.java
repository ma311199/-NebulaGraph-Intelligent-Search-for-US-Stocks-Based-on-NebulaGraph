package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.UserBean;
import com.example.distributed_graph_stock.stock.dao.UserDao;
import org.apache.tomcat.util.net.openssl.ciphers.MessageDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/12 18:27
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: UserDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int showUser(String name, String password) {
        String md5Pwd = DigestUtils.md5DigestAsHex((name+password).getBytes());

        String sql = "select count(*) as num from stock_ads.ads_stock_user where name='"+name+"' and possword='"+md5Pwd+"'";
        Integer icount = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("--嘿嘿---"+icount);
        return icount;
    }

    @Override
    public int insertUser(UserBean userBean) {
        int insert=0;
        String md5Pwd = DigestUtils.md5DigestAsHex((userBean.getName()+userBean.getPassword()).getBytes());
        String sql = "insert into stock_ads.ads_stock_user(id,name,possword,phone,sex,adderss) values(0,?,?,?,?,?)";
        Object[] args = {userBean.getName(), md5Pwd, userBean.getPhone(),userBean.getSex(),userBean.getAddress()};
        String sql1 = "select count(*) as num from stock_ads.ads_stock_user where name='"+userBean.getName()+"'";
        Integer icount = jdbcTemplate.queryForObject(sql1, Integer.class);  //查看用户是否存在
        if(icount==0)  //ture，用户不存在，执行插入语句
            insert = jdbcTemplate.update(sql,args);
        return insert;
    }
}
