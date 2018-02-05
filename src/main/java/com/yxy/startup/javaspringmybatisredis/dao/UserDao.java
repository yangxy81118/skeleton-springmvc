 package com.yxy.startup.javaspringmybatisredis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yxy.startup.javaspringmybatisredis.dao.dataobject.UserDO;

@Mapper
public interface UserDao {

	@Select("SELECT * FROM user WHERE state = 1 AND id = #{id}")
	public UserDO selectOne(@Param("id") Long id );
	
	
	@Select("SELECT * FROM user")
	public List<UserDO> list();
	
}
