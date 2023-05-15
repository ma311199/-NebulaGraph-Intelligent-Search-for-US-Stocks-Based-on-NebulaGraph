package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.DiffBean;
import com.example.distributed_graph_stock.stock.bean.SymbolBean;
import com.example.distributed_graph_stock.stock.dao.DiffDao;
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
 * @Date 2023/3/16 16:02
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: DiffDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "diffDaoImpl")
public class DiffDaoImpl implements DiffDao {

    @Autowired //是用在JavaBean中的注解，通过byType(按类型)形式，用来给指定的字段或方法注入所需的外部资源。
    private JdbcTemplate jdbcTemplate; //jdbc连接工具类

    @Override
    public List<DiffBean> SelectDiff() {
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt)-1;
        String sql = "select cname,symbol ,diff  from stock_ads.ads_filter_stock_usa_day where part_dt="+dt+" order by diff DESC limit 5;";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<DiffBean>(DiffBean.class));
    }
}
