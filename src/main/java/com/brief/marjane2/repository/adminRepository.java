package com.brief.marjane2.repository;

import com.brief.marjane2.entity.AdminGeneral;
import com.brief.marjane2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRepository extends JpaRepository<AdminGeneral,Integer> {
     AdminGeneral findByEmail(String email);
}
