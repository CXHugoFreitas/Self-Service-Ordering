package com.controller;

import com.github.pagehelper.PageInfo;
import com.model.Category;
import com.service.CategoryService;
import com.utils.RequestParamsUtil;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜的种类Controller
 *
 * @author Clrvn
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询菜的种类页面
     *
     * @return 分页菜的种类数据
     */
    @GetMapping("/page")
    public PageInfo<Category> page() {
        return categoryService.page(new RequestParamsUtil());
    }

    /**
     * 查询菜的种类列表
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<Category> categoryList = categoryService.list(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(categoryList);
    }

    /**
     * 通过id查询单个菜的种类
     */
    @GetMapping("/findById")
    public ResultVO findById(@RequestParam(value = "id") Integer id) {
        Category category = categoryService.findById(id);
        return ResultVOUtil.success(category);
    }

    /**
     * 通过map查询单个菜的种类
     */
    @GetMapping("/findByMap")
    public ResultVO findByMap() {
        Category category = categoryService.findByMap(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(category);
    }

    /**
     * 添加菜的种类
     */
    @PostMapping("/save")
    public ResultVO save(@RequestBody Category category) {
        try {
            categoryService.save(category);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("添加失败！");
        }
    }

    /**
     * 修改菜的种类
     */
    @PutMapping("/update")
    public ResultVO update(@RequestBody Category category) {
        try {
            categoryService.update(category);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("修改失败！");
        }

    }

    /**
     * 删除菜的种类
     */
    @DeleteMapping("/deleteById")
    public ResultVO deleteById(@RequestParam(value = "id") Integer id) {
        try {
            categoryService.deleteById(id);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("删除失败！");
        }
    }

}