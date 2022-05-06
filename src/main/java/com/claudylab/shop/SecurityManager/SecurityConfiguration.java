package com.claudylab.shop.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/").hasRole("ADMIN")
                .antMatchers("/category/list").hasRole("ADMIN")
                .antMatchers("/category/add").hasRole("ADMIN")
                .antMatchers("/article/list").hasRole("ADMIN")
                .antMatchers("/article/add").hasRole("ADMIN")
                .antMatchers("/appro").hasRole("ADMIN")
                .antMatchers("/users/list").hasRole("ADMIN")
                .antMatchers("/vente/new").hasRole("ADMIN")
                .antMatchers("/vente/cart/{id}").hasRole("ADMIN")
                .antMatchers("/ventes/list").hasRole("ADMIN")

                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
