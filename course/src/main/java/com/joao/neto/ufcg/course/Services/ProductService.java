package com.joao.neto.ufcg.course.Services;

import com.joao.neto.ufcg.course.entities.Product;
import com.joao.neto.ufcg.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByid(Long id) {
        if (productRepository.findById(id).isEmpty())
            return null;
        return productRepository.findById(id).get();
    }

    public boolean saveProduct(Product product) {
        if (productRepository.findByName(product.getName()).isPresent())
            return false;

        productRepository.save(product);
        return true;
    }
}
