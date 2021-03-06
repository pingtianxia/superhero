package com.next.service.impl;

import com.next.mapper.CarouselMapper;
import com.next.pojo.Carousel;
import com.next.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @路径: com.next.service.impl.CarouselServiceImpl
 * @描述: 轮播图Services实现
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-10-30 10:44
 **/
@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryAll() {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow", 1);
        List<Carousel> carouselList = carouselMapper.selectByExample(example);
        return carouselList;
    }
}
