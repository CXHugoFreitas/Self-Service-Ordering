package com.controller;

import com.github.pagehelper.PageInfo;
import com.model.Order;
import com.service.OrderService;
import com.utils.RequestParamsUtil;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单Controller
 *
 * @author Clrvn
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单页面
     *
     * @return 分页订单数据
     */
    @GetMapping("/page")
    public PageInfo<Order> page() {
        return orderService.page(new RequestParamsUtil());
    }

    /**
     * 查询订单列表
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<Order> orderList = orderService.list(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(orderList);
    }

    /**
     * 通过id查询单个订单
     */
    @GetMapping("/findById")
    public ResultVO findById(@RequestParam(value = "id") Integer id) {
        Order order = orderService.findById(id);
        return ResultVOUtil.success(order);
    }

    /**
     * 通过map查询单个订单
     */
    @GetMapping("/findByMap")
    public ResultVO findByMap() {
        Order order = orderService.findByMap(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(order);
    }

    /**
     * 添加订单
     */
    @PostMapping("/save")
    public ResultVO save(@RequestBody Order order) {
        try {
            orderService.save(order);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("添加失败！");
        }
    }

    /**
     * 修改订单
     */
    @PutMapping("/update")
    public ResultVO update(@RequestBody Order order) {
        try {
            orderService.update(order);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("修改失败！");
        }

    }

    /**
     * 删除订单
     */
    @DeleteMapping("/deleteById")
    public ResultVO deleteById(@RequestParam(value = "id") Integer id) {
        try {
            orderService.deleteById(id);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("删除失败！");
        }
    }

}