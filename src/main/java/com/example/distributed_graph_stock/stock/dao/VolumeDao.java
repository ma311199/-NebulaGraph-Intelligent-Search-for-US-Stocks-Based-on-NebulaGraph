package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.VolumeAllBean;
import com.example.distributed_graph_stock.stock.bean.VolumeCategoryMarketBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/19 17:20
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: VolumeDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface VolumeDao {
    List<VolumeAllBean> selectvolume();

    List<VolumeCategoryMarketBean> showCategoryVolume(Integer srcDate,Integer tarDate);

    List<VolumeCategoryMarketBean> showMarketCategoryVolume(Integer srcDate,Integer tarDate,String market);
}
