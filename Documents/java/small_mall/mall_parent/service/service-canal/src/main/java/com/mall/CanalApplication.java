package com.mall;

import com.xpand.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/27 10:20 上午
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient

//启动canal
@EnableCanalClient
@EnableFeignClients(basePackages = {"com.mall.content.feign","com.mall.item.feign"})

public class CanalApplication {
    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class,args);
    }
}
