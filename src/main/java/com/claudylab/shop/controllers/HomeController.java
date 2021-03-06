package com.claudylab.shop.controllers;

import com.claudylab.shop.services.ApproviseService;
import com.claudylab.shop.services.ArticleService;
import com.claudylab.shop.services.CategoryService;
import com.claudylab.shop.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ApproviseService approviseService;
    @Autowired
    private VenteService venteService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("totalCategory",categoryService.categoryCount());
        model.addAttribute("totalProduct",articleService.ProductCount());
        model.addAttribute("totalAppro",approviseService.approCount());
        model.addAttribute("totalStock",approviseService.underStockCount());
        model.addAttribute("totalVente",venteService.venteCount());
        model.addAttribute("montantTotal",venteService.totalVente());
        model.addAttribute("allStock",articleService.totalStock());
        return "Home/index";
    }
}
