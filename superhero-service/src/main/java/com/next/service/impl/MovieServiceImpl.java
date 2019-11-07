package com.next.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.next.common.MovieTypeEnum;
import com.next.common.SpGridResult;
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


    @Transactional(propagation = Propagation.SUPPORTS)
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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer queryAllTrailerCounts() {
        int count = movieMapper.selectCount(null);
        return count;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Movie> queryAllTrailers() {
        List<Movie> movieList = movieMapper.selectAll();
        return movieList;
    }

    @Override
    public SpGridResult searchTrailer(String keywords, int page, int pageSize) {
        Example example = new Example(Movie.class);
        example.orderBy("createTime").desc();

        Example.Criteria criteria = example.createCriteria();
        criteria.orLike("name", "%" + keywords + "%");
        criteria.orLike("originalName", "%" + keywords + "%");

        PageHelper.startPage(page, pageSize);

        List<Movie> movieList = movieMapper.selectByExample(example);
        PageInfo<Movie> moviePageInfo = new PageInfo<>(movieList);

        SpGridResult gridResult = new SpGridResult();
        gridResult.setPage(page);
        gridResult.setRows(movieList);
        gridResult.setTotal(moviePageInfo.getPages());
        gridResult.setRecords(moviePageInfo.getTotal());
        return gridResult;
    }

    @Override
    public Movie queryTrailerInfo(String trailerId) {
        return movieMapper.selectByPrimaryKey(trailerId);
    }
}
