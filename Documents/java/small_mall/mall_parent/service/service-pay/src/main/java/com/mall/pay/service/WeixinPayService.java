package com.mall.pay.service;

import java.util.Map;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/6/7 2:56 下午
 */
public interface WeixinPayService {
    /**
     * 生成二维码
     *
     * @return
     */
    Map<String,String> createNative(Map<String,String> parameters);


    /**
     *
     * @param out_trade_no
     * @return
     */
    Map<String, String> queryStatus(String out_trade_no);


    /***
     * 关闭支付
     * @param orderId
     * @return
     */
    Map<String,String> closePay(Long orderId) throws Exception;
}
