package com.joao.neto.ufcg.course.repositories;

import com.joao.neto.ufcg.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
