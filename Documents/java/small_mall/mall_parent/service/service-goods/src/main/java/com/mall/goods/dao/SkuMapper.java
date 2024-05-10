package com.mall.goods.dao;

import com.mall.goods.pojo.Sku;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
import com.mall.order.pojo.OrderItem;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/21 1:48 下午
 */
public interface SkuMapper extends Mapper<Sku> {

    @Update(value = "update tb_sku set num=num-#{num},sale_num=sale_num+#{num} where id =#{skuId} and num >=#{num}")
    public int decrCount(OrderItem orderItem);
}
