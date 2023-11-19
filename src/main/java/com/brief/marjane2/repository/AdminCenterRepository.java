package com.brief.marjane2.repository;

import com.brief.marjane2.entity.AdminCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCenterRepository extends JpaRepository<AdminCentre,Integer> {

    AdminCentre findByEmail(String email);



}
