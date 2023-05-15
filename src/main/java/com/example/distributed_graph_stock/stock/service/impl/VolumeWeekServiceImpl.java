package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.VolumeAllBean;
import com.example.distributed_graph_stock.stock.bean.VolumeWeekBean;
import com.example.distributed_graph_stock.stock.dao.impl.VolumeWeekDaoImpl;
import com.example.distributed_graph_stock.stock.service.VolumeWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/30 10:49
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: VolumeWeekSericeImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "volumeWeekService")
public class VolumeWeekServiceImpl implements VolumeWeekService {

    @Autowired
    private VolumeWeekDaoImpl volumeWeekDao;

    @Override
    public List<VolumeWeekBean> selectWeekVolume() {
        return volumeWeekDao.selectWeekVolume();
    }

    @Override
    public List<VolumeWeekBean> selectMonthVolume() {
        return volumeWeekDao.selectMonthVolume();
    }
}
