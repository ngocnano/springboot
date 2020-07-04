package com.ngoctm.cruddemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		//using jdbc authentication
		auth.jdbcAuthentication().dataSource(dataSource);
		
		//add our users for in memory authentication
		/*UserBuilder user = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser(user.username("ngocnano").password("123456").roles("manager","employee"))
		                             .withUser(user.username("jame").password("123456").roles("ad","employee"))
		                             .withUser(user.username("hulu").password("123456").roles("employee"));
		*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		     .antMatchers("/api/**").permitAll()
		     .antMatchers("/home/**").hasRole("employee")
		     .and()
		     .formLogin();
		     //.loginPage("/showMyLoginPage")
		     //.loginProcessingUrl("/authenticateTheUser")
		     //.permitAll();
		    // .and()
		     //.logout().permitAll()
		    // .and()
		     //.exceptionHandling()
		     //.accessDeniedPage("/access-denied");
	}
}
