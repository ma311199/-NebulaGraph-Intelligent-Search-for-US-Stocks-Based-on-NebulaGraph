package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.ChainUSAStock;
import com.example.distributed_graph_stock.stock.bean.StockUSABean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/5 15:52
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: ChainUSADAO
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface ChainUSADAO {
    List<ChainUSAStock> selectChainUsa(String tab);  //各种指数排行榜接口
}
