package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.NewsStockBean;
import com.example.distributed_graph_stock.stock.dao.impl.NewsStockDaoImpl;
import com.example.distributed_graph_stock.stock.service.NewsStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/8 21:49
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: NewsStockServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "newsStockService")
public class NewsStockServiceImpl implements NewsStockService {
    @Autowired
    private NewsStockDaoImpl newsStockDao;
    @Override
    public List<NewsStockBean> listNewsStock() {
        return newsStockDao.listNewsStock();
    }
}
