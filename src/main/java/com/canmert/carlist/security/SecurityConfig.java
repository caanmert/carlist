package com.canmert.carlist.security;

import java.util.Arrays;

import com.canmert.carlist.filter.AuthenticationFilter;
import com.canmert.carlist.filter.LoginFilter;
import com.canmert.carlist.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * SecurityConfig
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsServiceImpl customUserDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }
  /*
   * @Override protected void configure(AuthenticationManagerBuilder auth) throws
   * Exception{ auth.inMemoryAuthentication()
   * .withUser("admin").password("{noop}admin").roles("ADMIN"); }
   */

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().cors().and().authorizeRequests().antMatchers(HttpMethod.GET, "/cars/**").permitAll()
        .antMatchers("/login").permitAll()
        .anyRequest().authenticated().and()
        .addFilterBefore(new LoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    /*
     * http .httpBasic().and() .authorizeRequests() .antMatchers(HttpMethod.POST,
     * "/cars").hasRole("ADMIN") .antMatchers(HttpMethod.PUT,
     * "/cars/**").hasRole("ADMIN") .antMatchers(HttpMethod.PATCH,
     * "/cars/**").hasRole("ADMIN").and() .csrf().disable();
     */

    // http.httpBasic().and().authorizeRequests().antMatchers("/cars").permitAll();
    // web.ignoring().antMatchers("/cars/**" ,"/models/**");
  }

}