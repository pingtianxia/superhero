package com.hyp.next;

import java.util.UUID;

/**
 * @路径: com.hyp.next.Test
 * @描述: 测试方法
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-09 16:16
 **/
public class Test {

    @org.junit.Test
    public void taskDemo1() {

        String string = UUID.randomUUID().toString();
        System.out.println("带 trim 方法： ---》" + string);

         string = string.trim();

        System.out.println("不带 trim 方法： ---》" + string);
    }
}
