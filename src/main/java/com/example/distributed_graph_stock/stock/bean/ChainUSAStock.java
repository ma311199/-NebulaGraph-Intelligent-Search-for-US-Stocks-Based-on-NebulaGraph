package com.example.distributed_graph_stock.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/5 15:20
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.bean
 * @CLASS_NAME: ChainUSAStock
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
public class ChainUSAStock {
    private String symbol ;
    private String cname ;
    private Double price ;
    private String chg  ;
    private Double diff ;
    private String turnover_rate ;
    private String volume ;
    private String pe ;
    private String transactions ;
    private Double max52 ;
    private Double min52;
    private String category ;
    private String market ;
}
