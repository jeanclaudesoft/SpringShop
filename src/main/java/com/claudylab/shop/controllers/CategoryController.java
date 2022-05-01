package com.claudylab.shop.controllers;

import com.claudylab.shop.models.Category;
import com.claudylab.shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String viewCategories(Model model){
        model.addAttribute("categoryList",categoryService.categoryList());
        return "Category/list";
    }

    @GetMapping("/add")
    public String addView(){
        return "Category/add";
    }

    @PostMapping("/save")
    public String saveCategory(Category category){
        categoryService.createCategory(category);
        return "redirect:/category/list";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") int id,Model model){
        model.addAttribute("singleCategory",categoryService.singleCategory(id));
        return "Category/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("category") Category category){
        categoryService.createCategory(category);
        return "redirect:/category/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id){
        categoryService.deleteCategory(id);
        return "redirect:/category/list";
    }

}
