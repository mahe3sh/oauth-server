/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.config;

/**
 * contains status constants for role management responses
 * 
 * 
 *
 */
public class AppConfig {
	public static final byte SUCCESSFUL = 1;// Role Management operation success constant
	public static final byte OPER_FAIL = 0;// Role Management operation fail constant

	public static final boolean IS_ENABLED = true;// indicates Role enable or not
	public static final boolean IS_DISABLED = false;// indicates Role disable or not

	public static final boolean IS_DELETED = true;// indicates Role deleted or not
	public static final boolean IS_NOT_DELETED = false;// indicates Role existed or not

	public static final String STATUS_FOR_ACTIVE = "Active"; // indicates Role active or not
	public static final String STATUS_FOR_DEACTIVE = "Deactive"; // indicates Role deactive or not
	public static final String MENU="menu";
	public static final String LIST="list";
	public static final String SUBCATEGORY="subcategory";
	public static final String secret_connect_key="secret_connect_key";
	public static final String Cache_Control="Cache-Control";

	public static String getCategoryCollectionName() {
		return "acl_category1";
	}
	
}
