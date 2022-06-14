package com.t2008m.orderdemo.entity.dto;

import com.t2008m.orderdemo.entity.CartItem;
import com.t2008m.orderdemo.entity.ShoppingCart;
import lombok.*;

import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCartDTO {
    private String id;
    private String userId; // ai tạo
    private BigDecimal totalPrice;
    private String shipName;
    private String shipAddress;
    private String shipPhone;
    private String shipNote;
    private Set<CartItemDTO> items;

    public ShoppingCart generateCart(){
        return new ShoppingCart();
    }
}
