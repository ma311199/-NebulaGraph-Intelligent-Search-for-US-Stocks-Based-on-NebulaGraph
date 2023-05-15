package com.example.distributed_graph_stock.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/7 13:48
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.bean
 * @CLASS_NAME: MarketCategoryBean
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
public class MarketCategoryBean {
    private String category_cn;
    private Double average; //平均价格
    private Double diff;
    private String percent;
    private Long amount;
    private Long mktcap;
    private Integer total_company;
    private String uppercent;
    private String lead_cname;
    private String lead_shares;
    private String increase;
    private String led_cname;
    private String led_shares;
    private String dropercent;
}
