package com.auth.security.cofig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
	
		security.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated")
		.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
		.inMemory()
        .withClient("clientapp").
         secret(bCryptPasswordEncoder.encode("123456"))
        .authorizedGrantTypes("password", "authorization_code", "refresh_token")
        .authorities("READ_ONLY_CLIENT")
        .scopes("user_info")
        .resourceIds("oauth2-resource")
        
        .redirectUris("http://localhost:8081/login")
        .accessTokenValiditySeconds(3600)
        .refreshTokenValiditySeconds(240000);
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
	
		endpoints.authenticationManager(authenticationManager)
		.userDetailsService(userDetailsService);
	}
	
	
	
	
	
	

	
	     
}
