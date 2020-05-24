package com.dao;

import com.model.Category;

import java.util.List;
import java.util.Map;


/**
 * 菜的种类DAO
 *
 * @author Clrvn
 */
public interface CategoryDao {

    /**
     * 通过id查询单个菜的种类
     */
    Category findById(Integer id);

    /**
     * 通过map查询单个菜的种类
     */
    Category findByMap(Map<String, Object> map);

    /**
     * 查询菜的种类列表
     */
    List<Category> list(Map<String, Object> map);

    /**
     * 新增菜的种类
     */
    int save(Category category);

    /**
     * 修改菜的种类
     */
    int update(Category category);

    /**
     * 删除菜的种类
     */
    int deleteById(Integer id);

}
