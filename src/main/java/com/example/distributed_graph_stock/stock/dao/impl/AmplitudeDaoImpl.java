package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.AmplitudeCategoryBean;
import com.example.distributed_graph_stock.stock.bean.AmplitudeCategoryDateBean;
import com.example.distributed_graph_stock.stock.bean.AmplitudeDateBean;
import com.example.distributed_graph_stock.stock.bean.ChgCategoryDateBean;
import com.example.distributed_graph_stock.stock.dao.AmplitudeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/18 22:48
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: AmplitudeDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "amplDao")
public class AmplitudeDaoImpl implements AmplitudeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AmplitudeDateBean> selectAmplitude(String ln, Integer srcDate, Integer tarDate) {

        String sql = "select a.cname,a.symbol,ROUND( (md -ml)/`close`,3) as amplitude \n" +
                "FROM \n" +
                "( \n" +
                "select cname,symbol,max(high) as md,min(low) as ml  \n" +
                "from stock_ads.ads_filter_stock_usa_day \n" +
                "where part_dt between "+srcDate+" and "+tarDate+" \n" +
                "group by cname,symbol \n" +
                ") a \n" +
                "join \n" +
                "stock_ads.ads_filter_stock_usa_day b \n" +
                "on a.cname=b.cname \n" +
                "where a.symbol=b.symbol and b.part_dt ="+srcDate+"-if(dayofweek("+srcDate+") -1=1,3,if(dayofweek("+srcDate+") -1=0,2,1)) \n" +
                "HAVING amplitude >0 \n" +
                "order by amplitude "+ln+" \n" +
                "limit 100;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(AmplitudeDateBean.class));
    }

    @Override
    public List<AmplitudeCategoryBean> selectCategoryAmplitude(String index,Integer part_dt) {
        String sql="select category,"+index+" as va from stock_ads.ads_ampl_stock_view_day where part_dt="+part_dt+";";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(AmplitudeCategoryBean.class));
    }


    @Override
    public List<AmplitudeCategoryDateBean> selectCategoryDateMarketAmplitude(String market, Integer part_dt) {
        String sql = "select category ,sumAmpl,avgAmpl,maxAmpl,minAmpl from stock_ads.ads_ampl_market_category_stock_view_day where part_dt="+part_dt+" and market='"+market+"' ; ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(AmplitudeCategoryDateBean.class));
    }

}
