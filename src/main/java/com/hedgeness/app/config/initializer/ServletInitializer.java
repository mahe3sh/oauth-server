/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.config.initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.hedgeness.app.OAuth2ServerApplication;

/**
 * It is needed to run a SpringApplication from a WAR deployment
 * 
 * @author Pavan
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OAuth2ServerApplication.class);
	}

}
