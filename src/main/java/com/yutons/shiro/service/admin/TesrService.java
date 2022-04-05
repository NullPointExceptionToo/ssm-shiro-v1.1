package com.yutons.shiro.service.admin;

import java.util.List;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.vo.TesrVO;

public interface TesrService {
    /**
     * esr列表（分页）
     *
     */
    ModulePage<TesrVO> selecTesrsByPage(Tesr tesr);
    /**
     * esr详情
     *
     */
    TesrVO selectTesrsById(int id);

    
    /**
     * 添加esr
     *
     * @return
     */
    Integer addTesr(Tesr esr);

    /**
     * 修改esr
     *
     * @return
     */
    Integer updateTesr(Tesr esr);
    
    /**
     * 删除esr
     *
     * @return
     */
    Integer delTesr(Tesr esr);

}
