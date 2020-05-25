package com.service.impl;

import com.dao.DeskDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.Desk;
import com.service.DeskService;
import com.utils.RequestParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 餐桌ServiceImpl
 *
 * @author Clrvn
 */
@Service
public class DeskServiceImpl implements DeskService {

    @Autowired
    private DeskDao deskDao;

    /**
     * 查询餐桌页面
     *
     * @return 分页餐桌数据
     */
    @Override
    public PageInfo<Desk> page(RequestParamsUtil requestParamsUtil) {
        PageHelper.startPage(requestParamsUtil.getPageNo(), requestParamsUtil.getPageSize());
        return new PageInfo<>(deskDao.list(requestParamsUtil.getParameters()));
    }

    /**
     * 查询餐桌列表
     */
    @Override
    public List<Desk> list(Map<String, Object> map) {
        return deskDao.list(map);
    }


    /**
     * 通过id查询单个餐桌
     */
    @Override
    public Desk findById(Integer id) {
        return deskDao.findById(id);
    }

    /**
     * 通过map查询单个餐桌
     */
    @Override
    public Desk findByMap(Map<String, Object> map) {
        return deskDao.findByMap(map);
    }

    /**
     * 新增餐桌
     */
    @Override
    public int save(Desk desk) {
        return deskDao.save(desk);
    }

    /**
     * 修改餐桌
     */
    @Override
    public int update(Desk desk) {
        return deskDao.update(desk);
    }

    /**
     * 删除餐桌
     */
    @Override
    public int deleteById(Integer id) {
        return deskDao.deleteById(id);
    }

}
