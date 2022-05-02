package com.claudylab.shop.controllers;

import com.claudylab.shop.models.Product;
import com.claudylab.shop.services.ArticleService;
import com.claudylab.shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public String viewCategories(Model model){
        model.addAttribute("articleList", articleService.ProductList());
        model.addAttribute("totalProduct", articleService.ProductCount());
        return "Product/productList";
    }

    @GetMapping("/add")
    public String addView(Model model){
        model.addAttribute("categoryList",categoryService.categoryList());
        return "Product/addProduct";
    }

    @PostMapping("/save")
    public String saveCategory(Product product){
        product.setStockQuantity(0);
        product.setDateCreation(LocalDate.now());
        articleService.createProduct(product);
        return "redirect:/article/list";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") int id,Model model){
        model.addAttribute("singleProduct", articleService.singleProduct(id));
        model.addAttribute("categoryList",categoryService.categoryList());
        return "Product/updateProduct";
    }

    @GetMapping("/appro/{id}")
    public String approvisView(@PathVariable("id") int id,Model model){
        model.addAttribute("singleProduct", articleService.singleProduct(id));
        return "Approvisionnement/addAppro";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product){
        articleService.createProduct(product);
        return "redirect:/article/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id){
        articleService.deleteProduct(id);
        return "redirect:/article/list";
    }

    @GetMapping("/stock")
    public String getAppprovise(Model model){
        model.addAttribute("articleList", articleService.underStocktList());
        return "Product/approvise";
    }

}
