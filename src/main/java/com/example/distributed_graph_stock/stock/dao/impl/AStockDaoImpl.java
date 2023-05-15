package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.AStockBean;
import com.example.distributed_graph_stock.stock.bean.StockUSABean;
import com.example.distributed_graph_stock.stock.bean.StockVolumeBean;
import com.example.distributed_graph_stock.stock.dao.AStockDao;
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
 * @Date 2023/3/22 13:04
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: AStockDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "aStockDao")
public class AStockDaoImpl implements AStockDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<AStockBean> SelectA(String symbol) { //k线图
        String sql="select cname ,`open`,`close` ,low ,high,part_dt  from stock_ads.ads_filter_stock_usa_day where symbol='"+symbol+"' or cname='"+symbol+"' order by part_dt ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(AStockBean.class));
    }

    @Override
    public List<StockVolumeBean> SelectVolume(String symbol) {  //成交量柱状图
        String sql="select part_dt,volume  from stock_ads.ads_filter_stock_usa_day where symbol='"+symbol+"' or cname='"+symbol+"'  order by part_dt ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(StockVolumeBean.class));
    }
}
