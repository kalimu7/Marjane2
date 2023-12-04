package com.brief.marjane2.controller;


import com.brief.marjane2.dto.CategoryDto;
import com.brief.marjane2.dto.PromotionDto;
import com.brief.marjane2.entity.Category;
import com.brief.marjane2.entity.Product;
import com.brief.marjane2.entity.Promotion;
import com.brief.marjane2.entity.ResponsableRayon;
import com.brief.marjane2.mapper.CategotyMapper;
import com.brief.marjane2.mapper.PromotionMapper;
import com.brief.marjane2.repository.ProductRepository;
import com.brief.marjane2.repository.ResponsableRayonRepository;
import com.brief.marjane2.service.ResponsableRayonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Responsable")
public class ResponsableRayonController {

    private  int PN;
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
    public List<CategoryDto> fetch(){
       List<CategoryDto> categoryDtos = new ArrayList<>();
       List<Category> categories = responsableRayonService.fetchCategory();
       for(Category cat : categories){
           categoryDtos.add( CategotyMapper.categotyMapper.toDto(cat) );
       }
       //return responsableRayonService.fetchCategory();
       return categoryDtos;

   }

   @GetMapping("/promotion/")
    public List<PromotionDto> promo(@RequestParam int pg){

       Page<Promotion> promotions =  responsableRayonService.promo(pg);
       List<PromotionDto> promotionDtos = new ArrayList<>();

       this.PN =  promotions.getTotalPages();
       for(Promotion p : promotions){
           promotionDtos.add(PromotionMapper.PM.toDto(p));
       }
       return promotionDtos;
   }
   @GetMapping("/PNumbers")
   public int PNumber(){
       return this.PN;
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
