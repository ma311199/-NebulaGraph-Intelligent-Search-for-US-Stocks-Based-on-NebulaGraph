package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.*;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/18 22:47
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: AmplitudeDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface AmplitudeDao {

    List<AmplitudeDateBean> selectAmplitude(String ln, Integer srcDate, Integer tarDate);//当日股票振幅

    List<AmplitudeCategoryBean> selectCategoryAmplitude(String index,Integer part_dt);//不同行业股票振幅情况

    List<AmplitudeCategoryDateBean> selectCategoryDateMarketAmplitude(String market,Integer part_dt);//不同日期的不同证券交易所不同行业股票振幅情况
}
