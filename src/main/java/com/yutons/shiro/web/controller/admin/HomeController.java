package com.yutons.shiro.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yutons.shiro.bean.admin.Home;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.User;
import com.yutons.shiro.service.admin.HomeService;
import com.yutons.shiro.service.admin.UserService;
import com.yutons.shiro.util.Constans;
import com.yutons.shiro.util.StatusUtil;
import com.yutons.shiro.util.TokenUtil;

@Controller
@RequestMapping(value = "/admin/channel/home")
public class HomeController {
    @Autowired
    private HomeService homeService;
    @Autowired
    private UserService userService;

    /**
     * 跳转到基地列表
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(String msg,Model model) {
    	User user = TokenUtil.getUser();
    	model.addAttribute("checkRole", user.getRoleId());
        return "admin/home/list";
    }

    /**
     * 获取基地分页列表
     *
     * @param home
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModulePage<Home> list(Home home) {
    	ModulePage<Home> homeArray = homeService.selectHomesByPage();
    	for (Home ho:homeArray.getData()) {
    		User user = userService.selectUserById(ho.getHomeUserId());
    		ho.setHomeUserName(user.getStaffname());
    	}
    	return homeArray;
    }
    
    /**
     * 跳转到基地添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
    	List<User> userArray = userService.findUserByRid(Constans.homeRole);
    	model.addAttribute("homeRoles", userArray);
        return "admin/home/add";
    }

    /**
     * 添加基地---提交
     *
     * @param home
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Home home, Model model) {
    	if (!checkHomeName(home,"add")) {
    		List<User> userArray = userService.findUserByRid(Constans.homeRole);
    		model.addAttribute("msg", "基地名已存在!");
    		model.addAttribute("home", home);
        	model.addAttribute("homeRoles", userArray);
            return "admin/home/add";
    	}else if(!checkHomeUser(null, home.getHomeUserId())){
    		List<User> userArray = userService.findUserByRid(Constans.homeRole);
    		model.addAttribute("msg", "该用户已绑定过基地!");
    		model.addAttribute("home", home);
        	model.addAttribute("homeRoles", userArray);
            return "admin/home/add";
    	}else{
    		home.setStatusDsc(StatusUtil.statusMap.get(home.getStatus()));
    		homeService.addHome(home);
    		return "redirect:/admin/channel/home/index?msg=success";
    	}
    }

    /**
     * 跳转到基地修改页面
     *
     * @param hId
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{homeId}", method = RequestMethod.GET)
    public String updateInex(@PathVariable("homeId") Integer homeId, Model model) {
        List<Home> homeArray = homeService.selectHomeById(homeId);
        Home home = homeArray.get(0);
        User user = userService.selectUserById(home.getHomeUserId());
		home.setHomeUserName(user.getStaffname());
        model.addAttribute("home", home);
        List<User> userArray = userService.findUserByRid(Constans.homeRole);
    	model.addAttribute("homeRoles", userArray);
        return "admin/home/update";
    }

    /**
     * 提交用户修改数据
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Home home,Model model) {
    	if (!checkHomeName(home,"update")) {
            model.addAttribute("home", home);
            model.addAttribute("msg", "修改失败，基地名已被占用");
            List<User> userArray = userService.findUserByRid(Constans.homeRole);
        	model.addAttribute("homeRoles", userArray);
            return "admin/home/update";
    	}else if(!checkHomeUser(home.getHomeId(), home.getHomeUserId())){
    		model.addAttribute("home", home);
            model.addAttribute("msg", "修改失败,该用户已绑定过基地");
            List<User> userArray = userService.findUserByRid(Constans.homeRole);
        	model.addAttribute("homeRoles", userArray);
            return "admin/home/update";
    	}else{
    		User user = userService.selectUserById(home.getHomeUserId());
    		home.setHomeUserName(user.getStaffname());
        	home.setStatusDsc(StatusUtil.statusMap.get(home.getStatus()));
        	homeService.updateHome(home);
            model.addAttribute("msg", "基地修改成功!");
            return "redirect:/admin/channel/home/index?msg=success";
    	}
    }
    
    /**
     * 修改基地当前状态
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateState",method = RequestMethod.POST)
    public String updateState(Home home) {
    	home.setStatusDsc(StatusUtil.statusMap.get(home.getStatus()));
        Integer i=homeService.updateStatusById(home);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }

    /**
     * 删除选择基地
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/deleteHomeById",method = RequestMethod.POST)
    public String deleteHomeById(Home home){
    	Integer i= homeService.deleteHomeById(home);
        if (i==1) {
            return "success";
        }else {
            return "error";
        }
    }
    /**
     * 鉴定基地名唯一性
     * @param home
     * @return
     */
    private Boolean checkHomeName(Home home, String opera){
    	List<Home> proList = homeService.selectHomeByName(home.getHomeName());
        if (proList == null || proList.size() == 0) {
        	return true;
        }
        if ("update".equals(opera)) {
        	List<Home> oldList = homeService.selectHomeById(home.getHomeId());
            if (oldList.get(0).getHomeName().equals(proList.get(0).getHomeName())) {
            	return true;
            }
        }
        return false; 	
    }
    /**
     * 鉴定基地负责人有效性（一个基地角色只能绑定一个基地）
     * @param home
     * @return
     */
    private Boolean checkHomeUser(Integer pid, Integer homeUserId){
    	Home home = new Home();
    	home.setHomeUserId(homeUserId);
    	home.setExcludeHomeId(pid);
    	List<Home> homeArray = homeService.selectHomeByUserIdAndExcludeId(home);
    	if (homeArray != null && homeArray.size() > 0) {
    		return false;
    	}
    	return true;
    }
}
