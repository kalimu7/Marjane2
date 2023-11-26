package com.brief.marjane2.repository;

import com.brief.marjane2.entity.CarteFidelité;
import com.brief.marjane2.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteFidilteRepository extends JpaRepository<CarteFidelité,Integer> {

    CarteFidelité findByClient(Client clientId);

}
