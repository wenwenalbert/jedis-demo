package com.autonavi.shanghai.redisdemo.persist.driver.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.autonavi.shanghai.redisdemo.App;
import com.autonavi.shanghai.redisdemo.domain.User;
import com.autonavi.shanghai.redisdemo.persist.mapper.impl.UserMapperImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class JedisDriverImplTest {
	
	private static final Logger logger = LoggerFactory.getLogger(JedisDriverImplTest.class);

	@Autowired
	private UserMapperImpl mapper;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		User user = new User();
		user.setUserId(1L);
		//user.setUsername("yuanyuan");
		//user.setPassword("123");
		//user.setEmail("yuan@ali.com");
		//user.setDescription("");
		user.resetEnabled(true);
		mapper.updateUser(user);
		
	}
	
	@Test 
	public void test1() {
		User user = new User();
		user = mapper.getUser(2L);
		logger.debug(JSON.toJSONString(user));
		
		logger.debug(JSON.toJSONString(mapper.getUserAll()));
	}

}
