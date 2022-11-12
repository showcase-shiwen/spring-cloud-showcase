package org.showcase.auth.service;

import org.showcase.auth.vo.ShowCaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if("lirong".equals(username)||"admin".equals(username))
        return  ShowCaseUser.builder().username(username).status(0).password(passwordEncoder.encode("123456")).build();
        throw new UsernameNotFoundException("user not found");
    }
}
