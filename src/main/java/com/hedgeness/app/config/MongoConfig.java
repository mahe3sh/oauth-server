/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

/**
 * Mongo db configurations for mongo db connection.
 * 
 * @author Pavan
 *
 */
@Configuration
public class MongoConfig {

	// inject via application.properties
	@Value("${spring.data.mongodb.host}")
	private String mongoHost;

	// inject via application.properties
	@Value("${spring.data.mongodb.database}")
	private String mongoDB;

	// inject via application.properties
	@Value("${spring.data.mongodb.port}")
	private int mongoPort;

	// inject via application.properties
	// @Value("${spring.data.mongodb.username}")
	// private String dbUserName;

	// inject via application.properties
	// @Value("${spring.data.mongodb.password}")
	// private String dbPassword;

	/**
	 * produces a MongoTemplate bean to be managed by the Spring container.
	 * 
	 * @author Pavan
	 * @return MongoTemplate instance
	 * @throws Exception
	 */
	public @Bean MongoTemplate mongoTemplate() throws Exception {

		// If MongoDB in secure mode, authentication is required.
		// MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient(mongoHost,
		// mongoPort), mongoDB,new UserCredentials(dbUserName, dbPassword));

		// If MongoDB in secure mode in un secured mode
		MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient(mongoHost, mongoPort), mongoDB);

		return mongoTemplate;

	}
}
