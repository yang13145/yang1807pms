package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

import com.zs.pms.utils.DateUtil;


public class TUsers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8740825364988872217L;
	
	private int id;
	private String loginname;
	private String password;
	private String realname;
	private String sex;
	private Date birthday;
	private String dep;
	private String email;
	private int isenabled;
	private TDep dept;
	private String pic;
	private int updator;
	private String updatime;
	private int creator;
	private String creatime;
	private String isenabledTxt;
	private String birthdayTxt;
	
	
	
	
	public String getIsenabledTxt() {
		if(isenabled==1) {
			return "可用";
		}else {
			return "不可用";
		}
	}
	
	public String getBirthdayTxt() {
		return DateUtil.getStrDate(birthday);
	}
	
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public String getCreatime() {
		return creatime;
	}
	public void setCreatime(String creatime) {
		this.creatime = creatime;
	}
	public String getUpdatime() {
		return updatime;
	}
	public void setUpdatime(String updatime) {
		this.updatime = updatime;
	}
	public int getUpdator() {
		return updator;
	}
	public void setUpdator(int updator) {
		this.updator = updator;
	}
	public TDep getDept() {
		return dept;
	}
	public void setDept(TDep dept) {
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getIsenabled() {
		return isenabled;
	}
	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}
	
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	
	
	
	
}
