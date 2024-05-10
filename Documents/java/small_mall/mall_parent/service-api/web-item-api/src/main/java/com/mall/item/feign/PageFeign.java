package com.mall.item.feign;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/6/1 1:42 下午
 */
@FeignClient(name = "item")
@RequestMapping("/page")
public interface PageFeign {
    /***
     * 生成静态页
     *
     */
    @RequestMapping("/create/{id}")
    Result createHtml(@PathVariable(name = "id") Long id);
}
