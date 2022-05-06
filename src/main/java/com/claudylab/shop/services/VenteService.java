package com.claudylab.shop.services;

import com.claudylab.shop.models.Cart;
import com.claudylab.shop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public List<Cart> cartList(String ref){
        return cartRepository.getListe(ref);
    }
    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }
    public void delete(int id){
        cartRepository.deleteById(id);
    }
    public Cart singleCart(int id){
        return cartRepository.findById(id).get();
    }

}
