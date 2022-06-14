package com.t2008m.orderdemo.service;

import com.t2008m.orderdemo.entity.Order;
import com.t2008m.orderdemo.entity.search.FilterParameter;
import com.t2008m.orderdemo.entity.search.OrderSpecification;
import com.t2008m.orderdemo.entity.search.SearchCriteria;
import com.t2008m.orderdemo.entity.search.SearchCriteriaOperator;
import com.t2008m.orderdemo.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public Page<Order> findAll(int page, int limit,
                               Specification<Order> orderSpecification) {
        return orderRepository.findAll(
                orderSpecification, PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.ASC, "createdAt")));
    }

    public Page<Order> findAll(FilterParameter param) {
        Specification<Order> specification = Specification.where(null);
        if (param.getKeyword() != null && param.getKeyword().length() > 0) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("keyword", SearchCriteriaOperator.JOIN, param.getKeyword());
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (param.getStatus() != 0) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("status", SearchCriteriaOperator.EQUALS, param.getStatus());
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (param.getUserId() != null) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("userId", SearchCriteriaOperator.EQUALS, param.getUserId());
            OrderSpecification filter = new OrderSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        return orderRepository.findAll(
                specification, PageRequest.of(param.getPage() - 1, param.getLimit()));
    }
}
