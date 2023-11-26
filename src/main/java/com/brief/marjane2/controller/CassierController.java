package com.brief.marjane2.controller;

import com.brief.marjane2.dto.ProductDto;
import com.brief.marjane2.dto.PurchaseDto;
import com.brief.marjane2.entity.Caissier;
import com.brief.marjane2.entity.Client;
import com.brief.marjane2.entity.Product;
import com.brief.marjane2.entity.Purchases;
import com.brief.marjane2.mapper.PurchaseMapper;
import com.brief.marjane2.service.CaissierService;
import com.brief.marjane2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Caissier")
public class CassierController {


    @Autowired
    private  CaissierService caissierService;

    @Autowired
    private ClientService clientService;




    @PostMapping("")
    public ResponseEntity create(@RequestBody Caissier caissier){
        return caissierService.create(caissier);
    }

    @GetMapping("/product")
    public List<ProductDto> fetch(){
            return caissierService.fetchproduct();
    }




    @PostMapping("/purchase")
    public ResponseEntity BuyProduct(@RequestBody PurchaseDto purchaseDto){
        try {

            String response =  caissierService.BuyProduct(purchaseDto);
            if (response.equals("Purchase successful")) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body(response);
            }

        }catch (Exception e){
            return new ResponseEntity<>("something wring has happned while trying to buy new product", HttpStatus.BAD_REQUEST);
        }
    }



}
