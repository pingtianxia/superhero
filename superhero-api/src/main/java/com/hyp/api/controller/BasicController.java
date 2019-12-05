package com.hyp.api.controller;

import com.hyp.api.config.FaceConfig;
import com.next.common.RedisOperator;
import com.next.pojo.Users;
import com.next.pojo.vo.UsersVO;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @路径: com.hyp.api.controller.BasicController
 * @描述: 基础Controller
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-05 10:44
 **/
@RestController
public class BasicController {
    @Autowired
    public RedisOperator redisOperator;

    @Autowired
    public FaceConfig faceConfig;

    public static final String REDIS_USER_TOKEN = "redis-user-token:";

    public Integer[] getGuessULikeArray(Integer counts,int arrayCount) {

        Integer[] guessIndexArray = new Integer[arrayCount];

        for (int i = 0; i < guessIndexArray.length; i++) {
            int numIndex = (int)(Math.random() * counts);

            if ( ArrayUtils.contains(guessIndexArray, numIndex)) {
                i --;
                continue;
            }
            guessIndexArray[i] = numIndex;
        }
        return guessIndexArray;

    }

    public UsersVO setRedisUserToken(Users user) {
        // 保存用户的分布式会话 - 生成一个token保存到redis中，可以被任何分布式集群节点访问到
        String userId = user.getId();
        // 生成一个token
        String uniqueToken = UUID.randomUUID().toString().trim();
        // 保存用户会话
        redisOperator.set(REDIS_USER_TOKEN + ":" + userId, uniqueToken);

        UsersVO userVO = new UsersVO();
        BeanUtils.copyProperties(user, userVO);
        userVO.setUserUniqueToken(uniqueToken);
        return userVO;
    }

}
