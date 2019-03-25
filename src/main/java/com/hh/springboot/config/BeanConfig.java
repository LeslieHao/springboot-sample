package com.hh.springboot.config;

import com.hh.springboot.model.GolfGTI;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HaoHao
 * @date 2019/3/25下午5:41
 */

@Configuration
@ConfigurationProperties(prefix = "m.config")
public class BeanConfig {

    private String name;

    private Integer size;

    @Bean
    public GolfGTI getCar(){
        GolfGTI gti = new GolfGTI();
        gti.setEngine("EA888");
        gti.setName("高尔夫GTI");
        return gti;
    }
}
