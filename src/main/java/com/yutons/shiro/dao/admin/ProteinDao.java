package com.yutons.shiro.dao.admin;

import com.yutons.shiro.bean.admin.quota.Protein;
import com.yutons.shiro.bean.admin.quota.Tesr;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProteinDao {
    /**
     * 根据条件查询 protein
     *
     */
    List<Protein> selectProteinByCondition(@Param("protein") Protein protein);
    /**
     * 根据条件查询 protein count
     *
     */
    int selectProteinCountByCondition(@Param("protein") Protein protein);
    /**
     * 根据id查询 protein
     *
     */
    Protein selectProteinById(@Param("protein") Protein protein);
    
    /**
     * 添加 protein
     *
     * @param protein
     * @return
     */
    int insert(@Param("protein") Protein protein);
    /**
     * 修改 protein
     *
     * @param protein
     * @return
     */
    int update(@Param("protein") Protein protein);
    
    /**
     * 删除 protein
     *
     * @return
     */
    int deleteProteinById(@Param("protein") Protein protein);

    /**
     *
     * @return
     */
    int deleteProteinByCheckId(@Param("checkId") Integer checkId);

}
