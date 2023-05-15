package com.example.distributed_graph_stock.stock.service;

import com.example.distributed_graph_stock.stock.bean.PeiceBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/19 12:36
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: PriceService
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface PriceService {
    List<PeiceBean> findPrice();
}
