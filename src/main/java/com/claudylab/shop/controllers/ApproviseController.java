package com.claudylab.shop.controllers;

import com.claudylab.shop.models.Approvisionnement;
import com.claudylab.shop.services.ApproviseService;
import com.claudylab.shop.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/appro")
public class ApproviseController {

    @Autowired
    private ApproviseService approviseService;

    @Autowired
    private ArticleService articleService;


    @GetMapping("/list")
    public String viewAppro(Model model){
        model.addAttribute("approList",approviseService.approList());
        model.addAttribute("totalAppro",approviseService.approCount());
        return "Approvisionnement/approList";
    }


    @PostMapping("/save")
    public String saveApprovise(Approvisionnement approvisionnement){
        approvisionnement.setDateAppro(LocalDate.now());
        approviseService.createAppro(approvisionnement);
        articleService.updateStock(approvisionnement.getArticleId(),approvisionnement.getQuantity());
        return "redirect:/article/list";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") int id,Model model){
        model.addAttribute("singleProduct", approviseService.singleAppro(id));
        System.out.println("product data" + approviseService.singleAppro(id).getProduct().getLibelle());
        return "Approvisionnement/edit";
    }



    @PostMapping("/update")
    public String update(@ModelAttribute("approvisionnement") Approvisionnement approvisionnement){
        approviseService.createAppro(approvisionnement);
        return "redirect:/appro/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        approviseService.delete(id);
        return "redirect:/appro/list";
    }

}
