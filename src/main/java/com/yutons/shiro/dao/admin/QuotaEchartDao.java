package com.yutons.shiro.dao.admin;

import com.yutons.shiro.bean.admin.QuotaEchart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuotaEchartDao {
    List<QuotaEchart> getLeastQuota(@Param("table") String table, @Param("column") String column,
                                    @Param("timer") Integer limit);
}
