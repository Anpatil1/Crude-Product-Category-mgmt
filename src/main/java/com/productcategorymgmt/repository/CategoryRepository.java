package com.productcategorymgmt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.productcategorymgmt.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
