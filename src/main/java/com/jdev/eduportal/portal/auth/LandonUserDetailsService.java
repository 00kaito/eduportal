package com.jdev.eduportal.portal.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LandonUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public LandonUserDetailsService(UserRepository userRepository){
        super();
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        if(!optionalUser.isPresent()){
            throw new UsernameNotFoundException("cannot find user: "+ email);
        }
        return new LandonUserPrincipal(optionalUser.get());
    }
}
