package com.next.mapper;

import com.next.pojo.vo.StaffVO;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @包 名: com.next.mapper
 * @类 名:
 * @描 述:
 * @作 者: hyp
 * @邮 箱: henanyunpingearl@163.com
 * @创建日期: 2019/11/7 17:28
 */
public interface StaffMapperCustom {
    /**
     * 根据预告片的id和角色查询导演列表或者演员列表
     * @return
     */
    public List<StaffVO> queryStaffs(
            @Param(value = "trailerId") String trailerId,
            @Param(value = "role") Integer role);
}
