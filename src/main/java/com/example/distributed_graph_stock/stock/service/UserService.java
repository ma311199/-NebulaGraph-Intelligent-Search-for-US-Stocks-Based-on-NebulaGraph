package com.example.distributed_graph_stock.stock.service;

import com.example.distributed_graph_stock.stock.bean.UserBean;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/12 18:32
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service
 * @CLASS_NAME: UserService
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */
public interface UserService {
    int showUser(String name,String password);
    int insertUser(UserBean userBean);
}
