package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.PeiceBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/19 12:24
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: PriceDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface PriceDao {
    List<PeiceBean> selectAllPrice();
}
