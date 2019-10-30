package com.hyp.api.controller;

import com.next.common.NEXTJSONResult;
import com.next.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @路径: com.hyp.api.controller.IndexController
 * @描述: 首页Controller
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-10-30 10:54
 **/
@RestController
@RequestMapping("index")
@Api(value = "首页", tags = {"首页展示的相关接口"})
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "POST")
    @PostMapping("/carousel/list")
    public NEXTJSONResult list() {
        return NEXTJSONResult.ok(carouselService.queryAll());
    }
}
