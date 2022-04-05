package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Protein;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.vo.ProteinVO;
import com.yutons.shiro.bean.vo.TesrVO;

public interface ProteinService {
    /**
     * protein 列表（分页）
     *
     */
    ModulePage<ProteinVO> selecProteinsByPage(Protein protein);
    /**
     * protein 详情
     *
     */
    ProteinVO selectProteinsById(int id);

    
    /**
     * 添加 protein
     *
     * @return
     */
    Integer addProtein(Protein protein);

    /**
     * 修改 protein
     *
     * @return
     */
    Integer updateProtein(Protein protein);
    
    /**
     * 删除 protein
     *
     * @return
     */
    Integer delProtein(Protein protein);

}
