package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.MeiDataBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/16 21:02
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: MeiDataDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface MeiDataDao {
    List<MeiDataBean> SelectSC();
}
