package com.hyp.api.controller;

import com.alibaba.fastjson.JSONArray;
import com.next.common.DESSecurity;
import com.next.common.HttpClientUtil;
import com.next.common.NEXTJSONResult;
import com.next.common.WXMPConfig;
import com.next.pojo.Users;
import com.next.pojo.bo.WXMPUserBo;
import com.next.pojo.bo.WXReturnSessionBO;
import com.next.pojo.vo.UsersVO;
import com.next.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @路径: com.hyp.api.controller.WXMPController
 * @描述: 微信小程序授权登录Controller
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-09 14:35
 **/
@RestController
@Api(value = "微信小程序授权登录",tags = {"微信小程序授权登录"})
public class WXMPController extends BasicController{
    @Autowired
    private UserService userService;

    @ApiOperation(value = "微信登录",notes = "微信登录",httpMethod = "POST")
    @PostMapping(value = "/mpWXLogin/{code}")
    public NEXTJSONResult wxLogin(
            @ApiParam(name = "code",value = "jscode,授权凭证",required = true)
            @PathVariable String code,
            @RequestBody WXMPUserBo wxUserBO) {

        String requstUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("appid", DESSecurity.decrypt(WXMPConfig.APPID));
        paramMap.put("secret", DESSecurity.decrypt(WXMPConfig.SECRET));
        paramMap.put("js_code", code);
        paramMap.put("grant_type", "authorization_code");
        String wxResult = HttpClientUtil.doGet(requstUrl, paramMap);
        System.out.println(wxResult);

        WXReturnSessionBO sessionBO = JSONArray.parseObject(wxResult, WXReturnSessionBO.class);

        Users users = userService.queryUserForLoginByMPWX(sessionBO.getOpenid());
        if (users == null) {
            users = userService.saveUserMPWX(sessionBO.getOpenid(), wxUserBO);
        }

        // 保存用户的分布式会话 - 生成一个token保存到redis中，可以被任何分布式集群节点访问到 生成一个token
        String uniqueToken = UUID.randomUUID().toString().trim();
        // 保存用户会话
        redisOperator.set(REDIS_USER_TOKEN + users.getId(), uniqueToken);
        UsersVO usersVO = new UsersVO();
        BeanUtils.copyProperties(users , usersVO);
        usersVO.setUserUniqueToken(uniqueToken);
        return NEXTJSONResult.ok(usersVO);
    }


}
