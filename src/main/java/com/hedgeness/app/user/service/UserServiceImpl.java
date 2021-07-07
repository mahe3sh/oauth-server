/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hedgeness.app.config.encryption.EncryptionConfig;
import com.hedgeness.app.config.encryption.EncryptionUtil;
import com.hedgeness.app.role.model.RoleRights;
import com.hedgeness.app.role.repository.RoleRepoIntf;
import com.hedgeness.app.user.model.AppUser;
import com.hedgeness.app.user.repository.UserRepoIntf;
import com.hedgeness.app.userroles.constants.UserRoleStatusConstants;
import com.hedgeness.app.userroles.model.AppUserRole;
import com.hedgeness.app.userroles.repository.UserRoleRepoIntf;

/**
 * Direct implementation for {@link UserServiceIntf} having all
 * specific implementations for user management service
 * 
 * @author Veeranjaneyulu
 *
 */
@Service("appUserManagementServiceImpl")
public class UserServiceImpl implements UserServiceIntf,UserDetailsService {
	
	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepoIntf appUserManagementRepoI;// injects the AppUserManagementRepoI instance
	
	@Autowired
	private UserRoleRepoIntf roleRepoIntf;
	@Autowired
	private RoleRepoIntf roleRepo;
    @Autowired
    private EncryptionUtil encryptionUtil;
    @Autowired
    private EncryptionConfig encryptionConfig;
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
    	logger.info("username---->"+username);
		AppUser appUser= appUserManagementRepoI.getUserByUserName(username);
		if (appUser != null) 
		{
	 		/**
			 * we will change logic of validating registration code
			 * **/
			logger.info("appUser.getRegistrationCode()--->"+appUser.getRegistrationCode());
			if(StringUtils.isEmpty(appUser.getRegistrationCode())){
				throw new UsernameNotFoundException(
						"User '" + username + "' activation not found.");
			}
			LocalDate localDate=null;
			
			if(encryptionConfig!=null  && encryptionConfig.getEnabled()!=null && 
					(encryptionConfig.getEnabled().equalsIgnoreCase("true") || encryptionConfig.getEnabled().equalsIgnoreCase("yes"))
			){
				try{
					logger.info("username "+appUser.getEmail());
					String activationCode=	encryptionUtil.decryptText(appUser.getRegistrationCode());
					String[] arr=	activationCode.split("#");
					String date=arr[arr.length-1];
					logger.info("expiry date"+date);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					localDate = LocalDate.parse(date, formatter);
				}catch (Exception ex){
					logger.error("ActivationCode ["+username+"]"+appUser.getRegistrationCode());
					logger.error("exception while regisration paring for user "+username,ex);
					
					throw new UsernameNotFoundException(
							"User '" + username + "' registration code not valid.");
				}
			}

			if(localDate!=null && !LocalDate.now().isBefore(localDate)){
				throw new UsernameNotFoundException(
						"your activation date expired");
			}
			
			logger.info("get token using user----->");

			appUser.setSuperAdmin(false);
			appUser.setOrgAdmin(false);
            List<AppUserRole> appUserRoles= roleRepoIntf.getUserRolesByUserName(appUser.getUsername());

            List<GrantedAuthority> authorities = new ArrayList<>();
            if(appUserRoles!=null && !appUserRoles.isEmpty())
            {
				for(AppUserRole userRole: appUserRoles)
				{
					RoleRights roleRights= roleRepo.getRoleIdByRoleName(userRole.getRolename(),appUser.getOrganizationId());
					userRole.setSid(new ObjectId(roleRights.getId()));
					authorities.add(new SimpleGrantedAuthority(userRole.getRolename().toUpperCase()));
					//set super admin 
					if(UserRoleStatusConstants.ROLE_ADMIN.equals(userRole.getRolename().toUpperCase())){
						appUser.setSuperAdmin(true);
					}
					else if(UserRoleStatusConstants.ROLE_ORG_ADMIN.equals(userRole.getRolename().toUpperCase())){
						appUser.setOrgAdmin(true);
					}
				}
			}else{
            	//// TODO: 24/11/18 we need to provide use a role when he get registered
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			}

            appUser.setAppUserRoles(appUserRoles);
            appUser.setAuthorities(authorities);
            logger.info("loaded app user-----");
            logger.info("appUser-->"+appUser);
            return appUser;
           
        }
        throw new UsernameNotFoundException("User '" + username + "' not found.");
	}
}
