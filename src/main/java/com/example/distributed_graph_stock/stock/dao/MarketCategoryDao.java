package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.MarketCategoryBean;
import com.example.distributed_graph_stock.stock.bean.MarketDateNumber;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/7 14:20
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: MarketCategoryBean
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface MarketCategoryDao {
    List<MarketCategoryBean> find(String v_tab);

    List<MarketDateNumber> showNumber();
}
