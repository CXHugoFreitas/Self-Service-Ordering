package com.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 活动
 *
 * @author Clrvn
 */
@Data
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增id
     */
    private Integer id;

    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动内容
     */
    private String content;


}
