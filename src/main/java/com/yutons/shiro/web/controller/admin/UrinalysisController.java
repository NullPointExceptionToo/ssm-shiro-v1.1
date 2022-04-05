package com.yutons.shiro.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Urinalysis;
import com.yutons.shiro.bean.vo.UrinalysisVO;
import com.yutons.shiro.service.admin.CheckOrderService;
import com.yutons.shiro.service.admin.UrinalysisService;
import com.yutons.shiro.util.Constans;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/quota/urinalysis")
public class UrinalysisController {
    @Autowired
    private UrinalysisService urinalysisService;
    @Autowired
    private CheckOrderService checkOrderService;


    /**
     * urinalysis列表页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "admin/quota/urinalysis/list";
    }

    /**
     * urinalysis分页列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<UrinalysisVO> list(Urinalysis urinalysis) {
    	return urinalysisService.selecUrinalysisByPage(urinalysis);
    }
    
    /**
     * 跳转到urinalysis添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.URINALYSIS);
        if (!CollectionUtils.isEmpty(checkOrders)) {
    		model.addAttribute("checkOrders", checkOrders);
    	}
        return "admin/quota/urinalysis/add";
    }

    /**
     * 添加urinalysis---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Urinalysis urinalysis, Model model) {
    	urinalysisService.addUrinalysis(urinalysis);
        return "redirect:/admin/quota/urinalysis/index?msg=success";

    }

    /**
     * 跳转到urinalysis修改页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateIndex(Model model, @PathVariable("id")Integer id) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.URINALYSIS);
        UrinalysisVO urinalysisVO = urinalysisService.selectUrinalysisById(id);
        model.addAttribute("urinalysisVO", urinalysisVO);
        if (!CollectionUtils.isEmpty(checkOrders)) {
            model.addAttribute("checkOrders", checkOrders);
        }
        return "admin/quota/urinalysis/update";
    }

    /**
     * 修改urinalysis---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Urinalysis urinalysis, Model model) {
        urinalysisService.updateUrinalysis(urinalysis);
        return "redirect:/admin/quota/urinalysis/index?msg=success";
    }


    /**
     * 跳转到详情界面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,@PathVariable("id")Integer id) {
        UrinalysisVO urinalysisVO = urinalysisService.selectUrinalysisById(id);
        model.addAttribute("urinalysisVO", urinalysisVO);
        return "admin/quota/urinalysis/detail";
    }

    
    /**
     * 删除urinalysis
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/del",method = RequestMethod.POST)
    public String delrinalysisById(Urinalysis urinalysis){
        Integer i = urinalysisService.delUrinalysis(urinalysis);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }

}
