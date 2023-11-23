package com.brief.marjane2;


import com.brief.marjane2.entity.AdminCentre;
import com.brief.marjane2.entity.Category;
import com.brief.marjane2.entity.Promotion;
import com.brief.marjane2.repository.PromotionRespository;
import com.brief.marjane2.service.PromotionService;
import com.marjane.enums.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public class PromotionSerivceTest {

    @Mock
    private PromotionRespository promotionRespository;

    @InjectMocks
    private PromotionService service;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void testCreateAdminCentre() {
        Category category = new Category();
        category.setIdC(1);

        Promotion promotion = new Promotion();
        promotion.setDateDebut(LocalDate.now());
        promotion.setDateFin(LocalDate.parse("2023-10-10"));
        promotion.setStatus(status.EnCours);
        promotion.setCategory(category);

        ResponseEntity<Promotion> res = service.create(promotion);

        assertTrue(res.getStatusCode() == HttpStatusCode.valueOf(200));


    }

}
