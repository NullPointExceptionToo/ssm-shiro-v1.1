package com.yutons.shiro.dao.admin;

import java.util.List;

import com.yutons.shiro.bean.admin.quota.Tesr;
import org.apache.ibatis.annotations.Param;


public interface TesrDao {
    /**
     * 根据条件查询tesr
     *
     */
    List<Tesr> selectTesrByCondition(@Param("tesr") Tesr Tesr);
    /**
     * 根据条件查询tesr count
     *
     */
    int selectTesrCountByCondition(@Param("tesr") Tesr tesr);
    /**
     * 根据id查询tesr
     *
     */
    Tesr selectTesrById(@Param("tesr") Tesr tesr);
    
    /**
     * 添加tesr
     *
     * @param tesr
     * @return
     */
    int insert(@Param("tesr") Tesr tesr);
    /**
     * 修改tesr
     *
     * @param tesr
     * @return
     */
    int update(@Param("tesr") Tesr tesr);
    
    /**
     * 删除tesr
     *
     * @return
     */
    int deleteTesrById(@Param("tesr") Tesr tesr);

    /**
     *
     * @return
     */
    int deleteTesrByCheckId(@Param("checkId") Integer checkId);

}
