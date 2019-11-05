package com.next.service.impl;

import com.github.pagehelper.PageHelper;
import com.next.common.MovieTypeEnum;
import com.next.mapper.MovieMapper;
import com.next.pojo.Movie;
import com.next.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @路径: com.next.service.impl.MovieServiceImpl
 * @描述: MovieService 实现类
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-04 16:00
 **/
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;


    @Override
    public List<Movie> queryHotSuperhero(String type) {
        // 定义分页，永远只拿第一页的数据，分别是第一页的前8/前4条记录
        Integer page = 1;
        Integer pageSize = 0;

        Example example = new Example(Movie.class);
        if (type.equals(MovieTypeEnum.SUPERHERO.getType())) {
            example.orderBy("score").desc();
            pageSize = 8;
        }else if (type.equals(MovieTypeEnum.TRAILER.getType())){
            example.orderBy("prisedCounts").desc();
            pageSize = 4;
        }else {
            return null;
        }
        PageHelper.startPage(page, pageSize);
        return movieMapper.selectByExample(example);
    }

    @Override
    public Integer queryAllTrailerCounts() {
        int count = movieMapper.selectCount(null);
        return count;
    }

    @Override
    public List<Movie> queryAllTrailers() {
        List<Movie> movieList = movieMapper.selectAll();
        return movieList;
    }
}
