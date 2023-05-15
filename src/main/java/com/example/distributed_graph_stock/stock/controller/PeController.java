package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.PeBean;
import com.example.distributed_graph_stock.stock.dao.impl.PeDaoImpl;
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
 * @Date 2023/4/21 16:08
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: PeController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/stock",method = RequestMethod.GET)
public class PeController {
    @Autowired
    private PeDaoImpl peDao;
    public String part_dt1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    public int dt = Integer.parseInt(part_dt1)-1;
    private String peIndex="desc";
    private Integer part_dt=dt;
    private Integer top=100;



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

    @RequestMapping(value = "/peListIndex",method = RequestMethod.GET)
    public void showIndexPe(@RequestParam(value = "peIndex")String peIndex, @RequestParam(value = "part_dt")Integer part_dt, @RequestParam(value = "top")Integer top){
        setPeIndex(peIndex);
        setPart_dt(part_dt);
        setTop(top);
    }

    @RequestMapping(value = "/peListValue",method = RequestMethod.GET)
    public List<PeBean> showListPe(){
        return peDao.showList(getPeIndex(),getPart_dt(),getTop());
    }

    public String getPeIndex() {
        return peIndex;
    }

    public void setPeIndex(String peIndex) {
        this.peIndex = peIndex;
    }
}
