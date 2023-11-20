package com.brief.marjane2.service;

import com.brief.marjane2.entity.Category;
import com.brief.marjane2.entity.Product;
import com.brief.marjane2.entity.ResponsableRayon;
import com.brief.marjane2.repository.CategoryRepository;
import com.brief.marjane2.repository.ProductRepository;
import com.brief.marjane2.repository.ResponsableRayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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


}
