package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.DiffBean;
import com.example.distributed_graph_stock.stock.bean.SymbolBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/16 16:01
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: DiffDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface DiffDao {
    List<DiffBean> SelectDiff();   //涨跌额top-5
}
