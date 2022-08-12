package org.fundacionview.SGSST.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class Configutations extends WebSecurityConfigurerAdapter{
	
	private static final String[] unfilteredPages = new String[] {"/**","/login", "/js/**","/css/**"};
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public LoginUrlAuthenticationEntryPoint createDelegateAuthEntryPoint() {
		return new LoginUrlAuthenticationEntryPoint("/login");
	}
	@Bean
	public UserDetailsService createUser() {
		return new SecurityUserDetailsService();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.userDetailsService(createUser()).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http)throws Exception {
		http.authorizeRequests().antMatchers(unfilteredPages).permitAll()
		.anyRequest().fullyAuthenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(createDelegateAuthEntryPoint())
		.accessDeniedPage("/sinpermisos")
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/home")
		.permitAll()
		.and()
		.rememberMe()
		.and()
		.csrf();
	}
}
