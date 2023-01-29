package org.example.authorization.repository;

import org.example.authorization.Authorities;

import java.util.List;

public class UserRepository {
    String user;
    String password;
    public UserRepository(String user,String password) {
        this.user=user;
        this.password=password;
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if(this.user.equals(user)&this.password.equals(password)) {
            return List.of(Authorities.values());
        }else{
            return null;
        }
    }
}
