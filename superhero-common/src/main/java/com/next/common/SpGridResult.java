package com.next.common;

import lombok.Data;

import java.util.List;

/**
 * @路径: com.next.common.SpGridResult
 * @描述: 用来返回小程序Grid的数据格式
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-06 18:07
 **/
@Data
public class SpGridResult {
    private int page;			// 当前页数
    private int total;			// 总页数
    private long records;		// 总记录数
    private List<?> rows;		// 每行显示的内容
}
