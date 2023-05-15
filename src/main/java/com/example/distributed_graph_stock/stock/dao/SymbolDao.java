package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.SymbolBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/11 10:27
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: SymbolDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface SymbolDao {
    List<SymbolBean> SelectAll(String volumeIndex,Integer part_dt,Integer top);
}
