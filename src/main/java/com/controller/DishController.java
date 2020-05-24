package com.controller;

import com.github.pagehelper.PageInfo;
import com.model.Dish;
import com.service.DishService;
import com.utils.RequestParamsUtil;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜的数量Controller
 *
 * @author Clrvn
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * 查询菜的数量页面
     *
     * @return 分页菜的数量数据
     */
    @GetMapping("/page")
    public PageInfo<Dish> page() {
        return dishService.page(new RequestParamsUtil());
    }

    /**
     * 查询菜的数量列表
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<Dish> dishList = dishService.list(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(dishList);
    }

    /**
     * 通过id查询单个菜的数量
     */
    @GetMapping("/findById")
    public ResultVO findById(@RequestParam(value = "id") Integer id) {
        Dish dish = dishService.findById(id);
        return ResultVOUtil.success(dish);
    }

    /**
     * 通过map查询单个菜的数量
     */
    @GetMapping("/findByMap")
    public ResultVO findByMap() {
        Dish dish = dishService.findByMap(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(dish);
    }

    /**
     * 添加菜的数量
     */
    @PostMapping("/save")
    public ResultVO save(@RequestBody Dish dish) {
        try {
            dishService.save(dish);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("添加失败！");
        }
    }

    /**
     * 修改菜的数量
     */
    @PutMapping("/update")
    public ResultVO update(@RequestBody Dish dish) {
        try {
            dishService.update(dish);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("修改失败！");
        }

    }

    /**
     * 删除菜的数量
     */
    @DeleteMapping("/deleteById")
    public ResultVO deleteById(@RequestParam(value = "id") Integer id) {
        try {
            dishService.deleteById(id);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("删除失败！");
        }
    }

}