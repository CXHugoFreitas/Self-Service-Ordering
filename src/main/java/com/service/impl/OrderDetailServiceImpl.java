package com.service.impl;

import java.util.Date;

import com.dao.DishDao;
import com.dao.OrderDao;
import com.dao.OrderDetailDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.Dish;
import com.model.Order;
import com.model.OrderDetail;
import com.service.OrderDetailService;
import com.utils.RequestParamsUtil;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单详情ServiceImpl
 *
 * @author Clrvn
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private DishDao dishDao;

    /**
     * 查询订单详情页面
     *
     * @return 分页订单详情数据
     */
    @Override
    public PageInfo<OrderDetail> page(RequestParamsUtil requestParamsUtil) {
        PageHelper.startPage(requestParamsUtil.getPageNo(), requestParamsUtil.getPageSize());
        return new PageInfo<>(orderDetailDao.list(requestParamsUtil.getParameters()));
    }

    /**
     * 查询订单详情列表
     */
    @Override
    public List<OrderDetail> list(Map<String, Object> map) {
        return orderDetailDao.list(map);
    }


    /**
     * 通过order_id查询单个订单详情
     */
    @Override
    public OrderDetail findById(Integer orderId) {
        return orderDetailDao.findById(orderId);
    }

    /**
     * 通过map查询单个订单详情
     */
    @Override
    public OrderDetail findByMap(Map<String, Object> map) {
        return orderDetailDao.findByMap(map);
    }

    /**
     * 新增订单详情
     */
    @Override
    public ResultVO save(OrderDetail orderDetail) {

        Integer orderId = orderDetail.getOrderId();
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderId);

        Map<String, Object> othermap = new HashMap<>();
        othermap.put("cateId", orderDetail.getCateId());
        othermap.put("size", orderDetail.getSize());

        //验证够不够
        Dish dish = dishDao.findByMap(othermap);

        //库存小于则添加
        if (orderDetail.getNum() <= dish.getQuantity()) {
            //保存菜品
            orderDetailDao.save(orderDetail);
            //计算价格
            List<OrderDetail> orderDetailList = orderDetailDao.list(map);
            long amount = orderDetailList.stream().mapToInt(OrderDetail::getAmount).sum();
            Order order = new Order();
            order.setId(orderId);
            order.setAmount((int) amount);
            //修改价格
            orderDao.update(order);
            //修改库存
            dish.setQuantity(dish.getQuantity() - orderDetail.getNum());
            dishDao.update(dish);
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.failure("添加失败，数量不够！");
        }
    }

    /**
     * 修改订单详情
     */
    @Override
    public ResultVO update(OrderDetail newOrderDetail) {

        OrderDetail oldOrderDetail = orderDetailDao.findById(newOrderDetail.getId());

        Map<String, Object> oldMap = new HashMap<>();

        oldMap.put("cateId", oldOrderDetail.getCateId());
        oldMap.put("size", oldOrderDetail.getSize());
        //修改回来库存
        Dish oldDish = dishDao.findByMap(oldMap);
        oldDish.setQuantity(oldDish.getQuantity() + oldOrderDetail.getNum());

        Integer orderId = newOrderDetail.getOrderId();
        Map<String, Object> newMap = new HashMap<>();

        newMap.put("orderId", orderId);
        newMap.put("cateId", newOrderDetail.getCateId());
        newMap.put("size", newOrderDetail.getSize());

        //验证够不够
        Dish dish = dishDao.findByMap(newMap);

        //库存小于则添加
        if (newOrderDetail.getNum() <= dish.getQuantity()) {
            //保存菜品
            orderDetailDao.update(newOrderDetail);
            //计算价格
            List<OrderDetail> orderDetailList = orderDetailDao.list(newMap);
            long amount = orderDetailList.stream().mapToInt(OrderDetail::getAmount).sum();
            Order order = new Order();
            order.setId(orderId);
            order.setAmount((int) amount);
            //修改价格
            orderDao.update(order);
            //修改库存
            dishDao.update(oldDish);
            dish.setQuantity(dish.getQuantity() - newOrderDetail.getNum());
            dishDao.update(dish);
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.failure("修改失败，数量不够！");
        }
    }

    /**
     * 删除订单详情
     */
    @Override
    public ResultVO deleteById(Integer orderId) {

        OrderDetail oldOrderDetail = orderDetailDao.findById(orderId);

        Map<String, Object> oldMap = new HashMap<>();

        oldMap.put("cateId", oldOrderDetail.getCateId());
        oldMap.put("size", oldOrderDetail.getSize());
        //修改回来库存
        Dish oldDish = dishDao.findByMap(oldMap);
        oldDish.setQuantity(oldDish.getQuantity() + oldOrderDetail.getNum());
        //计算价格
        List<OrderDetail> orderDetailList = orderDetailDao.list(oldMap);
        long amount = orderDetailList.stream().mapToInt(OrderDetail::getAmount).sum();
        Order order = new Order();
        order.setId(orderId);
        order.setAmount((int) amount);
        //修改价格
        orderDao.update(order);
        //修改库存
        dishDao.update(oldDish);
        return ResultVOUtil.success();
    }

}
