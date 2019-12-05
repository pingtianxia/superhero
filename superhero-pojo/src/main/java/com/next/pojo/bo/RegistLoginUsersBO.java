package com.next.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @路径: com.next.pojo.bo.RegistLoginUsersBO
 * @描述: 用户注册Bo
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-14 14:56
 **/
@ApiModel(value = "用户对象",description = "从客户端,由用户传入的数据封装在实体类BO中")
@Data
public class RegistLoginUsersBO {
    @ApiModelProperty(value = "用户名",name = "username",example="张三",required = false)
    private String username;
    @ApiModelProperty(value = "密码",name = "password",example = "123",required = false)
    private String password;
}
