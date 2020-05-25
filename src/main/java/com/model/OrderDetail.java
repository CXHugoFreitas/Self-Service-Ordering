package com.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单详情
 *
 * @author Clrvn
 */
@Data
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 菜品分类id
     */
    private Integer cateId;

    /**
     * 菜品种类
     */
    private String cateName;

    /**
     * 分量
     */
    private Integer size;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 单价
     */
    private Integer price;

    /**
     * 总价
     */
    private Integer amount;


}
