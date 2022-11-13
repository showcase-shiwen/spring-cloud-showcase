package org.showcase.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

/**
 * 该配置类，主要处理⽤户名和密码的校验等事宜
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
    //配置加密
    @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().csrf().disable().authorizeRequests().anyRequest().fullyAuthenticated();
//        http.formLogin().and().csrf().disable().authorizeRequests().anyRequest().fullyAuthenticated();
        //http.formLogin()
        //                .usernameParameter("username")
        //                .passwordParameter("password")
        //                .loginPage("/admin/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("lishiwen")
                .password(passwordEncoder().encode("123456")).authorities(new ArrayList<>())
        ;
    }
}
