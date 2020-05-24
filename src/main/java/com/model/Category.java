package com.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 菜的种类
 *
 * @author Clrvn
 */
@Data
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增id
     */
    private Integer id;

    /**
     * 种类名称
     */
    private String cateName;

    /**
     * 图片
     */
    private String img;


}
