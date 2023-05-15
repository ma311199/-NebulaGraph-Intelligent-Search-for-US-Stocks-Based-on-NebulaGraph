package com.example.distributed_graph_stock.stock.service;

import com.example.distributed_graph_stock.stock.bean.MarketCategoryBean;
import com.example.distributed_graph_stock.stock.bean.MarketDateNumber;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/7 14:26
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: MarketCategoryService
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface MarketCategoryService {
    List<MarketCategoryBean> find(String viewTab);

    List<MarketDateNumber> showNumber();
}
