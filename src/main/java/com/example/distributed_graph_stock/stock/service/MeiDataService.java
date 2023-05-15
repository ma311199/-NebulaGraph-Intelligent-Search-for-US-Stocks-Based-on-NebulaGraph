package com.example.distributed_graph_stock.stock.service;

import com.example.distributed_graph_stock.stock.bean.MeiDataBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/16 21:09
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: MeiDataService
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface MeiDataService {
    List<MeiDataBean> findSc();
}
