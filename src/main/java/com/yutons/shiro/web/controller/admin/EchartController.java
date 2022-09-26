package com.yutons.shiro.web.controller.admin;

import com.yutons.shiro.bean.vo.req.QuotaEchartLoadRequest;
import com.yutons.shiro.bean.vo.resp.QuotaEchartLoadResponse;
import com.yutons.shiro.service.admin.EchartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @title: EchartController
 * @Author fq
 * @Date: 2022/4/6 18:02
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/admin/echart")
public class EchartController {
    @Autowired
    private EchartService echartService;

    @RequestMapping(value = "/quota/index", method = RequestMethod.GET)
    public String index() {
        return "admin/echart/quota";
    }

    @RequestMapping(value = "/quota/loadData", method = RequestMethod.POST)
    @ResponseBody
    public QuotaEchartLoadResponse loadData(@RequestBody QuotaEchartLoadRequest request) {
        return echartService.selectQuotaEchartData(request);
    }
}
