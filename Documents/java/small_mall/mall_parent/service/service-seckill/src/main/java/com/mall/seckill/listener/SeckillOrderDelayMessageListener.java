package com.mall.seckill.listener;

import com.alibaba.fastjson.JSON;
import com.mall.seckill.pojo.SeckillOrder;
import com.mall.seckill.pojo.SeckillStatus;
import com.mall.pay.feign.PayFeign;
import com.mall.seckill.service.SeckillOrderService;
import entity.Result;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/6/9 11:25 上午
 */
@Component
@RabbitListener(queues = "${mq.pay.queue.seckillordertimer}")
public class SeckillOrderDelayMessageListener {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SeckillOrderService seckillOrderService;

    @Autowired
    private PayFeign weixinPayFeign;

    /***
     * 读取消息
     * 判断Redis中是否存在对应的订单
     * 如果存在，则关闭支付，再关闭订单
     * @param message
     */
    @RabbitHandler
    public void consumeMessage(@Payload String message){
        //读取消息
        SeckillStatus seckillStatus = JSON.parseObject(message,SeckillStatus.class);

        //获取Redis中订单信息
        String username = seckillStatus.getUsername();
        SeckillOrder seckillOrder = (SeckillOrder) redisTemplate.boundHashOps("SeckillOrder").get(username);

        //如果Redis中有订单信息，说明用户未支付
        if(seckillOrder!=null){
            System.out.println("准备回滚---"+seckillStatus);
            //关闭支付
            Result closeResult = weixinPayFeign.closePay(seckillStatus.getOrderId());
            Map<String,String> closeMap = (Map<String, String>) closeResult.getData();

            if(closeMap!=null && closeMap.get("return_code").equalsIgnoreCase("success") &&
                    closeMap.get("result_code").equalsIgnoreCase("success") ){
                //关闭订单
                seckillOrderService.closeOrder(username);
            }
        }
    }
}