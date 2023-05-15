package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.CategoryBean;
import com.example.distributed_graph_stock.stock.bean.CategoryDiffBean;
import com.example.distributed_graph_stock.stock.bean.CategoryNumberBean;
import com.example.distributed_graph_stock.stock.dao.impl.CategoryDaoImpl;
import com.example.distributed_graph_stock.stock.service.impl.CategoryNumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/15 10:15
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: CategoryController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "stock",method = RequestMethod.GET)
public class CategoryController {
    @Autowired
    private CategoryDaoImpl categoryDao;

    @Autowired
    private CategoryNumberServiceImpl categoryNumberService;

    private String market="美国交易所";
    String part_dt1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    int dt = (int) (Integer.parseInt(part_dt1)-1);
    private Integer part_dt=dt;


    @RequestMapping(value = "categorydiff",method = RequestMethod.GET)
    public List<CategoryBean> showCategory(){
        return categoryDao.showCategory();
    }

    @RequestMapping(value = "categorydiffDt",method = RequestMethod.GET)
    public List<CategoryDiffBean> showCategory1(){
        return categoryDao.ShowCategoryDiff();
    }

    @ResponseBody
    @RequestMapping(value = "categoryMarket")
    public void showCategoryMarketValue(@RequestParam(value="market")String market) {
        setMarket(market);
    }


    @RequestMapping(value = "categoryMarketdiff",method = RequestMethod.GET)
    public List<CategoryBean> showCategoryMarket() {
        return categoryDao.showCategoryMarket(market);
    }

    @RequestMapping(value = "categoryNumber",method = RequestMethod.GET)
    public List<CategoryNumberBean> categoryNumber(){
        return categoryNumberService.showCategoryNumber(getPart_dt());
    }

    @RequestMapping(value = "categoryDate",method = RequestMethod.GET)
    public void categoryDate(@RequestParam(value = "part_dt")Integer part_dt){
        setPart_dt(part_dt);
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Integer getPart_dt() {
        return part_dt;
    }

    public void setPart_dt(Integer part_dt) {
        this.part_dt = part_dt;
    }
}
