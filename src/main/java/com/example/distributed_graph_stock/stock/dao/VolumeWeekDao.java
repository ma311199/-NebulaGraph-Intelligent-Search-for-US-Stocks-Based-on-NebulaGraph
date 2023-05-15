package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.VolumeWeekBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/30 10:42
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: VolumeWeekDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface VolumeWeekDao {
    List<VolumeWeekBean> selectWeekVolume();

    List<VolumeWeekBean> selectMonthVolume();
}
