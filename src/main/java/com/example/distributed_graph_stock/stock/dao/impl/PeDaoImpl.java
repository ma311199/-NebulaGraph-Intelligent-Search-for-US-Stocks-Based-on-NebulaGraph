package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.PeBean;
import com.example.distributed_graph_stock.stock.dao.PeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/21 16:15
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: PeDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "peDao")
public class PeDaoImpl implements PeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PeBean> showList(String peIndex,Integer part_dt,Integer top) {
//        因为饼图需要的数据是正数，所以升序的数据不要是负数的市盈率，pe>0
        String sql = "select cname ,pe from stock_ads.ads_filter_stock_usa_day where pe != '' and pe>0 and part_dt="+part_dt+" order by pe "+peIndex+" limit "+top+";";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(PeBean.class));
    }
}
