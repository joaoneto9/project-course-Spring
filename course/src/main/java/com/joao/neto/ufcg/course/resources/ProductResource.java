package com.joao.neto.ufcg.course.resources;

import com.joao.neto.ufcg.course.Services.ProductService;
import com.joao.neto.ufcg.course.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findByid(@PathVariable Long id) {
        if (productService.findByid(id) == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto nao encontrado");

        return ResponseEntity.ok().body(productService.findByid(id));
    }

    @PostMapping(value = "/send")
    public ResponseEntity<String> saveProduct( @RequestBody Product product) {
        if (productService.saveProduct(product))
            return ResponseEntity.status(HttpStatus.CREATED).body("produto Adicionado com sucesso");
        return ResponseEntity.status(HttpStatus.CONFLICT).body("produto ja existe com esse nome");
    }
}
