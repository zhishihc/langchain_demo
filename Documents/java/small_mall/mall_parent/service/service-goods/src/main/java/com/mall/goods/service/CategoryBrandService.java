package com.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.mall.goods.pojo.CategoryBrand;

import java.util.List;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/21 1:59 下午
 */
public interface CategoryBrandService {

    /***
     * CategoryBrand多条件分页查询
     * @param categoryBrand
     * @param page
     * @param size
     * @return
     */
    PageInfo<CategoryBrand> findPage(CategoryBrand categoryBrand, int page, int size);

    /***
     * CategoryBrand分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<CategoryBrand> findPage(int page, int size);

    /***
     * CategoryBrand多条件搜索方法
     * @param categoryBrand
     * @return
     */
    List<CategoryBrand> findList(CategoryBrand categoryBrand);

    /***
     * 删除CategoryBrand
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改CategoryBrand数据
     * @param categoryBrand
     */
    void update(CategoryBrand categoryBrand);

    /***
     * 新增CategoryBrand
     * @param categoryBrand
     */
    void add(CategoryBrand categoryBrand);

    /**
     * 根据ID查询CategoryBrand
     * @param id
     * @return
     */
    CategoryBrand findById(Integer id);

    /***
     * 查询所有CategoryBrand
     * @return
     */
    List<CategoryBrand> findAll();
}

