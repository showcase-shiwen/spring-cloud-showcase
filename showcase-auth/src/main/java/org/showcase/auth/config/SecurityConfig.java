package org.showcase.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

/**
 * 该配置类，主要处理⽤户名和密码的校验等事宜
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
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
    //配置过滤
    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.
                    csrf().disable()
                    .authorizeRequests()
                    .anyRequest().authenticated()//其他需要权限
                    .and()
                    .formLogin().permitAll();//放行登录接口（表单）
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("lishiwen")
                .password(passwordEncoder().encode("123456")).authorities(new ArrayList<>())
        ;
    }
}
