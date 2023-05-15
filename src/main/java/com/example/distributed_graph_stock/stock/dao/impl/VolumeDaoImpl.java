package com.example.distributed_graph_stock.stock.dao.impl;

import com.example.distributed_graph_stock.stock.bean.VolumeAllBean;
import com.example.distributed_graph_stock.stock.bean.VolumeCategoryMarketBean;
import com.example.distributed_graph_stock.stock.dao.VolumeDao;
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
 * @Date 2023/3/19 17:21
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: VolumeDaoImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "volumeDaoImpl")
public class VolumeDaoImpl implements VolumeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<VolumeAllBean> selectvolume() {   //总成交量的行业占比
        String part_dt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int dt = Integer.parseInt(part_dt)-1;
        String sql="select category,p from stock_ads.volume_all limit 6;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(VolumeAllBean.class));
    }

    @Override
    public List<VolumeCategoryMarketBean> showCategoryVolume(Integer srcDate, Integer tarDate) {
        String sql="select category,max(maxVolume) as maxVolume,min(maxVolume) as minVolume,sum(sumVolume) as sumVolume,round(avg(avgVolume),3) as avgVolume \n" +
                "from stock_ads.ads_volume_stock_view_day \n" +
                "where part_dt between "+srcDate+" and "+tarDate+" group by category;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(VolumeCategoryMarketBean.class));
    }

    @Override
    public List<VolumeCategoryMarketBean> showMarketCategoryVolume(Integer srcDate, Integer tarDate, String market) {
        String sql="select category,max(maxVolume) as maxVolume,min(maxVolume) as minVolume,sum(sumVolume) as sumVolume,round(avg(avgVolume),3) as avgVolume \n" +
                "from stock_ads.ads_volume_stock_view_day \n" +
                "where market='"+market+"' and part_dt between "+srcDate+" and "+tarDate+" group by category;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(VolumeCategoryMarketBean.class));
    }
}
