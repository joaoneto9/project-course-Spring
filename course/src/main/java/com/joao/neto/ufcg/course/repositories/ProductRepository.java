package com.joao.neto.ufcg.course.repositories;

import com.joao.neto.ufcg.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
}
