package com.autonavi.shanghai.redisdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	@Value("${redis.host}")
	private String redisHost;
	@Value("${redis.port}")
	private Integer redisPort;
	@Value("${redis.maxActive}")
	private Integer redisMaxActive;
	@Value("${redis.maxIdle}")
	private Integer redisMaxIdle;
	@Value("${redis.maxWait}")
	private Long redisMaxWait;
	@Value("${redis.testOnBorrow}")
	private boolean redisTestOnBorrow;
	@Value("${redis.testOnReturn}")
	private boolean redisTestOnReturn;

	public String getRedisHost() {
		return redisHost;
	}

	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}

	public Integer getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(Integer redisPort) {
		this.redisPort = redisPort;
	}

	public Integer getRedisMaxActive() {
		return redisMaxActive;
	}

	public void setRedisMaxActive(Integer redisMaxActive) {
		this.redisMaxActive = redisMaxActive;
	}

	public Integer getRedisMaxIdle() {
		return redisMaxIdle;
	}

	public void setRedisMaxIdle(Integer redisMaxIdle) {
		this.redisMaxIdle = redisMaxIdle;
	}

	public Long getRedisMaxWait() {
		return redisMaxWait;
	}

	public void setRedisMaxWait(Long redisMaxWait) {
		this.redisMaxWait = redisMaxWait;
	}

	public boolean getRedisTestOnBorrow() {
		return redisTestOnBorrow;
	}

	public void setRedisTestOnBorrow(boolean redisTestOnBorrow) {
		this.redisTestOnBorrow = redisTestOnBorrow;
	}

	public boolean isRedisTestOnReturn() {
		return redisTestOnReturn;
	}

	public void setRedisTestOnReturn(boolean redisTestOnReturn) {
		this.redisTestOnReturn = redisTestOnReturn;
	}

}
