package com.service.impl;

import com.dao.OrderDao;
import com.dao.OrderDetailDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.Order;
import com.service.OrderService;
import com.utils.RequestParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 订单ServiceImpl
 *
 * @author Clrvn
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailDao orderDetailDao;

    /**
     * 查询订单页面
     *
     * @return 分页订单数据
     */
    @Override
    public PageInfo<Order> page(RequestParamsUtil requestParamsUtil) {
        PageHelper.startPage(requestParamsUtil.getPageNo(), requestParamsUtil.getPageSize());
        return new PageInfo<>(orderDao.list(requestParamsUtil.getParameters()));
    }

    /**
     * 查询订单列表
     */
    @Override
    public List<Order> list(Map<String, Object> map) {
        return orderDao.list(map);
    }


    /**
     * 通过id查询单个订单
     */
    @Override
    public Order findById(Integer id) {
        return orderDao.findById(id);
    }

    /**
     * 通过map查询单个订单
     */
    @Override
    public Order findByMap(Map<String, Object> map) {
        return orderDao.findByMap(map);
    }

    /**
     * 新增订单
     */
    @Override
    public int save(Order order) {
        return orderDao.save(order);
    }

    /**
     * 修改订单
     */
    @Override
    public int update(Order order) {
        return orderDao.update(order);
    }

    /**
     * 删除订单
     */
    @Override
    public int deleteById(Integer id) {
        orderDetailDao.deleteByOrderId(id);
        return orderDao.deleteById(id);
    }

}
