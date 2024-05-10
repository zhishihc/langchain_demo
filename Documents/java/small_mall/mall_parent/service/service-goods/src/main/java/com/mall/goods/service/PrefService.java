package com.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.mall.goods.pojo.Pref;

import java.util.List;

/**
 * @description: some desc
 * @author: zhishi
 * @email: baozhuo@zdns.com
 * @date: 2021/4/21 2:01 下午
 */
public interface PrefService {

    /***
     * Pref多条件分页查询
     * @param pref
     * @param page
     * @param size
     * @return
     */
    PageInfo<Pref> findPage(Pref pref, int page, int size);

    /***
     * Pref分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Pref> findPage(int page, int size);

    /***
     * Pref多条件搜索方法
     * @param pref
     * @return
     */
    List<Pref> findList(Pref pref);

    /***
     * 删除Pref
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Pref数据
     * @param pref
     */
    void update(Pref pref);

    /***
     * 新增Pref
     * @param pref
     */
    void add(Pref pref);

    /**
     * 根据ID查询Pref
     * @param id
     * @return
     */
    Pref findById(Integer id);

    /***
     * 查询所有Pref
     * @return
     */
    List<Pref> findAll();
}

