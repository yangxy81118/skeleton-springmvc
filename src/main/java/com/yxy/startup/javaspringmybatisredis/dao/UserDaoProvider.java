package com.yxy.startup.javaspringmybatisredis.dao;

import org.apache.ibatis.jdbc.SQL;

import com.yxy.startup.javaspringmybatisredis.dao.dataobject.UserDO;

public class UserDaoProvider {

	public String selectUser(UserDO userquery){
		return new SQL() {{
			SELECT("*");
			FROM("user");
			WHERE("openId="+userquery.getOpenId());
			
		}}.toString();
	}
	
	public static void main(String[] args) {
	}
}
