package org.showcase.auth.service;

import org.showcase.auth.vo.ShowCaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("showcaseUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ShowCaseUser showCaseUser = loadUser(username);
        if (showCaseUser == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return showCaseUser;
    }

    private ShowCaseUser loadUser(String username) {
        return ShowCaseUser.builder().username(username).status(0).password(passwordEncoder.encode("123456")).build();

    }
}
