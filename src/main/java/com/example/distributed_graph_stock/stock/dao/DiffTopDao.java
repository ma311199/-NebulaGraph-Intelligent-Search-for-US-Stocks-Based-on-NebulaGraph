package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.DiffBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/11 19:11
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: DiffTopDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface DiffTopDao {
    List<DiffBean> SelectDiff(String ln,String tab,Long date);   //涨跌额top-100
}
