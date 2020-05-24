package com.service.impl;

import com.dao.DishDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.Category;
import com.model.Dish;
import com.service.CategoryService;
import com.dao.CategoryDao;
import com.utils.RequestParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 菜的种类ServiceImpl
 *
 * @author Clrvn
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private DishDao dishDao;

    /**
     * 查询菜的种类页面
     *
     * @return 分页菜的种类数据
     */
    @Override
    public PageInfo<Category> page(RequestParamsUtil requestParamsUtil) {
        PageHelper.startPage(requestParamsUtil.getPageNo(), requestParamsUtil.getPageSize());
        return new PageInfo<>(categoryDao.list(requestParamsUtil.getParameters()));
    }

    /**
     * 查询菜的种类列表
     */
    @Override
    public List<Category> list(Map<String, Object> map) {
        return categoryDao.list(map);
    }


    /**
     * 通过id查询单个菜的种类
     */
    @Override
    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }

    /**
     * 通过map查询单个菜的种类
     */
    @Override
    public Category findByMap(Map<String, Object> map) {
        return categoryDao.findByMap(map);
    }

    /**
     * 新增菜的种类
     */
    @Override
    public int save(Category category) {
        int cateId = categoryDao.save(category);

        //默认添加小份数量
        Dish smallDish = new Dish();
        smallDish.setCateId(cateId);
        smallDish.setSize(1);
        smallDish.setPrice(9);
        smallDish.setQuantity(10);
        dishDao.save(smallDish);

        //默认添加中份数量
        Dish middleDish = new Dish();
        middleDish.setCateId(cateId);
        middleDish.setSize(2);
        middleDish.setPrice(9);
        middleDish.setQuantity(10);
        dishDao.save(middleDish);

        //默认添加大份数量
        Dish largeDish = new Dish();
        largeDish.setCateId(cateId);
        largeDish.setSize(3);
        largeDish.setPrice(9);
        largeDish.setQuantity(10);
        dishDao.save(largeDish);

        return cateId;
    }

    /**
     * 修改菜的种类
     */
    @Override
    public int update(Category category) {
        return categoryDao.update(category);
    }

    /**
     * 删除菜的种类
     */
    @Override
    public int deleteById(Integer id) {
        return categoryDao.deleteById(id);
    }

}
