package com.yutons.shiro.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Protein;
import com.yutons.shiro.bean.vo.ProteinVO;
import com.yutons.shiro.service.admin.CheckOrderService;
import com.yutons.shiro.service.admin.ProteinService;
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
@RequestMapping(value = "/admin/quota/protein")
public class ProteinController {
    @Autowired
    private ProteinService proteinService;
    @Autowired
    private CheckOrderService checkOrderService;


    /**
     * protein列表页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "admin/quota/protein/list";
    }

    /**
     * protein分页列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<ProteinVO> list(Protein protein) {
    	return proteinService.selecProteinsByPage(protein);
    }

    /**
     * 跳转到protein添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.PROTEIN);
        if (!CollectionUtils.isEmpty(checkOrders)) {
    		model.addAttribute("checkOrders", checkOrders);
    	}
        return "admin/quota/protein/add";
    }

    /**
     * 添加protein---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Protein protein, Model model) {
    	proteinService.addProtein(protein);
    	return "redirect:/admin/quota/protein/index?msg=success";

    }

    /**
     * 跳转到protein修改页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateIndex(Model model, @PathVariable("id")Integer id) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.PROTEIN);
        ProteinVO proteinVO = proteinService.selectProteinsById(id);
        model.addAttribute("proteinVO", proteinVO);
        if (!CollectionUtils.isEmpty(checkOrders)) {
            model.addAttribute("checkOrders", checkOrders);
        }
        return "admin/quota/protein/update";
    }

    /**
     * 修改protein---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Protein protein, Model model) {
        proteinService.updateProtein(protein);
        return "redirect:/admin/quota/protein/index?msg=success";

    }


    /**
     * 跳转到详情界面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,@PathVariable("id")Integer id) {
        ProteinVO proteinVO = proteinService.selectProteinsById(id);
        model.addAttribute("proteinVO", proteinVO);
        return "admin/quota/protein/detail";
    }

    
    /**
     * 删除protein
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/del",method = RequestMethod.POST)
    public String delProteinById(Protein protein){
        Integer i = proteinService.delProtein(protein);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }

}
