package com.example.distributed_graph_stock.stock.controller;

import com.alibaba.fastjson.JSON;
import com.example.distributed_graph_stock.stock.bean.UserBean;
import com.example.distributed_graph_stock.stock.service.impl.SymbolServiceImpl;
import com.example.distributed_graph_stock.stock.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/16 16:28
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.controller
 * @CLASS_NAME: AllController
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/stock",method = RequestMethod.GET)
public class AllController {

    @Autowired
    private SymbolServiceImpl symbolServiceImpl;

    @Autowired
    private UserServiceImpl userService;

    private boolean flag=false;


    @RequestMapping(value = "/flag",method = RequestMethod.GET)
    public String setAjaxValue(@RequestParam(value="name")String name, @RequestParam(value="password")String password){
        int fl = userService.showUser(name, password); //fl=0，用户未注册
        Map<String,Integer> map=new HashMap<>();
        if(fl>=1){
            setFlag(true);
            map.put("status",1);
        }else
            map.put("status",0);
        String mapJson = JSON.toJSONString(map);
        System.out.println(mapJson);
        return mapJson;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String setAjaxRegister(UserBean userBean){
        int fl = userService.insertUser(userBean);

        Map<String,Integer> map=new HashMap<>();
        if(fl>=1){
            map.put("status",1);
        }else
            map.put("status",0);
        String mapJson = JSON.toJSONString(map);
        return mapJson;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        if(isFlag())
            return new ModelAndView("index");
        else
            return new ModelAndView("login");
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest1(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("sotck");
    }

    @RequestMapping(value = "/stockA",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest2(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("美股数据可视化");
    }

    @RequestMapping(value = "/chainUSA",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest3(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("chain_usa_stock");
    }

    @RequestMapping(value = "/index_number_DJIA",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest4(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("道琼斯指数");
    }

    @RequestMapping(value = "/index_number_St500",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest5(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("标普500");
    }

    @RequestMapping(value = "/index_number_NASDAQ",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest6(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("纳斯达克");
    }

    @RequestMapping(value = "/marketNasdaq",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest7(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("纳斯达克板块涨幅");
    }

    @RequestMapping(value = "/marketNyse",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest8(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("纽约板块涨幅");
    }

    @RequestMapping(value = "/newsStockUSA",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest9(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("stock_news");
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest10(){
        if(isFlag())
            return new ModelAndView("admin");
        else
            return new ModelAndView("login");
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest11(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("tes");
    }

    @RequestMapping(value = "/top",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTest12(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("DiffTop");
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView FirtstEchartsTestLogin(){
        //test为在为你的html文件名字,SpringBoot会自动找到这个html文件
        return new ModelAndView("login");
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
