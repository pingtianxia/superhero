package com.next.service;

import com.next.pojo.Movie;

import java.util.List;

/**
 * @包 名: com.next.service
 * @类 名:
 * @描 述:
 * @作 者: hyp
 * @邮 箱: henanyunpingearl@163.com
 * @创建日期: 2019/11/4 16:00
 */
public interface MovieService {

    /***
     * 查询热么电影预告片
     * 评分越高，超英越热门
     * 点赞数越高，预告片越热门
     * @param type
     * @return
     */
    public List<Movie> queryHotSuperhero(String type);

    /**
     * 查询电影预告表的记录数
     * @return
     */
    public Integer queryAllTrailerCounts();

    /***
     * 查询所有的电影记录
     * @return
     */
    public List<Movie> queryAllTrailers();
}
