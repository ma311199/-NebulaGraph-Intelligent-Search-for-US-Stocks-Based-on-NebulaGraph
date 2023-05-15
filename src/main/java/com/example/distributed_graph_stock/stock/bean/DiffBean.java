package com.example.distributed_graph_stock.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/16 15:58
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.bean
 * @CLASS_NAME: DiffBean
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Data //包含了get，set和toString
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
public class DiffBean {   //涨跌额bean
    private String cname;  //股票名称
    private String symbol;  //股票代码
    private Double diff;  //涨跌额
}
