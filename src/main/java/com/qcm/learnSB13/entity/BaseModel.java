package com.qcm.learnSB13.entity;

import java.util.Date;

/**
 * 
 * @author Congmin Qiu 
 */
public class BaseModel {
	private Integer id;
	private Date gmt_create;
	private Date gmt_modified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}

	public Date getGmt_modified() {
		return gmt_modified;
	}

	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}

}
