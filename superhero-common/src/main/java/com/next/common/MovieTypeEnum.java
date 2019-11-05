package com.next.common;

/**
 * @路径: com.next.common.MovieTypeEnum
 * @描述: 热门查询类型枚举类
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-04 16:09
 **/
public enum  MovieTypeEnum {
    SUPERHERO("superhero","热门超英"),
    TRAILER("trailer", "热门预告片");

    public final String type;
    public final String value;

    private MovieTypeEnum(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
