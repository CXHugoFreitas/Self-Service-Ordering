package com.dao;

import com.model.Dish;

import java.util.List;
import java.util.Map;


/**
 * 菜的数量DAO
 *
 * @author Clrvn
 */
public interface DishDao {

    /**
     * 通过id查询单个菜的数量
     */
    Dish findById(Integer id);

    /**
     * 通过map查询单个菜的数量
     */
    Dish findByMap(Map<String, Object> map);

    /**
     * 查询菜的数量列表
     */
    List<Dish> list(Map<String, Object> map);

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
