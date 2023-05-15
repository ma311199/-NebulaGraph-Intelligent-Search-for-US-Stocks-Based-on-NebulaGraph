package com.example.distributed_graph_stock.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/16 22:20
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.bean
 * @CLASS_NAME: ChgDateBean
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Data //包含了get，set和toString
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
public class ChgDateBean {
    private String cname;
    private String symbol;
    private Double chg;
}
