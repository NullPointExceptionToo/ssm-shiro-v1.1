package com.yutons.shiro.dao.admin;

import com.yutons.shiro.bean.admin.quota.Screening;
import com.yutons.shiro.bean.admin.quota.Urinalysis;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ScreeningDao {
    /**
     * 根据条件查询screening
     *
     */
    List<Screening> selectScreeningByCondition(@Param("screening") Screening screening);
    /**
     * 根据条件查询screening count
     *
     */
    int selectScreeningCountByCondition(@Param("screening") Screening urinalysis);
    /**
     * 根据id查询screening
     *
     */
    Screening selectScreeningById(@Param("screening") Screening urinalysis);
    
    /**
     * 添加screening
     *
     * @param urinalysis
     * @return
     */
    int insert(@Param("screening") Screening urinalysis);
    /**
     * 修改screening
     *
     * @param urinalysis
     * @return
     */
    int update(@Param("screening") Screening urinalysis);
    
    /**
     * 删除screening
     *
     * @return
     */
    int deleteScreeningById(@Param("screening") Screening urinalysis);
    /**
     *
     * @return
     */
    int deleteScreeningByCheckId(@Param("checkId") Integer checkId);

}
