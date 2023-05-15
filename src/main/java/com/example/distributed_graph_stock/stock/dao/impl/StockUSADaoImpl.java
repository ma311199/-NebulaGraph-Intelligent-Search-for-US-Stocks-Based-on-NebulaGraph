package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.StockUSABean;
import com.example.distributed_graph_stock.stock.dao.StockUSADao;
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
 * @Date 2023/3/20 21:31
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: StockUSADaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "stockUSABean")
public class StockUSADaoImpl implements StockUSADao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<StockUSABean> selectA() {   //美股大屏数据明细
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt)-1;
        String sql="select symbol,cname,chg,diff,close,amplitude ,open,high,low,volume,mktcap,pe,category,market " +
                "from stock_ads.ads_filter_stock_usa_day where part_dt="+dt+";";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(StockUSABean.class));
    }
}
