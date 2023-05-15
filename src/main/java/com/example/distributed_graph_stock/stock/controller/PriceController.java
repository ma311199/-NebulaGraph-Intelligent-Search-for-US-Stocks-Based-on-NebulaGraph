package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.PeiceBean;
import com.example.distributed_graph_stock.stock.service.impl.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/19 12:39
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: PriceController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "stock",method = RequestMethod.GET)
public class PriceController {
    @Autowired
    private PriceServiceImpl priceService;

    @RequestMapping(value = "price",method = RequestMethod.GET)
    private List<PeiceBean> listPrice(){
        return priceService.findPrice();
    }
}
