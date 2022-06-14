package com.t2008m.orderdemo.repository;

import com.t2008m.orderdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
