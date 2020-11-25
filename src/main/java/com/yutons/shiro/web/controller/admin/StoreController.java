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
import com.yutons.shiro.bean.admin.Store;
import com.yutons.shiro.bean.admin.User;
import com.yutons.shiro.service.admin.StoreService;
import com.yutons.shiro.service.admin.UserService;
import com.yutons.shiro.util.Constans;
import com.yutons.shiro.util.StatusUtil;
import com.yutons.shiro.util.TokenUtil;

@Controller
@RequestMapping(value = "/admin/channel/store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private UserService userService;

    /**
     * 跳转到商店列表
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(String msg,Model model) {
    	User user = TokenUtil.getUser();
    	model.addAttribute("checkRole", user.getRoleId());
        return "admin/store/list";
    }

    /**
     * 获取商店分页列表
     *
     * @param store
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<Store> list(Store store) {
    	ModulePage<Store> storeArray = storeService.selectStoresByPage();
    	for (Store ho:storeArray.getData()) {
    		User user = userService.selectUserById(ho.getStoreUserId());
    		ho.setStoreUserName(user.getStaffname());
    	}
    	return storeArray;
    }
    
    /**
     * 跳转到商店添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
    	List<User> userArray = userService.findUserByRid(Constans.storeRole);
    	model.addAttribute("storeRoles", userArray);
        return "admin/store/add";
    }

    /**
     * 添加商店---提交
     *
     * @param store
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Store store, Model model) {
    	List<Store> proList = storeService.selectStoreByName(store.getStoreName());
    	if (proList != null && proList.size() != 0) {
    		model.addAttribute("msg", "商店名已存在!");
    		model.addAttribute("store", store);
    		List<User> userArray = userService.findUserByRid(Constans.storeRole);
        	model.addAttribute("storeRoles", userArray);
            return "admin/store/add";
    	}else{
    		store.setStatusDsc(StatusUtil.statusMap.get(store.getStatus()));
    		storeService.addStore(store);
    		return "redirect:/admin/channel/store/index?msg=success";
    	}
    }

    /**
     * 跳转到商店修改页面
     *
     * @param hId
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{sid}", method = RequestMethod.GET)
    public String updateInex(@PathVariable("sid") Integer sid, Model model) {
        List<Store> storeArray = storeService.selectStoreById(sid);
        Store store = storeArray.get(0);
        User user = userService.selectUserById(store.getStoreUserId());
		store.setStoreUserName(user.getStaffname());
        model.addAttribute("store", store);
        List<User> userArray = userService.findUserByRid(Constans.storeRole);
    	model.addAttribute("storeRoles", userArray);
        return "admin/store/update";
    }

    /**
     * 提交用户修改数据
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Store store,Model model) {
    	if (!checkStoreName(store)) {
            model.addAttribute("store", store);
            model.addAttribute("msg", "修改失败，商店名已被占用");
            List<User> userArray = userService.findUserByRid(Constans.storeRole);
        	model.addAttribute("storeRoles", userArray);
            return "admin/store/update";
    	}
    	User user = userService.selectUserById(store.getStoreUserId());
		store.setStoreUserName(user.getStaffname());
    	store.setStatusDsc(StatusUtil.statusMap.get(store.getStatus()));
    	storeService.updateStore(store);
        model.addAttribute("msg", "商店修改成功!");
        return "redirect:/admin/channel/store/index?msg=success";
    }
    
    /**
     * 修改商店当前状态
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateState",method = RequestMethod.POST)
    public String updateState(Store store) {
    	store.setStatusDsc(StatusUtil.statusMap.get(store.getStatus()));
        Integer i=storeService.updateStatusById(store);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }

    /**
     * 删除选择商店
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/deleteStoreById",method = RequestMethod.POST)
    public String deleteStoreById(Store store){
    	Integer i= storeService.deleteStoreById(store);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }
    private Boolean checkStoreName(Store store){
    	List<Store> proList = storeService.selectStoreByName(store.getStoreName());
        if (proList == null || proList.size() == 0) {
        	return true;
        }
        List<Store> oldList = storeService.selectStoreById(store.getSid());
        if (oldList.get(0).getStoreName().equals(proList.get(0).getStoreName())) {
        	return true;
        }
        return false; 	
    }
}
