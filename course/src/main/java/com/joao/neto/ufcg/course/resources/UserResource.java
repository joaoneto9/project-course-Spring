package com.joao.neto.ufcg.course.resources;

import com.joao.neto.ufcg.course.Services.UserService;
import com.joao.neto.ufcg.course.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) { // com "?" eu nao determino o tipo do retorno presente no ResponseEntity
        User user = userService.findById(id);
        
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado."); // resposta em Json para caso o User nao seja encontrado

        return ResponseEntity.ok().body(user); // retorna o Objeto que foi buscado pelo service em Json
    }

    @PostMapping("/send")
    public boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(value = "/remove/{id}")
    public boolean removeUserById(@PathVariable Long id) {
        return userService.removeUserById(id);
    }
}
