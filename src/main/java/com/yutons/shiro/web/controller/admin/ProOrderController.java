package com.yutons.shiro.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.ProOrder;
import com.yutons.shiro.bean.admin.Product;
import com.yutons.shiro.bean.admin.ProductCount;
import com.yutons.shiro.bean.admin.User;
import com.yutons.shiro.service.admin.ProOrderService;
import com.yutons.shiro.service.admin.ProductService;
import com.yutons.shiro.util.Constans;
import com.yutons.shiro.util.TokenUtil;

@Controller
@RequestMapping(value = "/admin/order/proOrder")
public class ProOrderController {
    @Autowired
    private ProOrderService proOrderService;
    @Autowired
    private ProductService productService;


    /**
     * 跳转到供货订单列表
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(String msg,Model model) {
    	User user = TokenUtil.getUser();
    	model.addAttribute("checkRole", user.getRoleId());
        return "admin/proOrder/list";
    }

    /**
     * 获取订单分页列表
     *
     * @param store
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<ProOrder> list(ProOrder proOrder) {
    	return proOrderService.selectProOrdersByPage(proOrder);
    }
    
    /**
     * 跳转到商品统计列表
     *
     * @return
     */
    @RequestMapping(value = "/countIndex", method = RequestMethod.GET)
    public String countIndex(String msg,Model model) {
        return "admin/proOrder/countList";
    }

    /**
     * 获取商品统计分页列表
     *
     * @param store
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/countList", method = RequestMethod.GET)
    public ModulePage<ProductCount> countlist(ProOrder proOrder) {
    	return proOrderService.selectGroupCount(proOrder);
    }
    
    /**
     * 跳转到订单添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
    	List<Product> productArray = productService.selectProducts();
    	model.addAttribute("products", productArray);
        return "admin/proOrder/add";
    }

    /**
     * 添加订单---提交
     *
     * @param store
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ProOrder proOrder, Model model) {
    	int result = proOrderService.addProOrder(proOrder);
    	if (result == Constans.NONE_HOME) {
    		model.addAttribute("msg", "未持有基地,请联系公司绑定基地!");
    		model.addAttribute("proOrder", proOrder);
    		List<Product> productArray = productService.selectProducts();
        	model.addAttribute("products", productArray);
            return "admin/proOrder/add";
    	}
		return "redirect:/admin/order/proOrder/index?msg=success";
    }

    /**
     * 删除选择订单
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/deleteProOrderById",method = RequestMethod.POST)
    public String deleteProOrderById(ProOrder proOrder){
    	Integer i= proOrderService.deleteProOrderById(proOrder);
        if (i==1) {
            return "success";
        }else if(i == Constans.HOME_LESS){
        	return "mark";//失败，产品库存剩余数量不足以抵消该订单已售数量"
        }else {
            return "error";
        }
    }
}
