package com.hadialaoui.spring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Abdelhakim
 *
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		////////////////// Memory Authentication \\\\\\\\\\\\\\\\\\\\
		/*auth.inMemoryAuthentication()
		.withUser("hadialaoui").password("hadialaoui").roles("USER")
		.and()
		.withUser("admin").password("admin").roles("ADMIN");*/
		
		
		////////////////// Default Authentication (h2) \\\\\\\\\\\\\\\\\\\\
		/*auth.jdbcAuthentication()
		.dataSource(dataSource).withDefaultSchema()
		.withUser(
				User.withUsername("admin2")
				.password("admin2")
				.roles("ADMIN"))
		.withUser(
				User.withUsername("hadialaoui2")
				.password("hadialaoui2") 
				.roles("USER"));*/
		
		//////////////////Default Tables USERS/AUTHORITIERS Authentication (h2) \\\\\\\\\\\\\\\\\\\\
		/*auth.jdbcAuthentication()
		.dataSource(dataSource);*/
		
		//////////////////custom Tables myusers/myauthorities Authentication (h2) \\\\\\\\\\\\\\\\\\\\
		/*auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from myusers where username = ? ")
		.authoritiesByUsernameQuery("select username, authority from myauthorities where username = ?");*/
		
		//////////////////Authentication (MySQL) \\\\\\\\\\\\\\\\\\\\
		auth.userDetailsService(userDetailsService);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/users").hasRole("ADMIN")
		.antMatchers("/helloWorld").hasAnyRole("USER","ADMIN")
		
		.antMatchers("/").permitAll()
		.and().formLogin();
	}


	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
    
}
