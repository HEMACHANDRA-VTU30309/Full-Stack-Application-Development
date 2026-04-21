package com.example.fsdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fsdp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}