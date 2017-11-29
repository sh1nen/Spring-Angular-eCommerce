package com.bookstore.config;

import com.bookstore.services.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PUBLIC_MATCHES = {
            "/css/**",
            "/js/**",
            "/image/**",
            "/book/**",
            "/user/**"
    };

    private Environment env;
    private UserSecurityService userSecurityService;

    @Autowired
    private SecurityConfig(Environment env, UserSecurityService userSecurityService) {
        this.env = env;
        this.userSecurityService = userSecurityService;
    }

    private BCryptPasswordEncoder bCryptPasswordEncoder() {
        return SecurityUtility.passwordEncoder();
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf()
                .disable()
                .cors()
                .disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHES)
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService).passwordEncoder(bCryptPasswordEncoder());
    }
}
