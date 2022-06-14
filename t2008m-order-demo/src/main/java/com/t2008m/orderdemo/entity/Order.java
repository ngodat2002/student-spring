package com.t2008m.orderdemo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.t2008m.orderdemo.entity.base.BaseEntity;
import com.t2008m.orderdemo.entity.enums.OrderSimpleStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    private String id;
    private String userId;//0
    private BigDecimal totalPrice;
    @Enumerated(EnumType.ORDINAL)
    private OrderSimpleStatus status;

    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<OrderDetail> orderDetails;

    @PostPersist
    public void updateSlug() {
        System.out.println("Before save");
        System.out.println(id);
    }

    @PostUpdate
    public void afterSave() {
        System.out.println("After save");
        System.out.println(id);
    }

    public void addTotalPrice(OrderDetail orderDetail) {
        if (this.totalPrice == null) {
            this.totalPrice = new BigDecimal(0);
        }
        BigDecimal quantityInBigDecimal = new BigDecimal(orderDetail.getQuantity());
        this.totalPrice = this.totalPrice.add(
                orderDetail.getUnitPrice().multiply(quantityInBigDecimal));
    }
}
