package br.edu.infnet.lojavirtual.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends 
   WebSecurityConfigurerAdapter
{
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
			  .csrf()
			  .disable()
			  .authorizeRequests()
			  .anyRequest()
			  .authenticated()
			  .and()
			  .httpBasic();
	
	}
	
	//AUTENTICAÇAO COM PAGINA DE LOGIN
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		   .authorizeRequests().antMatchers("/").permitAll()
//		   .anyRequest().authenticated()
//		   .and()
//		   .formLogin().permitAll()
//		   .and()
//		   .logout().permitAll();
//		
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		  .inMemoryAuthentication()
		  .withUser("admin").password("{noop}passwd").roles("ADMIN")
		  .and()
		  .withUser("user").password("{noop}user00").roles("USER");
	}
	
	
	
}
