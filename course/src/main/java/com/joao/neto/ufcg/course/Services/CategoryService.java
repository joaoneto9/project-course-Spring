package com.joao.neto.ufcg.course.Services;

import com.joao.neto.ufcg.course.entities.Category;
import com.joao.neto.ufcg.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        if (categoryRepository.findById(id).isEmpty())
            return null;
        return categoryRepository.findById(id).get();
    }

    public void SaveCategory(Category category) {
        categoryRepository.save(category);
    }
}
