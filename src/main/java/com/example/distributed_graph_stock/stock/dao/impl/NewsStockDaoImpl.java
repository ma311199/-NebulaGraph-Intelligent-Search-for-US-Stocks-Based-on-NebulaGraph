package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.NewsStockBean;
import com.example.distributed_graph_stock.stock.dao.NewsStockDao;
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
 * @Date 2023/4/8 21:39
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: NewsStockDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "newsStockDao")
public class NewsStockDaoImpl implements NewsStockDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<NewsStockBean> listNewsStock() {
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt);
        String sql="select title,url,media_name,mtime from stock_ads.ads_stock_usa_news_view_day;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(NewsStockBean.class));
    }
}
