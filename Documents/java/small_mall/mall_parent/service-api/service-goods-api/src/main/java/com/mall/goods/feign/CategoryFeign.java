package com.mall.goods.feign;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall.goods.pojo.Category;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/28 10:06 上午
 */
@FeignClient(value = "goods")
@RequestMapping("/category")
public interface CategoryFeign {
    @GetMapping("/{id}")
    public Result<Category> findById(@PathVariable(name = "id") Integer id);
}
