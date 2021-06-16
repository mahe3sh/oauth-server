/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.model;

import com.hedgeness.app.common.model.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model to display App Users
 * 
 * @author Pavan
 *
 */
@Document
public class DisplayAppUserDetails extends BaseEntity {

	private String username;
	private String registrationCode;
	private String firstName;
	private String middleName;
	private String lastName;
	private String enterpriseName;
	private String email;
	private Address address;
	private String answer1;
	private String answer2;

	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	private boolean isDeleted;
	
	private String status;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the registrationCode
	 */
	public String getRegistrationCode() {
		return registrationCode;
	}
	/**
	 * @param registrationCode the registrationCode to set
	 */
	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the enterpriseName
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * @param enterpriseName the enterpriseName to set
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the answer1
	 */
	public String getAnswer1() {
		return answer1;
	}
	/**
	 * @param answer1 the answer1 to set
	 */
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	/**
	 * @return the answer2
	 */
	public String getAnswer2() {
		return answer2;
	}
	/**
	 * @param answer2 the answer2 to set
	 */
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	/**
	 * @return the isAccountNonExpired
	 */
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}
	/**
	 * @param isAccountNonExpired the isAccountNonExpired to set
	 */
	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}
	/**
	 * @return the isAccountNonLocked
	 */
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}
	/**
	 * @param isAccountNonLocked the isAccountNonLocked to set
	 */
	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	/**
	 * @return the isCredentialsNonExpired
	 */
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}
	/**
	 * @param isCredentialsNonExpired the isCredentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AppUser [id=" + this.getId() + ", username=" + username + ", createdAt=" + this.getCreatedAt() + ", createdBy=" + this.getCreatedBy()
				+ ", registrationCode=" + registrationCode + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", enterpriseName=" + enterpriseName + ", email=" + email + ", address="
				+ address + ", answer1=" + answer1 + ", answer2=" + answer2 + ", updatedAt=" + this.getUpdatedAt()
				+ ", updatedBy=" + this.getUpdatedBy() + ", isAccountNonExpired=" + isAccountNonExpired + ", isAccountNonLocked="
				+ isAccountNonLocked + ", isCredentialsNonExpired=" + isCredentialsNonExpired + ", isEnabled="
				+ isEnabled + ", isDeleted=" + isDeleted + ", status=" + status + "]";
	}

}
