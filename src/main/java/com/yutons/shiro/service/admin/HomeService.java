package com.yutons.shiro.service.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.Home;

public interface HomeService {
	 /**
     * 根据hid获得基地
     *
     */
    Home findByHomeId(Integer homeId);
    /**
     * 根据基地ID查询基地
     *
     */
    List<Home> selectHomeById(Integer homeId);
    /**
     * 根据基地名字查询基地
     *
     */
    List<Home> selectHomeByName(String homeName);
    /**
     * 根据基地列表（分页）
     *
     */
    ModulePage<Home> selectHomesByPage(Home home);
    /**
     * 添加基地
     *
     * @param home
     * @return
     */
    Integer addHome(Home home);
    /**
     * 提交用户修改数据
     *
     * @param user
     * @return
     */
    Integer updateHome(Home home);
    /**
     * 修改基地当前状态
     *
     * @param status
     * @return
     */
    int updateStatusById(Home home);

    /**
     * 删除基地
     *
     * @param home
     * @return
     */
    Integer deleteHomeById(Home home);
    /**
     * 根据基地负责人和排除基地id查询基地
     *
     */
    List<Home> selectHomeByUserIdAndExcludeId(Home home);
}
