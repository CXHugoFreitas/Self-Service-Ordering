package com.dao;

import com.model.Desk;

import java.util.List;
import java.util.Map;


/**
 * 餐桌DAO
 *
 * @author Clrvn
 */
public interface DeskDao {

    /**
     * 通过id查询单个餐桌
     */
    Desk findById(Integer id);

    /**
     * 通过map查询单个餐桌
     */
    Desk findByMap(Map<String, Object> map);

    /**
     * 查询餐桌列表
     */
    List<Desk> list(Map<String, Object> map);

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
