package com.zs.pms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.zs.pms.po.TUsers;
import com.zs.pms.vo.QueryUser;

@Repository
public interface UserDao2 {

	@Select("select * from tusers where sex=#{sex}")
	public List<TUsers> queryByCon(QueryUser query);

}
