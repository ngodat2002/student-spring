package com.t2008m.orderdemo.repository;

import com.t2008m.orderdemo.T2008mOrderDemoApplication;
import com.t2008m.orderdemo.config.H2JpaConfig;
import com.t2008m.orderdemo.entity.Product;
import com.t2008m.orderdemo.entity.enums.ProductSimpleStatus;
import com.t2008m.orderdemo.entity.enums.ProductStatus;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {T2008mOrderDemoApplication.class, H2JpaConfig.class})
@ActiveProfiles("test")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void save() {
        Product product = new Product();
        product.setName("Product 01");
        product.setDescription("Helo");
        product.setPrice(new BigDecimal(20));
        product.setSlug("hello-product");
        product.setStatus(ProductSimpleStatus.ACTIVE);
//        product.setProductStatus(ProductStatus.ACTIVE);
        productRepository.save(product);
        System.out.println(productRepository.findAll().size());
        Product product1 = productRepository.findAll().get(0);
        System.out.println(product1.toString());
    }
}