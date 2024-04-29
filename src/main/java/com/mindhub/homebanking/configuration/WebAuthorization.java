package com.mindhub.homebanking.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebAuthorization extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN").antMatchers("/**").hasAuthority("USER");

        http.formLogin().usernameParameter("name").passwordParameter("pwd").loginPage("app/login");
        
        http.logout().logoutUrl("app/logout");
    }
}
