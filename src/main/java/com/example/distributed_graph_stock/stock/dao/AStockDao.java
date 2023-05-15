package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.AStockBean;
import com.example.distributed_graph_stock.stock.bean.StockVolumeBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/22 13:03
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: AStockDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface AStockDao {
    public List<AStockBean> SelectA(String cname);

    public List<StockVolumeBean> SelectVolume(String cname);
}
