package com.zs.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@Controller
public class UserController {
	
	@Autowired
	UserService us;
	
	
	//列表
	@RequestMapping("/user/list.do")
	public String list(String page,QueryUser query,ModelMap map) {
		if(page==null) {
			page="1";
		}
		//返回分页数据
		map.addAttribute("LIST", us.queryByPage(Integer.parseInt(page),query));
		//返回总页数
		map.addAttribute("PAGECONT",us.queryByCont(query));
		//
		map.addAttribute("PAGE",page);
		map.addAttribute("QUERY",query);
		
		return "user/list";
	}
	
	
	
	//删除
	@RequestMapping("/user/delete.do")
	public String delete(int id) {
		us.deleteId(id);
		//跳转
		return "redirect:list.do";
	}
	
	
	//删除
	@RequestMapping("/user/deletes.do")
	public String delete(int[] ids) {
		us.deleteByIds(ids);
		//跳转
		return "redirect:list.do";
	}

}
