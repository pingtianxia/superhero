package com.hyp.api.config;

import com.alibaba.fastjson.JSONArray;
import com.next.common.RedisOperator;
import com.next.pojo.Movie;
import com.next.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @路径: com.hyp.api.config.AutoBootRunner
 * @描述: SpringBoot自启动类
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-05 10:59
 **/
@Component
public class AutoBootRunner implements ApplicationRunner {

    @Autowired
    private MovieService movieService;
    @Autowired
    private RedisOperator redisOperator;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 1. 获得所有的电影记录
        List<Movie> movieList = movieService.queryAllTrailers();

        // 2. 向redis存入每一条电影的记录
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            redisOperator.set("guess-trailer-id:"+i, JSONArray.toJSONString(movie));
        }
    }
}
