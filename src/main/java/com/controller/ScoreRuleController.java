package com.controller;

import com.github.pagehelper.PageInfo;
import com.model.ScoreRule;
import com.service.ScoreRuleService;
import com.utils.RequestParamsUtil;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 积分规则Controller
 *
 * @author Clrvn
 */
@RestController
@RequestMapping("/scoreRule")
public class ScoreRuleController {

    @Autowired
    private ScoreRuleService scoreRuleService;

    /**
     * 查询积分规则页面
     *
     * @return 分页积分规则数据
     */
    @GetMapping("/page")
    public PageInfo<ScoreRule> page() {
        return scoreRuleService.page(new RequestParamsUtil());
    }

    /**
     * 查询积分规则列表
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<ScoreRule> scoreRuleList = scoreRuleService.list(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(scoreRuleList);
    }

    /**
     * 通过id查询单个积分规则
     */
    @GetMapping("/findById")
    public ResultVO findById(@RequestParam(value = "id") Integer id) {
        ScoreRule scoreRule = scoreRuleService.findById(id);
        return ResultVOUtil.success(scoreRule);
    }

    /**
     * 通过map查询单个积分规则
     */
    @GetMapping("/findByMap")
    public ResultVO findByMap() {
        ScoreRule scoreRule = scoreRuleService.findByMap(new RequestParamsUtil().getParameters());
        return ResultVOUtil.success(scoreRule);
    }

    /**
     * 添加积分规则
     */
    @PostMapping("/save")
    public ResultVO save(@RequestBody ScoreRule scoreRule) {
        try {
            scoreRuleService.save(scoreRule);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("添加失败！");
        }
    }

    /**
     * 修改积分规则
     */
    @PutMapping("/update")
    public ResultVO update(@RequestBody ScoreRule scoreRule) {
        try {
            scoreRuleService.update(scoreRule);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("修改失败！");
        }

    }

    /**
     * 删除积分规则
     */
    @DeleteMapping("/deleteById")
    public ResultVO deleteById(@RequestParam(value = "id") Integer id) {
        try {
            scoreRuleService.deleteById(id);
            return ResultVOUtil.success();
        } catch (Exception ex) {
            return ResultVOUtil.failure("删除失败！");
        }
    }

}