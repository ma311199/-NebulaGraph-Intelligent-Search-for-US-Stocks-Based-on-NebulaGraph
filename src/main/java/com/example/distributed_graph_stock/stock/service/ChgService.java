package com.example.distributed_graph_stock.stock.service;

import com.example.distributed_graph_stock.stock.bean.ChgBean;
import com.example.distributed_graph_stock.stock.bean.ChgCategoryBean;
import com.example.distributed_graph_stock.stock.bean.ChgCategoryDateBean;
import com.example.distributed_graph_stock.stock.bean.ChgDateBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/17 18:42
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: ChgService
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface ChgService {
    List<ChgBean> findChgRise();
    List<ChgBean> findChgFall();

    List<ChgDateBean> selectChg(String ln, String tab, Long date);//当日股票涨跌额

    List<ChgCategoryBean> selectCategoryChg(String index);//当日不同行业股票涨跌幅情况

    List<ChgCategoryDateBean> selectCategoryDateChg();//不同日期的不同行业股票涨跌幅情况

    List<ChgCategoryDateBean> selectCategoryDateMarketChg(String market,Integer part_dt);//不同日期的不同证券交易所不同行业股票涨跌幅情况
}
