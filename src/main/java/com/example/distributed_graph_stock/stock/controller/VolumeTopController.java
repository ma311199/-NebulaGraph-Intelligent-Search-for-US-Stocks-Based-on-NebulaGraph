package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.SymbolBean;
import com.example.distributed_graph_stock.stock.service.impl.SymbolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/11 10:32
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: SymbolController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/stock",method = RequestMethod.GET)
public class VolumeTopController {
    @Autowired
    private SymbolServiceImpl symbolServiceImpl;

    public String part_dt1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    public int dt = Integer.parseInt(part_dt1)-1;
    private String volumeIndex="desc";
    private Integer part_dt=dt;
    private Integer top=100;
    @RequestMapping(value = "volumeTopList",method = RequestMethod.GET) //获取不同日期的不同股票成交量大小的不同top数量
    public List<SymbolBean> getJsonDate() {
        List<SymbolBean> symbolBeans = symbolServiceImpl.findAll(getVolumeIndex(),getPart_dt(),getTop());
        return symbolBeans;
    }

    @RequestMapping(value = "volumeTopIndex",method = RequestMethod.GET)
    public void setJsonDate(@RequestParam(value = "volumeIndex")String volumeIndex,@RequestParam(value = "part_dt")Integer part_dt,@RequestParam(value = "top")Integer top) {
        setPart_dt(part_dt);
        setTop(top);
        setVolumeIndex(volumeIndex);

    }

    public String getVolumeIndex() {
        return volumeIndex;
    }

    public void setVolumeIndex(String volumeIndex) {
        this.volumeIndex = volumeIndex;
    }

    public Integer getPart_dt() {
        return part_dt;
    }

    public void setPart_dt(Integer part_dt) {
        this.part_dt = part_dt;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }
}
