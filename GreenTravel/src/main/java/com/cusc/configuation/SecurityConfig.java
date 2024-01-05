/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.configuation;

import com.cusc.service.impl.UserDetailsServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

/**
 *
 * @author kyqua
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceimpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/admin/boss/**").access("hasRole('ROLE_ADMIN')")
                .and().authorizeRequests().antMatchers("/admin/employee/**").access("hasRole('ROLE_EMPLOYEE')")
                .and().authorizeRequests().antMatchers("/admin/home", "/admin/my-profile", "/admin/change-my-profile", "/admin/change-password")
                .access("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
                .and().authorizeRequests().antMatchers("/customer/**").access("hasRole('ROLE_CUSTOMER')")
                .and().authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests().and().formLogin().loginPage("/login").loginProcessingUrl("/login-process")
                .defaultSuccessUrl("/login-success").failureForwardUrl("/login?err=true").usernameParameter("username")
                .passwordParameter("password");
        http.authorizeRequests().and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout-success");
    }

}
