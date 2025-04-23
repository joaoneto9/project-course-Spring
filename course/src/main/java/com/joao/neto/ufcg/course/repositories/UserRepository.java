package com.joao.neto.ufcg.course.repositories;

import com.joao.neto.ufcg.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // e opcional pois, JPARepository ja tem essa notacao e por se tratar de heranca nao e necessario.
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); // permite achar por email
}
