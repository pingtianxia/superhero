package com.hyp.api.controller;

import com.alibaba.fastjson.JSONArray;
import com.next.common.NEXTJSONResult;
import com.next.common.RedisOperator;
import com.next.pojo.Movie;
import com.next.service.CarouselService;
import com.next.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
public class IndexController extends BasicController {

    @Autowired
    private CarouselService carouselService;
    @Autowired
    private MovieService movieService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "POST")
    @PostMapping("/carousel/list")
    public NEXTJSONResult list() {
        return NEXTJSONResult.ok(carouselService.queryAll());
    }


    @ApiOperation(value = "热门超英/预告", notes = "热门超英/预告" ,httpMethod = "POST")
    @PostMapping("/movie/hot")
    public NEXTJSONResult hot(
            @ApiParam(name = "type",value = "[超英(superhero)/预告(trailer)]",required = true)
            @RequestParam String type) {

        if (StringUtils.isBlank(type)) {
            return NEXTJSONResult.errorMsg("请传入参数");
        }

        return NEXTJSONResult.ok(movieService.queryHotSuperhero(type));
    }

    @ApiOperation(value = "猜你喜欢",notes = "猜你喜欢",httpMethod = "POST")
    @RequestMapping(value = "guessULike", method = {RequestMethod.POST})
    public NEXTJSONResult guessULike() {
        // 1. 获得数据库中 movie 表的所有数量 counts
        Integer movieCounts = movieService.queryAllTrailerCounts();

        // 2. 根据counts，获取随机的 5 个index，每个index和movie表中的主键id相互对应
        Integer[] guessIndexArray = getGuessULikeArray(movieCounts, 5);

        // 3. 从Redis中获得具体的movie记录
        List<Movie> guessList = new ArrayList<>();
        for (Integer index : guessIndexArray) {
            String jsonTrailer = redisOperator.get("guess-trailer-id:" + index);
            Movie movie = JSONArray.parseObject(jsonTrailer, Movie.class);
            guessList.add(movie);
        }


        return NEXTJSONResult.ok(guessList);
    }
}
