package com.service;

import com.github.pagehelper.PageInfo;
import com.model.Dish;
import com.utils.RequestParamsUtil;

import java.util.List;
import java.util.Map;

/**
 * 菜的数量Service
 *
 * @author Clrvn
 */
public interface DishService {

    /**
     * 查询菜的数量页面
     *
     * @return 分页菜的数量数据
     */
    PageInfo<Dish> page(RequestParamsUtil requestParamsUtil);

    /**
     * 查询菜的数量列表
     */
    List<Dish> list(Map<String, Object> map);

    /**
     * 通过id查询单个菜的数量
     */
    Dish findById(Integer id);

    /**
     * 通过map查询单个菜的数量
     */
    Dish findByMap(Map<String, Object> map);

    /**
     * 新增菜的数量
     */
    int save(Dish dish);

    /**
     * 修改菜的数量
     */
    int update(Dish dish);

    /**
     * 删除菜的数量
     */
    int deleteById(Integer id);

}
