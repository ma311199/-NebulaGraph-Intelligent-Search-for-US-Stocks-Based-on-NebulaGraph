package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.ChgBean;
import com.example.distributed_graph_stock.stock.bean.ChgCategoryBean;
import com.example.distributed_graph_stock.stock.bean.ChgCategoryDateBean;
import com.example.distributed_graph_stock.stock.bean.ChgDateBean;
import com.example.distributed_graph_stock.stock.dao.impl.ChgDaoImpl;
import com.example.distributed_graph_stock.stock.service.ChgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/17 18:44
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: ChgServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "chgServiceImpl")
public class ChgServiceImpl implements ChgService {
    @Autowired
    private ChgDaoImpl chgDaoImpl;

    @Override
    public List<ChgBean> findChgRise() {
        return chgDaoImpl.selectChgRise();
    }

    @Override
    public List<ChgBean> findChgFall() {
        return chgDaoImpl.selectChgFall();
    }

    @Override
    public List<ChgDateBean> selectChg(String ln, String tab, Long date) {
        return chgDaoImpl.selectChg(ln,tab,date);
    }

    @Override
    public List<ChgCategoryBean> selectCategoryChg(String index) {
        return chgDaoImpl.selectCategoryChg(index);
    }

    @Override
    public List<ChgCategoryDateBean> selectCategoryDateChg() {
        return chgDaoImpl.selectCategoryDateChg();
    }

    @Override
    public List<ChgCategoryDateBean> selectCategoryDateMarketChg(String market, Integer part_dt) {
        return chgDaoImpl.selectCategoryDateMarketChg(market,part_dt);
    }
}
