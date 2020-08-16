package com.gov.hack.demo.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class WebConfiguration {
@SuppressWarnings({"rawtypes","unchecked"})
@Bean
ServletRegistrationBean h2servletRegistration(){
		
		ServletRegistrationBean registartionBean= new ServletRegistrationBean(new WebServlet());
		
		registartionBean.addUrlMappings("/console/*");
		return registartionBean;
	}

}
