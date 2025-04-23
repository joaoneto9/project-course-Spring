package com.joao.neto.ufcg.course.resources;

import com.joao.neto.ufcg.course.Services.OrderService;
import com.joao.neto.ufcg.course.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findOrderById(@PathVariable Long id) {
        Order order = orderService.findByID(id);

        if (order == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order nao encontrada");

        return ResponseEntity.ok().body(order);
    }

    @PostMapping(value = "/send")
    public void saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }


}
