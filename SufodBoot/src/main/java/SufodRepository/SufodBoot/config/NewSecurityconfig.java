package SufodRepository.SufodBoot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class NewSecurityconfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/api/**")
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.csrf().ignoringAntMatchers("/api/**")
				.and()
				.authorizeHttpRequests()
				//.antMatchers(HttpMethod.OPTIONS).permitAll()
				.antMatchers(HttpMethod.GET).permitAll()
				
					.antMatchers("/api/**").permitAll()
				.and()
				.httpBasic();
		// @formatter:on
		return http.build();
	}
	
	@Autowired
	private UserDetailsService userDetailService;
	



	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	auth.userDetailsService(userDetailService);		
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
