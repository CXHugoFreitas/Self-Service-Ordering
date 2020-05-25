package com.service;

import com.github.pagehelper.PageInfo;
import com.model.Activity;
import com.utils.RequestParamsUtil;

import java.util.List;
import java.util.Map;

/**
 * 活动Service
 *
 * @author Clrvn
 */
public interface ActivityService {

    /**
     * 查询活动页面
     *
     * @return 分页活动数据
     */
    PageInfo<Activity> page(RequestParamsUtil requestParamsUtil);

    /**
     * 查询活动列表
     */
    List<Activity> list(Map<String, Object> map);

    /**
     * 通过id查询单个活动
     */
    Activity findById(Integer id);

    /**
     * 通过map查询单个活动
     */
    Activity findByMap(Map<String, Object> map);

    /**
     * 新增活动
     */
    int save(Activity activity);

    /**
     * 修改活动
     */
    int update(Activity activity);

    /**
     * 删除活动
     */
    int deleteById(Integer id);

}
