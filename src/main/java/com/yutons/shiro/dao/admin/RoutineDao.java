package com.yutons.shiro.dao.admin;

import com.yutons.shiro.bean.admin.quota.Routine;
import com.yutons.shiro.bean.admin.quota.Tesr;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RoutineDao {
    /**
     * 根据条件查询 routine
     *
     */
    List<Routine> selectRoutineByCondition(@Param("routine") Routine routine);
    /**
     * 根据条件查询 routine count
     *
     */
    int selectRoutineCountByCondition(@Param("routine") Routine routine);
    /**
     * 根据id查询 routine
     *
     */
    Routine selectRoutineById(@Param("routine") Routine routine);
    
    /**
     * 添加tesr
     *
     * @param routine
     * @return
     */
    int insert(@Param("routine") Routine routine);
    /**
     * 修改tesr
     *
     * @param routine
     * @return
     */
    int update(@Param("routine") Routine routine);
    
    /**
     * 删除 routine
     *
     * @return
     */
    int deleteRoutineById(@Param("routine") Routine routine);

    /**
     *
     * @return
     */
    int deleteRoutineByCheckId(@Param("checkId") Integer checkId);

}
