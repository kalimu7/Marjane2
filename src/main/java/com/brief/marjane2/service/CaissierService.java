package com.brief.marjane2.service;

import com.brief.marjane2.dto.ProductDto;
import com.brief.marjane2.entity.Caissier;
import com.brief.marjane2.entity.Product;
import com.brief.marjane2.mapper.ProductMapper;
import com.brief.marjane2.repository.CaissierRepository;
import com.brief.marjane2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaissierService {

    @Autowired
    private CaissierRepository caissierRepository;

    @Autowired
    private ProductRepository productRepository;



    public ResponseEntity create(Caissier caissier){
        try {
            Caissier caissier1 = caissierRepository.save(caissier);
            return ResponseEntity.ok( caissier1 );

        }catch (Exception e){
            return new ResponseEntity<>("not cerated", HttpStatus.OK);
        }
    }

    public List<ProductDto> fetchproduct(){
        List<ProductDto> productDtos = new ArrayList<>();
        productRepository.findAll().forEach(
                product -> {
                    productDtos.add(ProductMapper.productmapper.toDto(product));
                }
        );
        return productDtos;
    }

}
