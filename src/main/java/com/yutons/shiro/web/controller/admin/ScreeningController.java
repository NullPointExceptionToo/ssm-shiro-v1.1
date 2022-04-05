package com.yutons.shiro.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Screening;
import com.yutons.shiro.bean.vo.ScreeningVO;
import com.yutons.shiro.service.admin.CheckOrderService;
import com.yutons.shiro.service.admin.ScreeningService;
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
@RequestMapping(value = "/admin/quota/screening")
public class ScreeningController {
    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private CheckOrderService checkOrderService;


    /**
     * screening列表页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "admin/quota/screening/list";
    }

    /**
     * screening分页列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<ScreeningVO> list(Screening screening) {
    	return screeningService.selecScreeningsByPage(screening);
    }
    
    /**
     * 跳转到screening添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.SCREENING);
        if (!CollectionUtils.isEmpty(checkOrders)) {
    		model.addAttribute("checkOrders", checkOrders);
    	}
        return "admin/quota/screening/add";
    }

    /**
     * 添加screening---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Screening screening, Model model) {
    	screeningService.addScreening(screening);
        return "redirect:/admin/quota/screening/index?msg=success";

    }

    /**
     * 跳转到screening修改页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateIndex(Model model, @PathVariable("id")Integer id) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.SCREENING);
        ScreeningVO screeningVO = screeningService.selectScreeningsById(id);
        model.addAttribute("screeningVO", screeningVO);
        if (!CollectionUtils.isEmpty(checkOrders)) {
            model.addAttribute("checkOrders", checkOrders);
        }
        return "admin/quota/screening/update";
    }

    /**
     * 修改screening---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Screening screening, Model model) {
        screeningService.updateScreening(screening);
        return "redirect:/admin/quota/screening/index?msg=success";
    }


    /**
     * 跳转到详情界面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,@PathVariable("id")Integer id) {
        ScreeningVO screeningVO = screeningService.selectScreeningsById(id);
        model.addAttribute("screeningVO", screeningVO);
        return "admin/quota/screening/detail";
    }

    
    /**
     * 删除screening
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/del",method = RequestMethod.POST)
    public String delScreeningById(Screening screening){
        Integer i = screeningService.delScreening(screening);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }

}
