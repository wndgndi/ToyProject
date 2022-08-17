package com.fastcampus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fastcampus.security.jpa.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/auth/**", "/images/**", "/webjars/**", "/getBlog/**", "/blog/**").permitAll();
		
		http.authorizeRequests().anyRequest().authenticated();
		http.csrf().disable();
		
		http.formLogin().loginPage("/auth/login");
						
		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
		
	
		return http.build();
	}
	
	
	
}
