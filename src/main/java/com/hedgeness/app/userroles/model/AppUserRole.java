/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.userroles.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model for App User
 * 
 * @author Kuljeet
 *
 */
@Document
public class AppUserRole {
	

	@Id
	private String id;

	private String username;
	private String rolename;
	private String organizationId;
	//private String roleId;
	//private String userId;
	@Transient
	private ObjectId sid;
//	@DateTimeFormat(iso = ISO.DATE_TIME)
//	private Date createdAt;
//	private String createdBy;
//	@DateTimeFormat(iso = ISO.DATE_TIME)
//	private Date updatedAt;
//	private String updatedBy;


	@Transient
	private int action;

	public ObjectId getSid() {
		return sid;
	}

	public void setSid(ObjectId sid) {
		this.sid = sid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

//	/**
//	 * @return the createdAt
//	 */
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	/**
//	 * @param createdAt
//	 *            the createdAt to set
//	 */
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	/**
//	 * @return the createdBy
//	 */
//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	/**
//	 * @param createdBy
//	 *            the createdBy to set
//	 */
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//
//	/**
//	 * @return the updatedAt
//	 */
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	/**
//	 * @param updatedAt
//	 *            the updatedAt to set
//	 */
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//
//	/**
//	 * @return the updatedBy
//	 */
//	public String getUpdatedBy() {
//		return updatedBy;
//	}
//
//	/**
//	 * @param updatedBy
//	 *            the updatedBy to set
//	 */
//	public void setUpdatedBy(String updatedBy) {
//		this.updatedBy = updatedBy;
//	}

}
