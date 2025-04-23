package com.joao.neto.ufcg.course.repositories;

import com.joao.neto.ufcg.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // e opcional pois, JPARepository ja tem essa notacao e por se tratar de heranca nao e necessario.
public interface UserRepository extends JpaRepository<User, Long> {
// nesse caso UserRepository e uma interface que determina as funcionalidade que devem ser implementadas para acessar o banco de dados, geralmente, o CRUD
// essa implementacao ja esta pronta pir si so.

}
