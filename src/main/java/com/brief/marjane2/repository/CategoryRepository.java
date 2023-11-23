package com.brief.marjane2.repository;

import com.brief.marjane2.entity.Category;
import com.brief.marjane2.enums.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {


    List<Category> findByTitre(category title);
}
