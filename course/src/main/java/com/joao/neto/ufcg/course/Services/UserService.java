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

        if (userRepository.findByEmail(user.getEmail()).isPresent())
            return false;

        userRepository.save(user);
        return true;
    }

    public boolean removeUserById(Long id) {

        if (!userRepository.findById(id).isPresent())
            return false;

        userRepository.deleteById(id);
        return true;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        if (!userRepository.findById(id).isPresent())
            return null;
        return userRepository.findById(id).get();
    }

}
