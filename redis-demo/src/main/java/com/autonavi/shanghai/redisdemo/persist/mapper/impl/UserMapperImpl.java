package com.autonavi.shanghai.redisdemo.persist.mapper.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import com.autonavi.shanghai.redisdemo.domain.KeyTool;
import com.autonavi.shanghai.redisdemo.domain.Keys;
import com.autonavi.shanghai.redisdemo.domain.User;
import com.autonavi.shanghai.redisdemo.persist.mapper.UserMapper;
import com.autonavi.shanghai.redisdemo.util.MapUtil;

@Component
public class UserMapperImpl implements UserMapper {
	
	private static final Logger logger = LoggerFactory.getLogger(UserMapperImpl.class);

	@Autowired
	private RedisPool pool;
	
	@Override
	public void set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = pool.getJedis();
			jedis.set(key, value);
		} catch (Exception e) {
			logger.warn("", e);
		} finally {
			pool.closeJedis(jedis);
		}
	}

	@Override
	public String get(String key) {
		String result = null;
		Jedis jedis = null;
		
		try {
			jedis = pool.getJedis();
			result = jedis.get(key);
		} catch (Exception e) {
			logger.warn("", e);
		} finally {
			pool.closeJedis(jedis);
		}
		return result;
	}

	@Override
	public void addUser(User user) {
		Jedis jedis = null;
		try {
			jedis = pool.getJedis();
			Long userId = jedis.incr(KeyTool.format(Keys.USER.key(), Keys.IDS.key()));
			user.setUserId(userId);
			Pipeline pipeline = jedis.pipelined();
			pipeline.rpush(KeyTool.format(Keys.USER.key(), Keys.ALL.key()), String.valueOf(userId));
			pipeline.hmset(KeyTool.format(Keys.USER.key(), userId.toString()), MapUtil.bean2Map(user));
			pipeline.sync();
		} catch (Exception e) {
			logger.warn("", e);
		} finally {
			pool.closeJedis(jedis);
		}
	}

	@Override
	public User getUser(Long userId) {
		Jedis jedis = null;
		User user = new User();
		try {
			jedis = pool.getJedis();
			Map<String, String> map = new HashMap<String, String>();
			map = jedis.hgetAll(KeyTool.format(Keys.USER.key(), userId.toString()));
			MapUtil.map2Bean(map, user);
		} catch (Exception e) {
			logger.warn("", e);
		} finally {
			pool.closeJedis(jedis);
		}
		return user;
	}

	@Override
	public List<User> getUserAll() {
		Jedis jedis = null;
		List<User> users = new ArrayList<User>();
		try {
			jedis = pool.getJedis();
			List<String> userIds = jedis.lrange(KeyTool.format(Keys.USER.key(), Keys.ALL.key()), 0, -1);
			if (userIds != null && !userIds.isEmpty()) {
				List<Response<Map<String, String>>> responses = new ArrayList<Response<Map<String,String>>>();
				
				Pipeline pipeline = jedis.pipelined();
				for (String userId : userIds) {
					responses.add(pipeline.hgetAll(KeyTool.format(Keys.USER.key(), userId)));
				}
				pipeline.sync();
				
				for (Response<Map<String, String>> response : responses) {
					User user =  new User();
					MapUtil.map2Bean(response.get(), user);
					users.add(user);
				}
			}
		} catch (Exception e) {
			logger.warn("", e);
		} finally {
			pool.closeJedis(jedis);
		}
		return users;
	}

	@Override
	public void updateUser(User user) {
		Jedis jedis = null;
		try {
			jedis = pool.getJedis();
			jedis.hmset(KeyTool.format(Keys.USER.key(), user.getUserId().toString()), MapUtil.bean2Map(user));
		} catch (Exception e) {
			logger.warn("", e);
		} finally {
			pool.closeJedis(jedis);
		}
	}

}
