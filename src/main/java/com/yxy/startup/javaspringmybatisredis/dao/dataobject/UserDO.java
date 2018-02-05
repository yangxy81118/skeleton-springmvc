package com.yxy.startup.javaspringmybatisredis.dao.dataobject;

import java.util.Date;

public class UserDO {

	private long id;
	
	private String openId;
	
	private Date createTime;
	
	private Integer state;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "UserDO [id=" + id + ", openId=" + openId + ", createTime=" + createTime + ", state=" + state + "]";
	}
	
}
