package com.hyp.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @路径: com.hyp.api.controller.HelloController
 * @描述: Hello 测试项目Controller
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-10-26 16:45
 **/
@RestController
@Api(value = "测试",tags = "项目搭建测试")
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(value = "Hello World", notes = "Hello World", httpMethod = "GET")
    public String helloWorld() {
        return "Hello World";
    }
}
