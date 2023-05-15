package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.CategoryBean;
import com.example.distributed_graph_stock.stock.bean.CategoryDiffBean;
import com.example.distributed_graph_stock.stock.bean.CategoryNumberBean;
import com.example.distributed_graph_stock.stock.dao.CategoryDao;
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
 * @Date 2023/4/15 10:12
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: CategoryDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "Category")
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CategoryBean> showCategory() { //不同行业单日最涨跌额
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt)-1;
        String sql="select category ,maxdiff ,mindiff from stock_ads.ads_stock_view1_diff_category_market_day;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(CategoryBean.class));
    }

    @Override
    public List<CategoryDiffBean> ShowCategoryDiff() { //全部每天行业的diff聚合值
        String sql="select sumdiff,maxdiff ,mindiff,avgdiff,category ,part_dt  from stock_ads.ads_filter_stock_usa_category_view_day;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(CategoryDiffBean.class));
    }


    @Override
    public List<CategoryBean> showCategoryMarket(String market) { //不同证券交易所的行业diff值
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if(market.length()==0){
            market="纽约交易所";
        }
        String sql="select category,maxdiff,mindiff \n" +
                "from stock_ads.ads_stock_view2_diff_category_market_day \n" +
                "where market ='"+market+"'; ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(CategoryBean.class));
    }

    @Override
    public List<CategoryNumberBean> showCategoryNumber(Integer part_dt) {
        String sql="select category,count(*) as num \n" +
                "from stock_ads.ads_filter_stock_usa_day \n" +
                "where part_dt ="+part_dt+" \n" +
                "group by category;  ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(CategoryNumberBean.class));
    }
}
