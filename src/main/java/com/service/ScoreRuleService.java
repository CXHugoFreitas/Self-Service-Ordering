package com.service;

import com.model.ScoreRule;
import com.github.pagehelper.PageInfo;
import com.utils.RequestParamsUtil;

import java.util.List;
import java.util.Map;

/**
 * 积分规则Service
 *
 * @author Clrvn
 */
public interface ScoreRuleService {

    /**
     * 查询积分规则页面
     *
     * @return 分页积分规则数据
     */
    PageInfo<ScoreRule> page(RequestParamsUtil requestParamsUtil);

    /**
     * 查询积分规则列表
     */
    List<ScoreRule> list(Map<String, Object> map);

    /**
     * 通过id查询单个积分规则
     */
    ScoreRule findById(Integer id);

    /**
     * 通过map查询单个积分规则
     */
    ScoreRule findByMap(Map<String, Object> map);

    /**
     * 新增积分规则
     */
    int save(ScoreRule scoreRule);

    /**
     * 修改积分规则
     */
    int update(ScoreRule scoreRule);

    /**
     * 删除积分规则
     */
    int deleteById(Integer id);

}
