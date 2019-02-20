package com.zs.pms.service;

import java.util.List;
import com.zs.pms.po.TUsers;
import com.zs.pms.vo.QueryUser;


public interface UserService2 {
	
	public List<TUsers> queryByCon(QueryUser query);
}
