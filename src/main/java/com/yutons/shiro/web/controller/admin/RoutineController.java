package com.yutons.shiro.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Routine;
import com.yutons.shiro.bean.vo.RoutineVO;
import com.yutons.shiro.service.admin.CheckOrderService;
import com.yutons.shiro.service.admin.RoutineService;
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
@RequestMapping(value = "/admin/quota/routine")
public class RoutineController {
    @Autowired
    private RoutineService routineService;
    @Autowired
    private CheckOrderService checkOrderService;


    /**
     * routine列表页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "admin/quota/routine/list";
    }

    /**
     * routine分页列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<RoutineVO> list(Routine routine) {
    	return routineService.selecRoutinesByPage(routine);
    }
    
    /**
     * 跳转到routine添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.ROUTINE);
        if (!CollectionUtils.isEmpty(checkOrders)) {
    		model.addAttribute("checkOrders", checkOrders);
    	}
        return "admin/quota/routine/add";
    }

    /**
     * 添加routine---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Routine routine, Model model) {
    	routineService.addRoutine(routine);
        return "redirect:/admin/quota/routine/index?msg=success";

    }

    /**
     * 跳转到routine修改页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateIndex(Model model, @PathVariable("id")Integer id) {
        List<CheckOrder> checkOrders = checkOrderService.selectUnBindCheckOrder(Constans.TableName.ROUTINE);
        RoutineVO routineVO = routineService.selectRoutinesById(id);
        model.addAttribute("routineVO", routineVO);
        if (!CollectionUtils.isEmpty(checkOrders)) {
            model.addAttribute("checkOrders", checkOrders);
        }
        return "admin/quota/routine/update";
    }

    /**
     * 修改routine---提交
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Routine routine, Model model) {
        routineService.updateRoutine(routine);
        return "redirect:/admin/quota/routine/index?msg=success";

    }


    /**
     * 跳转到详情界面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,@PathVariable("id")Integer id) {
        RoutineVO routineVO = routineService.selectRoutinesById(id);
        model.addAttribute("routineVO", routineVO);
        return "admin/quota/routine/detail";
    }

    
    /**
     * 删除routine
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/del",method = RequestMethod.POST)
    public String delRoutineById(Routine routine){
        Integer i = routineService.delRoutine(routine);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }

}
