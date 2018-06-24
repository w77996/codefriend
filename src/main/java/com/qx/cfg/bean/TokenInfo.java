package com.qx.cfg.bean;

import java.sql.Timestamp;

public class TokenInfo {

	private Long id;
	private String token;
	private String userId;
	private Timestamp createtime;

	public Long getT_id() {
		return id;
	}

	public void setT_id(Long t_id) {
		this.id = t_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUser_id() {
		return userId;
	}

	public void setUser_id(String user_id) {
		this.userId = user_id;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
}
