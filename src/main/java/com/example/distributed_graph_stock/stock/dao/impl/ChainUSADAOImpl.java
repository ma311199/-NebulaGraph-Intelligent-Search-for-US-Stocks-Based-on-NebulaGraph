package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.ChainUSAStock;
import com.example.distributed_graph_stock.stock.dao.ChainUSADAO;
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
 * @Date 2023/4/5 15:54
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: ChainUSADAOImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "chainUsaDao")
public class ChainUSADAOImpl implements ChainUSADAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ChainUSAStock> selectChainUsa(String tab) {
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt)-1;
        String sql="select symbol ,cname ,price ,chg ,diff ,turnover_rate ,volume ,pe ,transactions ,max52 ,min52 ,category ,market\n" +
                " from "+tab+" where part_dt ="+dt+";";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(ChainUSAStock.class));
    }
}
