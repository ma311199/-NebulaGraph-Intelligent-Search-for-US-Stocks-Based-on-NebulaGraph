package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.SymbolBean;
import com.example.distributed_graph_stock.stock.dao.SymbolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/11 10:30
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: SymbolImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "symbolDaoImpl")
public class SymbolDaoImpl implements SymbolDao {
    @Autowired //是用在JavaBean中的注解，通过byType(按类型)形式，用来给指定的字段或方法注入所需的外部资源。
    private JdbcTemplate jdbcTemplate; //jdbc连接工具类


    @Override
    public List<SymbolBean> SelectAll(String volumeIndex,Integer part_dt,Integer top) {  //

        String sql = "select cname ,volume  from stock_ads.ads_filter_stock_usa_day where part_dt="+part_dt+" order by volume "+volumeIndex+" limit "+top+";";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<SymbolBean>(SymbolBean.class));
    }
}
