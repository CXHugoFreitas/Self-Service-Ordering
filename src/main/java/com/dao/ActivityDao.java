package com.dao;

import com.model.Activity;

import java.util.List;
import java.util.Map;


/**
 * 活动DAO
 *
 * @author Clrvn
 */
public interface ActivityDao {

    /**
     * 通过id查询单个活动
     */
    Activity findById(Integer id);

    /**
     * 通过map查询单个活动
     */
    Activity findByMap(Map<String, Object> map);

    /**
     * 查询活动列表
     */
    List<Activity> list(Map<String, Object> map);

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
