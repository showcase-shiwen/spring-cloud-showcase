package org.showcase.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    //打通数据库
        @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ClientDetailsService clientDetailsService;

//    @Autowired
//    private  TokenStore tokenStore;


    //配置授权服务器的客户端详情
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.withClientDetails(clientDetailsService)
        clients.inMemory()
                .withClient("app")// 客户端id
                .secret(passwordEncoder.encode("appsecret"))// 客户端密码
                .redirectUris("https://www.baidu.com")// 客户端重定向地址
                .scopes("all")// 客户端授权范围
                .authorities("all")// 客户端权限
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")// 客户端授权类型
                .autoApprove(true)// 是否自动授权
                .accessTokenValiditySeconds(3600)// token有效期
                .refreshTokenValiditySeconds(3600);// 刷新token有效期
        // @see org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint
        ///oauth/authorize
        ///oauth/token
        ///oauth/check_token
        ///oauth/confirm_access
        ///oauth/error
        //授权码模式
        //http://localhost:5000/oauth/authorize?response_type=code&client_id=app&redirect_uri=https://www.baidu.com

        //客户端授权类型
        // http://localhost:8033/oauth/authorize?response_type=token&client_id=admin&scop=all
        //密码模式
        //http://localhost:5000/oauth/token?grant_type=password&client_id=app&redirect_uri=https://www.baidu.com&username=lirong&password=123456
    }

    //授权服务器端点配置
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //配置密码编码器
        endpoints
//                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);

//        配置端点

        //扩展token返回结果
    }

    /**
     * 配置认证服务
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .passwordEncoder(passwordEncoder)
                .allowFormAuthenticationForClients();
    }
}
