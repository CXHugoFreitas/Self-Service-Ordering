package com.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 订单
 *
 * @author Clrvn
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 餐桌id
     */
    private Integer deskId;

    /**
     * 餐桌编号
     */
    private String deskNo;

    /**
     * 外送地址
     */
    private String address;

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

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 支付状态 0、未支付 1、已支付
     */
    private Integer status;

    /**
     * 下单时间
     */
    private Date createTime;


}
