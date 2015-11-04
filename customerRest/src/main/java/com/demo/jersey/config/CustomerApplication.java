package com.demo.jersey.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class CustomerApplication extends ResourceConfig {
	public CustomerApplication() {
		register(RequestContextFilter.class);
		register(JacksonFeature.class);	
	}

}
