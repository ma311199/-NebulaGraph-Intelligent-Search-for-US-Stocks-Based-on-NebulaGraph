package com.example.distributed_graph_stock.stock.controller;

import com.example.distributed_graph_stock.stock.bean.DiffBean;

import com.example.distributed_graph_stock.stock.dao.impl.DiffTopDaoImpl;
import com.example.distributed_graph_stock.stock.service.impl.DiffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/16 16:12
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: DiffContoroller
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/stock",method = RequestMethod.GET)
public class DiffContoroller {
    @Autowired
    private DiffServiceImpl diffService;

    @Autowired
    private DiffTopDaoImpl diffTopDaoImpl;

    private String ln;
    private String tab;
    private Long date;

    @RequestMapping(value = "diff",method = RequestMethod.GET)
    public List<DiffBean> getJsonDate() {
        List<DiffBean> diffBeans = diffService.findDiff();
        return diffBeans;
    }

    @RequestMapping(value = "diffValue",method = RequestMethod.GET)
    public void getDiffValue(@RequestParam(value="ln")String ln, @RequestParam(value="tab")String tab, @RequestParam(value="date")Long date) {
        setLn(ln);
        setTab(tab);
        setDate(date);
    }

    @RequestMapping(value = "diffTop",method = RequestMethod.GET)
    public List<DiffBean> getJsonDateDiff() {
        List<DiffBean> diffBeans = diffTopDaoImpl.SelectDiff(getLn(), getTab(), getDate());
        return diffBeans;
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
}
