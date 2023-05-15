package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.PeiceBean;
import com.example.distributed_graph_stock.stock.dao.impl.PriceDaoImpl;
import com.example.distributed_graph_stock.stock.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/19 12:37
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: PriceServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "priceService")
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceDaoImpl priceDao;
    @Override
    public List<PeiceBean> findPrice() {
        return priceDao.selectAllPrice();
    }
}
