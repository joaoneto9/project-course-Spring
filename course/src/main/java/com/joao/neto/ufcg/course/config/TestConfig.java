package com.joao.neto.ufcg.course.config;

import com.joao.neto.ufcg.course.entities.User;
import com.joao.neto.ufcg.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration // determina que euma classe de configuracao
@Profile("test") // setermina que e apenas teste
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2)); // salva todas essas intancias no banco quando iniciar a aplicacao.
    }


}
