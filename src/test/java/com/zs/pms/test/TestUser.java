package com.zs.pms.test;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUsers;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUser {
	
	@Autowired
	UserService us;
		//测试
	public void testHello() {
		us.hello();
	}
	
	
		//查询
	public void testQuery() {
		//创建对象
		QueryUser query=new QueryUser();
		query.setSex("男");
		for(TUsers users:us.queryByPage(1, query)) {
			System.out.println(users.getId()+"、"+users.getLoginname());
		}
		System.out.println("共"+us.queryByCont(query)+"页");
	}
	
	
		//删除
	public void testdelete() {
		int[] ids= {2};
		us.deleteByIds(ids);
	}
	
	
	public void testdetleteid() {
		us.deleteId(1);
	}
	
	
	public void testupdate() {
		TUsers user=new TUsers();
		TDep dept=new TDep();
		dept.setId(4);
		user.setId(3098);
		user.setLoginname("update123");
		user.setPassword("update123");
		//user.setBirthday(new Date());
		user.setDept(dept);
		user.setEmail("updator@163.com");
		user.setIsenabled(1);
		user.setPic("update123");
		user.setRealname("update123");
		user.setSex("男");
		user.setUpdator(1);
		us.updateUser(user);
		
		
	}
	
	
	
		//新增
	public void testInsert() {
		TUsers user=new TUsers();
		TDep dep=new TDep();
		dep.setId(1);
		user.setLoginname("loginnam");
		user.setPassword("passwor");
		//user.setBirthday(new Date());
		user.setDept(dep);
		user.setEmail("insert123@163.com");
		user.setIsenabled(1);
		user.setPic("insert123");
		user.setRealname("insert123");
		user.setSex("女");
		user.setCreator(3084);
		us.insertUser(user);
		
	}
	
	
	
	@Test	//排序
	public void testLogin() {
		List<TPermission> list1=us.queryByUid(3084);
		
		System.out.println("===================整理前================");
		for(TPermission per:list1) {
			System.out.println(per.getPname());
		}
		
		System.out.println("===================整理后================");
		for(TPermission per1:us.genMenu(list1)) {
			//一级权限
			System.out.println(per1.getPname());
			for(TPermission per2:per1.getChildren()) {
				System.out.println("===="+per2.getPname());
			}
		}
	}
	
}
