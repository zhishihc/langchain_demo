package com.mall.goods.pojo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * 商品组合实体类
 */
@ApiModel(description = "商品信息")
public class Goods implements Serializable {
    //SPU
    private com.mall.goods.pojo.Spu spu;
    //SKU集合
    private List<com.mall.goods.pojo.Sku> skuList;

    public com.mall.goods.pojo.Spu getSpu() {
        return spu;
    }

    public void setSpu(com.mall.goods.pojo.Spu spu) {
        this.spu = spu;
    }

    public List<com.mall.goods.pojo.Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<com.mall.goods.pojo.Sku> skuList) {
        this.skuList = skuList;
    }
}