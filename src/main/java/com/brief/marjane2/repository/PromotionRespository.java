package com.brief.marjane2.repository;

import com.brief.marjane2.entity.Promotion;
import com.brief.marjane2.enums.status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRespository extends JpaRepository<Promotion,Integer> {
    List<Promotion> findByCategoryTitre(String Title);
    int countByStatus(status status);

}
