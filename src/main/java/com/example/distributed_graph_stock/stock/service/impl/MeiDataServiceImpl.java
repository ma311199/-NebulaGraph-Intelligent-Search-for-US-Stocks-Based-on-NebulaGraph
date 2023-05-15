package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.MeiDataBean;
import com.example.distributed_graph_stock.stock.dao.impl.MeiDataDaoImpl;
import com.example.distributed_graph_stock.stock.service.MeiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/16 21:10
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: MeiDataServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "meiDataServiceImpl")
public class MeiDataServiceImpl implements MeiDataService {
    @Autowired
    private MeiDataDaoImpl meiDataDao;

    @Override
    public List<MeiDataBean> findSc() {
        return meiDataDao.SelectSC();
    }
}
