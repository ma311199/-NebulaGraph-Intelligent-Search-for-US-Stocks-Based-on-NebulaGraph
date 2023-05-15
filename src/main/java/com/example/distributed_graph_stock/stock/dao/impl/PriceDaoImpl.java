package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.PeiceBean;
import com.example.distributed_graph_stock.stock.dao.PriceDao;
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
 * @Date 2023/3/19 12:25
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: PriceDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "priceDao")
public class PriceDaoImpl implements PriceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<PeiceBean> selectAllPrice() {  //今日个股股价数据
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt)-1;
        String sql="select cname,symbol,`open` ,high ,low ,`close`  from stock_ads.ads_filter_stock_usa_day where part_dt="+dt+" \n" +
                "and cname not like '%指数%' and cname not like '%ETF%' and cname not like '%克希尔%' limit 12;";

        List<PeiceBean> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PeiceBean.class));
        return query;
    }
}
