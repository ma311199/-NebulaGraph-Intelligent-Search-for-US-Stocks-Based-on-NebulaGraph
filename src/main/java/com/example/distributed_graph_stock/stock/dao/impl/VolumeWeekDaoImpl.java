package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.VolumeWeekBean;
import com.example.distributed_graph_stock.stock.dao.VolumeWeekDao;
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
 * @Date 2023/3/30 10:43
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: VolumeWeekDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "volumeWeekDaoImpl")
public class VolumeWeekDaoImpl implements VolumeWeekDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<VolumeWeekBean> selectWeekVolume() {  //数据堆叠图，last 7 days
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt)-1;
        String sql="select cname ,total_wk_volume ,max_wk_volume ,min_wk_volume ,avg_wk_volume  from stock_ads.ads_usa_td_stock_week  " +
                "where part_dt ="+dt+" and total_wk_volume BETWEEN 100000 and 1000000 and length(cname)<10 limit 10;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(VolumeWeekBean.class));
    }

    @Override
    public List<VolumeWeekBean> selectMonthVolume() {
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt)-1;
        String sql="select cname ,total_mth_volume as total_wk_volume ,max_mth_volume as max_wk_volume ,min_mth_volume as min_wk_volume ,avg_mth_volume as avg_wk_volume  from stock_ads.ads_usa_td_stock_month  " +
                "where part_dt ="+dt+" and total_mth_volume BETWEEN 1000000 and 100000000 and length(cname)<10 limit 10;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(VolumeWeekBean.class));
    }
}
