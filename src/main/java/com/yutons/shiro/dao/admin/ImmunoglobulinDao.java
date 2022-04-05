package com.yutons.shiro.dao.admin;

import com.yutons.shiro.bean.admin.quota.Immunoglobulin;
import com.yutons.shiro.bean.admin.quota.Tesr;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ImmunoglobulinDao {
    /**
     * 根据条件查询 immunoglobulin
     *
     */
    List<Immunoglobulin> selectImmunoglobulinByCondition(@Param("immunoglobulin") Immunoglobulin immunoglobulin);
    /**
     * 根据条件查询 immunoglobulin count
     *
     */
    int selectImmunoglobulinCountByCondition(@Param("immunoglobulin") Immunoglobulin immunoglobulin);
    /**
     * 根据id查询 immunoglobulin
     *
     */
    Immunoglobulin selectImmunoglobulinById(@Param("immunoglobulin") Immunoglobulin immunoglobulin);
    
    /**
     * 添加 immunoglobulin
     *
     * @param immunoglobulin
     * @return
     */
    int insert(@Param("immunoglobulin") Immunoglobulin immunoglobulin);
    /**
     * 修改 immunoglobulin
     *
     * @param immunoglobulin
     * @return
     */
    int update(@Param("immunoglobulin") Immunoglobulin immunoglobulin);
    
    /**
     * 删除 immunoglobulin
     *
     * @return
     */
    int deleteImmunoglobulinById(@Param("immunoglobulin") Immunoglobulin immunoglobulin);

    /**
     *
     * @return
     */
    int deleteImmunoglobulinByCheckId(@Param("checkId") Integer checkId);

}
