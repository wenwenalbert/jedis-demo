package com.autonavi.shanghai.redisdemo.persist.mapper;

import java.util.List;

import com.autonavi.shanghai.redisdemo.domain.User;

public interface UserMapper {

	public String get(String key);
	public void set(String key, String value);
	
	public void addUser(User user);
	public User getUser(Long userId);
	public List<User> getUserAll();
	public void updateUser(User user);
}
