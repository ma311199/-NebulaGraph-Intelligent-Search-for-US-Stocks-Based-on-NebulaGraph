package com.example.distributed_graph_stock.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/17 20:57
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.bean
 * @CLASS_NAME: ChgCategoryBean
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChgCategoryBean {
    private String category;
    private Double va;
//    private Double sumChg;
//    private Double avgChg;
//    private Double maxChg;
//    private Double minChg;
}
