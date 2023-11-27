package com.brief.marjane2.service;

import com.brief.marjane2.dto.ProductDto;
import com.brief.marjane2.dto.PurchaseDto;
import com.brief.marjane2.entity.*;
import com.brief.marjane2.mapper.ProductMapper;
import com.brief.marjane2.mapper.PurchaseMapper;
import com.brief.marjane2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CaissierService {

    @Autowired
    private CaissierRepository caissierRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CarteFidilteRepository carteFidilteRepository;





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



    public String BuyProduct(PurchaseDto purchaseDto){
        Optional<Product> product = productRepository.findById(purchaseDto.getProductid());
        if(product.isPresent()){
            //i will check also quantity
            Product Ap = product.get();
            if(Ap.getQuantite() == 0){
                // todo:handle this situation
            return "sold out";
            }else{

            Ap.setQuantite(Ap.getQuantite() -  1);
            productRepository.save(Ap);

            Purchases purchases =  PurchaseMapper.inst.toEntity(purchaseDto);
            purchases.setDate(LocalDate.now());
            purchaseRepository.save(purchases);
            //todo:here i have to add points to card fidilite
            Optional<Client> client  = clientRepository.findById(purchaseDto.getClientid());
            Client client1 =  client.get();
            CarteFidelité carteFidelité = carteFidilteRepository.findByClient(client1);
            carteFidelité.setAmount(carteFidelité.getAmount() + 1);
            carteFidilteRepository.save(carteFidelité);

            return "purchase success";
            }

        }else {
            //todo:here i have to handle that there is no product
        return "product not found";

        }


    }

}
