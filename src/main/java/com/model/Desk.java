package com.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 餐桌
 *
 * @author Clrvn
 */
@Data
public class Desk implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增id
     */
    private Integer id;

    /**
     * 编号
     */
    private String deskNo;

    /**
     * 状态，0、未占用 1、已占用
     */
    private Integer status;


}
