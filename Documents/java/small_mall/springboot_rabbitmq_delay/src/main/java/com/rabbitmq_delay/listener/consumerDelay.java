package com.rabbitmq_delay.listener;


import com.rabbitmq_delay.config.QueueConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/6/9 10:01 上午
 */


@Component
@RabbitListener(queues = "queue.message")
public class consumerDelay {

    /***
     * 监听消息
     * @param msg
     */
    @RabbitHandler
    public void msg(@Payload Object msg){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间:"+dateFormat.format(new Date()));
        System.out.println("收到信息:"+msg);
    }
}



