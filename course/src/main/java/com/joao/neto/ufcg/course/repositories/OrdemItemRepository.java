package com.joao.neto.ufcg.course.repositories;

import com.joao.neto.ufcg.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemItemRepository extends JpaRepository<OrderItem, Long> {
}
