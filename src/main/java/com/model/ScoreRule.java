package com.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 积分规则
 *
 * @author Clrvn
 */
@Data
public class ScoreRule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增id
     */
    private Integer id;

    /**
     * 积分规则
     */
    private String ruleName;

    /**
     * 消耗积分
     */
    private Integer useScore;


}
