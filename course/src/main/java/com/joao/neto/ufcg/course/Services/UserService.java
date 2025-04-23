package com.joao.neto.ufcg.course.Services;

import com.joao.neto.ufcg.course.entities.User;
import com.joao.neto.ufcg.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // semanticamente mais especifico
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean saveUser(User user) {

        if (userRepository.findById(user.getId()).isPresent())
            return false;

        userRepository.save(user);
        return true;
    }

    public boolean removeUser(User user) {

        if (!userRepository.findById(user.getId()).isPresent())
            return false;

        userRepository.delete(user);
        return true;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
