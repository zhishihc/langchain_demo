package com.mall.search.feign;

import com.mall.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/28 9:43 上午
 */
@FeignClient(name = "search")
@RequestMapping("/search")
public interface SkuFeign {
    @GetMapping
    public Map search(@RequestParam(required = false) Map searchMap);
}
