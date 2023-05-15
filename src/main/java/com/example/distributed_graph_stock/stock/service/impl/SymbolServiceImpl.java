package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.SymbolBean;
import com.example.distributed_graph_stock.stock.dao.impl.SymbolDaoImpl;
import com.example.distributed_graph_stock.stock.service.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/11 10:48
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: SymbolServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "symbolServiceImpl")
public class SymbolServiceImpl implements SymbolService {
    @Autowired
    private SymbolDaoImpl symbolDaoImpl;


    @Override
    public List<SymbolBean> findAll(String volumeIndex,Integer part_dt,Integer top) {
        return symbolDaoImpl.SelectAll(volumeIndex,part_dt,top);
    }
}
