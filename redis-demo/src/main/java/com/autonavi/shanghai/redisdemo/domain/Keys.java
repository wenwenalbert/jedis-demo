package com.autonavi.shanghai.redisdemo.domain;

public enum Keys {

	IDS("ids"), ALL("all"),
	
	USER("user");
	
	private final String key;
	
	private Keys(String key) {
		this.key = key;
	}
	
	public String key() {
		return key;
	}

}
