//package com.example.DIgitalLedgerApp.Configurations;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//public class SpringConfigurations {
//	
//	@Autowired
//	UserDetailsService userDetailsService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//        		.csrf().disable()
////                .authorizeHttpRequests(registry -> {
////                    registry
////                        .requestMatchers("/", "/login", "/oauth2/**").permitAll(); // Public URLs
////                    registry.anyRequest().authenticated(); // Secure other URLs
////                })
////                
////                .formLogin(Customizer.withDefaults());
//        		
//        		
//        		.formLogin(form -> form
//        			    .loginPage("/login") // Custom login page
//        			    .loginProcessingUrl("/login") // Spring Security handles POST /login
//        			    .defaultSuccessUrl("/customer/profile", true)
//        			    .failureUrl("/login")
//        			)
//
//                .oauth2Login(oauth -> oauth
//                    .loginPage("/login") // Use same page for social login
//                )
//                .build();
//    }
//    
//   
//    
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//    	DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//    	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//    	provider.setUserDetailsService(userDetailsService);
//    	return provider;
//    }
//}





package com.example.DIgitalLedgerApp.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.DIgitalLedgerApp.Models.Customers;
import com.example.DIgitalLedgerApp.Models.LoggingUsers;
import com.example.DIgitalLedgerApp.Repos.CustomerRepo;
import com.example.DIgitalLedgerApp.Repos.LoggingUsersRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Configuration
public class SpringConfigurations {

    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    CustomerRepo cr;
    
    @Autowired
    LoggingUsersRepo lr;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .successHandler(customSuccessHandler()) // Custom success handler for role-based routing
                                .failureUrl("/login?error")
                )
                .oauth2Login(oauth -> oauth
                                .loginPage("/login")
                                .successHandler(oauthsuccesshandler())
                )
                .build();
    }
    
    @Bean
    public AuthenticationSuccessHandler oauthsuccesshandler() {
    	 return (HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.Authentication authentication) -> {
             // Get the user's role
             DefaultOAuth2User user =(DefaultOAuth2User) authentication.getPrincipal();

             // Route based on role
             String email=user.getAttribute("email").toString();
             String name=user.getAttribute("name").toString();
             
             Customers cust1=cr.getByEmail(email).orElse(null);
              
             if(cust1 == null) {
            	 Customers cust=new Customers();
                 cust.setEmail(email);
                 cust.setUsername(name);
                 cust.setPassword("CUSTOMER");
                 cust.setMobileNumber("0000000000");
                 cust.setPasskey("111");
                 
                 LoggingUsers lu=new LoggingUsers();
                 lu.setUsername(name);
                 lu.setRole("ROLE_CUSTOMER");
                 lu.setPassword("CUSTOMER");
                 
                 cr.save(cust);
                 lr.save(lu);
             }
             response.sendRedirect("/customer/profile");

         };
	}

	@Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(7));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    // Custom Success Handler
    @Bean
    public AuthenticationSuccessHandler customSuccessHandler() {
        return (HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.Authentication authentication) -> {
            // Get the user's role
            String role = authentication.getAuthorities().stream()
                    .findFirst() // Assumes a single role per user
                    .map(authority -> authority.getAuthority())
                    .orElse("");

            // Route based on role
            if (role.equals("ROLE_CUSTOMER")) {
                response.sendRedirect("/customer/profile");
            } else if (role.equals("ROLE_RETAILER")) {
                response.sendRedirect("/retailer/profile");
            } else {
                response.sendRedirect("/login?error=role");
            }
        };
    }
}




















