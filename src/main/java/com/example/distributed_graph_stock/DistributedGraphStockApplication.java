package com.example.distributed_graph_stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class DistributedGraphStockApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(DistributedGraphStockApplication.class, args);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/js/**").addResourceLocations("file:C:/Users/mameng/Desktop/基于NebulaGraph数据可视化系统设计与实现/代码/springboot项目/distributed_graph_stock/src/main/resources/static/js/");
        registry.addResourceHandler("/static/img/**").addResourceLocations("file:C:/Users/mameng/Desktop/基于NebulaGraph数据可视化系统设计与实现/代码/springboot项目/distributed_graph_stock/src/main/resources/static/img/");
        registry.addResourceHandler("/static/css/**").addResourceLocations("file:C:/Users/mameng/Desktop/基于NebulaGraph数据可视化系统设计与实现/代码/springboot项目/distributed_graph_stock/src/main/resources/static/css/");
        registry.addResourceHandler("/static/font/**").addResourceLocations("file:C:/Users/mameng/Desktop/基于NebulaGraph数据可视化系统设计与实现/代码/springboot项目/distributed_graph_stock/src/main/resources/static/font/");
        registry.addResourceHandler("/templates/**").addResourceLocations("file:C:/Users/mameng/Desktop/基于NebulaGraph数据可视化系统设计与实现/代码/springboot项目/distributed_graph_stock/src/main/resources/templates/");
    }

}
