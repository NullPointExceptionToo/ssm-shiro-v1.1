package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.admin.quota.Urinalysis;
import com.yutons.shiro.bean.vo.TesrVO;
import com.yutons.shiro.bean.vo.UrinalysisVO;

public interface UrinalysisService {
    /**
     * urinalysis列表（分页）
     *
     */
    ModulePage<UrinalysisVO> selecUrinalysisByPage(Urinalysis urinalysis);
    /**
     * urinalysis详情
     *
     */
    UrinalysisVO selectUrinalysisById(int id);

    
    /**
     * 添加urinalysis
     *
     * @return
     */
    Integer addUrinalysis(Urinalysis urinalysis);

    /**
     * 修改urinalysis
     *
     * @return
     */
    Integer updateUrinalysis(Urinalysis urinalysis);
    
    /**
     * 删除urinalysis
     *
     * @return
     */
    Integer delUrinalysis(Urinalysis urinalysis);

}
