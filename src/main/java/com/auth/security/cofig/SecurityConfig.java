package com.auth.security.cofig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@Configuration
@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	 * @Autowired private AuthenticationManager authenticationManager;
	 */
	
	@Autowired
	private UserDetailsService userDetailsService;
	
//	@Bean
//	public UserDetailsService getUserDetailsService() {
//		return new UserDetailsServiceImpl();
//	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	protected AuthenticationManager getauthenticationManager() throws Exception {
	    return super.authenticationManagerBean();
	}
	
	/* configure methods */
	
	  @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	    provider.setPasswordEncoder( passwordEncoder() );
	    provider.setUserDetailsService(userDetailsService);
	    return provider;
	  }

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	   
		auth
	//	.inMemoryAuthentication() .withUser("peter").password(passwordEncoder().encode("123456")).roles("USER");
		.authenticationProvider(authenticationProvider()).userDetailsService(userDetailsService);
	            
	    
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		 .antMatcher("/**")
         .authorizeRequests()
         .antMatchers("/oauth/authorize**", "/login**", "/error**")
         .permitAll()
     .and()
         .authorizeRequests()
         .anyRequest().authenticated()
     .and()
         .formLogin().permitAll()
         .and().csrf().disable();
          
 }
      
	}
	
	


