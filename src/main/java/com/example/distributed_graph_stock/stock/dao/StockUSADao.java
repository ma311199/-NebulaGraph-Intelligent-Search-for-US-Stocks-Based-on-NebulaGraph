package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.StockUSABean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/20 21:29
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao.impl
 * @CLASS_NAME: StockUSADao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface StockUSADao {
    List<StockUSABean> selectA();
}
