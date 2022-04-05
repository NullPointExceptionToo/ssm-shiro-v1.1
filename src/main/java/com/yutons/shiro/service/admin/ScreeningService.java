package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Screening;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.vo.ScreeningVO;
import com.yutons.shiro.bean.vo.TesrVO;

public interface ScreeningService {
    /**
     * screening 列表（分页）
     *
     */
    ModulePage<ScreeningVO> selecScreeningsByPage(Screening screening);
    /**
     * screening 详情
     *
     */
    ScreeningVO selectScreeningsById(int id);

    
    /**
     * 添加 screening
     *
     * @return
     */
    Integer addScreening(Screening screening);

    /**
     * 修改 screening
     *
     * @return
     */
    Integer updateScreening(Screening screening);
    
    /**
     * 删除 screening
     *
     * @return
     */
    Integer delScreening(Screening screening);

}
