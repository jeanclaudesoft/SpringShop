package com.claudylab.shop.services;

import com.claudylab.shop.models.Cart;
import com.claudylab.shop.models.Vente;
import com.claudylab.shop.repository.CartRepository;
import com.claudylab.shop.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {

    @Autowired
    VenteRepository venteRepository;

    public List<Vente> venteList(){
        return venteRepository.findAll();
    }
    public void saveVente(Vente vente){
        venteRepository.save(vente);
    }
    public void delete(int id){
        venteRepository.deleteById(id);
    }
    public Vente singleVente(int id){
        return venteRepository.findById(id).get();
    }

}
