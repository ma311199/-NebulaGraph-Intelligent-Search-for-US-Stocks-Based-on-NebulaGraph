package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.VolumeWeekBean;
import com.example.distributed_graph_stock.stock.service.impl.VolumeWeekServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/30 10:53
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: VolumeWeekController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "stock",method = RequestMethod.GET)
public class VolumeIndexController {
    @Autowired
    private VolumeWeekServiceImpl volumeWeekService;

    @RequestMapping(value = "weekVolume")
    public List<VolumeWeekBean> listWeekVolume(){
        return volumeWeekService.selectWeekVolume();
    }

    @RequestMapping(value = "monthVolume")
    public List<VolumeWeekBean> listMonthVolume(){
        return volumeWeekService.selectMonthVolume();
    }
}
