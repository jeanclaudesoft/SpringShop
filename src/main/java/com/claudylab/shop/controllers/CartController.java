package com.claudylab.shop.controllers;

import com.claudylab.shop.models.Cart;
import com.claudylab.shop.models.Category;
import com.claudylab.shop.services.ArticleService;
import com.claudylab.shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.Charset;
import java.util.Random;

@Controller
@RequestMapping("/vente")
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    ArticleService articleService;

    @GetMapping("/new")
    public String loads(Model model) {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String cartId = buffer.toString();
        model.addAttribute("cartId", cartId);
        model.addAttribute("articleList", articleService.ProductList());
        model.addAttribute("cartList", cartService.cartList(cartId));

        return "Ventes/get";
    }

    @PostMapping("/save/{cartId}")
    public String saveCart(@PathVariable("cartId") String id,Cart cart){
        cart.setCartId(id);
        cartService.saveCart(cart);
        return "redirect:/vente/cart/"+id;
    }

    @GetMapping("/cart/{cartId}")
    public String currentCart(@PathVariable("cartId") String id,Model model) {
        int total=0;
        for(int i =0;i<cartService.cartList(id).size();i++)
        {
            total+=cartService.cartList(id).get(i).getQuantity()*cartService.cartList(id).get(i).getPrice();
        }
        model.addAttribute("cartId", id);
        model.addAttribute("articleList", articleService.ProductList());
        model.addAttribute("cartList", cartService.cartList(id));
        model.addAttribute("total", total);

        return "Ventes/cart";
    }

    @GetMapping("/cart/{cartId}/delete/{id}")
    public String deleteCart(@PathVariable("cartId") String cart,@PathVariable("id") int id){
        cartService.delete(id);
        return "redirect:/vente/cart/"+cart;
    }
}
