package com.next.service;

import com.next.pojo.vo.StaffVO;

import java.util.List;

/**
 * @包 名: com.next.service
 * @类 名:
 * @描 述:
 * @作 者: hyp
 * @邮 箱: henanyunpingearl@163.com
 * @创建日期: 2019/11/7 17:31
 */
public interface StaffService {

    /**
     * 查询演职人员列表
     * @param trailerId
     * @param role
     * @return
     */
    public List<StaffVO> queryStaffs(String trailerId, Integer role);
}
