package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Routine;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.vo.RoutineVO;
import com.yutons.shiro.bean.vo.TesrVO;

public interface RoutineService {
    /**
     * routine列表（分页）
     *
     */
    ModulePage<RoutineVO> selecRoutinesByPage(Routine routine);
    /**
     * routine详情
     *
     */
    RoutineVO selectRoutinesById(int id);

    
    /**
     * 添加routine
     *
     * @return
     */
    Integer addRoutine(Routine routine);

    /**
     * 修改routine
     *
     * @return
     */
    Integer updateRoutine(Routine routine);
    
    /**
     * 删除routine
     *
     * @return
     */
    Integer delRoutine(Routine routine);

}
