/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.role.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.hedgeness.app.common.model.BaseEntity;

/**
 * Model for Role
 * 
 * @author Pavan
 *
 */
@Document
public class RoleRights extends BaseEntity
{
	private String roleName;
	private String displayName;
	private RightsOnEnterprises rightsOnEnterprises;
	private String description;
	private boolean isDeleted;
	private boolean isEnabled;
	private RightsOnRoles rightsOnRoles;
	private RightsOnUsers rightsOnUsers;
	private String status;
	private String enterpriseName;

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the rightsOnEnterprises
	 */
	public RightsOnEnterprises getRightsOnEnterprises() {
		return rightsOnEnterprises;
	}

	/**
	 * @param rightsOnEnterprises the rightsOnEnterprises to set
	 */
	public void setRightsOnEnterprises(RightsOnEnterprises rightsOnEnterprises) {
		this.rightsOnEnterprises = rightsOnEnterprises;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the isEnabled
	 */
	public boolean isEnabled() {
		return isEnabled;
	}

	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * @return the rightsOnRoles
	 */
	public RightsOnRoles getRightsOnRoles() {
		return rightsOnRoles;
	}

	/**
	 * @param rightsOnRoles the rightsOnRoles to set
	 */
	public void setRightsOnRoles(RightsOnRoles rightsOnRoles) {
		this.rightsOnRoles = rightsOnRoles;
	}


	/**
	 * @return the rightsOnUsers
	 */
	public RightsOnUsers getRightsOnUsers() {
		return rightsOnUsers;
	}

	/**
	 * @param rightsOnUsers the rightsOnUsers to set
	 */
	public void setRightsOnUsers(RightsOnUsers rightsOnUsers) {
		this.rightsOnUsers = rightsOnUsers;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
}
