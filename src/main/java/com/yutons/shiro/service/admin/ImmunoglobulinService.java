package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Immunoglobulin;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.vo.ImmunoglobulinVO;
import com.yutons.shiro.bean.vo.TesrVO;

public interface ImmunoglobulinService {
    /**
     * immunoglobulin 列表（分页）
     *
     */
    ModulePage<ImmunoglobulinVO> selecImmunoglobulinsByPage(Immunoglobulin immunoglobulin);
    /**
     * immunoglobulin 详情
     *
     */
    ImmunoglobulinVO selectImmunoglobulinsById(int id);

    
    /**
     * 添加 immunoglobulin
     *
     * @return
     */
    Integer addImmunoglobulin(Immunoglobulin immunoglobulin);

    /**
     * 修改 immunoglobulin
     *
     * @return
     */
    Integer updateImmunoglobulin(Immunoglobulin immunoglobulin);
    
    /**
     * 删除 immunoglobulin
     *
     * @return
     */
    Integer delImmunoglobulin(Immunoglobulin immunoglobulin);

}
