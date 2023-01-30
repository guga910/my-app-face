package com.ajudaqui.myappface.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
//	@Autowired
//	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
		  http.authorizeRequests()
//			.antMatchers(HttpMethod.GET, "/boletos/id/*").permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers(HttpMethod.POST,"/users/registred").permitAll()
			.antMatchers(HttpMethod.POST,"/users/login").permitAll()
			.anyRequest().authenticated()
			
//			.and().formLogin();
			.and().csrf().disable() 		
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		  http.authorizeRequests()
//		  .antMatchers("/users/registred")
//		  .permitAll()
//		  .anyRequest()
//		  .authenticated().and().formLogin().and().httpBasic();
		  
		  
//	        http
//	            .authorizeRequests()
//	                .antMatchers("/**").permitAll()
//	                .anyRequest().authenticated()
//	                .and()
//	            .formLogin()
//	                .loginPage("/login")
//	                .permitAll()
//	                .and()
//	            .logout()
//	                .permitAll();
	    }

	    @Bean
	    public AuthenticationManager customAuthenticationManager() throws Exception {
	        return authenticationManager();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	    }
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().exceptionHandling()
//	.authenticationEntryPoint(unauthorizedHandler).and()
//				.exceptionHandling().accessDeniedHandler(accessDeniedHandler())
//	.and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	.and().authorizeRequests().antMatchers("/**")
//				.permitAll().anyRequest().authenticated();
//
//		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//	}

//	   @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http
//	            .authorizeRequests()
//	                .antMatchers("/resources/**", "/registration").permitAll()
//	                .anyRequest().authenticated()
//	                .and()
//	            .formLogin()
//	                .loginPage("/login")
//	                .permitAll()
//	                .and()
//	            .logout()
//	                .permitAll();
//	    }

}
