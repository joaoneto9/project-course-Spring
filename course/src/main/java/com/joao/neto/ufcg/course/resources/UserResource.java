package com.joao.neto.ufcg.course.resources;

import com.joao.neto.ufcg.course.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users") // mapeia, nomeiando o Local
public class UserResource {

    @GetMapping // responde a requisicao GET http.
    public List<ResponseEntity<User>> findAllUsers() {
        List<ResponseEntity<User>> lista = new ArrayList<>();
        User u = new User(1, "joao", "joao@gmail", "99999", "1234");
        lista.add(ResponseEntity.ok().body(u));
        lista.add(ResponseEntity.ok().body(new User(2, "barbara", "barabara@gmail.com", "98900809", "2222")));
        return lista; // retorna o Body desse User "u"
    }

}
