package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.MarketCategoryBean;
import com.example.distributed_graph_stock.stock.bean.MarketDateNumber;
import com.example.distributed_graph_stock.stock.dao.impl.MarketCategroyDaoImpl;
import com.example.distributed_graph_stock.stock.service.MarketCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/7 14:28
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: MarketCategoryServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "marketCategoryService")
public class MarketCategoryServiceImpl implements MarketCategoryService {
    @Autowired
    private MarketCategroyDaoImpl marketCategroyDao;

    @Override
    public List<MarketCategoryBean> find(String viewTab) {
        return marketCategroyDao.find(viewTab);
    }

    @Override
    public List<MarketDateNumber> showNumber() {
        return marketCategroyDao.showNumber();
    }
}
