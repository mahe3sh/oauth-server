/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.model;

import java.util.Date;

import com.hedgeness.app.common.model.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model for App User login attempts
 * 
 * @author Pavan
 *
 */
@Document
public class AppUserAttempts extends BaseEntity {

	private String userName;

	private String mail;

	private int attempts;

	private Date lastModified;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the attempts
	 */
	public int getAttempts() {
		return attempts;
	}

	/**
	 * @param attempts
	 *            the attempts to set
	 */
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	/**
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified
	 *            the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}