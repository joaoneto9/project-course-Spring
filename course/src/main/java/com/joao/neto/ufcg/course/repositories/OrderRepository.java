package com.joao.neto.ufcg.course.repositories;

import com.joao.neto.ufcg.course.entities.Order;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
