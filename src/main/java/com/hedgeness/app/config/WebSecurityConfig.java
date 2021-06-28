/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsUtils;

//import com.hedgeness.app.config.filter.JwtRequestFilter;
import com.hedgeness.app.user.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	UserServiceImpl userimpl;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
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
		.authorizeRequests()
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
	}

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
