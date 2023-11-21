package com.brief.marjane2.repository;

import com.brief.marjane2.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRespository extends JpaRepository<Promotion,Integer> {

}
