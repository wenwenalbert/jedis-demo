package com.autonavi.shanghai.redisdemo.domain;

public class KeyTool {
	
	private static final String KEY_SEPARATOR = ":";
	//private static final String KEY_INNER_SEPARATOR = "_";

	public static String format(String key, String type) {
		return key + KEY_SEPARATOR + type;
	}
	
}
