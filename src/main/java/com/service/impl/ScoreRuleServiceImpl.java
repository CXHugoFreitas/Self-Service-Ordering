package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.ScoreRule;
import com.service.ScoreRuleService;
import com.dao.ScoreRuleDao;
import com.utils.RequestParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 积分规则ServiceImpl
 *
 * @author Clrvn
 */
@Service
public class ScoreRuleServiceImpl implements ScoreRuleService {

    @Autowired
    private ScoreRuleDao scoreRuleDao;

    /**
     * 查询积分规则页面
     *
     * @return 分页积分规则数据
     */
    @Override
    public PageInfo<ScoreRule> page(RequestParamsUtil requestParamsUtil) {
        PageHelper.startPage(requestParamsUtil.getPageNo(), requestParamsUtil.getPageSize());
        return new PageInfo<>(scoreRuleDao.list(requestParamsUtil.getParameters()));
    }

    /**
     * 查询积分规则列表
     */
    @Override
    public List<ScoreRule> list(Map<String, Object> map) {
        return scoreRuleDao.list(map);
    }


    /**
     * 通过id查询单个积分规则
     */
    @Override
    public ScoreRule findById(Integer id) {
        return scoreRuleDao.findById(id);
    }

    /**
     * 通过map查询单个积分规则
     */
    @Override
    public ScoreRule findByMap(Map<String, Object> map) {
        return scoreRuleDao.findByMap(map);
    }

    /**
     * 新增积分规则
     */
    @Override
    public int save(ScoreRule scoreRule) {
        return scoreRuleDao.save(scoreRule);
    }

    /**
     * 修改积分规则
     */
    @Override
    public int update(ScoreRule scoreRule) {
        return scoreRuleDao.update(scoreRule);
    }

    /**
     * 删除积分规则
     */
    @Override
    public int deleteById(Integer id) {
        return scoreRuleDao.deleteById(id);
    }

}
