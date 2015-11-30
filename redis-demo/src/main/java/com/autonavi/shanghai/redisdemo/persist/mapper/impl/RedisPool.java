package com.autonavi.shanghai.redisdemo.persist.mapper.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.autonavi.shanghai.redisdemo.config.AppConfig;

@Component
public class RedisPool implements InitializingBean, DisposableBean {

	@Autowired
	private AppConfig appConfig;
	
	private static JedisPool pool = null;

	public static JedisPool getPool() {
		return pool;
	}

	public static void setPool(JedisPool pool) {
		RedisPool.pool = pool;
	}

	public Jedis getJedis() {
		return pool.getResource();
	}

	public void closeJedis(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (pool == null) {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(appConfig.getRedisMaxActive());
			config.setMaxIdle(appConfig.getRedisMaxIdle());
			config.setMaxWaitMillis(appConfig.getRedisMaxWait());
			config.setTestOnBorrow(appConfig.getRedisTestOnBorrow());
			
			pool = new JedisPool(config, appConfig.getRedisHost(), appConfig.getRedisPort());
		}
	}

	@Override
	public void destroy() throws Exception {
		if (pool != null) {
			pool.destroy();
		}
	}
	
}
