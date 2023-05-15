package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.AmplitudeCategoryBean;
import com.example.distributed_graph_stock.stock.bean.AmplitudeCategoryDateBean;
import com.example.distributed_graph_stock.stock.bean.AmplitudeDateBean;
import com.example.distributed_graph_stock.stock.dao.impl.AmplitudeDaoImpl;
import com.example.distributed_graph_stock.stock.service.AmplitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/18 22:55
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: AmplitudeServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "amplService")
public class AmplitudeServiceImpl implements AmplitudeService {

    @Autowired
    private AmplitudeDaoImpl amplitudeDao;

    @Override
    public List<AmplitudeDateBean> selectAmplitude(String ln, Integer tab, Integer date) {
        return amplitudeDao.selectAmplitude(ln,tab,date);
    }

    @Override
    public List<AmplitudeCategoryBean> selectCategoryAmplitude(String index,Integer part_dt) {
        return amplitudeDao.selectCategoryAmplitude(index,part_dt);
    }


    @Override
    public List<AmplitudeCategoryDateBean> selectCategoryDateMarketAmplitude(String market, Integer part_dt) {
        return amplitudeDao.selectCategoryDateMarketAmplitude(market,part_dt);
    }
}
