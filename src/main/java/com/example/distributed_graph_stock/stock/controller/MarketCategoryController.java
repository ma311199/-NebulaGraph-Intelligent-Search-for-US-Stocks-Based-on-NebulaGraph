package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.MarketCategoryBean;
import com.example.distributed_graph_stock.stock.bean.MarketDateNumber;
import com.example.distributed_graph_stock.stock.service.impl.MarketCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/7 14:31
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: MarketCategoryController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "stock",method = RequestMethod.GET)
public class MarketCategoryController {
    @Autowired
    private MarketCategoryServiceImpl marketCategoryService;

    @RequestMapping(value = "marketCategory",method = RequestMethod.GET)
    public List<MarketCategoryBean> select(@RequestParam(value="tab")String tab){

        return marketCategoryService.find(tab);
    }

    @RequestMapping(value = "marketCategoryNumber",method = RequestMethod.GET)
    public List<MarketDateNumber> showNumber(){
        return marketCategoryService.showNumber();
    }

}
