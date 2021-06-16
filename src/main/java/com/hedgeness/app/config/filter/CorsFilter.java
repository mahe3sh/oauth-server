/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * CORS Filter is for fitting Cross-Origin Resource Sharing (CORS) support to
 * application
 * 
 * @author Pavan
 *
 */

@Component("corsFilter")
public class CorsFilter implements Filter {

	public CorsFilter() { //0-param constructor
		// no code to be added
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, OPTIONS, PATCH");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, X-Requested-With, remember-me, accept, X-Requested-With, authorization, Origin, Access-Control-Request-Method, Access-Control-Request-Headers, user-agent, x-csrftoken, accept-encoding");

		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) {
		// no code to be added
	}

	@Override
	public void destroy() {
		// no code to be added
	}

}
