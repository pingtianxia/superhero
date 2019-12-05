package com.next.pojo.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @路径: com.next.pojo.bo.WXReturnSessionBO
 * @描述: 请求微信授权返回信息实体类
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-09 15:30
 **/
@ApiModel(value = "微信授权返回信息",description = "发送微信授权请求返回信息")
@Data
public class WXReturnSessionBO {
    private String session_key;
    private String openid;
}
