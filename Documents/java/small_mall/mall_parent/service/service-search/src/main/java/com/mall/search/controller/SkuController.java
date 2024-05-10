package com.mall.search.controller;

import com.mall.search.service.SkuService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/28 10:13 上午
 */
@RestController
@CrossOrigin
@RequestMapping("/search")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @RequestMapping("/import")
    public Result importEs() {

        skuService.importEs();
        return new Result(true, StatusCode.OK, "导入成功");
    }

    /**
     * @param searchMap 搜索的条件 map
     * @return resultMap  返回的结果 map
     */
//    @GetMapping
//    public Map search(@RequestParam(required = false) Map searchMap) {
//        Object pageNum = searchMap.get("pageNum");
//        if (pageNum == null) {
//            searchMap.put("pageNum", "1");
//        }
//        if (pageNum instanceof Integer) {
//            searchMap.put("pageNum", pageNum.toString());
//        }
//
//        return skuService.search(searchMap);
//    }

    @GetMapping
    public Map search(@RequestBody(required = false) Map searchMap){
//        Object pageNum = searchMap.get("pageNum");
//        if (pageNum == null) {
//            searchMap.put("pageNum", "1");
//        }
//        if (pageNum instanceof Integer) {
//            searchMap.put("pageNum", pageNum.toString());
//        }
//
//        return  skuService.search(searchMap);

        Map resultMap = skuService.search(searchMap);
        return resultMap;
    }

}
