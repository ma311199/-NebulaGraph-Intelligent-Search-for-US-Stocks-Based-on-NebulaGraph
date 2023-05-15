package com.example.distributed_graph_stock.stock.service;

import com.example.distributed_graph_stock.stock.bean.VolumeAllBean;
import com.example.distributed_graph_stock.stock.bean.VolumeWeekBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/30 10:48
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: VolumeWeekService
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface VolumeWeekService {
    List<VolumeWeekBean> selectWeekVolume();

    List<VolumeWeekBean> selectMonthVolume();
}
