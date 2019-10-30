package com.hyp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @路径: com.hyp.api.Application
 * @描述: Spting boot 启动类
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-10-26 16:36
 **/
@SpringBootApplication
// 扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.next.mapper")
// 组件扫描
@ComponentScan(basePackages = {"com.next","com.hyp.api.config","com.hyp.api.controller"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
