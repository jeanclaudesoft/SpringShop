package com.claudylab.shop.services;

import com.claudylab.shop.models.Approvisionnement;
import com.claudylab.shop.models.Product;
import com.claudylab.shop.repository.ApproviseRepository;
import com.claudylab.shop.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApproviseService {

    @Autowired
    private ApproviseRepository approviseRepository;

    public void createAppro(Approvisionnement approvisionnement){
        approviseRepository.save(approvisionnement);
    }

    public List<Approvisionnement> approList(){
        return approviseRepository.findAll();
    }

    public Approvisionnement singleAppro(int id){
        return  approviseRepository.findById(id).get();
    }

    public void delete(int id){
        approviseRepository.deleteById(id);
    }

    public Long approCount(){
        return  approviseRepository.count();
    }
    public Long underStockCount(){
        return  approviseRepository.underStockCount();
    }

}
