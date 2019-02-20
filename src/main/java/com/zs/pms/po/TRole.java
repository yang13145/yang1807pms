package com.zs.pms.po;

import java.io.Serializable;

public class TRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1962827445200282876L;

	private int id;
	private String rame;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRame() {
		return rame;
	}
	public void setRame(String rame) {
		this.rame = rame;
	}
	@Override
	public String toString() {
		return "TRole [id=" + id + ", rame=" + rame + "]";
	}
	
	
	
	
	

}
