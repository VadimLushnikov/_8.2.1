package org.example.authorization.config;

import org.example.authorization.exceptions.InvalidCredentials;
import org.example.authorization.exceptions.UnauthorizedUser;
import org.example.authorization.repository.UserRepository;
import org.example.authorization.service.AuthorizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public AuthorizationService authorizationService(UserRepository userRepository){
        return new AuthorizationService(userRepository);
    }
    @Bean
    public UserRepository userRepository(){
        return new UserRepository("vadik","111");
    }
//    @Bean
//    public InvalidCredentials invalidCredentials(){
//        return new InvalidCredentials();
//    }
//    @Bean
//    public UnauthorizedUser unauthorizedUser(){
//        return new UnauthorizedUser();
//    }
}
