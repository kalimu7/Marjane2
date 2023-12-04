package com.brief.marjane2.controller;


import com.brief.marjane2.entity.AdminCentre;
import com.brief.marjane2.entity.Promotion;
import com.brief.marjane2.service.AdminCenterService;
import com.brief.marjane2.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Center")
public class AdminCenterController {


    private final AdminCenterService adminCenterService;

    @Autowired
    private  PromotionService promotionService;

    @Autowired
    public AdminCenterController(AdminCenterService adminCenterService) {

        this.adminCenterService = adminCenterService;
    }

    /*@Autowired
    private AdminCenterRepository adminCenterRepository;
     */

    @PostMapping("/admin")
    public ResponseEntity create(@RequestBody AdminCentre adminCentre){
        return this.adminCenterService.create(adminCentre);
    }
    @GetMapping("/admin")
    public List<AdminCentre> fetchAll(){
        return this.adminCenterService.fetchall();
    }

    @GetMapping("/admin/{id}")
    public Optional<AdminCentre> findByid(@PathVariable("id") int id){
        return this.adminCenterService.findByid(id);
    }

    @PutMapping("admin")
    public ResponseEntity update(@RequestBody AdminCentre adminCentre){
        return this.adminCenterService.Update(adminCentre);
    }

    @DeleteMapping("admin")
    public ResponseEntity delete(@RequestBody AdminCentre adminCentre){
        return this.adminCenterService.delete(adminCentre);
    }

    @PostMapping("/promotion")
    public ResponseEntity createPromotion(@RequestBody Promotion promotion){

        return promotionService.create(promotion);

    }


}
