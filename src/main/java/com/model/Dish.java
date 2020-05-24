package com.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 菜的数量
 *
 * @author Clrvn
 */
@Data
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增id
     */
    private Integer id;

    /**
     * 种类id
     */
    private Integer cateId;

    /**
     * 种类名称
     */
    private String cateName;

    /**
     * 分量
     */
    private Integer size;

    /**
     * 单价
     */
    private Integer price;


    /**
     * 数量
     */
    private Integer quantity;


}
