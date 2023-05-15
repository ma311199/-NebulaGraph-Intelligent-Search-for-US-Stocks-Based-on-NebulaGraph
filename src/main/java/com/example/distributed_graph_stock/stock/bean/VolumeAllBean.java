package com.example.distributed_graph_stock.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/19 17:16
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.bean
 * @CLASS_NAME: VolumeAllBean
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
public class VolumeAllBean {
    private String category;
    private Double p;
}
