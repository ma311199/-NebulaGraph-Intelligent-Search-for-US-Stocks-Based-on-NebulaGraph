package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.NewsStockBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/8 21:39
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: NewsStockDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface NewsStockDao {
    List<NewsStockBean> listNewsStock();
}
