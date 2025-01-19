package com.productcategorymgmt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.productcategorymgmt.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
