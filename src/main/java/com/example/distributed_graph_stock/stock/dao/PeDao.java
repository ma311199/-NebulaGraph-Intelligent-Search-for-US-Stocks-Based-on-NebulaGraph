package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.PeBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/21 16:14
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: PeDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface PeDao {
    List<PeBean> showList(String peIndex,Integer part_dt,Integer top);
}
