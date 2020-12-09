package com.yutons.shiro.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yutons.shiro.bean.admin.Home;


public interface HomeDao {
    /**
     * 根据hid获得基地
     *
     */
    Home findByHomeId(@Param("homeId") Integer homeId);

    /**
     * 根据条件查询基地列表
     *
     */
    List<Home> selectHomeByCondition(@Param("home") Home home);
    /**
     * 根据条件查询基地列表(不分页)
     *
     */
    List<Home> selectHomeByConditionNoPage(@Param("home") Home home);
    /**
     * 根据条件查询基地count
     *
     */
    int selectHomeCountByCondition(@Param("home") Home home);
    /**
     * 添加基地
     *
     * @param Home
     * @return
     */
    int insert(@Param("home") Home home);
    /**
     * 提交用户修改数据
     *
     * @param user
     * @return
     */
    int update(@Param("home") Home home);
    /**
     * 修改基地当前状态
     *
     * @param status
     * @return
     */
    int updateStatusById(@Param("home") Home home);

    /**
     * 删除基地
     *
     * @param home
     * @return
     */
    Integer deleteHomeById(@Param("home") Home home);

}
