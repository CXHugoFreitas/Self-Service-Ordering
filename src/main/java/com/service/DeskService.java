package com.service;

import com.model.Desk;
import com.github.pagehelper.PageInfo;
import com.utils.RequestParamsUtil;

import java.util.List;
import java.util.Map;

/**
 * 餐桌Service
 *
 * @author Clrvn
 */
public interface DeskService {

    /**
     * 查询餐桌页面
     *
     * @return 分页餐桌数据
     */
    PageInfo<Desk> page(RequestParamsUtil requestParamsUtil);

    /**
     * 查询餐桌列表
     */
    List<Desk> list(Map<String, Object> map);

    /**
     * 通过id查询单个餐桌
     */
    Desk findById(Integer id);

    /**
     * 通过map查询单个餐桌
     */
    Desk findByMap(Map<String, Object> map);

    /**
     * 新增餐桌
     */
    int save(Desk desk);

    /**
     * 修改餐桌
     */
    int update(Desk desk);

    /**
     * 删除餐桌
     */
    int deleteById(Integer id);

}
