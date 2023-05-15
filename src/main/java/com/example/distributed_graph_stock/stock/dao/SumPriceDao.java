package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.SumPriceBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/19 14:05
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: SumPriceDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface SumPriceDao {
    List<SumPriceBean> selectSum();
}
