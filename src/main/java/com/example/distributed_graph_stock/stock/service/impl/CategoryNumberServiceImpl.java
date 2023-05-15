package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.CategoryNumberBean;
import com.example.distributed_graph_stock.stock.dao.impl.CategoryDaoImpl;
import com.example.distributed_graph_stock.stock.service.CategoryNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/21 14:34
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: CategoryNumberServeiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
@Service(value = "categoryNumberService")
public class CategoryNumberServiceImpl implements CategoryNumberService {
    @Autowired
    private CategoryDaoImpl categoryDao;
    @Override
    public List<CategoryNumberBean> showCategoryNumber(Integer part_dt) {
        return categoryDao.showCategoryNumber(part_dt);
    }
}
