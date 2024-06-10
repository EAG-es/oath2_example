package inser.spring.oath2_example.service;

import inser.spring.oath2_example.entity.Oauth_userDetail;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import inser.spring.oath2_example.entity.User;
import inser.spring.oath2_example.repository.UserDetailsRepository;


@Service("userDetailsService")
public class Oauth_userDetailsService implements UserDetailsService {
    @Autowired
    public UserDetailsRepository userDetailRepository;
    
    public Oauth_userDetail oauth_userDetail;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDetailRepository.findByUsername(name);
        
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));
        oauth_userDetail = new Oauth_userDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(oauth_userDetail);
        return oauth_userDetail;
    }
}
