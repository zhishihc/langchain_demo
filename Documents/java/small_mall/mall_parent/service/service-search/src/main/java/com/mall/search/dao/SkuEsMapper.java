package com.mall.search.dao;

import com.mall.search.pojo.SkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/28 9:45 上午
 */
public interface SkuEsMapper extends ElasticsearchRepository<SkuInfo,Long>{

}
