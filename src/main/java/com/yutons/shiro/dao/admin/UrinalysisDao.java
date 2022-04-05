package com.yutons.shiro.dao.admin;

import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.admin.quota.Urinalysis;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UrinalysisDao {
    /**
     * 根据条件查询urinalysis
     *
     */
    List<Urinalysis> selectUrinalysisByCondition(@Param("urinalysis") Urinalysis urinalysis);
    /**
     * 根据条件查询urinalysis count
     *
     */
    int selectUrinalysisCountByCondition(@Param("urinalysis") Urinalysis urinalysis);
    /**
     * 根据id查询urinalysis
     *
     */
    Urinalysis selectUrinalysisById(@Param("urinalysis") Urinalysis urinalysis);
    
    /**
     * 添加urinalysis
     *
     * @param urinalysis
     * @return
     */
    int insert(@Param("urinalysis") Urinalysis urinalysis);
    /**
     * 修改urinalysis
     *
     * @param urinalysis
     * @return
     */
    int update(@Param("urinalysis") Urinalysis urinalysis);
    
    /**
     * 删除urinalysis
     *
     * @return
     */
    int deleteUrinalysisById(@Param("urinalysis") Urinalysis urinalysis);
    /**
     *
     * @return
     */
    int deleteUrinalysisByCheckId(@Param("checkId") Integer checkId);

}
