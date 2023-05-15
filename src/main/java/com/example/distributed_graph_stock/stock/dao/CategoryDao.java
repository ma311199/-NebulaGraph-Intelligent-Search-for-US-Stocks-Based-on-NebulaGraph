package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.CategoryBean;
import com.example.distributed_graph_stock.stock.bean.CategoryDiffBean;
import com.example.distributed_graph_stock.stock.bean.CategoryNumberBean;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/15 10:10
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: CategoryDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface CategoryDao {
    List<CategoryBean> showCategory();

    List<CategoryDiffBean> ShowCategoryDiff();

    List<CategoryBean> showCategoryMarket(String market);

    List<CategoryNumberBean> showCategoryNumber(Integer part_dt);
}
