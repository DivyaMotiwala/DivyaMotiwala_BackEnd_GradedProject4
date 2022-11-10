package com.divyamotiwala.gradedproject4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.divyamotiwala.gradedproject4.service.DomainUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final DomainUserDetailsService userDetailsService;
	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());

	}
	
	//Authorization
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().disable();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		httpSecurity
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/v1/employees/**")
					.hasAnyRole("USER", "ADMIN")
				.antMatchers("/h2-console/**", "/login/**")
					.permitAll()
				.antMatchers(HttpMethod.GET, "/api/v1/users/**")
					.permitAll()
				.antMatchers(HttpMethod.GET, "/api/v1/roles/**")
					.permitAll()
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/v1/employees/**")
					.hasRole("ADMIN")
					.antMatchers(HttpMethod.PUT, "/api/v1/employees/**")
					.hasRole("ADMIN")
					.antMatchers(HttpMethod.DELETE, "/api/v1/employees/**")
					.hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/v1/users/**")
					.permitAll()
				//.antMatchers(HttpMethod.POST, "/api/v1/roles/**")
					//.permitAll()
			.anyRequest()
				.authenticated()
			.and()
				.formLogin()
			.and()
				.httpBasic()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(); 	
	}
}
