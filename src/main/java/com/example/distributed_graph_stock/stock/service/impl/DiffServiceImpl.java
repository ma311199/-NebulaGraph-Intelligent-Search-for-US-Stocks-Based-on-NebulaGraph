package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.DiffBean;
import com.example.distributed_graph_stock.stock.bean.SymbolBean;
import com.example.distributed_graph_stock.stock.dao.impl.DiffDaoImpl;
import com.example.distributed_graph_stock.stock.service.DiffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/16 16:08
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: DiffServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "diffServiceImpl")
public class DiffServiceImpl implements DiffService {

    @Autowired
    private DiffDaoImpl diffDaoImpl;

    @Override
    public List<DiffBean> findDiff() {
        return diffDaoImpl.SelectDiff();
    }
}
