package com.claudylab.shop.controllers;

import com.claudylab.shop.models.Category;
import com.claudylab.shop.models.Product;
import com.claudylab.shop.services.ArticleyService;
import com.claudylab.shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleyService articleyService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public String viewCategories(Model model){
        model.addAttribute("articleList",articleyService.ProductList());
        return "Product/productList";
    }

    @GetMapping("/add")
    public String addView(Model model){
        model.addAttribute("categoryList",categoryService.categoryList());
        return "Product/addProduct";
    }

    @PostMapping("/save")
    public String saveCategory(Product product){
        articleyService.createProduct(product);
        return "redirect:/article/list";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") int id,Model model){
        model.addAttribute("singleCategory",articleyService.singleProduct(id));
        return "Product/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product){
        articleyService.createProduct(product);
        return "redirect:/article/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id){
        articleyService.deleteProduct(id);
        return "redirect:/article/list";
    }

}
