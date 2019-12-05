package com.next.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @路径: com.next.pojo.bo.ModifiedUserBO
 * @描述: 修改信息Bo
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-14 15:26
 **/
@ApiModel(value="用户修改信息对象", description="用户修改的昵称/生日/性别等数据封装在此entity中")
@Data
public class ModifiedUserBO {
    @ApiModelProperty(value="用户id",name="userId",example="20190101oweidjaw", required=true)
    private String userId;

    @ApiModelProperty(value="性别",name="sex",example="1", required=false)
    private Integer sex;
    @ApiModelProperty(value="昵称",name="nickName",example="NEXT", required=false)
    private String nickname;
    @ApiModelProperty(value="生日",name="birthday",example="1900-01-01", required=false)
    private String birthday;
}
