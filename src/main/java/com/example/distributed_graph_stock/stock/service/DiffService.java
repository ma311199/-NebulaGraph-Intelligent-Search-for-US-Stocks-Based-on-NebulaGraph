package com.example.distributed_graph_stock.stock.service;
import com.example.distributed_graph_stock.stock.bean.DiffBean;


import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/16 16:07
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: DiffService
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface DiffService {
    List<DiffBean> findDiff();
}
