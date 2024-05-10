package com.mall.goods.feign;

import com.mall.goods.pojo.Spu;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/28 10:06 上午
 */
@FeignClient(value = "goods")
@RequestMapping("/spu")
public interface SpuFeign {

    @GetMapping("/{id}")
    public Result<Spu> findById(@PathVariable(name = "id") Long id);
}
