package com.yutons.shiro.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Immunoglobulin;
import com.yutons.shiro.bean.vo.ImmunoglobulinVO;
import com.yutons.shiro.service.admin.CheckOrderService;
import com.yutons.shiro.service.admin.ImmunoglobulinService;
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
@RequestMapping(value = "/admin/quota/immunoglobulin")
public class ImmunoglobulinController {
    @Autowired
    private ImmunoglobulinService immunoglobulinService;
    @Autowired
    private CheckOrderService checkOrderService;


    /**
     * immunoglobulin列表页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "admin/quota/immunoglobulin/list";
    }

    /**
     * immunoglobulin分页列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<ImmunoglobulinVO> list(Immunoglobulin immunoglobulin) {
    	return immunoglobulinService.selecImmunoglobulinsByPage(immunoglobulin);
    }
    
    /**
     * 跳转到immunoglobulin添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.IMMUNOGLOBULIN);
        if (!CollectionUtils.isEmpty(checkOrders)) {
    		model.addAttribute("checkOrders", checkOrders);
    	}
        return "admin/quota/immunoglobulin/add";
    }

    /**
     * 添加immunoglobulin---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Immunoglobulin immunoglobulin, Model model) {
    	immunoglobulinService.addImmunoglobulin(immunoglobulin);
    	return "redirect:/admin/quota/immunoglobulin/index?msg=success";

    }

    /**
     * 跳转到immunoglobulin修改页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateIndex(Model model, @PathVariable("id")Integer id) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.IMMUNOGLOBULIN);
        ImmunoglobulinVO immunoglobulinVO = immunoglobulinService.selectImmunoglobulinsById(id);
        model.addAttribute("immunoglobulinVO", immunoglobulinVO);
        if (!CollectionUtils.isEmpty(checkOrders)) {
            model.addAttribute("checkOrders", checkOrders);
        }
        return "admin/quota/immunoglobulin/update";
    }

    /**
     * 修改immunoglobulin---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Immunoglobulin immunoglobulin, Model model) {
        immunoglobulinService.updateImmunoglobulin(immunoglobulin);
        return "redirect:/admin/quota/immunoglobulin/index?msg=success";

    }


    /**
     * 跳转到详情界面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,@PathVariable("id")Integer id) {
        ImmunoglobulinVO immunoglobulinVO = immunoglobulinService.selectImmunoglobulinsById(id);
        model.addAttribute("immunoglobulinVO", immunoglobulinVO);
        return "admin/quota/immunoglobulin/detail";
    }

    
    /**
     * 删除immunoglobulin
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/del",method = RequestMethod.POST)
    public String delImmunoglobulinById(Immunoglobulin immunoglobulin){
        Integer i = immunoglobulinService.delImmunoglobulin(immunoglobulin);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }

}
