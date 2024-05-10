package com.mall;

import entity.IdWorker;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/6/4 10:55 上午
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages = {"com.mall.seckill.dao"})
@EnableScheduling//启用任务    使得 任务注解能生效

@EnableAsync//开始多线程的支持()
public class SeckillApplication {


    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class,args);
    }
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //采用普通的key 为 字符串
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }


    /***
     * 创建DirectExchange交换机
     * @return
     */
    @Bean
    public DirectExchange basicExchange(){
        return new DirectExchange(env.getProperty("mq.pay.exchange.order"), true,false);
    }

    /**
     * 到期数据队列
     * @return
     */
    @Bean
    public Queue seckillOrderTimerQueue() {
        return new Queue(env.getProperty("mq.pay.queue.seckillordertimer"), true);
    }

    /**
     * 超时数据队列
     * @return
     */
    @Bean
    public Queue delaySeckillOrderTimerQueue() {
        return QueueBuilder.durable(env.getProperty("mq.pay.queue.seckillordertimerdelay"))
                .withArgument("x-dead-letter-exchange", env.getProperty("mq.pay.exchange.order"))        // 消息超时进入死信队列，绑定死信队列交换机
                .withArgument("x-dead-letter-routing-key", env.getProperty("mq.pay.queue.seckillordertimer"))   // 绑定指定的routing-key
                .build();
    }

    /***
     * 交换机与队列绑定
     * @return
     */
    @Bean
    public Binding basicBinding() {
        return BindingBuilder.bind(seckillOrderTimerQueue())
                .to(basicExchange())
                .with(env.getProperty("mq.pay.queue.seckillordertimer"));
    }

}
