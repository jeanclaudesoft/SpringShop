package com.claudylab.shop.controllers;

import com.claudylab.shop.models.Product;
import com.claudylab.shop.models.Vente;
import com.claudylab.shop.services.ArticleService;
import com.claudylab.shop.services.CartService;
import com.claudylab.shop.services.CategoryService;
import com.claudylab.shop.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/ventes")
public class VenteController {

    @Autowired
    private VenteService venteService;

    @Autowired
    private CartService cartService;
    @Autowired
    private ArticleService articleService;


    @GetMapping("/list")
    public String viewCategories(Model model){
        model.addAttribute("venteList", venteService.venteList());
        return "Ventes/venteList";
    }


    @PostMapping("/{cartId}/save")
    public String saveVente(@PathVariable("cartId") String id,Vente vente){
        System.out.println("MON ID " + cartService.cartList(id).get(1).getProduct().getId());
        for (int i = 0; i <  cartService.cartList(id).size(); i++) {
            articleService.minusStock(cartService.cartList(id).get(i).getProduct().getId(),cartService.cartList(id).get(i).getQuantity());
        }
        vente.setDate(LocalDate.now());
        vente.setCartId(id);
        venteService.saveVente(vente);

        return "redirect:/ventes/recu/"+vente.getId();
    }

    @GetMapping("/recu/{id}")
    public String updateView(@PathVariable("id") int id,Model model){
        model.addAttribute("singleVente", venteService.singleVente(id));
        model.addAttribute("products",cartService.cartList(venteService.singleVente(id).getCartId()));
        return "Ventes/recu";
    }
    @GetMapping("/delete/{id}")
    public String deleteVente(@PathVariable("id") int id){
        venteService.delete(id);
        return "redirect:/ventes/list";
    }


}
