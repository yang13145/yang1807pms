package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUsers;
import com.zs.pms.vo.QueryUser;

public interface UserService {
	//测试方法
	public void hello();
	
	//获得用户权限
	public List<TPermission> queryByUid(int id);
	
	//根据原有权限整理菜单
	public List<TPermission> genMenu(List<TPermission> pers);
	
	//根据条件查询
	public List<TUsers> queryByCon(QueryUser query);
	
	//分页查询
	public List<TUsers> queryByPage(int page,QueryUser query);
	
	//计算总页数
	public int queryByCont(QueryUser query);
	
	//批量删除
	public void deleteByIds(int[] ids);
	
	//删除一条
	public void deleteId(int id);
	
	//修改
	public void updateUser(TUsers tuser);
	
	//新增返回主键
	public int insertUser(TUsers users);
	
	
	
	
	
}
