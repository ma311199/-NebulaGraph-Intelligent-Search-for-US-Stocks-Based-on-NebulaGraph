package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.VolumeAllBean;
import com.example.distributed_graph_stock.stock.bean.VolumeCategoryMarketBean;
import com.example.distributed_graph_stock.stock.dao.impl.VolumeDaoImpl;
import com.example.distributed_graph_stock.stock.service.impl.VolumeServiceImpl;
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
 * @Date 2023/3/19 17:24
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: VolumeController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/stock",method = RequestMethod.GET)
public class VolumeController {
    @Autowired
    private VolumeDaoImpl volumeDao;
    @Autowired
    private VolumeServiceImpl volumeService;
    public String part_dt1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    public int dt = Integer.parseInt(part_dt1)-1;

    private String market="纽约交易所";
    private Integer srcDate=dt;
    private Integer tarDate=dt;
    private Integer srcDate1=dt;
    private Integer tarDate1=dt;

    @RequestMapping(value = "volumeall",method = RequestMethod.GET)
    public List<VolumeAllBean> listVolume(){
        return volumeDao.selectvolume();
    }

    @RequestMapping(value = "volumeIndex1",method = RequestMethod.GET)
    public void setVolumeIndex1(@RequestParam(value = "srcDate")Integer srcDate,@RequestParam(value = "tarDate")Integer tarDate){
        setSrcDate1(srcDate);
        setTarDate1(tarDate);
    }

    @RequestMapping(value = "volumeIndex2",method = RequestMethod.GET)
    public void setVolumeIndex2(@RequestParam(value = "srcDate")Integer srcDate,@RequestParam(value = "tarDate")Integer tarDate,@RequestParam(value = "market")String market){
        setSrcDate(srcDate);
        setTarDate(tarDate);
        setMarket(market);
    }

    @RequestMapping(value = "volumeCategoryList",method = RequestMethod.GET)  //不同周期行业成交量
    public List<VolumeCategoryMarketBean> volumeCategoryList(){
        return volumeService.showCategoryVolume(getSrcDate1(),getTarDate1());
    }

    @RequestMapping(value = "volumeMarketCategoryList",method = RequestMethod.GET) //不同周期不同证券交易所成交量
    public List<VolumeCategoryMarketBean> volumeMarketCategoryList(){
        return volumeService.showMarketCategoryVolume(getSrcDate1(),getTarDate1(),getMarket());
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
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

    public Integer getSrcDate1() {
        return srcDate1;
    }

    public void setSrcDate1(Integer srcDate1) {
        this.srcDate1 = srcDate1;
    }

    public Integer getTarDate1() {
        return tarDate1;
    }

    public void setTarDate1(Integer tarDate1) {
        this.tarDate1 = tarDate1;
    }
}
