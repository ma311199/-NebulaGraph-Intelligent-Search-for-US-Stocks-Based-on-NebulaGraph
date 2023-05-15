package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.AStockBean;
import com.example.distributed_graph_stock.stock.bean.StockVolumeBean;
import com.example.distributed_graph_stock.stock.dao.impl.AStockDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/22 13:14
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: AStockController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "stock",method = RequestMethod.GET)
public class AStockController {
    @Autowired
    private AStockDaoImpl aStockDao;

    private String cname;

    @ResponseBody
    @RequestMapping(value = "resultA")   //获取点击的股票cname
    public String showA(@RequestParam(value="cname") String cname){
        System.out.println(cname);
        setCname(cname);
        return "{name:哈哈}";
    }

    @RequestMapping(value = "a",method = RequestMethod.GET)  //单股K线图
    public List<AStockBean> listA(){
        return aStockDao.SelectA(cname);
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @RequestMapping(value = "VolumeList",method = RequestMethod.GET)//单股成交量
    public List<StockVolumeBean> listZhu(){
        return aStockDao.SelectVolume(cname);
    }

}
