package com.product.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.project.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
