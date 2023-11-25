package com.brief.marjane2.repository;

import com.brief.marjane2.entity.ResponsableRayon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsableRayonRepository extends JpaRepository<ResponsableRayon,Integer> {

    //ResponsableRayon FindByEmail(String email);



    List<ResponsableRayon> findBySubscribe(boolean Sub);
}
