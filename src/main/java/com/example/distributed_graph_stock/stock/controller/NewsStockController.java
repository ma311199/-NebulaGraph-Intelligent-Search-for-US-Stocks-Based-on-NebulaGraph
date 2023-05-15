package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.NewsStockBean;
import com.example.distributed_graph_stock.stock.service.impl.NewsStockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/8 21:51
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: NewsStockController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/stock",method = RequestMethod.GET)
public class NewsStockController {
    @Autowired
    private NewsStockServiceImpl newsStockService;

    @RequestMapping(value = "/newsStock",method = RequestMethod.GET)
    public List<NewsStockBean> listNewsStock(){
        return newsStockService.listNewsStock();
    }
}
