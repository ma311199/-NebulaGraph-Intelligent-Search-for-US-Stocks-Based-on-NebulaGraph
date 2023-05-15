package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.ChgBean;
import com.example.distributed_graph_stock.stock.bean.ChgCategoryBean;
import com.example.distributed_graph_stock.stock.bean.ChgCategoryDateBean;
import com.example.distributed_graph_stock.stock.bean.ChgDateBean;
import com.example.distributed_graph_stock.stock.service.impl.ChgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/17 18:46
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: ChgController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/stock",method = RequestMethod.GET)
public class ChgController {
    @Autowired
    private ChgServiceImpl chgService;

    String part_dt1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    int dt = (int) (Integer.parseInt(part_dt1)-1);
    private String ln;
    private String tab;
    private Long date;
    private String index="sumChg";

    private String market="纽约交易所";

    private Integer part_dt=dt;

    @RequestMapping(value = "chg1",method = RequestMethod.GET)
    public List<ChgBean> getJson1(){
        return chgService.findChgRise();
    }

    @RequestMapping(value = "chg2",method = RequestMethod.GET)
    public List<ChgBean> getJson2(){
        return chgService.findChgFall();
    }

    @RequestMapping(value = "chgValue",method = RequestMethod.GET)
    public void getDiffValue(@RequestParam(value="ln")String ln, @RequestParam(value="tab")String tab, @RequestParam(value="date")Long date) {
        setLn(ln);
        setTab(tab);
        setDate(date);
    }

    @RequestMapping(value = "chgList",method = RequestMethod.GET)
    public List<ChgDateBean> listChg(){
        return chgService.selectChg(getLn(),getTab(),getDate());
    }

    @RequestMapping(value = "chgCategoryindex",method = RequestMethod.GET)
    public void setchgindex(@RequestParam(value = "index")String index){
        setIndex(index);
    }
    @RequestMapping(value = "chgCategoryList",method = RequestMethod.GET)
    public List<ChgCategoryBean> listChgCategory(){
        return chgService.selectCategoryChg(getIndex());
    }

    @RequestMapping(value = "chgDateCategoryList",method = RequestMethod.GET)
    public List<ChgCategoryDateBean> listChgDateCategory(){ //
        return chgService.selectCategoryDateChg();
    }


    @RequestMapping(value = "chgMarketCategory",method = RequestMethod.GET)
    public void chgMarketCategory(@RequestParam(value = "market")String market,@RequestParam(value = "part_dt")Integer part_dt){ //
        setMarket(market);
        setPart_dt(part_dt);
    }

    @RequestMapping(value = "chgMarketCategoryList",method = RequestMethod.GET)
    public List<ChgCategoryDateBean> chgMarketCategoryList(){ //
        return chgService.selectCategoryDateMarketChg(getMarket(),getPart_dt());
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getMarket() {
        return market;
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
