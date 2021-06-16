/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.role.model;

import com.hedgeness.app.common.model.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model for privileges to access Enterprise management service
 * 
 * @author Pavan
 *
 */
@Document
public class RightsOnEnterprises extends BaseEntity {

	private boolean addRights;
	private boolean editRights;
	private boolean deleteRights;
	private boolean enableRights;
	private boolean disableRights;
	private boolean activateRights;
	private boolean deActivateRights;
	private boolean listRights;
	private boolean viewRights;
	
	/**
	 * @return the addRights
	 */
	public boolean isAddRights() {
		return addRights;
	}
	/**
	 * @param addRights the addRights to set
	 */
	public void setAddRights(boolean addRights) {
		this.addRights = addRights;
	}
	/**
	 * @return the editRights
	 */
	public boolean isEditRights() {
		return editRights;
	}
	/**
	 * @param editRights the editRights to set
	 */
	public void setEditRights(boolean editRights) {
		this.editRights = editRights;
	}
	/**
	 * @return the deleteRights
	 */
	public boolean isDeleteRights() {
		return deleteRights;
	}
	/**
	 * @param deleteRights the deleteRights to set
	 */
	public void setDeleteRights(boolean deleteRights) {
		this.deleteRights = deleteRights;
	}
	/**
	 * @return the enableRights
	 */
	public boolean isEnableRights() {
		return enableRights;
	}
	/**
	 * @param enableRights the enableRights to set
	 */
	public void setEnableRights(boolean enableRights) {
		this.enableRights = enableRights;
	}
	/**
	 * @return the disableRights
	 */
	public boolean isDisableRights() {
		return disableRights;
	}
	/**
	 * @param disableRights the disableRights to set
	 */
	public void setDisableRights(boolean disableRights) {
		this.disableRights = disableRights;
	}
	/**
	 * @return the activateRights
	 */
	public boolean isActivateRights() {
		return activateRights;
	}
	/**
	 * @param activateRights the activateRights to set
	 */
	public void setActivateRights(boolean activateRights) {
		this.activateRights = activateRights;
	}
	/**
	 * @return the deActivateRights
	 */
	public boolean isDeActivateRights() {
		return deActivateRights;
	}
	/**
	 * @param deActivateRights the deActivateRights to set
	 */
	public void setDeActivateRights(boolean deActivateRights) {
		this.deActivateRights = deActivateRights;
	}
	/**
	 * @return the listRights
	 */
	public boolean isListRights() {
		return listRights;
	}
	/**
	 * @param listRights the listRights to set
	 */
	public void setListRights(boolean listRights) {
		this.listRights = listRights;
	}
	/**
	 * @return the viewRights
	 */
	public boolean isViewRights() {
		return viewRights;
	}
	/**
	 * @param viewRights the viewRights to set
	 */
	public void setViewRights(boolean viewRights) {
		this.viewRights = viewRights;
	}
	
	
	
}
