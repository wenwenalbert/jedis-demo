package com.autonavi.shanghai.redisdemo.domain;

import java.util.Date;

import com.autonavi.shanghai.redisdemo.util.MathUtil;

public class Partial {

	private Date createdAt;
	private Date updatedAt;
	private Integer enabled;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	public void resetEnabled(boolean status) {
		if(status) {
			setEnabled(MathUtil.ENABLED_TRUE);
		} else {
			setEnabled(MathUtil.ENABLED_FALSE);
		}
	}

}
