package com.next.pojo.bo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @路径: com.next.pojo.bo.WXMPUserBo
 * @描述: 微信授权登陆，前端传入的授权信息
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-09 14:44
 **/
@ApiModel(value = "微信小程序用户对象",description = "从客户端，获取到微信用户的数据封装在此entity中")
@Data
public class WXMPUserBo {
    @ApiModelProperty(value = "昵称",name = "nickName",example = "NEXT",required = true)
    private String nickName;
    @ApiModelProperty(value = "头像",name = "avatarUrl",example = "http://49.232.6.28/default-face.png",required = true)
    private String avatarUrl;
    @ApiModelProperty(value = "使用哪个小程序[0:NEXT超英预告][1:超英预告][2:NEXT学院电影预告]",name = "whichMP",example = "0",required = false)
    private Integer whichMP;

}
