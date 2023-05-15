package com.example.distributed_graph_stock.stock.service;

import com.example.distributed_graph_stock.stock.bean.NewsStockBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/8 21:48
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: NewsStockService
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface NewsStockService {
    List<NewsStockBean> listNewsStock();
}
