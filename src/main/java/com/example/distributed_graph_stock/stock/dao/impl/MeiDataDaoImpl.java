package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.MeiDataBean;
import com.example.distributed_graph_stock.stock.bean.SymbolBean;
import com.example.distributed_graph_stock.stock.dao.MeiDataDao;
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
 * @Date 2023/3/16 21:06
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: MeiDataDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "meiDataDaoImpl")
public class MeiDataDaoImpl implements MeiDataDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MeiDataBean> SelectSC() {  //数据轮番图
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt)-1;
        String sql = "select cname ,symbol,amplitude,chg  from stock_ads.ads_filter_stock_usa_day where part_dt="+dt+" and length(cname)<10 order by volume DESC limit 100;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MeiDataBean>(MeiDataBean.class));
    }
}
