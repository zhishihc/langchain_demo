package com.mall.search.service;

import java.util.Map;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/28 9:49 上午
 */
public interface SkuService {

    /**
     * //1.调用 goods微服务的fegin 查询 符合条件的sku的数据
     //2.调用spring data elasticsearch的API 导入到ES中
     */
    void  importEs();


    /**
     *
     * @param searchMap
     * @return
     */
    Map search(Map<String,String> searchMap);
}
