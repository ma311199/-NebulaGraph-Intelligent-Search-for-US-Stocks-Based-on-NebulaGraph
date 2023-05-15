package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.SumPriceBean;
import com.example.distributed_graph_stock.stock.dao.impl.SumPriceDaoImpl;
import com.example.distributed_graph_stock.stock.service.SumPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/19 14:11
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: SumPriceServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "sumPriceService")
public class SumPriceServiceImpl implements SumPriceService {
    @Autowired
    private SumPriceDaoImpl sumPriceDao;
    @Override
    public List<SumPriceBean> chaZhao() {
        return sumPriceDao.selectSum();
    }
}
