package org.example.authorization.service;

import org.example.authorization.Authorities;
import org.example.authorization.User;
import org.example.authorization.exceptions.InvalidCredentials;
import org.example.authorization.exceptions.UnauthorizedUser;
import org.example.authorization.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository;
    public AuthorizationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

//    public List<Authorities> getAuthorities(String user, String password) {
//        if (isEmpty(user) || isEmpty(password)) {
//            throw new InvalidCredentials("User name or password is empty");
//        }
//        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
//        if (isEmpty(userAuthorities)) {
//            throw new UnauthorizedUser("Unknown user " + user);
//        }
//        System.out.println(userAuthorities+" userAuthorities");
//        return userAuthorities;
//    }
    public List<Authorities> getAuthoritiesList(User user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST,new InvalidCredentials("User name or password is empty").getMessage());
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            //throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,new InvalidCredentials("Unknown user " + user).getMessage());
            throw new UnauthorizedUser("Unknown user " + user);
        }
        System.out.println(userAuthorities+" userAuthorities");
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
