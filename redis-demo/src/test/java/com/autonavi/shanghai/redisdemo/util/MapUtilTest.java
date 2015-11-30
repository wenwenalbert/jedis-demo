package com.autonavi.shanghai.redisdemo.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.autonavi.shanghai.redisdemo.domain.User;

public class MapUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void test() {
		try {
			User user = new User();
			user.setUserId(1L);
			user.setUsername("wenwen");
			user.setPassword("123");
			user.setEmail("123@ali.com");
			user.setDescription("wu");
			System.out.println(JSON.toJSONString(MapUtil.bean2Map(user)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void test1() throws Exception {
		User user = new User();
		user.setDescription("miao");
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", "1");
		map.put("username", "wen");
		map.put("password", "123");
		map.put("email", "wen@ali.com");
		map.put("class", "class com.autonavi.shanghai.redisdemo.domain.User");
		MapUtil.map2Bean(map, user);
		System.out.println(JSON.toJSONString(user));
	}
}
