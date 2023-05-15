package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.*;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/17 18:30
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: ChgDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface ChgDao {
    List<ChgBean> selectChgRise();  //行业涨幅榜

    List<ChgBean> selectChgFall();  //行业跌幅榜

    List<ChgDateBean> selectChg(String ln, String tab, Long date);//当日股票涨跌额

    List<ChgCategoryBean> selectCategoryChg(String index);//当日不同行业股票涨跌幅情况

    List<ChgCategoryDateBean> selectCategoryDateChg();//不同日期的不同行业股票涨跌幅情况


    List<ChgCategoryDateBean> selectCategoryDateMarketChg(String market,Integer part_dt);//不同日期的不同证券交易所不同行业股票涨跌幅情况
}
