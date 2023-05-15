package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.AmplitudeCategoryBean;
import com.example.distributed_graph_stock.stock.bean.AmplitudeCategoryDateBean;
import com.example.distributed_graph_stock.stock.bean.AmplitudeDateBean;
import com.example.distributed_graph_stock.stock.service.impl.AmplitudeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/18 23:07
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: AmplitudeController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "stock",method = RequestMethod.GET)
public class AmplitudeController {
    @Autowired
    private AmplitudeServiceImpl amplitudeService;

    String part_dt1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    int dt = (int) (Integer.parseInt(part_dt1)-1);
    private String ln="desc";
    private Integer srcDate=dt;
    private Integer tarDate=dt;
    private String index="sumAmpl";

    private String market="纽约交易所";

    private Integer part_dt=dt;

    private Integer partdt=dt;

    @RequestMapping(value = "amplValue",method = RequestMethod.GET)
    public void amplitudeValue(@RequestParam(value="ln")String ln, @RequestParam(value="srcDate")Integer srcDate, @RequestParam(value="tarDate")Integer tarDate){
        setLn(ln);
        setSrcDate(srcDate);
        setTarDate(tarDate);
    }

    @RequestMapping(value = "amplList",method = RequestMethod.GET)
    public List<AmplitudeDateBean> showAmplList(){
        return amplitudeService.selectAmplitude(getLn(),getSrcDate(),getTarDate());
    }

    @RequestMapping(value = "amplIndex",method = RequestMethod.GET)
    public void showAmplIndex(@RequestParam(value = "index")String index,@RequestParam(value = "partdt")Integer partdt){
        setPartdt(partdt);
        setIndex(index);
    }

    @RequestMapping(value = "amplIndexList",method = RequestMethod.GET)
    public List<AmplitudeCategoryBean> amplIndexList(){
        return amplitudeService.selectCategoryAmplitude(getIndex(),getPartdt());
    }


    @RequestMapping(value = "amplMarket",method = RequestMethod.GET)
    public void showAmplMarket(@RequestParam(value = "Market")String market,@RequestParam(value = "part_dt")Integer part_dt){
        setMarket(market);
        setPart_dt(part_dt);
    }

    @RequestMapping(value = "amplMarketList",method = RequestMethod.GET)
    public List<AmplitudeCategoryDateBean> amplMarketList(){
        return amplitudeService.selectCategoryDateMarketAmplitude(getMarket(),getPart_dt());
    }


    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
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

    public Integer getSrcDate() {
        return srcDate;
    }

    public void setSrcDate(Integer srcDate) {
        this.srcDate = srcDate;
    }

    public Integer getTarDate() {
        return tarDate;
    }

    public void setTarDate(Integer tarDate) {
        this.tarDate = tarDate;
    }


    public Integer getPartdt() {
        return partdt;
    }

    public void setPartdt(Integer partdt) {
        this.partdt = partdt;
    }
}
