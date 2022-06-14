package com.t2008m.orderdemo.repository;

import com.t2008m.orderdemo.entity.Order;
import com.t2008m.orderdemo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository
        extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order> {

}
