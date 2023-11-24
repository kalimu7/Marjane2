package com.brief.marjane2.service;

import com.brief.marjane2.entity.Category;
import com.brief.marjane2.entity.Product;
import com.brief.marjane2.entity.Promotion;
import com.brief.marjane2.entity.ResponsableRayon;
import com.brief.marjane2.enums.category;
import com.brief.marjane2.observer.PromotionManager;
import com.brief.marjane2.repository.CategoryRepository;
import com.brief.marjane2.repository.ProductRepository;
import com.brief.marjane2.repository.PromotionRespository;
import com.brief.marjane2.repository.ResponsableRayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResponsableRayonService {



    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ResponsableRayonRepository responsableRayonRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PromotionRespository promotionRespository;

    private LocalTime before = LocalTime.parse("08:00");
    private LocalTime after = LocalTime.parse("12:00");

    public ResponseEntity<String> create(ResponsableRayon responsableRayon){
        try {
            responsableRayon.setPassword(passwordEncoder.encode(responsableRayon.getPassword()));
            responsableRayonRepository.save(responsableRayon);
            return  new ResponseEntity<>("created", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("not created",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> createcategory(Category category){
        try{
            categoryRepository.save(category);
            return  new ResponseEntity<>("created", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("not created",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity createProduct(Product product){
        try{


            return  ResponseEntity.ok(productRepository.save(product));
        }catch (Exception e){
            return new ResponseEntity<>("not created",HttpStatus.BAD_REQUEST);
        }
    }
    public List<Category> fetchCategory(){

            return categoryRepository.findAll();

    }

    public List<Promotion> promo(){
            return promotionRespository.findAll();
    }

    public List<Promotion> promotion(String title){
        category categoryEnum = category.valueOf(title);
        List<Category> categories =   categoryRepository.findByTitre(categoryEnum);
        List<Promotion> promotions = new ArrayList<>();
        for(Category c : categories){
            promotions.add((Promotion) c.getPromotion());
        }
        return promotions;
    }

    public ResponseEntity valide(Promotion promotion){
        try {
            if (promotion.getDateFin() != null && promotion.getDateDebut() != null) {
                if (LocalDate.now().isAfter(promotion.getDateFin()) || LocalDate.now().isBefore(promotion.getDateDebut())) {
                    // if(LocalTime.now().isAfter(this.before) || LocalTime.now().isBefore(this.after)){
                    //    return new ResponseEntity<>("promblem due to time ",HttpStatus.OK);
                    // }
                    return new ResponseEntity<>("promblem due to time ",HttpStatus.OK);

                }else {
                    promotionRespository.save(promotion);
                    return new ResponseEntity<>("validated ",HttpStatus.OK);
                }
            }

        }catch (Exception e){
            return new ResponseEntity<>("not validated due to time or quantite problems",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);

    }


}
