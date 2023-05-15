package com.example.distributed_graph_stock.stock.service.impl;

import com.example.distributed_graph_stock.stock.bean.UserBean;
import com.example.distributed_graph_stock.stock.dao.impl.UserDaoImpl;
import com.example.distributed_graph_stock.stock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author BuGui
 * @Description TODO
 * @Date 2023/4/12 18:32
 * @PACKAGE_NAME: com.example.distributed_graph_stock.stock.service.impl
 * @CLASS_NAME: UserServiceImpl
 * @PROJECT_NAME: distributed_graph_stock
 * @Version 1.0
 */

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;

    @Override
    public int showUser(String name, String password) {  //查看用户是否存在
        return userDao.showUser(name,password);
    }

    @Override
    public int insertUser(UserBean userBean) {  //插入用户数据
        return userDao.insertUser(userBean);
    }
}
