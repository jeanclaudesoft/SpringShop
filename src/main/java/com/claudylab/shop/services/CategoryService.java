package com.claudylab.shop.services;

import com.claudylab.shop.models.Category;
import com.claudylab.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Category> categoryList(){
        return categoryRepository.findAll();
    }

    public Category singleCategory(int categoryId){
        return  categoryRepository.findById(categoryId).get();
    }

    public void deleteCategory(int categoryId){
        categoryRepository.deleteById(categoryId);
    }

    public Long categoryCount(){
        return  categoryRepository.count();
    }


}
