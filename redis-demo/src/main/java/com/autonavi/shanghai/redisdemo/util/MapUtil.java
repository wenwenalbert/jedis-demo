package com.autonavi.shanghai.redisdemo.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class MapUtil {

	public static Map<String, String> bean2Map(Object object) throws Exception {
		if (object == null) {
			return null;
		}

		Map<String, String> map = new HashMap<String, String>();
		//可以直接用commons BeanUtils Lib,但是会包含class属性
		//map = BeanUtilsBean.getInstance().describe(object);  
		
		BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			if (!key.equals("class")) {
				Method getter = property.getReadMethod();
				Object value = getter.invoke(object);
				if (value != null) {
					map.put(key, value.toString());
				}
			}
		}
		return map;
	}

	public static <T extends Object>T map2Bean(Map<String, String> map, T object)
			throws Exception {
		if ((map == null) || (object == null)) {
			return null;
		}
		BeanUtils.populate(object, map);
		return object;
	}
}
