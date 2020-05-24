package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.Dish;
import com.service.DishService;
import com.dao.DishDao;
import com.utils.RequestParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 菜的数量ServiceImpl
 *
 * @author Clrvn
 */
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishDao dishDao;

    /**
     * 查询菜的数量页面
     *
     * @return 分页菜的数量数据
     */
    @Override
    public PageInfo<Dish> page(RequestParamsUtil requestParamsUtil) {
        PageHelper.startPage(requestParamsUtil.getPageNo(), requestParamsUtil.getPageSize());
        return new PageInfo<>(dishDao.list(requestParamsUtil.getParameters()));
    }

    /**
     * 查询菜的数量列表
     */
    @Override
    public List<Dish> list(Map<String, Object> map) {
        return dishDao.list(map);
    }


    /**
     * 通过id查询单个菜的数量
     */
    @Override
    public Dish findById(Integer id) {
        return dishDao.findById(id);
    }

    /**
     * 通过map查询单个菜的数量
     */
    @Override
    public Dish findByMap(Map<String, Object> map) {
        return dishDao.findByMap(map);
    }

    /**
     * 新增菜的数量
     */
    @Override
    public int save(Dish dish) {
        return dishDao.save(dish);
    }

    /**
     * 修改菜的数量
     */
    @Override
    public int update(Dish dish) {
        return dishDao.update(dish);
    }

    /**
     * 删除菜的数量
     */
    @Override
    public int deleteById(Integer id) {
        return dishDao.deleteById(id);
    }

}
