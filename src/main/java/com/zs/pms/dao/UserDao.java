package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUsers;
import com.zs.pms.vo.QueryUser;

public interface UserDao {

	//获得用户权限
	public  List<TPermission> queryByUid(int id);
	
	//根据条件查询
	public List<TUsers> queryByCon(QueryUser query);
	
	//分页查询
	public List<TUsers> queryByPage(QueryUser query);
	
	//总条数
	public int queryCont(QueryUser query);
	
	//新增返回主键
	public int insertUser(TUsers users);
	
	//批量删除
	public void deleteByIds(int[] ids);
	
	//删除一条
	public void deleteId(int id);
	
	//修改
	public void updateUser(TUsers tuser);
	
	//部门
	public void getDep(int id);
	
	
	
}
