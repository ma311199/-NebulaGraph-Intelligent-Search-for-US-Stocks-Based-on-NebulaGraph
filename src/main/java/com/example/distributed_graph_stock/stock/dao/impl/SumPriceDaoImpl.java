package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.SumPriceBean;
import com.example.distributed_graph_stock.stock.dao.SumPriceDao;
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
 * @Date 2023/3/19 14:06
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: SumPriceDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "sumPriceDao")
public class SumPriceDaoImpl implements SumPriceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<SumPriceBean> selectSum() {  //今日行业成交额
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt)-1;
        String sql="select category,allvolume,allprice,avprice  from stock_ads.all_price limit 12;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(SumPriceBean.class));
    }
}
