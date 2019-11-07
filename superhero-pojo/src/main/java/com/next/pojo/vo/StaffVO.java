package com.next.pojo.vo;

import lombok.Data;

/**
 * @路径: com.next.pojo.vo.StaffVO
 * @描述: vo 由系统向外 的实体类
 * 小程序查询演职人员信息
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-07 17:25
 **/
@Data
public class StaffVO {
    private String staffId;
    private String name;
    private Integer sex;
    private String photo;
    private Integer role;
    private String actName;

}
