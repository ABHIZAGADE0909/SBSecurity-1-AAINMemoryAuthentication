package com.abhay.sb.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("ABC").password("{noop}ABC").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("ABHAY").password("{noop}ABHAY").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("TEST").password("{noop}TEST").authorities("GUEST");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		http.authorizeRequests().antMatchers("/home").permitAll();
		
		http.authorizeRequests().antMatchers("/admin").hasAuthority("ADMIN");
		
		http.authorizeRequests()
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.anyRequest().authenticated()
		
		
		.and()
		.formLogin()
		.defaultSuccessUrl("/profile",true)
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		;
		
		
		
		
		
	}

}
