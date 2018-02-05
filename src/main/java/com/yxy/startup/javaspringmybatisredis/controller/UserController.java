package com.yxy.startup.javaspringmybatisredis.controller;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.util.collections.SynchronizedStack;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.yxy.startup.javaspringmybatisredis.dao.UserDao;
import com.yxy.startup.javaspringmybatisredis.dao.dataobject.UserDO;

@RestController
@RequestMapping("/user")
public class UserController implements ApplicationContextAware {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private StringRedisTemplate template;
	
	@Autowired
	DataSource ds;

	@Autowired
	SqlSessionFactory factory;
	
//	@Autowired
//	SqlSessionFactoryBean fBean;
	
	
	
	//TODO 需要一个公用的Response
	@GetMapping("/find/{id}")
	public UserDO find(@PathVariable("id") Long id){
		
//		System.out.println(ds); //检查连接池
		
//		System.out.println(fBean);
		
		Object obj = app.getBean("stringRedisTemplate");
		System.out.println(obj);
		
		//使用mysql
		UserDO user = userDao.selectOne(id); 
		
		//使用redis
		BoundValueOperations<String, String> state = template.boundValueOps("USER:"+id);
		if(null == state.get()) state.set(1+"");
		else System.out.println("From redis:"+state.get());
		
		return user;
	}
	
	
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	@GetMapping("/list/{page}")
	public List<UserDO> list(@PathVariable("page") int page){
		PageHelper.startPage(page, 2);
		List<UserDO> list = userDao.list();
		return list;
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		System.out.println(applicationContext);
		this.app = applicationContext;
		
	}
	
	//POST
	
	//DELETE
	
	//PUT
	
	
	ApplicationContext app;
	
	
}
