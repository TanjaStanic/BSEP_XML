package project.xml.AgentMegaTravel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import project.xml.AgentMegaTravel.filter.AuthenticationTokenFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
	securedEnabled = true,
	jsr250Enabled = true,
	prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
    public AuthenticationTokenFilter authenticationFilter() throws Exception {
		AuthenticationTokenFilter authenticationFilter = new AuthenticationTokenFilter();

        authenticationFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationFilter;
    }
	
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			
			//*
			 /*.authorizeRequests()

			//.antMatchers("/api/*").permitAll()*/
			.authorizeRequests()
			.antMatchers("/auth/**").permitAll()
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated().and();
			/*.antMatchers("/h2console/*").permitAll()
			//.antMatchers("/ws/*").permitAll()
			//.antMatchers("/ws").permitAll()/*/
			//.antMatchers("/api/accommodations/allAdditionalServices").permitAll()
			//.antMatchers("/hello").permitAll()

			//.antMatchers("/api/accobject/*").permitAll()
			//.antMatchers("/api/accommodations/*").permitAll()
			//.antMatchers("/api/addresses/test2").permitAll()
			//.antMatchers("/api/comment/*").permitAll()
			//.anyRequest().authenticated().and()
			
			
			//.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		http.csrf().disable();
	  
	  }
	}
