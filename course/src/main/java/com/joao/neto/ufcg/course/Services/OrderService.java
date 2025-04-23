package com.joao.neto.ufcg.course.Services;

import com.joao.neto.ufcg.course.entities.Order;
import com.joao.neto.ufcg.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findByID(Long id) {
        if (orderRepository.findById(id).isEmpty())
            return null;
        return orderRepository.findById(id).get();
    }

    public void saveOrder(Order order) {
       orderRepository.save(order);
    }
}
