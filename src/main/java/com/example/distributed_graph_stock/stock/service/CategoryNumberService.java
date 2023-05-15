package com.example.distributed_graph_stock.stock.service;

import com.example.distributed_graph_stock.stock.bean.CategoryNumberBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/21 14:33
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: CategoryBean
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface CategoryNumberService {
    List<CategoryNumberBean> showCategoryNumber(Integer part_dt);
}
