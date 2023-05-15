package com.example.distributed_graph_stock.stock.service;

import com.example.distributed_graph_stock.stock.bean.VolumeCategoryMarketBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/20 20:51
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: VolumeService
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface VolumeService {
    List<VolumeCategoryMarketBean> showCategoryVolume(Integer srcDate, Integer tarDate);

    List<VolumeCategoryMarketBean> showMarketCategoryVolume(Integer srcDate,Integer tarDate,String market);
}
