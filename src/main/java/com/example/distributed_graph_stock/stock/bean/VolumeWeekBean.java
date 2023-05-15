package com.example.distributed_graph_stock.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/3/30 10:40
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.bean
 * @CLASS_NAME: VolumeWeekBean
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Data
@AllArgsConstructor //有参构造器 set
@NoArgsConstructor  //无参构造器 get
public class VolumeWeekBean {
    private String cname;
    private Double total_wk_volume;
    private Double max_wk_volume;
    private Double min_wk_volume;
    private Double avg_wk_volume;
}
