package com.service;

import com.github.pagehelper.PageInfo;
import com.model.OrderDetail;
import com.utils.RequestParamsUtil;
import com.vo.ResultVO;

import java.util.List;
import java.util.Map;

/**
 * 订单详情Service
 *
 * @author Clrvn
 */
public interface OrderDetailService {

    /**
     * 查询订单详情页面
     *
     * @return 分页订单详情数据
     */
    PageInfo<OrderDetail> page(RequestParamsUtil requestParamsUtil);

    /**
     * 查询订单详情列表
     */
    List<OrderDetail> list(Map<String, Object> map);

    /**
     * 通过order_id查询单个订单详情
     */
    OrderDetail findById(Integer orderId);

    /**
     * 通过map查询单个订单详情
     */
    OrderDetail findByMap(Map<String, Object> map);

    /**
     * 新增订单详情
     */
    ResultVO save(OrderDetail orderDetail);

    /**
     * 修改订单详情
     */
    ResultVO update(OrderDetail orderDetail);

    /**
     * 删除订单详情
     */
    ResultVO deleteById(Integer orderId);

}
