package com.joao.neto.ufcg.course.resources;

import com.joao.neto.ufcg.course.Services.UserService;
import com.joao.neto.ufcg.course.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users") // mapeia, nomeiando o Local
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping // responde a requisicao GET http.
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok().body(userService.findAll()); // retorna um body em Json de uma Lista de Users
    }

}
