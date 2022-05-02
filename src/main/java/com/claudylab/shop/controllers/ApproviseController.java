package com.claudylab.shop.controllers;

import com.claudylab.shop.models.Approvisionnement;
import com.claudylab.shop.models.Product;
import com.claudylab.shop.services.ApproviseService;
import com.claudylab.shop.services.ArticleyService;
import com.claudylab.shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/appro")
public class ArpproviseController {

    @Autowired
    private ApproviseService approviseService;

    @Autowired
    private ArticleyService articleyService;


    @GetMapping("/list")
    public String viewAppro(Model model){
        model.addAttribute("approList",approviseService.approList());
        model.addAttribute("totalAppro",approviseService.approCount());
        return "Approvisionnement/view";
    }


    @PostMapping("/save")
    public String saveApprovise(Approvisionnement approvisionnement){
        approvisionnement.setDateAppro(LocalDate.now());
        approviseService.createAppro(approvisionnement);
        articleyService.updateStock(approvisionnement.getId(),approvisionnement.getQuantity());
        return "redirect:/appro/view";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") int id,Model model){
        model.addAttribute("singleAppro",articleyService.singleProduct(id));
        return "Approvisionnement/edit";
    }



    @PostMapping("/update")
    public String update(@ModelAttribute("approvisionnement") Approvisionnement approvisionnement){
        approviseService.createAppro(approvisionnement);
        return "redirect:/appro/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        approviseService.delete(id);
        return "redirect:/appro/list";
    }

}
