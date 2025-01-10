package com.example.DIgitalLedgerApp.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringConfigurations {
	
	@Autowired
	UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
        		.csrf().disable()
//                .authorizeHttpRequests(registry -> {
//                    registry
//                        .requestMatchers("/", "/login", "/oauth2/**").permitAll(); // Public URLs
//                    registry.anyRequest().authenticated(); // Secure other URLs
//                })
//                
//                .formLogin(Customizer.withDefaults());
        		
        		
        		.formLogin(form -> form
        			    .loginPage("/login") // Custom login page
        			    .loginProcessingUrl("/login") // Spring Security handles POST /login
        			    .defaultSuccessUrl("/about", true)
        			    .failureUrl("/login")
        			)

                .oauth2Login(oauth -> oauth
                    .loginPage("/") // Use same page for social login
                )
                .build();
    }
    
   
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    	provider.setUserDetailsService(userDetailsService);
    	return provider;
    }
}
