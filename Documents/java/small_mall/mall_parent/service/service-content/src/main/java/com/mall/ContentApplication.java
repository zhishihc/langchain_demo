package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/27 2:42 下午
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.mall.content.dao"})
public class ContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentApplication.class);
    }
}
