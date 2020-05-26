package com.dao;

import com.model.OrderDetail;

import java.util.List;
import java.util.Map;


/**
 * 订单详情DAO
 *
 * @author Clrvn
 */
public interface OrderDetailDao {

    /**
     * 通过order_id查询单个订单详情
     */
    OrderDetail findById(Integer id);

    /**
     * 通过map查询单个订单详情
     */
    OrderDetail findByMap(Map<String, Object> map);

    /**
     * 查询订单详情列表
     */
    List<OrderDetail> list(Map<String, Object> map);

    /**
     * 新增订单详情
     */
    int save(OrderDetail orderDetail);

    /**
     * 修改订单详情
     */
    int update(OrderDetail orderDetail);

    /**
     * 删除订单详情
     */
    int deleteById(Integer id);

    /**
     * 删除订单详情
     */
    void deleteByOrderId(Integer id);
}
