package com.example.distributed_graph_stock.stock.service;

import com.example.distributed_graph_stock.stock.bean.SymbolBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/11 10:47
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: SymbolService
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface SymbolService {
    List<SymbolBean> findAll(String volumeIndex,Integer part_dt,Integer top);
}
