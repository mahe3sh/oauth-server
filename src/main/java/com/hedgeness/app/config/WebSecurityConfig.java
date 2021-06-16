/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

//import com.hedgeness.app.config.filter.JwtRequestFilter;
import com.hedgeness.app.user.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static String REALM = "WEB_APP_REALM";

//	@Autowired
//	private CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;

	@Autowired
	UserServiceImpl userimpl;
	
	//@Autowired
	//private JwtRequestFilter jwtRequestFilter;
	
	/*
	 * @Bean public PasswordEncoder encoder() { return new BCryptPasswordEncoder();
	 * }
	 */
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("admin").password("p$$d").roles(UserRoleStatusConstants.ROLE_ADMIN);
		//auth.inMemoryAuthentication().withUser("user").password("p$$d").roles(AppRolesConstant.ROLE_USER);
		auth.userDetailsService(userimpl);
	}
	
	
/*	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated().and()
	                .httpBasic().and().csrf().disable();
	    }
	*/
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().disable().csrf().disable()
		.authorizeRequests().antMatchers("/basic/secure/login").permitAll()
				.antMatchers("/userVerification/**").permitAll()
				//all allowed for analytical service for vait 
				.antMatchers("/analytic/processvait/**").permitAll()
				.antMatchers("/analytic/processRetirementPlan/**").permitAll()
				.antMatchers("/v2/api-docs/**",
						"/swagger-ui.html", "/webjars/**", "/swagger-resources/**").permitAll()
				.antMatchers("/oauth/token").permitAll()
				.antMatchers("/*")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.anyRequest().authenticated()
					.and().
					exceptionHandling().
				and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.NEVER).and().authorizeRequests()
			.requestMatchers(CorsUtils::isCorsRequest).permitAll();
		//httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.requestMatchers(CorsUtils::isCorsRequest).permitAll()
				.antMatchers("/userVerification/**").permitAll()
				//all allowed for analytical service for vait 
				.antMatchers("/analytic/processvait/**").permitAll()
				.antMatchers("/analytic/processRetirementPlan/**").permitAll()
				.antMatchers("/v2/api-docs/**",
						"/swagger-ui.html", "/webjars/**", "/swagger-resources/**").permitAll()
				.antMatchers("/oauth/token").permitAll()
				.antMatchers("/*")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.anyRequest().authenticated().and().httpBasic()
				.realmName(REALM).authenticationEntryPoint(customBasicAuthenticationEntryPoint).and().csrf().disable()
				.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);

	}

*/

	// @Order(2)
	// @Configuration
	// public static class FormLoginWebSecurityConfigurerAdapter extends
	// WebSecurityConfigurerAdapter {
	//
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http
	// .authorizeRequests()
	// .anyRequest().authenticated()
	// .and()
	// .formLogin();
	// }
	// }
	// @Configuration
	// @Order(3)
	// public static class ApiWebSecurityConfigurationAdapter extends
	// WebSecurityConfigurerAdapter {
	// protected void configure(HttpSecurity http) throws Exception {
	// http
	// .antMatcher("/api/**")
	// .authorizeRequests()
	// .anyRequest().hasRole("ADMIN")
	// .and()
	// .httpBasic();
	// }
	// }

	@Override
	public void configure(WebSecurity web) throws Exception { // To allow Pre-flight [OPTIONS] request from browser
		web.ignoring().antMatchers(
				HttpMethod.OPTIONS, "/**"
				,"/v2/api-docs/**"
				,"/configuration/ui/**",
				"/swagger-resources/**",
				"/configuration/security/**");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
}
