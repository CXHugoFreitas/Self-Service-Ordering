package com.service.impl;

import com.dao.ActivityDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.Activity;
import com.service.ActivityService;
import com.utils.RequestParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 活动ServiceImpl
 *
 * @author Clrvn
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    /**
     * 查询活动页面
     *
     * @return 分页活动数据
     */
    @Override
    public PageInfo<Activity> page(RequestParamsUtil requestParamsUtil) {
        PageHelper.startPage(requestParamsUtil.getPageNo(), requestParamsUtil.getPageSize());
        return new PageInfo<>(activityDao.list(requestParamsUtil.getParameters()));
    }

    /**
     * 查询活动列表
     */
    @Override
    public List<Activity> list(Map<String, Object> map) {
        return activityDao.list(map);
    }


    /**
     * 通过id查询单个活动
     */
    @Override
    public Activity findById(Integer id) {
        return activityDao.findById(id);
    }

    /**
     * 通过map查询单个活动
     */
    @Override
    public Activity findByMap(Map<String, Object> map) {
        return activityDao.findByMap(map);
    }

    /**
     * 新增活动
     */
    @Override
    public int save(Activity activity) {
        return activityDao.save(activity);
    }

    /**
     * 修改活动
     */
    @Override
    public int update(Activity activity) {
        return activityDao.update(activity);
    }

    /**
     * 删除活动
     */
    @Override
    public int deleteById(Integer id) {
        return activityDao.deleteById(id);
    }

}
