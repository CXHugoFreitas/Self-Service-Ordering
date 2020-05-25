package com.controller;

import com.github.pagehelper.PageInfo;
import com.model.OrderDetail;
import com.service.OrderDetailService;
import com.utils.RequestParamsUtil;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单详情Controller
 *
 * @author Clrvn
 */
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 查询订单详情页面
     *
     * @return 分页订单详情数据
     */
    @GetMapping("/page")
    public PageInfo<OrderDetail> page() {
        return orderDetailService.page(new RequestParamsUtil());
    }

    /**
     * 查询订单详情列表
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<OrderDetail> orderDetailList = orderDetailService.list(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(orderDetailList);
    }

    /**
     * 通过order_id查询单个订单详情
     */
    @GetMapping("/findById")
    public ResultVO findById(@RequestParam(value = "order_id") Integer order_id) {
        OrderDetail orderDetail = orderDetailService.findById(order_id);
        return ResultVOUtil.success(orderDetail);
    }

    /**
     * 通过map查询单个订单详情
     */
    @GetMapping("/findByMap")
    public ResultVO findByMap() {
        OrderDetail orderDetail = orderDetailService.findByMap(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(orderDetail);
    }

    /**
     * 添加订单详情
     */
    @PostMapping("/save")
    public ResultVO save(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.save(orderDetail);
    }

    /**
     * 修改订单详情
     */
    @PutMapping("/update")
    public ResultVO update(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.update(orderDetail);
    }

    /**
     * 删除订单详情
     */
    @DeleteMapping("/deleteById")
    public ResultVO deleteById(@RequestParam(value = "order_id") Integer order_id) {
        return orderDetailService.deleteById(order_id);
    }

}