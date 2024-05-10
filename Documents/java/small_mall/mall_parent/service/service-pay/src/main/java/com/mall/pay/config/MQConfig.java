package com.mall.pay.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/6/7 2:58 下午
 */

@Configuration
public class MQConfig {

    @Autowired
    private Environment env;

    /***
     * 创建DirectExchange交换机
     * @return
     */
    @Bean
    public DirectExchange basicExchange() {
        return new DirectExchange(env.getProperty("mq.pay.exchange.order"), true, false);
    }

    /***
     * 创建队列
     * @return
     */
    @Bean(name = "queueOrder")
    public Queue queueOrder() {
        return new Queue(env.getProperty("mq.pay.queue.order"), true);
    }

    /****
     * 队列绑定到交换机上
     * @return
     */
    @Bean
    public Binding basicBinding() {
        return BindingBuilder.bind(queueOrder()).to(basicExchange()).with(env.getProperty("mq.pay.routing.key"));
    }
}
