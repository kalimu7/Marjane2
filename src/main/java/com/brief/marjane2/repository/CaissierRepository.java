package com.brief.marjane2.repository;

import com.brief.marjane2.entity.Caissier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CaissierRepository extends JpaRepository<Caissier,Integer> {




}
