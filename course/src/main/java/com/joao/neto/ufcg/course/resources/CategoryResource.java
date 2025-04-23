package com.joao.neto.ufcg.course.resources;

import com.joao.neto.ufcg.course.Services.CategoryService;
import com.joao.neto.ufcg.course.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories() {
        return ResponseEntity.ok().body(categoryService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById( @PathVariable Long id) {
        if (categoryService.findById(id) == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nao existe essa acategoria");

        return ResponseEntity.ok().body(categoryService.findById(id));
    }

    @PostMapping(value = "/send")
    public void saveCategory( @RequestBody Category category) {
        categoryService.SaveCategory(category);
    }

}
