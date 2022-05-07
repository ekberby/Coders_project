package com.example.web_demo0.config;

import com.example.web_demo0.model.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;


    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/registration**",
                        "/js/**",
                        "/css/**",
                        "/img/**").permitAll()
                .antMatchers(HttpMethod.GET, "/users").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/users").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/trips").hasAnyAuthority("ADMIN", "MODERATOR", "USER")
                .antMatchers(HttpMethod.POST, "/trips").hasAnyAuthority("MODERATOR")
                .antMatchers(HttpMethod.POST, "/trips/{id}").hasAnyAuthority("MODERATOR")
                .antMatchers(HttpMethod.GET, "/trips/new").hasAnyAuthority("MODERATOR")
                .antMatchers(HttpMethod.GET, "/trips/edit/{id}").hasAnyAuthority("MODERATOR")
                .antMatchers(HttpMethod.GET, "/trips/delete/{id}").hasAnyAuthority("MODERATOR")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
}
