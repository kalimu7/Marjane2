package com.brief.marjane2.repository;

import com.brief.marjane2.entity.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchases,Integer> {



}
