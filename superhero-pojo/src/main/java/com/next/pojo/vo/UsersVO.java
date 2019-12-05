package com.next.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @路径: com.next.pojo.vo.UsersVO
 * @描述: VO返回给前端的对象信息
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-09 16:24
 **/
@Data
public class UsersVO {
    private String id;
    private String username;
    private String nickname;
    private String mpWxOpenId;
    private String appQqOpenId;
    private String appWxOpenId;
    private String appWeiboUid;
    private Integer sex;
    private String birthday;
    private String faceImage;
    private Integer isCertified;
    private Date registTime;
    // 用户唯一令牌
    private String userUniqueToken;
}
