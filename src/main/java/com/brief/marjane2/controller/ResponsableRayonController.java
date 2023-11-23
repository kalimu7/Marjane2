package com.brief.marjane2.controller;


import com.brief.marjane2.entity.Category;
import com.brief.marjane2.entity.Product;
import com.brief.marjane2.entity.Promotion;
import com.brief.marjane2.entity.ResponsableRayon;
import com.brief.marjane2.repository.ProductRepository;
import com.brief.marjane2.repository.ResponsableRayonRepository;
import com.brief.marjane2.service.ResponsableRayonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Responsable")
public class ResponsableRayonController {
    
    @Autowired
    private ResponsableRayonRepository responsableRayonRepository;

    @Autowired
    private ResponsableRayonService responsableRayonService;

   @PostMapping("/rayon")
   public ResponseEntity<String> create(@RequestBody ResponsableRayon responsableRayon){


       return responsableRayonService.create(responsableRayon);

   }

   @PostMapping("/category")
   public ResponseEntity<String> createcategory(@RequestBody Category category){
       return responsableRayonService.createcategory(category);
   }

   @PostMapping("/product")
    public ResponseEntity<String> createProduct(@RequestBody Product product ){
       return responsableRayonService.createProduct(product);
   }

   @GetMapping("/category")
    public List<Category> fetch(){
       return responsableRayonService.fetchCategory();
   }

   @GetMapping("/promotion")
    public List<Promotion> promo(){
       return responsableRayonService.promo();
       //todo: return null;
   }

   @PostMapping("/promo/{titre}")
   public List<Promotion> promoByResponsanle(@PathVariable String titre){

       return responsableRayonService.promotion(titre);


   }

   @PutMapping("/promo")
   public ResponseEntity valide(@RequestBody Promotion promotion){
       return responsableRayonService.valide(promotion);
   }




}
