package com.example.distributed_graph_stock.stock.dao;

import com.example.distributed_graph_stock.stock.bean.UserBean;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/12 18:23
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.dao
 * @CLASS_NAME: UserDao
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface UserDao {
    int showUser(String name,String possword);
    int insertUser(UserBean userBean);
}
