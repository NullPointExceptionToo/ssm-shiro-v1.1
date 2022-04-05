package com.yutons.shiro.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.User;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.vo.CheckOrderVO;
import com.yutons.shiro.bean.vo.TesrVO;
import com.yutons.shiro.service.admin.CheckOrderService;
import com.yutons.shiro.service.admin.TesrService;
import com.yutons.shiro.util.Constans;
import com.yutons.shiro.util.TokenUtil;
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
@RequestMapping(value = "/admin/quota/tesr")
public class TesrController {
    @Autowired
    private TesrService tesrService;
    @Autowired
    private CheckOrderService checkOrderService;


    /**
     * tesr列表页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "admin/quota/tesr/list";
    }

    /**
     * tesr分页列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<TesrVO> list(Tesr tesr) {
    	return tesrService.selecTesrsByPage(tesr);
    }
    
    /**
     * 跳转到tesr添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.TESR);
        if (!CollectionUtils.isEmpty(checkOrders)) {
    		model.addAttribute("checkOrders", checkOrders);
    	}
        return "admin/quota/tesr/add";
    }

    /**
     * 添加tesr---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Tesr tesr, Model model) {
        Integer integer = tesrService.addTesr(tesr);
        return "redirect:/admin/quota/tesr/index?msg=success";
    }

    /**
     * 跳转到tesr修改页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateIndex(Model model, @PathVariable("id")Integer id) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.TESR);
        TesrVO tesrVO = tesrService.selectTesrsById(id);
        model.addAttribute("tesrVO", tesrVO);
        if (!CollectionUtils.isEmpty(checkOrders)) {
            model.addAttribute("checkOrders", checkOrders);
        }
        return "admin/quota/tesr/update";
    }

    /**
     * 修改tesr---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Tesr tesr, Model model) {
        Integer integer = tesrService.updateTesr(tesr);
        return "redirect:/admin/quota/tesr/index?msg=success";
    }


    /**
     * 跳转到详情界面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,@PathVariable("id")Integer id) {
        TesrVO tesrVO = tesrService.selectTesrsById(id);
        model.addAttribute("tesrVO", tesrVO);
        return "admin/quota/tesr/detail";
    }

    
    /**
     * 删除tesr
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/del",method = RequestMethod.POST)
    public String delTesrById(Tesr tesr){
        Integer i = tesrService.delTesr(tesr);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }

}
