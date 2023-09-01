package com.product.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.project.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
