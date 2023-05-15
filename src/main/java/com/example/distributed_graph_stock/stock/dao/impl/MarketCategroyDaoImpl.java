package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.MarketCategoryBean;
import com.example.distributed_graph_stock.stock.bean.MarketDateNumber;
import com.example.distributed_graph_stock.stock.dao.MarketCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/7 14:21
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: MarketCategroyDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "marketCategoryDao")
public class MarketCategroyDaoImpl implements MarketCategoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<MarketCategoryBean> find(String v_tab) {
        String sql="select * from "+v_tab;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(MarketCategoryBean.class));
    }

    @Override
    public List<MarketDateNumber> showNumber() {
        String sql="select part_dt ,\n" +
                "sum(case when market ='美国交易所' then 1 else 0 end) as usaTd, \n" +
                "sum(case when market ='纽约交易所' then 1 else 0 end) as nuTd, \n" +
                "sum(case when market ='纳斯达克交易所' then 1 else 0 end) as nsTd \n" +
                "from stock_ads.ads_filter_stock_usa_day \n" +
                "group by part_dt ;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(MarketDateNumber.class));
    }
}
