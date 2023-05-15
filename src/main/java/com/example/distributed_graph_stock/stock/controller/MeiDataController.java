package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.DiffBean;
import com.example.distributed_graph_stock.stock.bean.MeiDataBean;
import com.example.distributed_graph_stock.stock.service.impl.MeiDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/16 21:12
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: MeiDataController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/stock",method = RequestMethod.GET)
public class MeiDataController {
    @Autowired
    private MeiDataServiceImpl meiDataService;

    @RequestMapping(value = "sc",method = RequestMethod.GET)
    public List<MeiDataBean> getJsonDate() {
        List<MeiDataBean> meiDataBeans = meiDataService.findSc();

        return meiDataBeans;
    }
}
