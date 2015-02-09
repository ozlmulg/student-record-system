package edu.srs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
				.antMatchers("/addStudent/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/student/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
				.antMatchers("/listStudents/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
				.antMatchers("/info/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
				.and().formLogin()
				.and().logout().permitAll();

		http.
				csrf().disable();
		
	}
}