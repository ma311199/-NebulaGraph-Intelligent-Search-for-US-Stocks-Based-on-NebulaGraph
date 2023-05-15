package com.example.distributed_graph_stock.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/20 21:19
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.bean
 * @CLASS_NAME: StockUSABean
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
public class StockUSABean {
    private String symbol ;
    private String cname ;
    private Double chg ;
    private Double diff;
    private Double close ;
    private String amplitude ;
    private Double open ;
    private Double high;
    private Double low;
    private Long volume ;
    private Long mktcap ;
    private Double pe ;
    private String category ;
    private String market ;

}
