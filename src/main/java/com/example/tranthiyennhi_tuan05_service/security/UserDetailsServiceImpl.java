package com.example.tranthiyennhi_tuan05_service.security;

import java.util.Arrays;
import java.util.List;

import com.example.tranthiyennhi_tuan05_service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final List<User> users = Arrays.asList(
                new User(1, "tubean", encoder.encode("12345"), "USER"),
                new User(2, "admin", encoder.encode("12345"), "ADMIN")
        );


        for (User appUser : users) {
            if (appUser.getUsername().equals(username)) {
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());

            }
        }

        throw new UsernameNotFoundException("Username: " + username + " not found");
    }
}
