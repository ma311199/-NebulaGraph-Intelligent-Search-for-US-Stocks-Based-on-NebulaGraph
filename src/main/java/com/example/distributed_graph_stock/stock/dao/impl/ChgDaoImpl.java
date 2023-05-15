package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.*;
import com.example.distributed_graph_stock.stock.dao.ChgDao;
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
 * @Date 2023/3/17 18:31
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: ChgDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "chgDaoImpl")
public class ChgDaoImpl implements ChgDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
    int dt = Integer.parseInt(part_dt)-1;

    @Override
    public List<ChgBean> selectChgRise() { //涨幅图

        String sql="select * from stock_ads.chg_rise;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<ChgBean>(ChgBean.class));
    }

    @Override
    public List<ChgBean> selectChgFall() { //跌幅图
        String sql="select * from stock_ads.chg_fall;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<ChgBean>(ChgBean.class));
    }

    @Override
    public List<ChgDateBean> selectChg(String ln, String tab, Long date) {
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = (int) (Integer.parseInt(part_dt)-date);
        String sql = "select cname,symbol ,chg  from "+tab+" where part_dt>="+dt+" order by chg "+ln+" limit 100;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ChgDateBean>(ChgDateBean.class));
    }

    @Override
    public List<ChgCategoryBean> selectCategoryChg(String index) {
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = (int) (Integer.parseInt(part_dt)-1);
        String sql = "select category ,"+index+" as va from stock_ads.ads_usa_chg_view_day where part_dt="+dt+"; ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(ChgCategoryBean.class));
    }

    @Override
    public List<ChgCategoryDateBean> selectCategoryDateChg() {
        String sql = "select category ,sumChg,avgChg,maxChg,minChg,part_dt from stock_ads.ads_usa_chg_view_day ; ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(ChgCategoryDateBean.class));
    }

    @Override
    public List<ChgCategoryDateBean> selectCategoryDateMarketChg(String market,Integer part_dt) {
        String sql = "select category ,sumChg,avgChg,maxChg,minChg from stock_ads.ads_stock_chg_category_market_view_day where part_dt="+part_dt+" and market='"+market+"' ; ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(ChgCategoryDateBean.class));
    }
}
