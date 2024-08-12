package com.geek.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig  {
	@Autowired
	private UserDetailsService userDetailsService;
	
	//Authentication
	@Autowired
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//authentication provider ... Earlier InMemory authentication
			auth.userDetailsService(userDetailsService);
			
			}
		
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .cors().and().csrf().disable()
	            .authorizeHttpRequests()
	                // Allow POST requests to /register/
	                .requestMatchers(HttpMethod.POST, "/register").permitAll()
	                
	                // Allow access to root and other paths as needed
	                .requestMatchers(HttpMethod.GET, "/").permitAll()
	                
	                // Restrict access to /admin/** and /user/** paths
	             /*  .requestMatchers("/admin/**").hasRole("ADMIN")
	                .requestMatchers("/user/**").hasAnyRole("ADMIN", "USER")
	              */ 
	                // Any other request requires authentication
	                .anyRequest().authenticated()
	            //.anyRequest().permitAll()  
	            .and()
	            .formLogin();  // Enable form-based authentication

	        return http.build();
	    }

	
	  @Bean public PasswordEncoder passwordEncoder() {
		  return NoOpPasswordEncoder.getInstance();
	  }
	  // Use this only for testing. }
	 
}
