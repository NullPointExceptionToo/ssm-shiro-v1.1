package com.yutons.shiro.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.CosOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.OrdItem;
import com.yutons.shiro.bean.admin.ProOrder;
import com.yutons.shiro.bean.admin.ProductCount;
import com.yutons.shiro.bean.admin.User;
import com.yutons.shiro.service.admin.CosOrderService;
import com.yutons.shiro.service.admin.ProOrderService;
import com.yutons.shiro.util.Constans;
import com.yutons.shiro.util.TokenUtil;

@Controller
@RequestMapping(value = "/admin/order/cosOrder")
public class CosOrderController {
    @Autowired
    private CosOrderService cosOrderService;
    @Autowired
    private ProOrderService proOrderService;


    /**
     * 跳转到订货订单列表页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(String msg,Model model) {
    	User user = TokenUtil.getUser();
    	model.addAttribute("checkRole", user.getRoleId());
        return "admin/cosOrder/list";
    }

    /**
     * 获取订单分页列表
     *
     * @param store
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<CosOrder> list(CosOrder cosOrder) {
    	return cosOrderService.selectCosOrdersByPage(cosOrder);
    }
    
    /**
     * 跳转到订单添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
    	List<ProductCount> list = proOrderService.selectGroupCountNoPage(new ProOrder());
    	if (list != null && list.size() != 0) {
    		model.addAttribute("productRes", list);
    	}
        return "admin/cosOrder/add";
    }
    
    /**
     * 跳转到详情界面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{cid}", method = RequestMethod.GET)
    public String detail(Model model,@PathVariable("cid")Integer cid) {
    	List<OrdItem> ordArray = cosOrderService.selectCosOrdersById(cid);
    	model.addAttribute("ordArray", ordArray);
        return "admin/cosOrder/detail";
    }

    /**
     * 添加订单---提交
     *
     * @param store
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Integer add(String cosOrder, Model model) {
    	return cosOrderService.addCosOrder(JSON.parseObject(cosOrder, CosOrder.class));
    }

    /**
     * 撤销订单
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/cancelCosOrderById",method = RequestMethod.POST)
    public String cancelCosOrderById(CosOrder cosOrder){
    	Integer i= cosOrderService.cancelById(cosOrder);
        if (i==1) {
            return "success";
        }else if(i==999){
        	return "撤销失败，订单已配送";
        }else {
            return "error";
        }
    }
    
    /**
     * 删除订单
     * @param cosOrder
     * @return
     */
    @ResponseBody
    @RequestMapping(value="delCosOrderById",method = RequestMethod.POST)
    public String delCosOrderById(CosOrder cosOrder){
    	Integer i= cosOrderService.delCosOrder(cosOrder);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }
    
    /**
     * 订单派送
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/deliveryCosOrderById",method = RequestMethod.POST)
    public String deliveryCosOrderById(CosOrder cosOrder){
    	Integer i= cosOrderService.deliveryOrder(cosOrder);
        if (i==1) {
            return "success";
        }else if(i == Constans.HOME_LESS){
        	return "mark";//库存不足
        }else {
            return "error";
        }
    }
}
