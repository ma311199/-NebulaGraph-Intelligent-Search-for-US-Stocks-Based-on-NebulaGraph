package com.example.distributed_graph_stock.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/19 14:02
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.bean
 * @CLASS_NAME: SumPriceBean
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
public class SumPriceBean {  //成交额
    private String category;
    private Double allvolume;
    private Double allprice;
    private Double avprice;
}
