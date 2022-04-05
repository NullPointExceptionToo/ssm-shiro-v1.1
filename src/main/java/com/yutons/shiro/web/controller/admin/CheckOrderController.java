package com.yutons.shiro.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.vo.CheckOrderVO;
import com.yutons.shiro.bean.vo.TesrVO;
import com.yutons.shiro.service.admin.CheckOrderService;
import com.yutons.shiro.service.admin.TesrService;
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
@RequestMapping(value = "/admin/checkOrder")
public class CheckOrderController {

    @Autowired
    private CheckOrderService checkOrderService;


    /**
     * checkOrder列表页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "admin/checkOrder/list";
    }

    /**
     * checkOrder分页列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<CheckOrder> list(CheckOrder checkOrder) {
    	return checkOrderService.selecCheckOrdersByPage(checkOrder);
    }
    
    /**
     * 跳转到checkOrder添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
        return "admin/checkOrder/add";
    }

    /**
     * 添加checkOrder---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(CheckOrder checkOrder, Model model) {
    	checkOrderService.addCheckOrder(checkOrder);
        return "redirect:/admin/checkOrder/index?msg=success";
    }

    /**
     * 跳转到checkOrder修改页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateIndex(Model model, @PathVariable("id")Integer id) {
        CheckOrderVO checkOrderVO = checkOrderService.selectCheckOrdersById(id);
        model.addAttribute("checkOrderVO", checkOrderVO);
        return "admin/checkOrder/update";
    }

    /**
     * 修改checkOrder---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(CheckOrder checkOrder, Model model) {
        checkOrderService.updateCheckOrder(checkOrder);
        return "redirect:/admin/checkOrder/index?msg=success";

    }


    /**
     * 跳转到详情界面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,@PathVariable("id")Integer id) {
        CheckOrderVO checkOrderVO = checkOrderService.selectCheckOrdersById(id);
        model.addAttribute("checkOrderVO", checkOrderVO);
        return "admin/checkOrder/detail";
    }

    
    /**
     * 删除checkOrder
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/del",method = RequestMethod.POST)
    public String delcheckOrderById(CheckOrder checkOrder){
        Integer i = checkOrderService.delCheckOrder(checkOrder);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }

}
