package com.auth.security.cofig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestOperations;



@Configuration
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		 .authorizeRequests()
         .antMatchers("/api/**").authenticated()
         .antMatchers("/").permitAll();
	}
//
//	@Bean
//	public RestOperations restTemplate(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext oAuth2ClientContext) {
//		
//		return new OAuth2RestTemplate(resource,oAuth2ClientContext);
//	}
	
}
