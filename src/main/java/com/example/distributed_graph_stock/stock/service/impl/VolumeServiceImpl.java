package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.VolumeCategoryMarketBean;
import com.example.distributed_graph_stock.stock.dao.impl.VolumeDaoImpl;
import com.example.distributed_graph_stock.stock.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/20 20:51
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: VolumeServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "volumeService")
public class VolumeServiceImpl implements VolumeService {
    @Autowired
    private VolumeDaoImpl volumeDao;

    @Override
    public List<VolumeCategoryMarketBean> showCategoryVolume(Integer srcDate, Integer tarDate) {
        return volumeDao.showCategoryVolume(srcDate,tarDate);
    }

    @Override
    public List<VolumeCategoryMarketBean> showMarketCategoryVolume(Integer srcDate, Integer tarDate, String market) {
        return volumeDao.showMarketCategoryVolume(srcDate,tarDate,market);
    }
}
