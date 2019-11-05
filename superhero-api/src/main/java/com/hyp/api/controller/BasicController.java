package com.hyp.api.controller;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.RestController;

/**
 * @路径: com.hyp.api.controller.BasicController
 * @描述: 基础Controller
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-05 10:44
 **/
@RestController
public class BasicController {

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

}
