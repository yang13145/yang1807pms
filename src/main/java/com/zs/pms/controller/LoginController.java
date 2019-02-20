package com.zs.pms.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.md5.MD5;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUsers;
import com.zs.pms.serviceimpl.UserServiceImpl;
import com.zs.pms.vo.QueryLogin;
import com.zs.pms.vo.QueryUser;


@Controller	//控制器
public class LoginController{
	
	@Autowired
	UserServiceImpl us;
	
	
	//登录页面
	@RequestMapping("/tologin.do")
	public String tologin() {
		return "login";
	}
	
	//主要页面
	@RequestMapping("/login.do")
	public String login(QueryLogin login,HttpSession session,ModelMap model) {
		//验证验证码
		String ocode=(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//生成验证码不匹配
		if(!ocode.equals(login.getChkcode())) {
			model.addAttribute("MSG", "验证码输入有误，请重新输入");
			return "login";
		}
		//账号和密码
		//装在数据
		QueryUser query=new QueryUser();
		//登录名
		query.setLoginname(login.getUsername());
		//密码MD5加密
		MD5 md5=new MD5();
		//密码
		query.setPassword(md5.getMD5ofStr(login.getPassword()));
		//设置可用
		query.setIsenabled(1);
		//返回登录的用户
		List<TUsers> users=us.queryByCon(query);
		//登陆失败
		if(users==null||users.size()!=1) {
			return "login";
		}
		//登陆证确
		session.setAttribute("CUSER", users.get(0));
		//主页面
		return "main";
	}
	
	//顶部页面
	@RequestMapping("/top.do")
	public String top() {
		return "top";
	}
	
	//左部页面
	@RequestMapping("/left.do")
	public String left(HttpSession session,ModelMap model) {
		//获得登录用户
		TUsers cu=(TUsers) session.getAttribute("CUSER");
		//获得用户的权限列表
		List<TPermission> list1=us.queryByUid(cu.getId());
		//返回菜单
		model.addAttribute("MENU", us.genMenu(list1));
		return "left";
	}
	
	//左部页面
	@RequestMapping("/right.do")
	public String main() {
		return "right";
	}

}
