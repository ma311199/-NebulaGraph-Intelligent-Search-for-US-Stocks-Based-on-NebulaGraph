package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.ChainUSAStock;
import com.example.distributed_graph_stock.stock.bean.StockUSABean;
import com.example.distributed_graph_stock.stock.dao.impl.ChainUSADAOImpl;
import com.example.distributed_graph_stock.stock.dao.impl.StockUSADaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/20 21:36
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: StockUSAController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "stock",method = RequestMethod.GET)
public class StockUSAController {
    @Autowired
    private StockUSADaoImpl stockUSADao;

    @Autowired
    private ChainUSADAOImpl chainUSADAO;

    @RequestMapping(value = "usa",method = RequestMethod.GET)
    public List<StockUSABean> listStockUsa(){
        return stockUSADao.selectA();
    }

    @RequestMapping(value = "chain_usa",method = RequestMethod.GET)  //各种指数排行榜
    public List<ChainUSAStock> listChainUsa(@RequestParam(value="tab") String tab){
        return chainUSADAO.selectChainUsa(tab);
    }
}
