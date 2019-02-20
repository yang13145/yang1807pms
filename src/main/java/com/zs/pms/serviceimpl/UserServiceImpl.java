package com.zs.pms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.UserDao;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUsers;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.contests;
import com.zs.pms.vo.QueryUser;

@Service
public  class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao dao;
	
	@Override
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("HELLO SPRING");
	}

	@Override
	public List<TPermission> queryByUid(int id) {
		// TODO Auto-generated method stub
		return dao.queryByUid(id);
	}

	@Override
	public List<TPermission> genMenu(List<TPermission> pers) {
		// TODO Auto-generated method stub
		//创建新容器
		List<TPermission> list = new ArrayList<>();
		//遍历权限列表
		for(TPermission per:pers) {
			//一级菜单
			if(per.getLev()==1) {
				//加载一级菜单下的二级菜单
				//遍历
				for(TPermission per2:pers) {
					//二级权限的上级id等于一级权限id
					if(per2.getPid()==per.getId()) {
						//添加子权限
						per.addChild(per2);
					}
				}
				//加载到新的集合中
				list.add(per);
			}
		}
		return list;
	}

	@Override
	public List<TUsers> queryByCon(QueryUser query) {
		// TODO Auto-generated method stub
		return dao.queryByCon(query);
	}

	@Override
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteByIds(ids);
	}

	@Override
	public void updateUser(TUsers tuser) {
		// TODO Auto-generated method stub
		dao.updateUser(tuser);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(TUsers users) {
		// TODO Auto-generated method stub
		dao.insertUser(users);
		int i=10/0;
		dao.insertUser(users);
		return users.getId();
	}

	@Override
	public void deleteId(int id) {
		// TODO Auto-generated method stub
		dao.deleteId(id);
	}

	@Override
	public List<TUsers> queryByPage(int page, QueryUser query) {
		// TODO Auto-generated method stub
		
		int start=(page-1)*contests.PAGECONT+1;
		int end=page*contests.PAGECONT;
		query.setStart(start);
		query.setEnd(end);
		return dao.queryByPage(query);
	}

	@Override
	public int queryByCont(QueryUser query) {
		// TODO Auto-generated method stub
		int cont=dao.queryCont(query);
		if(cont%contests.PAGECONT==0) {
			return cont/contests.PAGECONT;
		}else {
			return cont/contests.PAGECONT+1;
		}
		
	}
	
	
	

}
