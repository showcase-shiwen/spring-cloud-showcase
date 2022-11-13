package org.showcase.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * 1.此处使用的
 *  ResourceServerConfigurerAdapter是spring-security-oauth2中的，
 *  WebSecurityConfigurerAdapter是spring-security-config中的；
 *
 * 2.同时使用上面的两种配置的时候，如果两者配种存在重写相同的方法时，
 * 后者的会出现配置不生效的问题，比如重写了configure这个方法（参数final不影响）
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.formLogin()
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/actuator/**",
                        "/oauth/**",
                        "/login/**",
                        "/oauth/token",
                        "/v2/api-docs").permitAll()//放行上面配置的地址
                .anyRequest().authenticated()//其它都需要权限
                .and().csrf().disable();//禁用跨域
        ;
        ;
    }
}
