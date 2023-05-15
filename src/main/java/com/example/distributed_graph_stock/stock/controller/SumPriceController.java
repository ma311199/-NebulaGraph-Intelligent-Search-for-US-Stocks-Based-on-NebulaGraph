package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.SumPriceBean;
import com.example.distributed_graph_stock.stock.service.impl.SumPriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/19 14:12
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: SumPriceController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "stock",method = RequestMethod.GET)
public class SumPriceController {
    @Autowired
    private SumPriceServiceImpl service;

    @RequestMapping(value = "sumprice",method = RequestMethod.GET)
    public List<SumPriceBean> listSum(){
        return service.chaZhao();
    }
}
