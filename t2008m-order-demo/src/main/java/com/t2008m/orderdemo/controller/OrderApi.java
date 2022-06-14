package com.t2008m.orderdemo.controller;

import com.t2008m.orderdemo.entity.Order;
import com.t2008m.orderdemo.entity.enums.OrderSimpleStatus;
import com.t2008m.orderdemo.entity.search.FilterParameter;
import com.t2008m.orderdemo.entity.search.OrderSpecification;
import com.t2008m.orderdemo.entity.search.SearchCriteria;
import com.t2008m.orderdemo.entity.search.SearchCriteriaOperator;
import com.t2008m.orderdemo.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderApi {

    final OrderService orderService;

    public OrderApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") String userId,
            @RequestParam(defaultValue = "2") int status) {

        Specification<Order> specification = Specification.where(null);

        if (keyword != null && keyword.length() > 0) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("keyword", SearchCriteriaOperator.JOIN, keyword);
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (status != 0) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("status", SearchCriteriaOperator.EQUALS, status);
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (userId != null) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("userId", SearchCriteriaOperator.EQUALS, userId);
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        Page<Order> result = this.orderService.findAll(page, limit, specification);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> findAllByOneObject(
            @RequestBody FilterParameter param) {
        Page<Order> result = this.orderService.findAll(param);
        return ResponseEntity.ok().body(result);
    }
}
