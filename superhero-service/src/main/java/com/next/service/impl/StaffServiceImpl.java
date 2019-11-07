package com.next.service.impl;

import com.next.mapper.StaffMapperCustom;
import com.next.pojo.vo.StaffVO;
import com.next.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @路径: com.next.service.impl.StaffServiceImpl
 * @描述: 自定义mapper
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-07 17:31
 **/
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapperCustom staffMapperCustom;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<StaffVO> queryStaffs(String trailerId, Integer role) {
        return staffMapperCustom.queryStaffs(trailerId, role);
    }
}
