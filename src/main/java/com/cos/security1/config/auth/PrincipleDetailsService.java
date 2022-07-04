package com.cos.security1.config.auth;

import com.cos.security1.model.UserData;
import com.cos.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipleDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    //유저 정보 조회
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        UserData userData = userRepository.findByUsername(username);
        if(username!=null){
            return new PrincipalDetails(userData);
            //함수 종료시 @auth 어노테이션 만들어짐
        }
        return null;
    }
}
