package com.yutons.shiro.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.Product;
import com.yutons.shiro.service.admin.ProductService;
import com.yutons.shiro.util.ProductTypeUtil;

@Controller
@RequestMapping(value = "/admin/channel/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 跳转到商品列表
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(String msg,Model model) {
        return "admin/product/list";
    }

    /**
     * 获取商品分页列表
     *
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<Product> list(Product product) {
        return productService.selectProductsByPage();
    }
    /**
     * 获取商品不分页列表
     *
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/listNoPage", method = RequestMethod.GET)
    public List<Product> listNoPage(Product product) {
    	return productService.selectProducts();
    }

    /**
     * 跳转到商品添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
        return "admin/product/add";
    }

    /**
     * 添加商品---提交
     *
     * @param product
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Product product, Model model) {
    	List<Product> proList = productService.selectProductByName(product.getProductName());
    	if (proList != null && proList.size() != 0) {
    		model.addAttribute("msg", "商品名已存在!");
    		model.addAttribute("product", product);
            return "admin/product/add";
    	}else{
    		product.setProductTypeName(ProductTypeUtil.typeMap.get(product.getProductTypeID()));
    		productService.addProduct(product);
    		return "redirect:/admin/channel/product/index?msg=success";
    	}
    }

    /**
     * 跳转到商品修改页面
     *
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{pid}", method = RequestMethod.GET)
    public String updateInex(@PathVariable("pid") Integer pid, Model model) {
        List<Product> productArray = productService.selectProductById(pid);
        model.addAttribute("product", productArray.get(0));
        return "admin/product/update";
    }

    /**
     * 提交用户修改数据
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Product product,Model model) {
    	if (!checkProductName(product)) {
            model.addAttribute("product", product);
            model.addAttribute("msg", "修改失败，商品名已被占用");
            return "admin/product/update";
    	}
    	product.setProductTypeName(ProductTypeUtil.typeMap.get(product.getProductTypeID()));
    	productService.updateProduct(product);
        model.addAttribute("msg", "商品修改成功!");
        return "redirect:/admin/channel/product/index?msg=success";
    }

    /**
     * 删除选择商品
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/deleteProductById",method = RequestMethod.POST)
    public String deleteProductById(Product product){
    	Integer i= productService.deleteProductById(product);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }
    private Boolean checkProductName(Product product){
    	List<Product> proList = productService.selectProductByName(product.getProductName());
        if (proList == null && proList.size() != 0) {
        	return true;
        }
        List<Product> oldList = productService.selectProductById(product.getPid());
        if (oldList.get(0).getProductName().equals(proList.get(0).getProductName())) {
        	return true;
        }
        return false; 	
    }
}
