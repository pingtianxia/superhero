package com.hyp.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @路径: com.hyp.api.config.FaceConfig
 * @描述: 头像上传face
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-14 15:29
 **/
@Configuration
@ConfigurationProperties(prefix = "com.next")
@PropertySource("classpath:face.properties")
@Data
public class FaceConfig {
    private String faceFileSpace;
    private String url;
}
