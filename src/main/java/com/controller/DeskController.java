package com.controller;

import com.github.pagehelper.PageInfo;
import com.model.Desk;
import com.service.DeskService;
import com.utils.RequestParamsUtil;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 餐桌Controller
 *
 * @author Clrvn
 */
@RestController
@RequestMapping("/desk")
public class DeskController {

    @Autowired
    private DeskService deskService;

    /**
     * 查询餐桌页面
     *
     * @return 分页餐桌数据
     */
    @GetMapping("/page")
    public PageInfo<Desk> page() {
        return deskService.page(new RequestParamsUtil());
    }

    /**
     * 查询餐桌列表
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<Desk> deskList = deskService.list(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(deskList);
    }

    /**
     * 通过id查询单个餐桌
     */
    @GetMapping("/findById")
    public ResultVO findById(@RequestParam(value = "id") Integer id) {
        Desk desk = deskService.findById(id);
        return ResultVOUtil.success(desk);
    }

    /**
     * 通过map查询单个餐桌
     */
    @GetMapping("/findByMap")
    public ResultVO findByMap() {
        Desk desk = deskService.findByMap(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(desk);
    }

    /**
     * 添加餐桌
     */
    @PostMapping("/save")
    public ResultVO save(@RequestBody Desk desk) {
        try {
            deskService.save(desk);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("添加失败！");
        }
    }

    /**
     * 修改餐桌
     */
    @PutMapping("/update")
    public ResultVO update(@RequestBody Desk desk) {
        try {
            deskService.update(desk);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("修改失败！");
        }

    }

    /**
     * 删除餐桌
     */
    @DeleteMapping("/deleteById")
    public ResultVO deleteById(@RequestParam(value = "id") Integer id) {
        try {
            deskService.deleteById(id);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("删除失败！");
        }
    }

}